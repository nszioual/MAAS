package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.dto.MetadataDTO;
import eu.arrowhead.api.commons.dto.ModelDTO;
import eu.arrowhead.api.commons.dto.TransformationDTO;
import eu.arrowhead.api.commons.mapper.MetadataDTOMapperImpl;
import eu.arrowhead.api.commons.mapper.ModelDTOMapperImpl;
import eu.arrowhead.api.commons.mapper.TransformationDTOMapperImpl;
import eu.arrowhead.model.storage.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static eu.arrowhead.model.storage.Utils.getExtensionByStringHandling;

/**
 * Base model controller.
 */
public class BaseModelController {

    protected static final Logger logger = LoggerFactory.getLogger(BaseModelController.class);

    @Autowired
    private ModelDTOMapperImpl modelDTOMapper;

    @Autowired
    private MetadataDTOMapperImpl metadataDTOMapper;

    @Autowired
    private TransformationDTOMapperImpl transformationDTOMapper;

    /**
     * Convert to dto model dto.
     *
     * @param model the model
     * @return the model dto
     */
    protected ModelDTO convertToDTO(Model model) {
        return modelDTOMapper.mapToDTO(model);
    }

    /**
     * Convert to dto model dto.
     *
     * @param model the model
     * @return the model dto
     */
    protected MetadataDTO convertToMetadataDTO(Model model) {
        return metadataDTOMapper.mapToDTO(model);
    }


    /**
     * Convert to entity model.
     *
     * @param modelData the model dto
     * @return the model
     */
    protected Model convertToEntity(ModelDTO modelData) {
        return modelDTOMapper.mapToEntity(modelData);
    }

    /**
     * Convert to entity model.
     *
     * @param transformationDTO the model dto
     * @return the model
     */
    protected Model convertToEntity(TransformationDTO transformationDTO) {
        return transformationDTOMapper.mapToEntity(transformationDTO);
    }

    protected CpfContentPair getCpfFromFile(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                return ModelTransformationFactory
                        .getTransformer(getExtensionByStringHandling(file.getOriginalFilename()).get())
                        .toCpf(new String(file.getBytes(), StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new CpfContentPair();
    }
}
