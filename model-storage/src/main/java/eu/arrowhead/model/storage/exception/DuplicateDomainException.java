package eu.arrowhead.model.storage.exception;

public class DuplicateDomainException extends RuntimeException {
    public DuplicateDomainException(String name) {
        super(String.format("The provided name: %s already exists. Use another name instead!", name));
    }
}