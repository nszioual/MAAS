package eu.arrowhead.api.commons.dto;

import eu.arrowhead.model.storage.metadata.ModelElementMetadata;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetadataDTO {

    private String id;

    private String name;

    private String fileName;

    private String modelingLanguage;

    private String path;

    private ModelElementMetadata elements;

    private RepositoryMetadata repository;

    private String createdAt;

    private String updatedAt;
}
