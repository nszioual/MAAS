package eu.arrowhead.api.commons.canoniser.facade;

import de.epml.EPMLSchema;
import de.epml.TypeEPML;
import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import org.apromore.anf.AnnotationsType;
import org.apromore.canoniser.bpmn.BPMN20Canoniser;
import org.apromore.canoniser.bpmn.cpf.CpfCanonicalProcessType;
import org.apromore.canoniser.epml.EPML20Canoniser;
import org.apromore.canoniser.epml.internal.Canonical2EPML;
import org.apromore.canoniser.exception.CanoniserException;
import org.apromore.cpf.CPFSchema;
import org.apromore.cpf.CanonicalProcessType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TransformationFacade extends BaseTransformationFacade {

    public CpfContentPair Bpmn2Cpf(String source) throws CanoniserException, JAXBException, SAXException {
        return Model2Cpf(new ByteArrayInputStream(source.getBytes()), new BPMN20Canoniser());
    }

    public CpfContentPair Epml2Cpf(String source) throws CanoniserException, JAXBException, SAXException {
        return Model2Cpf(new ByteArrayInputStream(source.getBytes()), new EPML20Canoniser());
    }

    public String Cpf2Bpmn(String source) throws CanoniserException, JAXBException, SAXException {
        CanonicalProcessType cpf = CpfCanonicalProcessType.newInstance(new ByteArrayInputStream(source.getBytes()), true);
        ByteArrayOutputStream bpmnOut = new ByteArrayOutputStream();
        new BPMN20Canoniser().deCanonise(cpf, null, bpmnOut, null);
        return bpmnOut.toString();
    }

    public String Cpf2Epml(String source) throws CanoniserException, JAXBException, SAXException {
        CanonicalProcessType cpf = CPFSchema.unmarshalCanonicalFormat(new ByteArrayInputStream(source.getBytes()), true).getValue();
        AnnotationsType anf = null;
        TypeEPML epml = new Canonical2EPML(cpf, anf).getEPML();
        ByteArrayOutputStream epmlOut = new ByteArrayOutputStream();
        EPMLSchema.marshalEPMLFormat(epmlOut, epml, true);
        return epmlOut.toString();
    }
}