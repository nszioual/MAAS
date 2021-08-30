public class TransformationFactory {
    public static ProcessModelTransformation getTransformer(String type) {
        ProcessModelTransformation transformation;
        switch (type.toLowerCase()) {
            case ".epml":
                transformation = new Epml2Bpmn();
                break;
            case ".bpmn":
                transformation = new Bpmn2Epml();
                break;
            default:
                throw new IllegalArgumentException("No such transformation is available.");
        }
        return transformation;
    }
}
