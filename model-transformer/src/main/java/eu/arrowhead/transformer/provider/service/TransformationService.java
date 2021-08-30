package eu.arrowhead.transformer.provider.service;

import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.canoniser.factory.Transformation;
import eu.arrowhead.api.commons.dto.TransformationDTO;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TransformationService {

    private final Logger logger = LogManager.getLogger(TransformationService.class);

    private final ModelService modelService;

    @Autowired
    public TransformationService(ModelService modelService) {
        this.modelService = modelService;
    }

    public String convertModelToCpf(final String content, final String format) {
        Transformation transformation = ModelTransformationFactory.getTransformer(format);
        return transformation.toCpf(content).getContent();
    }

    public String convertModelToModel(final String content, final String format) {
        Transformation transformation = ModelTransformationFactory.getTransformer(format);
        return transformation.transform(content);
    }

//    public TransformationDTO transformModelToModel(Model model) {
//        Transformation transformation = ModelTransformationFactory.getTransformer(model.getModelingLanguage().toLowerCase(Locale.ROOT));
//        return convertToDTO(model, transformation.transform(model.getModel()));
//    }

//    public TransformationDTO transformModelToCpf(Model model) {
//        Transformation transformation = ModelTransformationFactory.getTransformer(model.getModelingLanguage().toLowerCase(Locale.ROOT));
//        return convertToDTO(model, transformation.toCpf(model.getModel()).getContent());
//    }

    public List<TransformationDTO> getProcessModels(final String format) {
        List<TransformationDTO> transformationDTOs = new ArrayList<>();
        modelService.findAll().forEach(model -> {
            if (!model.getModelingLanguage().equals(format)) {
                Transformation transformation = ModelTransformationFactory.getTransformer(model.getModelingLanguage());
                transformationDTOs.add(convertToDTO(model, transformation.transform(model.getCModel())));
            }
        });
        return transformationDTOs;
    }

    private TransformationDTO convertToDTO(Model originalModel, String transformationResult) {
        return TransformationDTO.builder()
                .id(originalModel.getId())
                .fileName(originalModel.getFileName())
                .modelingLanguage(originalModel.getModelingLanguage())
                .repository(originalModel.getRepository())
                .path(originalModel.getPath())
                .model(transformationResult)
                .elements(originalModel.getElements())
                .createdAt(originalModel.getCreatedAt())
                .updatedAt(originalModel.getUpdatedAt())
                .build();
    }
}
