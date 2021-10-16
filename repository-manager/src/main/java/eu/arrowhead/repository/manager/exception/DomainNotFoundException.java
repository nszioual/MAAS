package eu.arrowhead.repository.manager.exception;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(String id) {
        super(String.format("Could not find domain %s", id));
    }
}
