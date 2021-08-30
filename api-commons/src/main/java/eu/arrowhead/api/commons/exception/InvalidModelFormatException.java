package eu.arrowhead.api.commons.exception;

public class InvalidModelFormatException extends RuntimeException {

    public InvalidModelFormatException(String format) {
        super(String.format("Could not find model extension %s", format));
    }
}
