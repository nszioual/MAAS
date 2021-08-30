package eu.arrowhead.crawler.provider.exception;

public class InvalidModelFormatException extends RuntimeException {

    public InvalidModelFormatException(String format) {
        super(String.format("Could not find model format %s", format));
    }
}
