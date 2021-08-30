import org.apromore.anf.AnnotationsType;
import org.apromore.canoniser.bpmn.BPMN20Canoniser;
import org.apromore.canoniser.epml.EPML20Canoniser;
import org.apromore.canoniser.exception.CanoniserException;
import org.apromore.cpf.CanonicalProcessType;
import org.apromore.plugin.PluginRequest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Epml2Bpmn extends ProcessModelTransformation {
    @Override
    public void convert(String input, String output) throws CanoniserException, IOException {
        // EPML 2 CPF
        EPML20Canoniser canoniser = new EPML20Canoniser();
        PluginRequest request = null;
        InputStream bpmnInput = new FileInputStream(input);
        List<AnnotationsType> anfs = new ArrayList<>();
        List<CanonicalProcessType> cpfs = new ArrayList<>();
        canoniser.canonise(bpmnInput, anfs, cpfs, request);

        // CPF 2 BPMN
        CanonicalProcessType cpf = cpfs.get(0);
        ByteArrayOutputStream bpmnOut = new ByteArrayOutputStream();
        new BPMN20Canoniser().deCanonise(cpf, null, bpmnOut, null);
        writeStringToFile(bpmnOut.toString(), output);
    }
}
