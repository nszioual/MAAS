package eu.arrowhead.api.commons.canoniser.factory;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import org.apromore.canoniser.exception.CanoniserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;

public class Epml2BpmnTransformation extends Transformation {

    @Override
    public String transform(String source) {
        try {
            return transformationFacade.Cpf2Bpmn(source);
        } catch (CanoniserException | JAXBException | SAXException e) {
            logger.error("could not transform model: {}", e.toString());
        }
        return "";
    }

    @Override
    public CpfContentPair toCpf(String source) {
        try {
            return transformationFacade.Epml2Cpf(source);
        } catch (CanoniserException | JAXBException | SAXException e) {
            logger.error("could not transform model to cpf: {}", e.toString());
        }
        return null;
    }
}
