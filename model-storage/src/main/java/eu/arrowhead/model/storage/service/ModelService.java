package eu.arrowhead.model.storage.service;

import eu.arrowhead.model.storage.Utils;
import eu.arrowhead.model.storage.exception.DuplicateModelException;
import eu.arrowhead.model.storage.exception.ModelNotFoundException;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.repository.ModelRepository;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static eu.arrowhead.model.storage.Utils.getExtensionByStringHandling;

@Service
public class ModelService {

    private static final Logger logger = LoggerFactory.getLogger(ModelService.class);

    private final ModelRepository modelRepository;

    private final DomainService domainService;

    @Autowired
    public ModelService(ModelRepository modelRepository, DomainService domainService) {
        this.modelRepository = modelRepository;
        this.domainService = domainService;
    }

    public List<Domain> getDomains() {
        return domainService.findAll();
    }

    public Optional<Model> findById(final String Id) {
        return modelRepository.findById(Id);
    }

    public List<Model> findByName(final String name) {
        return modelRepository.findByName(name);
    }

    public List<Model> findByFileName(final String modelName) {
        return modelRepository.findByFileName(modelName);
    }

    public List<Model> findAll() {
        List<Model> models = new ArrayList<>();
        modelRepository.findAll().forEach(models::add);
        return models;
    }

    public Page<Model> findAll(PageRequest pageRequest) {
        return modelRepository.findAll(pageRequest);
    }

    public Model create(Model model) {
        if (!findByName(model.getName()).isEmpty()) {
            throw new DuplicateModelException(model.getFileName());
        }
        String modelFileName =  Utils.extractFileNameFromURL(model.getPath());
        model.setFileName(modelFileName);
        model.setModelingLanguage(getExtensionByStringHandling(model.getFileName()).orElse("N/A").toUpperCase());
        return modelRepository.save(model);
    }

    public Model create(Model model, MultipartFile file) {
        if (!findByName(model.getName()).isEmpty()) {
            throw new DuplicateModelException(model.getName());
        }
        createFileVersion(file, model);
        return modelRepository.save(model);
    }

    public void delete(Model model) {
        modelRepository.delete(model);
    }

    public void deleteAll() {
        modelRepository.deleteAll();
    }

    public Model update(Model newModel) {
        Model oldModel = modelRepository.findById(newModel.getId()).orElseThrow(() -> new ModelNotFoundException(newModel.getId()));
        return updateModel(oldModel, newModel);
    }

    public Model update(Model newModel, String id) {
        Model oldModel = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(id));
        return updateModel(oldModel, newModel);
    }

    public Model update(Model newModel, String id, MultipartFile file) {
        Model oldModel = modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(id));
        oldModel.setPath(newModel.getPath());
        oldModel.setCModel(newModel.getCModel());

        if (file != null && !file.isEmpty()) {
            createFileVersion(file, oldModel);
        } else {
            oldModel.setFileName(newModel.getFileName());
            oldModel.setModelingLanguage(newModel.getModelingLanguage());
            oldModel.setModel(newModel.getModel());
        }

        return modelRepository.save(oldModel);
    }

    private Model updateModel(Model oldModel, Model newModel) {
        oldModel.setFileName(newModel.getFileName());
        oldModel.setModelingLanguage(newModel.getModelingLanguage());
        oldModel.setRepository(newModel.getRepository());
        oldModel.setPath(newModel.getPath());
        oldModel.setModel(newModel.getModel());
        oldModel.setCModel(newModel.getCModel());
        return modelRepository.save(oldModel);
    }

    private void createFileVersion(MultipartFile file, Model model) {
        try {
            model.setFileName(file.getOriginalFilename());
            model.setModelingLanguage(getExtensionByStringHandling(file.getOriginalFilename()).orElse("N/A").toUpperCase());
            model.setModel(new String(file.getBytes(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.warn(e.toString());
        }
    }
}
