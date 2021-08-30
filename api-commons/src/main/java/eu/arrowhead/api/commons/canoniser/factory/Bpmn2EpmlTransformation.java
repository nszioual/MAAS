package eu.arrowhead.api.commons.canoniser.factory;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import org.apromore.canoniser.exception.CanoniserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;

public class Bpmn2EpmlTransformation extends Transformation {

    @Override
    public String transform(String cpf)  {
        try {
            return transformationFacade.Cpf2Epml(cpf);
        } catch (CanoniserException | JAXBException | SAXException e) {
            logger.error("could not transform model: {}", e.toString());
        }
        return "";
    }

    @Override
    public CpfContentPair toCpf(String model) {
        try {
            return transformationFacade.Bpmn2Cpf(model);
        } catch (CanoniserException | JAXBException | SAXException e) {
            logger.error("could not transform model to cpf: {}", e.toString());
        }
        return null;
    }
}
