package eu.arrowhead.repository.manager.exception;

public class InvalidDomainException extends RuntimeException {
    public InvalidDomainException() {
        super("Domain content is invalid");
    }
}
