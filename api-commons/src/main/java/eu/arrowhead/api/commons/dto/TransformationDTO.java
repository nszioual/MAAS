package eu.arrowhead.api.commons.dto;

import eu.arrowhead.model.storage.metadata.ModelElementMetadata;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonDeserialize(using = TransformationDTODeserializer.class)
public class TransformationDTO {

    private String id;

    private String name;

    private String fileName;

    private String modelingLanguage;

    private String path;

    private String model;

    private ModelElementMetadata elements;

    private RepositoryMetadata repository;

    private Long createdAt;

    private Long updatedAt;
}
