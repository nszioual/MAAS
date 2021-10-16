package eu.arrowhead.transformer.provider.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.dto.TransformationListDTO;
import eu.arrowhead.api.commons.exception.InvalidModelFormatException;
import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.transformer.provider.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * The Model Transformation provider controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODEL_TRANSFORMER_URI)
public class TransformerProviderController {

    private final TransformationService transformationService;

    /**
     * Instantiates a new Transformer provider controller.
     *
     * @param transformationService the transformation service
     */
    @Autowired
    public TransformerProviderController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    /**
     * Echo service string.
     *
     * @return the string
     */
    @GetMapping(path = CommonConstants.ECHO_URI)
    public String echoService() {
        return "Got it!";
    }

    /**
     * Transform model to model.
     *
     * @param content the content
     * @param format  the format
     * @return the response entity
     */
    @GetMapping(value = "/to-cpf", params = {"content", "format"})
    public ResponseEntity<?> transformModelToModel(@RequestParam String content, @RequestParam String format) {
        checkFormatValidity(format);
        String cpf = transformationService.convertModelToModel(content, format);
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("original", content);
            put("cpf", cpf);
        }});
    }

    /**
     * Gets process models.
     *
     * @param format the format
     * @return the process models
     */
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
