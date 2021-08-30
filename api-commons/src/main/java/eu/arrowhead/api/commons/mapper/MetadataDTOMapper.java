package eu.arrowhead.api.commons.mapper;

import eu.arrowhead.api.commons.dto.MetadataDTO;
import eu.arrowhead.model.storage.model.Model;
import org.mapstruct.Mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public interface MetadataDTOMapper {

    List<MetadataDTO> mapToDTO(List<Model> models);

    default MetadataDTO mapToDTO(Model model) {
        Date createdAt = new Date(model.getCreatedAt());
        Date updatedAt = new Date(model.getUpdatedAt());
        DateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

        return MetadataDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .fileName(model.getFileName())
                .modelingLanguage(model.getModelingLanguage())
                .repository(model.getRepository())
                .path(model.getPath())
                .elements(model.getElements())
                .createdAt(sdf.format(createdAt))
                .updatedAt(sdf.format(updatedAt))
                .build();
    }
}
