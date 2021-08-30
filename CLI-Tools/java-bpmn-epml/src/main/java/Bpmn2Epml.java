import de.epml.EPMLSchema;
import de.epml.TypeEPML;
import org.apromore.anf.AnnotationsType;
import org.apromore.canoniser.bpmn.BPMN20Canoniser;
import org.apromore.canoniser.epml.internal.Canonical2EPML;
import org.apromore.canoniser.exception.CanoniserException;
import org.apromore.cpf.CanonicalProcessType;
import org.apromore.plugin.PluginRequest;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Bpmn2Epml extends ProcessModelTransformation {

    public void convert(String input, String output) throws CanoniserException, IOException, JAXBException, SAXException {
        // BPMN 2 CPF
        BPMN20Canoniser canoniser = new BPMN20Canoniser();
        PluginRequest request = null;
        InputStream bpmnInput = new FileInputStream(input);
        List<AnnotationsType> anfs = new ArrayList<>();
        List<CanonicalProcessType> cpfs = new ArrayList<>();
        canoniser.canonise(bpmnInput, anfs, cpfs, request);

        // CPF 2 EPML
        CanonicalProcessType cpf = cpfs.get(0);
        AnnotationsType anf = null;
        TypeEPML epml = new Canonical2EPML(cpf, anf).getEPML();
        ByteArrayOutputStream epmlOut = new ByteArrayOutputStream();
        EPMLSchema.marshalEPMLFormat(epmlOut, epml, true);
        writeStringToFile(epmlOut.toString(), output);
    }
}
