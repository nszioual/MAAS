package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.dto.ModelDTO;
import eu.arrowhead.api.commons.mapper.ModelDTOMapperImpl;
import eu.arrowhead.model.storage.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base model controller.
 */
public class BaseModelController {

    protected static final Logger logger = LoggerFactory.getLogger(BaseModelController.class);

    @Autowired
    private ModelDTOMapperImpl modelDTOMapper;

    /**
     * Converts the model entity to a model DTO.
     *
     * @param model the model entity
     * @return the model DTO
     */
    protected ModelDTO convertToDTO(Model model) {
        return modelDTOMapper.mapToDTO(model);
    }
}
