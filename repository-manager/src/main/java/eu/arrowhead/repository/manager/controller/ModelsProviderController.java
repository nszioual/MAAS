package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.CreateModelDTO;
import eu.arrowhead.api.commons.dto.RepositoryDataDTO;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelSearchService;
import eu.arrowhead.model.storage.service.ModelService;
import eu.arrowhead.repository.manager.service.ModelDataService;
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
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The Models provider controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODELS_URI)
public class ModelsProviderController extends BaseModelController {

    private final ModelSearchService modelSearchService;

    private final ModelService modelService;

    private final ModelDataService modelDataService;

    /**
     * Instantiates a new Models provider controller.
     *
     * @param modelSearchService the model search service
     * @param modelService       the model service
     * @param modelDataService   the model data service
     */
    @Autowired
    public ModelsProviderController(ModelSearchService modelSearchService,
                                    ModelService modelService,
                                    ModelDataService modelDataService) {
        this.modelSearchService = modelSearchService;
        this.modelService = modelService;
        this.modelDataService = modelDataService;
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
     * Create model.
     *
     * @param modelData the model dto
     * @param file      the file
     * @return the response entity
     */
    @PostMapping(
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> createModel(
            @Valid @RequestPart("model") CreateModelDTO modelData,
            @RequestPart("file") MultipartFile file) {
        Model model = modelDataService.createModel(modelData, file);
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("model", modelService.findById(model.getId()).get());
        }});
    }

    /**
     * Create models.
     *
     * @param repositoryDTO the model dto
     * @param file          the file
     * @return the response entity
     */
    @PostMapping(
            path = ApiConstants.UPLOAD_URI,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> createModelsFromZipArchive(
            @RequestPart("repository") RepositoryDataDTO repositoryDTO,
            @RequestPart("file") MultipartFile file) throws IOException {
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

                modelDataService.createModel(repositoryDTO, zipEntry, in);
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();

        return ResponseEntity.ok("");
    }

    /**
     * Get models.
     *
     * @param name   the name
     * @param offset the offset
     * @param limit  the limit
     * @return the models
     */
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> getModels(
            @RequestParam(value = ApiConstants.REQUEST_PARAM_NAME, required = false) Optional<String> name,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_OFFSET, required = false, defaultValue = "0") int offset,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_LIMIT, required = false, defaultValue = "8") int limit) {
        Page<Model> models = name.isPresent()
                ? modelSearchService.findByModelMatchingNames(name.get(), PageRequest.of(offset, limit))
                : modelService.findAll(PageRequest.of(offset, limit));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("models", models.stream().map(model -> convertToDTO(model)).collect(Collectors.toList()));
            put("totalElements", models.getTotalElements());
            put("totalPages", models.getTotalPages());
        }});
    }
}
