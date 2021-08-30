package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.dto.ModelDTO;
import eu.arrowhead.api.commons.exception.InvalidModelFormatException;
import eu.arrowhead.api.commons.metadata.CpfMetadataExtractor;
import eu.arrowhead.api.commons.validation.factory.ModelValidatorFactory;
import eu.arrowhead.model.storage.Utils;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelSearchService;
import eu.arrowhead.model.storage.service.ModelService;
import eu.arrowhead.repository.manager.dto.RepositoryDataDTO;
import eu.arrowhead.repository.manager.exception.InvalidModelException;
import eu.arrowhead.repository.manager.service.ProcessTransformationService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The type Models provider controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODELS_URI)
public class ModelsProviderController extends BaseModelController {

    private final ModelSearchService modelSearchService;

    private final ModelService modelService;

    private final ProcessTransformationService processTransformationService;

    private final DomainLinkerService domainLinkerService;

    /**
     * Instantiates a new Models provider controller.
     * @param modelSearchService the model search service
     * @param modelService       the model service
     * @param processTransformationService the transformation service
     * @param domainLinkerService the domain linker
     */
    @Autowired
    public ModelsProviderController(ModelSearchService modelSearchService,
                                    ModelService modelService,
                                    ProcessTransformationService processTransformationService,
                                    DomainLinkerService domainLinkerService) {
        this.modelSearchService = modelSearchService;
        this.modelService = modelService;
        this.processTransformationService = processTransformationService;
        this.domainLinkerService = domainLinkerService;
    }

    /**
     * Echo response entity.
     *
     * @return the response entity
     */
    @GetMapping("/echo")
    public ResponseEntity<?> echo() {
        return ResponseEntity.ok("Got it!");
    }

    /**
     * Create model response entity.
     *
     * @param modelData the model dto
     * @param file      the file
     * @return the response entity
     */
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody public ResponseEntity<?> createModel(@Valid @RequestPart("model") ModelDTO modelData, @RequestPart("file") MultipartFile file) {
        CpfContentPair cpfResult = getCpfFromFile(file);
        if (cpfResult == null) throw new InvalidModelException();
        Model model = convertToEntity(modelData);
        model.setCModel(cpfResult.getContent());
        model.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));
        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(model, domains);
        Model modelCreated = modelService.create(model, file);
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("model", convertToDTO(modelCreated));
        }});
    }

    /**
     * Create models response entity.
     *
     * @param repositoryDTO the model dto
     * @param file      the file
     * @return the response entity
     */
    @PostMapping(path = ApiConstants.UPLOAD_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody public ResponseEntity<?> createModels(@Valid @RequestPart("repository") RepositoryDataDTO repositoryDTO, @RequestPart("file") MultipartFile file) throws IOException {
        File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");
        FileOutputStream o = new FileOutputStream(zip);
        IOUtils.copy(file.getInputStream(), o);
        o.close();

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zip));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            if (!zipEntry.isDirectory()) {
                ByteArrayOutputStream in = new ByteArrayOutputStream();
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    in.write(buffer, 0, len);
                }
                in.close();
                String fileName = zipEntry.getName().split("/")[1];
                String extension = Utils.getExtensionByStringHandling(fileName).get();
                String content = in.toString(StandardCharsets.UTF_8);
                if (modelIsValid(extension, content)) {
                    RepositoryMetadata repositoryMetadata = new RepositoryMetadata();
                    repositoryMetadata.setRepository(repositoryDTO.getRepository());
                    repositoryMetadata.setForks(repositoryDTO.getForks());
                    repositoryMetadata.setStars(repositoryDTO.getStars());
                    repositoryMetadata.setBranches(repositoryDTO.getBranches());
                    saveModel(fileName, extension, content, repositoryMetadata);
                }
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();

        return ResponseEntity.ok("");
    }

    /**
     * Gets models.
     *
     * @param name the name
     * @return the models
     */
    @GetMapping(value = "")
    @ResponseBody public ResponseEntity<?> getModels(@RequestParam(value = ApiConstants.REQUEST_PARAM_MODEL_NAME, required = false) Optional<String> name,
                                                     @RequestParam(value = ApiConstants.REQUEST_PARAM_MODELS_PAGE, required = false) Optional<Integer> page) {
        Page<Model> models = name.isEmpty() ? modelService.findAll(PageRequest.of(page.orElse(0), 8)) : modelSearchService.findByModelMatchingNames(name.get(), PageRequest.of(page.orElse(0), 8));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("models", models.stream().map(model -> convertToDTO(model)).collect(Collectors.toList()));
            put("totalElements", models.getTotalElements());
            put("totalPages", models.getTotalPages());
        }});
    }

    /**
     * Delete all models.
     */
    @DeleteMapping("")
    public ResponseEntity<?> deleteModels() {
        modelService.deleteAll();
        return ResponseEntity.ok("");
    }

    private void saveModel(String name, String extension, String content, RepositoryMetadata repositoryMetadata) {
        // Get canonical process format
        CpfContentPair cpfResult = modelToCpf(extension, content);

        // Set model metadata
        Model model = new Model();
        model.setName(name);
        model.setFileName(name);
        model.setRepository(repositoryMetadata);
        model.setPath("");
        model.setModel(content);
        model.setCModel(cpfResult.getContent());
        model.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));

        // Set domain data
        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(model, domains);
        modelService.create(model);
    }

    private boolean modelIsValid(String extension, String content) {
        return Objects.requireNonNull(ModelValidatorFactory
                .getValidator(extension))
                .validateSchema(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)))
                .equals(ApiConstants.XML_VALID);
    }

    private CpfContentPair modelToCpf(String extension, String content) {
        return ModelTransformationFactory.getTransformer(extension).toCpf(content);
    }
}
