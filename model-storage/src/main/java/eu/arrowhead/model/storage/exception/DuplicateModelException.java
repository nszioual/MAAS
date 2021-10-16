package eu.arrowhead.model.storage.exception;

public class DuplicateModelException extends RuntimeException {
    public DuplicateModelException(String name) {
        super(String.format("The provided name: %s already exists. Use another name instead!", name));
    }
}
