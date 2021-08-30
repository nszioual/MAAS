package eu.arrowhead.api.commons.mapper;

import eu.arrowhead.api.commons.dto.ModelDTO;
import eu.arrowhead.model.storage.model.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ModelDTOMapper {

    List<ModelDTO> mapToDTO(List<Model> models);

    List<Model> mapToEntity(List<ModelDTO> models);

    default ModelDTO mapToDTO(Model model) {
        return ModelDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .fileName(model.getFileName())
                .description(model.getDescription())
                .modelingLanguage(model.getModelingLanguage())
                .repository(model.getRepository())
                .path(model.getPath())
                .model(model.getModel())
                .cModel(model.getCModel())
                .elements(model.getElements())
                .domains(model.getDomains())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

    default Model mapToEntity(ModelDTO modelDTO) {
        return Model.builder()
                .id(modelDTO.getId())
                .name(modelDTO.getName())
                .fileName(modelDTO.getFileName())
                .description(modelDTO.getDescription())
                .modelingLanguage(modelDTO.getModelingLanguage())
                .repository(modelDTO.getRepository())
                .path(modelDTO.getPath())
                .model(modelDTO.getModel())
                .cModel(modelDTO.getCModel())
                .elements(modelDTO.getElements())
                .domains(modelDTO.getDomains())
                .createdAt(modelDTO.getCreatedAt())
                .updatedAt(modelDTO.getUpdatedAt())
                .build();
    }
}
