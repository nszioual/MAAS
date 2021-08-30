package eu.arrowhead.model.storage.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryMetadata {

    @Field(type = FieldType.Text, name = "repository")
    private String repository = "";

    @Field(type = FieldType.Integer, name = "stars")
    private int stars = 0;

    @Field(type = FieldType.Integer, name = "forks")
    private int forks = 0;

    @Field(type = FieldType.Integer, name = "branches")
    private int branches = 0;
}
