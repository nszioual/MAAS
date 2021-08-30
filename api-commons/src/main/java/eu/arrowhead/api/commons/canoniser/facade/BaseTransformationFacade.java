package eu.arrowhead.api.commons.canoniser.facade;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import org.apromore.anf.AnnotationsType;
import org.apromore.canoniser.DefaultAbstractCanoniser;
import org.apromore.canoniser.bpmn.cpf.CpfCanonicalProcessType;
import org.apromore.canoniser.exception.CanoniserException;
import org.apromore.cpf.CanonicalProcessType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BaseTransformationFacade {

    public CpfContentPair Model2Cpf(InputStream in, DefaultAbstractCanoniser canoniser) throws CanoniserException, JAXBException, SAXException {
        List<AnnotationsType> anfs = new ArrayList<>();
        List<CanonicalProcessType> cpfs = new ArrayList<>();
        canoniser.canonise(in, anfs, cpfs, null);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ((CpfCanonicalProcessType) cpfs.get(0)).marshal(output, true);
        return new CpfContentPair(cpfs.get(0), output.toString(StandardCharsets.UTF_8));
    }
}
