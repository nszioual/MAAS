package eu.arrowhead.api.commons.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eu.arrowhead.api.commons.serializer.DateSerializer;
import eu.arrowhead.model.storage.metadata.ModelElementMetadata;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Text, name = "description")
    private String description;

    @Field(type = FieldType.Text, name = "modeling_language")
    private String modelingLanguage;

    @Field(type = FieldType.Text, name = "path")
    private String path;

    @Field(type = FieldType.Text, name = "file_name")
    private String fileName;

    @Field(type = FieldType.Text, name = "model")
    private String model;

    @Field(type = FieldType.Text, name = "c_model")
    private String cModel;

    @Field(type = FieldType.Nested, includeInParent = true, name = "elements")
    private ModelElementMetadata elements;

    @Field(type = FieldType.Nested, includeInParent = true, name = "repository")
    private RepositoryMetadata repository;

    @Field(type = FieldType.Object, name = "domains")
    Map<String, Double> domains;

    @CreatedDate
    @JsonSerialize(using = DateSerializer.class)
    private Long createdAt;

    @LastModifiedDate
    @JsonSerialize(using = DateSerializer.class)
    private Long updatedAt;
}
