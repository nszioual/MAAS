package eu.arrowhead.crawler.provider.crawler;

import eu.arrowhead.api.commons.canoniser.CpfContentPair;
import eu.arrowhead.api.commons.canoniser.factory.ModelTransformationFactory;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.metadata.CpfMetadataExtractor;
import eu.arrowhead.api.commons.util.StringUtil;
import eu.arrowhead.api.commons.validation.factory.ModelValidatorFactory;
import eu.arrowhead.model.storage.Utils;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.model.Version;
import eu.arrowhead.model.storage.service.ModelService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class PageProcessor {

    protected static final Logger logger = LoggerFactory.getLogger(PageProcessor.class);

    protected static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    protected final Integer politenessDelay;
    protected final ModelService modelService;
    private final DomainLinkerService domainLinkerService;

    public PageProcessor(Integer politenessDelay, ModelService modelService, DomainLinkerService domainLinkerService) {
        this.politenessDelay = politenessDelay;
        this.modelService = modelService;
        this.domainLinkerService = domainLinkerService;
    }

    public abstract Set<String> processPage(String url);

    protected abstract Set<String> getOutgoingLinks(String url) throws IOException;

    protected void saveModel(String url, String extension, String content) throws IOException {
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata();
        saveModel(url, extension, content, repositoryMetadata);
    }

    protected void saveModel(String url, String extension, String content, RepositoryMetadata repositoryMetadata) {
        CpfContentPair cpfResult = modelToCpf(extension, content);

        Model model = new Model();
        model.setPath(url);
        model.setRepository(repositoryMetadata);
        model.setModel(content);
        model.setCModel(cpfResult.getContent());
        model.setElements(CpfMetadataExtractor.extractMetadata(cpfResult.getCpf()));
        model.setName(FilenameUtils.removeExtension(Utils.extractFileNameFromURL(model.getPath())));

        List<Domain> domains = modelService.getDomains();
        domainLinkerService.linkModelToDomains(model, domains);
        model.getVersions().put(model.getVersionNumber(), new Version(model));

        logger.info("storing process model in Elasticsearch {}", url);

        modelService.create(model);
    }

    protected boolean modelIsValid(String url, String content) {
        String extension = StringUtil.getExtensionByStringHandling(url).get();
        return Objects.requireNonNull(ModelValidatorFactory
                .getValidator(extension))
                .validateSchema(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)))
                .equals(ApiConstants.XML_VALID);
    }

    protected CpfContentPair modelToCpf(String extension, String content) {
        return ModelTransformationFactory.getTransformer(extension).toCpf(content);
    }

    protected abstract boolean linkAllowed(String link);
}
