package eu.arrowhead.api.commons.canoniser.factory;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.facade.TransformationFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Transformation {

    protected final Logger logger = LogManager.getLogger(Transformation.class);

    protected TransformationFacade transformationFacade;

    public Transformation() {
        transformationFacade = new TransformationFacade();
    }

    public abstract String transform(String source);

    public abstract CpfContentPair toCpf(String source);
}
