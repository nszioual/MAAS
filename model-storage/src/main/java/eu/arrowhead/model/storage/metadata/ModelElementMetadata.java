package eu.arrowhead.model.storage.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelElementMetadata {

    @Field(type = FieldType.Integer)
    private int edgeCount = 0;

    @Field(type = FieldType.Integer)
    private int taskCount = 0;

    @Field(type = FieldType.Integer)
    private int eventCount = 0;

    @Field(type = FieldType.Integer)
    private int ANDJoinCount = 0;

    @Field(type = FieldType.Integer)
    private int ANDSplitCount = 0;

    @Field(type = FieldType.Integer)
    private int ORJoinCount = 0;

    @Field(type = FieldType.Integer)
    private int ORSplitCount = 0;

    @Field(type = FieldType.Integer)
    private int XORJoinCount = 0;

    @Field(type = FieldType.Integer)
    private int XORSplitCount = 0;

    @Field(type = FieldType.Text)
    private List<String> nodeNames;

    public void setEdgeCount(int edgeCount) {
        this.edgeCount += edgeCount;
    }

    public void incrementTaskCount() {
        taskCount++;
    }

    public void incrementEventCount() {
        eventCount++;
    }

    public void incrementANDJoinCount() {
        ANDJoinCount++;
    }

    public void incrementANDSplitCount() {
        ANDSplitCount++;
    }

    public void incrementORJoinCount() {
        ORJoinCount++;
    }

    public void incrementORSplitCount() {
        ORSplitCount++;
    }

    public void incrementXORJoinCount() {
        XORJoinCount++;
    }

    public void incrementXORSplitCount() {
        XORSplitCount++;
    }
}
