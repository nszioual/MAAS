package eu.arrowhead.api.commons.canoniser.factory;

import eu.arrowhead.api.commons.constants.ApiConstants;

public class ModelTransformationFactory {

    public static Transformation getTransformer(String type) {
        Transformation transformation;
        switch (type.toLowerCase()) {
            case ApiConstants.EPML:
                transformation = new Epml2BpmnTransformation();
                break;
            case ApiConstants.BPMN:
                transformation = new Bpmn2EpmlTransformation();
                break;
            default:
                throw new IllegalArgumentException("No such transformation is available.");
        }
        return transformation;
    }
}
