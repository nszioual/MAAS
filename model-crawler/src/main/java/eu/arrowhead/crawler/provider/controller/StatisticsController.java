package eu.arrowhead.crawler.provider.controller;

import eu.arrowhead.crawler.provider.commons.CrawlerStatistics;
import eu.arrowhead.crawler.provider.service.ModelCrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * The Statistics controller.
 */
@Controller
public class StatisticsController {

    private final ModelCrawlService modelCrawlService;

    /**
     * Instantiates a new Statistics controller.
     *
     * @param modelCrawlService the model crawl service
     */
    @Autowired
    public StatisticsController(ModelCrawlService modelCrawlService) {
        this.modelCrawlService = modelCrawlService;
    }

    /**
     * Gets crawler statistics.
     *
     * @param message the message
     * @return the crawler statistics
     */
    @MessageMapping("/stats")
    @SendTo("/topic/messages")
    public CrawlerStatistics stats(String message) {
        return modelCrawlService.getCrawlerStatistics();
    }
}
