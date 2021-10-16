package eu.arrowhead.model.storage.model;

import eu.arrowhead.model.storage.metadata.ModelElementMetadata;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "version")
public class Version {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "model")
    private String model;

    @Field(type = FieldType.Text, name = "c_model")
    private String cModel;

    @Field(type = FieldType.Nested, includeInParent = true, name = "elements")
    private ModelElementMetadata elements;

    @Field(type = FieldType.Nested, includeInParent = true, name = "repository")
    private RepositoryMetadata repository;

    @Field(type = FieldType.Object, name = "domains")
    Map<String, Double> domains = new HashMap<>();

    public Version(Model model) {
        this.name = model.getName();
        this.model = model.getModel();
        this.cModel = model.getCModel();
        this.elements = model.getElements();
        this.repository = model.getRepository();
        this.domains = model.getDomains();
    }
}
