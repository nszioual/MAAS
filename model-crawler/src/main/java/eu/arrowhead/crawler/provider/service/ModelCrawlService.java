package eu.arrowhead.crawler.provider.service;

import eu.arrowhead.api.commons.domain.DomainLinkerService;
import eu.arrowhead.crawler.provider.commons.CrawlerStatistics;
import eu.arrowhead.crawler.provider.crawler.Crawler;
import eu.arrowhead.crawler.provider.crawler.GitHubPageProcessor;
import eu.arrowhead.crawler.provider.crawler.GitHubSearchPageProcessor;
import eu.arrowhead.model.storage.service.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelCrawlService {

    private static final Logger logger = LoggerFactory.getLogger(ModelCrawlService.class);

    private final ModelService modelService;

    private final DomainLinkerService domainLinkerService;

    private final CrawlerStatistics stats;

    private Crawler crawler;

    private boolean crawlerIsRunning;

    @Value("${crawler.politeness.delay}")
    private Integer politenessDelay;

    @Value("${github.user.name}")
    private String userName;

    @Value("${github.user.password}")
    private String userPassword;

    @Autowired
    public ModelCrawlService(ModelService modelService, DomainLinkerService domainLinkerService) {
        this.modelService = modelService;
        this.domainLinkerService = domainLinkerService;
        this.stats = new CrawlerStatistics();
    }

    @Async
    public void startCrawler(List<String> urls) {
        crawler = new Crawler(new GitHubPageProcessor(politenessDelay, modelService, domainLinkerService));

        logger.info("adding github repositories to queue...");

        for (String url : urls) {
            crawler.addUrl(url);
        }

        logger.info("started crawling potential process models...");

        crawler.crawl();
    }

    @Async
    public void startCrawler(String startingUrl, String format) {
        logger.info("started crawling potential process models...");
        crawlerIsRunning = true;
        crawler = new Crawler(new GitHubSearchPageProcessor(politenessDelay, modelService, domainLinkerService, userName, userPassword, format, stats));
        crawler.addUrl(startingUrl);
        crawler.crawl();
    }

    @Async
    public void startCrawlerWithOptions(String startingUrl, String format, String givenUsername, String givenPassword) {
        logger.info("started crawling potential process models...");
        crawlerIsRunning = true;
        crawler = new Crawler(new GitHubSearchPageProcessor(politenessDelay, modelService, domainLinkerService, givenUsername, givenPassword, format, stats));
        crawler.addUrl(startingUrl);
        crawler.crawl();
    }

    public void stopCrawler() {
        try {
            logger.info("stopping crawling service...");

            crawlerIsRunning = false;

            crawler.stopExecutorService(5);
        } catch (InterruptedException e) {
            logger.error(e.toString());
        }
    }

    public CrawlerStatistics getCrawlerStatistics() {
        return stats;
    }

    public String getStatus() {
        return crawlerIsRunning ? "running" : "idle";
    }
}
