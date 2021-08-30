package eu.arrowhead.api.commons.metadata;

import eu.arrowhead.model.storage.metadata.ModelElementMetadata;
import org.apromore.cpf.*;

import java.util.ArrayList;
import java.util.List;

public class CpfMetadataExtractor {

    public static ModelElementMetadata extractMetadata(CanonicalProcessType cpf) {
        ModelElementMetadata metadata = new ModelElementMetadata();
        metadata.setNodeNames(new ArrayList<>());
        for (NetType net : cpf.getNet()) {
            updateMetadata(metadata, net.getNode(), net.getEdge());
        }
        return metadata;
    }

    private static void updateMetadata(ModelElementMetadata metadata, List<NodeType> nodes, List<EdgeType> edges) {
        metadata.setEdgeCount(edges.size());
        for (NodeType node : nodes) {
            if (node instanceof TaskType) metadata.incrementTaskCount();
            if (node instanceof EventType) metadata.incrementEventCount();
            if (node instanceof ANDJoinType) metadata.incrementANDJoinCount();
            if (node instanceof ANDSplitType) metadata.incrementANDSplitCount();
            if (node instanceof ORJoinType) metadata.incrementORJoinCount();
            if (node instanceof ORSplitType) metadata.incrementORSplitCount();
            if (node instanceof XORJoinType) metadata.incrementXORJoinCount();
            if (node instanceof XORSplitType) metadata.incrementXORSplitCount();
            if (node.getName() != null && !node.getName().isEmpty()) {
                metadata.getNodeNames().add(node.getName());
            }
        }
    }
}
