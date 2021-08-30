package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.metadata.CpfMetadataExtractor;
import eu.arrowhead.api.commons.util.StringUtil;
import eu.arrowhead.model.storage.exception.ModelNotFoundException;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelSearchService;
import eu.arrowhead.model.storage.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * The type Model provider controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODELS_URI)
public class ModelProviderController extends BaseModelController {

    private final ModelSearchService modelSearchService;

    private final ModelService modelService;

    private final DomainLinkerService domainLinkerService;

    /**
     * Instantiates a new Model provider controller.
     *  @param modelSearchService the model search service
     * @param modelService      the model service
     * @param domainLinkerService
     */
    @Autowired
    public ModelProviderController(ModelSearchService modelSearchService, ModelService modelService, DomainLinkerService domainLinkerService) {
        this.modelSearchService = modelSearchService;
        this.modelService = modelService;
        this.domainLinkerService = domainLinkerService;
    }

    /**
     * Gets model.
     *
     * @param id the id
     * @return the model
     */
    @GetMapping(path = ApiConstants.BY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<?> getModel(@PathVariable String id) {
        if (modelService.findById(id).isEmpty()) {
            throw new ModelNotFoundException(id);
        }
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("model", convertToDTO(modelService.findById(id).get()));
        }});
    }

    /**
     * Update model response entity.
     *
     * @param newModel the new model dto
     * @param file         the file
     * @param id           the id
     * @return the response entity
     */
    @PutMapping(path = ApiConstants.BY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody public ResponseEntity<?> updateModel(@Valid @RequestPart("model") Model newModel,
                                         @RequestPart(value = "file", required = false) MultipartFile file,
                                         @PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        CpfContentPair cpfResult = getCpfFromFile(file);
        newModel.setCModel(cpfResult.getContent());
        newModel.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));
        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(newModel, domains);
        return ResponseEntity.ok(modelService.findById(id)
                .map(model -> convertToDTO(modelService.update(newModel, id , file)))
                .orElseGet(() -> convertToDTO(modelService.create(newModel, file))));
    }

    /**
     * Delete model response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping(path = ApiConstants.BY_ID_PATH)
    public ResponseEntity<?> deleteModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return modelService.findById(id).map(model -> {
            modelService.delete(model);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ModelNotFoundException(id));
    }

    /**
     * Download model response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = ApiConstants.BY_ID_PATH + "/download")
    public ResponseEntity<byte[]> downloadModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return modelService.findById(id).map(model -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + model.getFileName() + "\"")
                .body(model.getModel().getBytes(StandardCharsets.UTF_8)))
                .orElseThrow(() -> new ModelNotFoundException(id));
    }

    /**
     * Download model response entity.
     *
     * @param id      the id
     * @param version the version
     * @return the response entity
     */
    @GetMapping(value = ApiConstants.BY_ID_PATH + "/download", params = {"version"})
    public ResponseEntity<byte[]> downloadModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id, @RequestParam String version) {
        return modelService.findById(id).map(model -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + model.getFileName() + "\"")
                .body(model.getModel().getBytes(StandardCharsets.UTF_8)))
                .orElseThrow(() -> new ModelNotFoundException(id));
    }
}