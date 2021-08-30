package eu.arrowhead.repository.manager.exception;

public class InvalidModelException extends RuntimeException {

    public InvalidModelException() {
        super("Model content is invalid");
    }
}
