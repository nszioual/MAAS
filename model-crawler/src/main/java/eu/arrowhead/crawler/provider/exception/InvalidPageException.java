package eu.arrowhead.crawler.provider.exception;

public class InvalidPageException extends RuntimeException {

    public InvalidPageException(Integer page) {
        super(String.format("The given page number '%s' is invalid, please provide a positive integer", page));
    }
}
