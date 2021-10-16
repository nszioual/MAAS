package eu.arrowhead.model.storage.exception;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String id) {
        super(String.format("Could not find model %s", id));
    }
}
