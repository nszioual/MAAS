package eu.arrowhead.model.filter.provider.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.canoniser.factory.Transformation;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.MetadataDTO;
import eu.arrowhead.api.commons.dto.ModelDTO;
import eu.arrowhead.api.commons.mapper.MetadataDTOMapperImpl;
import eu.arrowhead.api.commons.mapper.ModelDTOMapperImpl;
import eu.arrowhead.model.filter.provider.dto.SearchFormDTO;
import eu.arrowhead.model.filter.provider.service.ModelFilterService;
import eu.arrowhead.model.filter.provider.service.ModelQueryService;
import eu.arrowhead.model.storage.model.Model;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/filter")
public class ModelFilteringController {

    private final ModelDTOMapperImpl modelDTOMapper;

    private final MetadataDTOMapperImpl metadataDTOMapper;

    private final ModelQueryService modelQueryService;

    private final ModelFilterService modelFilterService;

    private List<Model> filteredModels;

    @Autowired
    public ModelFilteringController(ModelDTOMapperImpl modelDTOMapper,
                                    MetadataDTOMapperImpl metadataDTOMapper,
                                    ModelQueryService modelQueryService,
                                    ModelFilterService modelFilterService) {
        this.modelDTOMapper = modelDTOMapper;
        this.metadataDTOMapper = metadataDTOMapper;
        this.modelQueryService = modelQueryService;
        this.modelFilterService = modelFilterService;
    }

    @GetMapping("/echo")
    public ResponseEntity<?> echo() {
        return ResponseEntity.ok("Got it!");
    }

    @PostMapping(value = "")
    @ResponseBody public ResponseEntity<?> getModelsByCriteria(@RequestBody SearchFormDTO searchFormDTO) {
        filteredModels = modelQueryService.findModelsByCriteria(modelFilterService.getSearchCriteria(searchFormDTO));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("models", filteredModels.stream().map(model -> convertToDTO(model)).collect(Collectors.toList()));
            put("totalElements", filteredModels.size());
        }});
    }

    @GetMapping(value = "")
    @ResponseBody public ResponseEntity<?> getModelsByCriteria(@RequestParam(value = "name", required = false) String name,
                                                 @RequestParam(value = "format",  required = false) String format,
                                                 @RequestParam(value = "elems",  required = false) String elems,
                                                 @RequestParam(value = "repo", required = false) String repo) {
        filteredModels = modelQueryService.findModelsByCriteria(modelFilterService.getSearchCriteria(name, format, elems, repo));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("models", filteredModels.stream().map(model -> convertToDTO(model)).collect(Collectors.toList()));
            put("totalElements", filteredModels.size());
        }});
    }

    @GetMapping(value = "download-bundle", produces = ApiConstants.APPLICATION_ZIP)
    public ResponseEntity<StreamingResponseBody> downloadBundle(@RequestParam(value = "target",  required = false) String target) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"models.zip\"")
                .body(out -> {
                    if (target != null & !target.isEmpty()) {
                        transformModels(target);
                    }
                    ZipOutputStream zipOutputStream = new ZipOutputStream(out);
                    prepareModels(zipOutputStream, filteredModels);
                    zipOutputStream.close();
                });
    }

    private void transformModels(String target) {
        Transformation t = ModelTransformationFactory.getTransformer(target.equals(ApiConstants.BPMN) ? ApiConstants.EPML : ApiConstants.BPMN);
        for (Model model : filteredModels) {
            if (model.getModelingLanguage().equalsIgnoreCase(target)) {
                continue;
            }
            model.setModel(t.transform(model.getCModel()));
            model.setModelingLanguage(target.toUpperCase());
        }
    }

    private void prepareModels(ZipOutputStream zipOutputStream, List<Model> models) throws IOException {
        for (Model model : models) {
            MetadataDTO metadataDto = convertToMetadataDTO(model);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            addFileToOutputStream(model.getModel().getBytes(StandardCharsets.UTF_8), model.getName() + "." + model.getModelingLanguage().toLowerCase(Locale.ROOT), zipOutputStream);
            addFileToOutputStream(ow.writeValueAsString(metadataDto).getBytes(StandardCharsets.UTF_8), model.getName() + ".json", zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void addFileToOutputStream(byte[] file, String fileName, ZipOutputStream zos) throws IOException {
        zos.putNextEntry(new ZipEntry(fileName));
        InputStream is = new ByteArrayInputStream(file);
        IOUtils.copy(is, zos);
        is.close();
    }

    private ModelDTO convertToDTO(Model model) {
        return modelDTOMapper.mapToDTO(model);
    }

    private MetadataDTO convertToMetadataDTO(Model model) {
        return metadataDTOMapper.mapToDTO(model);
    }
}
