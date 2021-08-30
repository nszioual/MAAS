package eu.arrowhead.crawler.provider.crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.util.StringUtil;
import eu.arrowhead.crawler.provider.commons.Utils;
import eu.arrowhead.model.storage.service.ModelService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GitHubPageProcessor extends PageProcessor {

    private static final Pattern MODEL_PATTERN = Pattern.compile(".*(\\.(bpmn|epml))$");

    public GitHubPageProcessor(Integer politenessDelay, ModelService modelService, DomainLinkerService domainLinkerService) {
        super(politenessDelay, modelService, domainLinkerService);
    }

    @Override
    public Set<String> processPage(String url) {
        try {
            Thread.sleep(this.politenessDelay); // Add delay between requests
            if (MODEL_PATTERN.matcher(url).matches()) {
                String model =  Utils.downloadModel(Utils.getDownloadURL(Jsoup.connect(url).userAgent(USER_AGENT).get()));
                if (modelIsValid(url, model)) {
                    String extension = StringUtil.getExtensionByStringHandling(url).get();
                    saveModel(url, extension, model);
                } else {
                    logger.warn("skipping non valid model: {}", url);
                }
            } else {
                return getOutgoingLinks(url);
            }
        } catch (IOException | InterruptedException e) {
            logger.warn("URL: {}, {}", url, e);
        }

        return new HashSet<>();
    }

    protected Set<String> getOutgoingLinks(String url) throws IOException {
        WebClient client = Utils.getConfiguredWebClient();
        HtmlPage page = client.getPage(url);
        Document document = Jsoup.parse(page.asXml());
        client.close();

        // Fetch all outgoing links leading to files in the file tree
        return document.select("div.js-details-container a[href^=\"" + Utils.extractRepoName(url) + "\"]")
                .stream()
                .map(e -> ApiConstants.GITHUB_BASE_URL + e.attr("href"))
                .filter(this::linkAllowed)
                .map(Utils::trimURL)
                .collect(Collectors.toSet());
    }

    @Override
    protected boolean linkAllowed(String link) {
        return link.contains("tree/master")
                || (link.contains("blob/master") && MODEL_PATTERN.matcher(link).matches());
    }
}
