package eu.arrowhead.api.commons;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.canoniser.factory.Transformation;
import eu.arrowhead.api.commons.constants.ApiConstants;
import org.apromore.canoniser.exception.CanoniserException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bpmn2CpfTest {

    @Test
    public void testTransform() throws IOException {
        // create bpmn2epml transformer
        Transformation bpmn2epml = ModelTransformationFactory.getTransformer(ApiConstants.BPMN);

        // read file to string
        String content = readFile("src/test/resources/BPMN_models/case 1.bpmn", StandardCharsets.UTF_8);

        // transform bpmn to epml
        CpfContentPair epmlOutput = bpmn2epml.toCpf(content);
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
