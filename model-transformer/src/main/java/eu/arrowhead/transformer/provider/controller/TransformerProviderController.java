package eu.arrowhead.transformer.provider.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.TransformationListDTO;
import eu.arrowhead.api.commons.exception.InvalidModelFormatException;
import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.model.storage.service.ModelService;
import eu.arrowhead.transformer.provider.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODEL_TRANSFORMER_URI)
public class TransformerProviderController {


    //=================================================================================================
    // members

    private final TransformationService transformationService;

    private final ModelService modelService;

    @Autowired
    public TransformerProviderController(TransformationService transformationService, ModelService modelService) {
        this.transformationService = transformationService;
        this.modelService = modelService;
    }

    //=================================================================================================
    // methods

    //-------------------------------------------------------------------------------------------------
    @GetMapping(path = CommonConstants.ECHO_URI)
    public String echoService() {
        return "Got it!";
    }

//    @GetMapping(value = "/to-model", params = {"modelId"})
//    public TransformationDTO transformModelToModel(@RequestParam String modelId) {
//        Optional<Model> model = modelService.findById(modelId);
//        if (!model.isPresent()) {
//            throw new ModelNotFoundException(modelId);
//        }
//
//        return transformationService.transformModelToModel(model.get());
//    }

    @GetMapping(value = "/to-cpf", params = {"content", "format"})
    public ResponseEntity<?> transformModelToModel(@RequestParam String content, @RequestParam String format) {
        checkFormatValidity(format);

        String cpf = transformationService.convertModelToModel(content, format);
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("original", content);
            put("cpf", cpf);
        }});
    }

//    @GetMapping(value = "/to-cpf", params = {"modelId"})
//    public TransformationDTO transformModelToCpf(@RequestParam String modelId) {
//        Optional<Model> model = modelService.findById(modelId);
//        if (!model.isPresent()) {
//            throw new ModelNotFoundException(modelId);
//        }
//
//        return transformationService.transformModelToCpf(model.get());
//    }

//    @GetMapping(value = "/to-cpf", params = {"content", "format"})
//    public ResponseEntity<?> transformModelToCpf(@RequestParam String content, @RequestParam String format) {
//        checkFormatValidity(format);
//
//        String cpf = transformationService.convertModelToCpf(content, format);
//        return ResponseEntity.ok(new HashMap<String, Object>() {{
//            put("original", content);
//            put("cpf", cpf);
//        }});
//    }

    @GetMapping(value = "", params = {"format"})
    public TransformationListDTO getProcessModels(@RequestParam String format) {
        checkFormatValidity(format);

        return new TransformationListDTO(transformationService.getProcessModels(format));
    }

    private void checkFormatValidity(@RequestParam String format) {
        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }
    }
}
