package eu.arrowhead.crawler.provider.crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.api.commons.util.GHURLUtil;
import eu.arrowhead.crawler.provider.commons.CrawlerStatistics;
import eu.arrowhead.crawler.provider.commons.Utils;
import eu.arrowhead.model.storage.metadata.RepositoryMetadata;
import eu.arrowhead.model.storage.service.ModelService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GitHubSearchPageProcessor extends PageProcessor {

    private static final Pattern MODEL_PATTERN = Pattern.compile(".*(\\.(bpmn|epml))$");

    private static int sizeLower = 0;
    private static int sizeUpper = 250;
    private static int numberOfResults = 0;
    private final static int maxSearchResults = 1000;
    private final static int intervalStepSize = 250;

    private final String userName;
    private final String userPassword;
    private final String format;
    private final CrawlerStatistics stats;

    public GitHubSearchPageProcessor(Integer politenessDelay,
                                     ModelService modelService,
                                     DomainLinkerService domainLinkerService,
                                     String userName,
                                     String userPassword,
                                     String format,
                                     CrawlerStatistics stats) {
        super(politenessDelay, modelService, domainLinkerService);
        this.userName = userName;
        this.userPassword = userPassword;
        this.format = format;
        this.stats = stats;
    }

    @Override
    public Set<String> processPage(String url) {
        try {
            Thread.sleep(this.politenessDelay); // Add delay between requests
            if (MODEL_PATTERN.matcher(url).matches()) {
                String extension = url.substring(url.lastIndexOf(".") + 1);
                if (extension.equalsIgnoreCase(format)) {
                    Document doc = Jsoup.connect(url).userAgent(USER_AGENT).get();
                    String model = Utils.downloadModel(Utils.getDownloadURL(doc));
                    if (!modelIsValid(url, model)) {
                        logger.warn("skipping non valid model: {}", url);
                        stats.incrementNonValidModels();
                        return new HashSet<>();
                    }
                    saveModel(url, extension, model, getRepositoryMetadata(url));
                    stats.incrementCollectedModels();
                }
            } else {
                return getOutgoingLinks(url);
            }
        } catch (IOException | InterruptedException e) {
            logger.warn("URL: {}, {}", url, e);
        }

        return new HashSet<>();
    }

    @Override
    protected Set<String> getOutgoingLinks(String url) throws IOException {
        Set<String> outgoingLinks = new HashSet<>();

        // Configure webclient and set a login user session
        WebClient webClient = Utils.getConfiguredWebClient();
        HtmlPage loginPage = webClient.getPage(ApiConstants.GITHUB_LOGIN_URL);
        HtmlForm form = loginPage.querySelector("form");
        HtmlTextInput loginField = form.getInputByName("login");
        loginField.type(this.userName);
        HtmlPasswordInput passwordField = form.getInputByName("password");
        passwordField.type(this.userPassword);
        HtmlSubmitInput loginBtn = loginPage.querySelector("#login > div.auth-form-body.mt-3 > form > div > input.btn.btn-primary.btn-block");
        loginBtn.click();
        HtmlPage page = webClient.getPage(url);
        Document document = Jsoup.parse(page.asXml());
        webClient.close();

        // Setup pagination on search page
        Elements nextPageLinkElement = document.select(".next_page");
        Elements searchResultElement = document.select("div.flex-column:nth-child(1) > h3:nth-child(1)");
        if (searchResultElement.size() > 0 && nextPageLinkElement.size() > 0) {
            String searchResults = searchResultElement.first().childNode(0).toString().replaceAll(",", "").replaceAll("[^0-9]", "");
            if (!searchResults.isEmpty()) {
                numberOfResults = Integer.parseInt(searchResults);
                if (numberOfResults > maxSearchResults) {
                    outgoingLinks.add(GHURLUtil.buildGitHubSearchURL(format, 1, sizeLower, sizeLower + intervalStepSize / 2));
                    outgoingLinks.add(GHURLUtil.buildGitHubSearchURL(format, 1, sizeLower + intervalStepSize / 2, sizeUpper));
                } else {
                    sizeLower += intervalStepSize;
                    sizeUpper += intervalStepSize;
                    outgoingLinks.add(GHURLUtil.buildGitHubSearchURL(format, 1, sizeLower, sizeUpper));
                    outgoingLinks.add(ApiConstants.GITHUB_BASE_URL + document.select(".next_page").first().attr("href"));
                }
            }
        }

        // Fetch all outgoing links leading to files in the file tree
        if (numberOfResults <= maxSearchResults) {
            Set<String> processLinks = document.select("div.code-list a[href]").stream()
                    .map(e -> ApiConstants.GITHUB_BASE_URL + e.attr("href"))
                    .filter(this::linkAllowed)
                    .map(Utils::trimURL)
                    .collect(Collectors.toSet());

            outgoingLinks.addAll(processLinks);
        }

        stats.incrementLinksCount(outgoingLinks.size());

        return outgoingLinks;
    }

    private RepositoryMetadata getRepositoryMetadata(String modelURL) throws IOException {
        String repoURL = GHURLUtil.getGitHubURL(modelURL);
        Document doc = Jsoup.connect(repoURL).userAgent(USER_AGENT).get();

        RepositoryMetadata metadata = new RepositoryMetadata();
        metadata.setRepository(repoURL);

        Elements socialCount = doc.select("a.social-count");
        if (socialCount.size() > 1) {
            int starCount = Integer.parseInt(socialCount.get(0).childNode(0).toString().trim());
            int forkCount = Integer.parseInt(socialCount.get(1).childNode(0).toString().trim());
            metadata.setStars(starCount);
            metadata.setForks(forkCount);
        }

        Elements branches = doc.select(".flex-self-center > a:nth-child(1)");
        if (branches.size() > 0) {
            int branchCount = Integer.parseInt(branches.first().childNode(3).childNode(0).toString().trim());
            metadata.setBranches(branchCount);
        }
        
        return metadata;
    }

    @Override
    protected boolean linkAllowed(String link) {
        return MODEL_PATTERN.matcher(link).matches();
    }
}
