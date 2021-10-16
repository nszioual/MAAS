package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.CreateModelDTO;
import eu.arrowhead.model.storage.exception.ModelNotFoundException;
import eu.arrowhead.model.storage.service.ModelService;
import eu.arrowhead.repository.manager.service.ModelDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * The type Model provider controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODELS_URI)
public class ModelProviderController extends BaseModelController {

    private final ModelService modelService;

    private final ModelDataService modelDataService;

    /**
     * Instantiates a new Model provider controller.
     *
     * @param modelService     the model service
     * @param modelDataService the model data service
     */
    @Autowired
    public ModelProviderController(
            ModelService modelService,
            ModelDataService modelDataService) {
        this.modelService = modelService;
        this.modelDataService = modelDataService;
    }

    /**
     * Gets a model by id.
     *
     * @param id the id
     * @return the model
     */
    @GetMapping(path = ApiConstants.BY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getModel(@PathVariable String id) {
        if (modelService.findById(id).isEmpty()) {
            throw new ModelNotFoundException(id);
        }
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("model", convertToDTO(modelService.findById(id).get()));
        }});
    }

    /**
     * Update model.
     *
     * @param newModel the new model dto
     * @param file     the file
     * @param id       the id
     * @return the response entity
     */
    @PutMapping(
            path = ApiConstants.BY_ID_PATH,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> updateModel(
            @Valid @RequestPart("model") CreateModelDTO newModel,
            @RequestPart(value = "file", required = false) MultipartFile file,
            @PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return ResponseEntity.ok(modelService.findById(id)
                .map(model -> convertToDTO(modelDataService.updateModel(newModel, id, file)))
                .orElseGet(() -> convertToDTO(modelDataService.createModel(newModel, file))));
    }

    /**
     * Delete model.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping(path = ApiConstants.BY_ID_PATH)
    public ResponseEntity<?> deleteModel(
            @PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return modelService.findById(id).map(model -> {
            modelService.delete(model);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ModelNotFoundException(id));
    }

    /**
     * Download model.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = ApiConstants.BY_ID_PATH + "/download")
    public ResponseEntity<byte[]> downloadModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return modelService.findById(id).map(model -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + model.getFileName() + "\"")
                .body(model.getModel().getBytes(StandardCharsets.UTF_8))
        ).orElseThrow(() -> new ModelNotFoundException(id));
    }

    /**
     * Download model.
     *
     * @param id      the id
     * @param version the version
     * @return the response entity
     */
    @GetMapping(value = ApiConstants.BY_ID_PATH + "/download", params = {"version"})
    public ResponseEntity<byte[]> downloadModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id, @RequestParam String version) {
        return modelService.findById(id).map(model -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + model.getFileName() + "\"")
                .body(model.getModel().getBytes(StandardCharsets.UTF_8))
        ).orElseThrow(() -> new ModelNotFoundException(id));
    }
}