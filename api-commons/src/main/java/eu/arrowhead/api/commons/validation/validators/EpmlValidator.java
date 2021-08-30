package eu.arrowhead.api.commons.validation.validators;

import de.epml.EPMLSchema;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public class EpmlValidator extends Validator {

    @Override
    public void validate(InputStream in) throws JAXBException, SAXException {
        EPMLSchema.unmarshalEPMLFormat(in, true);
    }
}
