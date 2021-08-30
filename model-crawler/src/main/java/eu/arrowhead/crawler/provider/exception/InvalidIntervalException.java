package eu.arrowhead.crawler.provider.exception;

public class InvalidIntervalException extends RuntimeException {

    public InvalidIntervalException(Integer lower, Integer upper) {
        super(String.format("The given page interval '%s..%s' is invalid", lower, upper));
    }
}

