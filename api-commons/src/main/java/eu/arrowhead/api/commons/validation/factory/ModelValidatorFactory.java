package eu.arrowhead.api.commons.validation.factory;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.validation.validators.BpmnValidator;
import eu.arrowhead.api.commons.validation.validators.EpmlValidator;
import eu.arrowhead.api.commons.validation.validators.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelValidatorFactory {

    private static final Logger logger = LoggerFactory.getLogger(ModelValidatorFactory.class);

    public static Validator getValidator(String modelType) {
        logger.info("getting validator: {}", modelType);
        if (modelType.equalsIgnoreCase(ApiConstants.BPMN)) {
            return new BpmnValidator();
        }
        if (modelType.equalsIgnoreCase(ApiConstants.EPML)) {
            return new EpmlValidator();
        }
        return null;
    }
}
