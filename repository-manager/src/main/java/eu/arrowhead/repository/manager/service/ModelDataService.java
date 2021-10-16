package eu.arrowhead.repository.manager.service;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.dto.CreateModelDTO;
import eu.arrowhead.api.commons.dto.RepositoryDataDTO;
import eu.arrowhead.api.commons.metadata.CpfMetadataExtractor;
import eu.arrowhead.api.commons.validation.factory.ModelValidatorFactory;
import eu.arrowhead.model.storage.Utils;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.model.Version;
import eu.arrowhead.model.storage.service.ModelService;
import eu.arrowhead.repository.manager.exception.InvalidModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;

import static eu.arrowhead.model.storage.Utils.getExtensionByStringHandling;

@Service
public class ModelDataService {

    private final ModelService modelService;

    private final DomainLinkerService domainLinkerService;

    @Autowired
    public ModelDataService(ModelService modelService, DomainLinkerService domainLinkerService) {
        this.modelService = modelService;
        this.domainLinkerService = domainLinkerService;
    }

    public Model createModel(CreateModelDTO modelData, MultipartFile file) {
        CpfContentPair cpfResult = getCpfFromFile(file);

        if (cpfResult == null) throw new InvalidModelException();

        Model model = new Model(
                modelData.getName(),
                modelData.getDescription(),
                modelData.getPath(),
                modelData.getType(),
                modelData.getRepoUrl(),
                modelData.getVersionNumber(),
                modelData.getStars(),
                modelData.getForks(),
                modelData.getBranches()
        );

        model.setModel(getFileContent(file));
        model.setCModel(cpfResult.getContent());
        model.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));
        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(model, domains);
        model.getVersions().put(model.getVersionNumber(), new Version(model));

        return modelService.create(model, file);
    }

    public void createModel(
            RepositoryDataDTO repositoryDTO,
            ZipEntry zipEntry,
            ByteArrayOutputStream in) {
        String fileName = zipEntry.getName().split("/")[1];
        String extension = Utils.getExtensionByStringHandling(fileName).get();
        String content = in.toString(StandardCharsets.UTF_8);
        if (modelIsValid(extension, content)) {
            RepositoryMetadata repositoryMetadata = new RepositoryMetadata();
            repositoryMetadata.setUrl(repositoryDTO.getUrl());
            repositoryMetadata.setForks(repositoryDTO.getForks());
            repositoryMetadata.setStars(repositoryDTO.getStars());
            repositoryMetadata.setBranches(repositoryDTO.getBranches());
            createModel(fileName, extension, content, repositoryMetadata);
        }
    }

    public void createModel(
            String name,
            String extension,
            String content,
            RepositoryMetadata repositoryMetadata) {
        Model model = getModel(name, content, extension, repositoryMetadata);
        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(model, domains);
        modelService.create(model);
    }

    public Model updateModel(
            CreateModelDTO updatedModel,
            String id,
            MultipartFile file) {
        Model model = getModel(
                updatedModel.getName(),
                getFileContent(file),
                updatedModel.getType(),
                updatedModel.getPath(),
                new RepositoryMetadata(
                        updatedModel.getRepoUrl(),
                        updatedModel.getStars(),
                        updatedModel.getForks(),
                        updatedModel.getBranches()
                ));

        model.setDescription(updatedModel.getDescription());
        model.getVersions().put(model.getVersionNumber(), new Version(model));

        return modelService.update(model, id, file);
    }

    private boolean modelIsValid(String extension, String content) {
        return Objects.requireNonNull(ModelValidatorFactory.getValidator(extension))
                .validateSchema(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)))
                .equals(ApiConstants.XML_VALID);
    }

    private CpfContentPair modelToCpf(String extension, String content) {
        return ModelTransformationFactory.getTransformer(extension).toCpf(content);
    }

    private Model getModel(
            String name,
            String content,
            String extension,
            RepositoryMetadata repositoryMetadata) {
        return getModel(name, content, extension, "", repositoryMetadata);
    }

    private Model getModel(
            String name,
            String content,
            String extension,
            String path,
            RepositoryMetadata repositoryMetadata) {
        CpfContentPair cpfResult = modelToCpf(extension, content);

        if (cpfResult == null) throw new InvalidModelException();

        Model model = new Model();
        model.setName(name);
        model.setFileName(name);
        model.setPath(path);
        model.setModel(content);
        model.setCModel(cpfResult.getContent());
        model.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));
        model.setRepository(repositoryMetadata);

        return model;
    }

    /**
     * Extract the CPF from a process model file.
     *
     * @param file the process model file
     * @return the CPF of the process model
     */
    private CpfContentPair getCpfFromFile(MultipartFile file) {
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

    /**
     * Extracts the contents of a file as a String
     *
     * @param file the process model file
     * @return the contents of the file
     */
    private String getFileContent(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return "";
        }
        try {
            return new String(file.getBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
