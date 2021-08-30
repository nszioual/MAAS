package eu.arrowhead.api.commons.validation.validators;

import eu.arrowhead.api.commons.constants.ApiConstants;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.InputStream;

public abstract class Validator {

    public String validateSchema(final InputStream in) {
        String msg = ApiConstants.XML_VALID;
        try {
            validate(in);
        }
        catch (JAXBException e) {
            msg = "Exception: " + e.getLinkedException().getMessage();
        }
        catch (SAXException e) {
            msg = "Exception: " + e.getMessage();
        }
        return msg;
    }

    protected abstract void validate(final InputStream in) throws JAXBException, SAXException;
}