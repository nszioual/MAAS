import org.apromore.canoniser.exception.CanoniserException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class ProcessModelTransformation {
    public abstract void convert(String input, String output) throws CanoniserException, IOException, JAXBException, SAXException;

    protected void writeStringToFile(String content, String path) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        byte[] strToBytes = content.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();
    }
}
