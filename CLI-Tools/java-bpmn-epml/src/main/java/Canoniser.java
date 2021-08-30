import org.apromore.canoniser.exception.CanoniserException;
import org.xml.sax.SAXException;
import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@CommandLine.Command(
        name = "canoniser",
        description = "Convert BPMN to EPML and EPML to BPMN"
)
public class Canoniser implements Runnable {

    @CommandLine.Option(names = {"-i", "--input"}, required = true)
    private String input;

    @CommandLine.Option(names = {"-o", "--output"}, required = true)
    private String output;

    @Spec
    CommandSpec spec;

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        CommandLine.run(new Canoniser(), args);
    }

    public void run() {
        validateInput();
        try {
            String format = getExtensionByStringHandling(input);
            TransformationFactory.getTransformer(format).convert(input, output);
        } catch (CanoniserException | JAXBException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void validateInput() {
        String msg = "Error: given file '%s' does not exist";
        if (!new File(input).exists()) {
            throw new CommandLine.ParameterException(spec.commandLine(), String.format(msg, input));
        }
    }

    private static String getExtensionByStringHandling(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(lastIndexOf);
    }
}
