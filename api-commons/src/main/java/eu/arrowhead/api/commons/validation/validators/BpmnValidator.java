package eu.arrowhead.api.commons.validation.validators;

import org.apromore.canoniser.bpmn.bpmn.BpmnDefinitions;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class BpmnValidator extends Validator {

    @Override
    public void validate(InputStream in) throws JAXBException {
        BpmnDefinitions.newInstance(in, true);
    }
}
