package eu.arrowhead.api.commons.mapper;

import eu.arrowhead.api.commons.dto.TransformationDTO;
import eu.arrowhead.model.storage.model.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TransformationDTOMapper {

    List<Model> mapToEntity(List<TransformationDTO> models);

    default Model mapToEntity(TransformationDTO transformationDTO) {
        return Model.builder()
                .id(transformationDTO.getId())
                .name(transformationDTO.getName())
                .fileName(transformationDTO.getFileName())
                .modelingLanguage(transformationDTO.getModelingLanguage())
                .repository(transformationDTO.getRepository())
                .path(transformationDTO.getPath())
                .model(transformationDTO.getModel())
                .elements(transformationDTO.getElements())
//                .createdAt(transformationDTO.getCreatedAt())
//                .updatedAt(transformationDTO.getUpdatedAt())
                .build();
    }
}
