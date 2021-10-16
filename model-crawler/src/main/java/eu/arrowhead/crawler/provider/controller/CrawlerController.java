package eu.arrowhead.crawler.provider.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.util.GHURLUtil;
import eu.arrowhead.crawler.provider.commons.CrawlerConstants;
import eu.arrowhead.crawler.provider.dto.CrawlerOptionsDTO;
import eu.arrowhead.crawler.provider.exception.InvalidModelFormatException;
import eu.arrowhead.crawler.provider.service.ModelCrawlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.MODEL_CRAWLER_URI)
public class CrawlerController {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerController.class);

    private final ModelCrawlService modelCrawlService;

    @Autowired
    public CrawlerController(ModelCrawlService modelCrawlService) {
        this.modelCrawlService = modelCrawlService;
    }

    /**
     * Launches the model crawler with additional options.
     *
     * @param options crawler options
     * @return the response entity
     */
    @PostMapping(value = "")
    public ResponseEntity<?> startCrawlTaskWithOptions(@RequestBody CrawlerOptionsDTO options) {
        String format = options.getExtension().contains(":") ? options.getExtension().split(":")[1].trim() : options.getExtension();

        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        modelCrawlService.startCrawlerWithOptions(
                GHURLUtil.buildGitHubSearchURL(format, CrawlerConstants.GSEARCH_PAGE, CrawlerConstants.GSEARCH_LOWER, CrawlerConstants.GSEARCH_UPPER),
                format, options.getUserName(), options.getPassWord()
        );

        return ResponseEntity.ok("");
    }

    /**
     * Sends a shutdown signal to the model crawler.
     *
     * @return the response entity
     */
    @GetMapping(value = "/stop")
    public ResponseEntity<?> stopCrawlTask() throws InterruptedException {
        logger.info("Shutting down...");
        modelCrawlService.stopCrawler();
        return ResponseEntity.ok("");
    }
}
