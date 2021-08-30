package eu.arrowhead.crawler.provider.controller;

import eu.arrowhead.crawler.provider.service.ModelCrawlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    private final ModelCrawlService modelCrawlService;

    private final SimpMessagingTemplate template;

    @Autowired
    public StatisticsController(ModelCrawlService modelCrawlService, SimpMessagingTemplate template) {
        this.modelCrawlService = modelCrawlService;
        this.template = template;
    }

    public void stats() {
        logger.info("The time is now {}", new SimpleDateFormat().format(new Date()));
        template.convertAndSend("message/stats", this.modelCrawlService.getCrawlerStatistics());
    }
}
