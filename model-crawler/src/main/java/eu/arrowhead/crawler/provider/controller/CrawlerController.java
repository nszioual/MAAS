package eu.arrowhead.crawler.provider.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.util.GHURLUtil;
import eu.arrowhead.crawler.provider.commons.CrawlerStatistics;
import eu.arrowhead.crawler.provider.dto.CrawlerOptionsDTO;
import eu.arrowhead.crawler.provider.exception.InvalidIntervalException;
import eu.arrowhead.crawler.provider.exception.InvalidModelFormatException;
import eu.arrowhead.crawler.provider.exception.InvalidPageException;
import eu.arrowhead.crawler.provider.service.ModelCrawlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Crawler controller.
 */
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

    //=================================================================================================
    // methods

    /**
     * Get crawler status.
     *
     * @return the response entity
     */
    @GetMapping(value = "")
    public ResponseEntity<?> crawlerStatus() {
        CrawlerStatistics stats = modelCrawlService.getCrawlerStatistics();
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("collectedModels", stats.getCollectedModels());
            put("nonValidModels", stats.getNonValidModels());
            put("totalLinksCount", stats.getTotalLinksCount());
            put("status", modelCrawlService.getStatus());
        }});
    }

    /**
     * Launch web crawler.
     *
     * @return the response entity
     */
    @PostMapping(value = "")
    public ResponseEntity<?> startCrawlTaskWithOptions(@RequestBody CrawlerOptionsDTO options) {
        String format = options.getExtension().contains(":") ? options.getExtension().split(":")[1].trim() : options.getExtension();

        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        if (!options.getUserName().isEmpty() && !options.getPassWord().isEmpty()) {
            modelCrawlService.startCrawlerWithOptions(GHURLUtil.buildGitHubSearchURL(format, 1, 0, 250), format, options.getUserName(), options.getPassWord());
        } else {
            modelCrawlService.startCrawler(GHURLUtil.buildGitHubSearchURL(format, 1, 0, 250), format);
        }

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "running");
        }});
    }

    /**
     * Launch web crawler.
     *
     * @return the response entity
     */
    @GetMapping(value = "", params = {"format"})
    public ResponseEntity<?> startCrawlTask(@RequestParam(name = "format") String format) {
        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        modelCrawlService.startCrawler(GHURLUtil.buildGitHubSearchURL(format, 1, 0, 250), format);

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "running");
        }});
    }

    /**
     * Launch web crawler.
     *
     * @return the response entity
     */
    @GetMapping(value = "", params = {"format", "page"})
    public ResponseEntity<?> startCrawlTask(@RequestParam(name = "format") String format,
                                            @RequestParam(name = "page") Integer page) {
        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        if (page <= 0) {
            throw new InvalidPageException(page);
        }

        modelCrawlService.startCrawler(GHURLUtil.buildGitHubSearchURL(format, page, 0, 250), format);

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "running");
        }});
    }

    /**
    /**
     * Launch web crawler.
     *
     * @return the response entity
     */
    @GetMapping(value = "", params = {"format", "page", "lower", "upper"})
    public ResponseEntity<?> startCrawlTask(@RequestParam(name = "format") String format,
                                            @RequestParam(name = "page") Integer page,
                                            @RequestParam(name = "lower") Integer lower,
                                            @RequestParam(name = "upper") Integer upper) {
        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        if (page <= 0) {
            throw new InvalidPageException(page);
        }

        if (upper <= lower) {
            throw  new InvalidIntervalException(lower, upper);
        }

        modelCrawlService.startCrawler(GHURLUtil.buildGitHubSearchURL(format, page, lower, upper), format);

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "running");
        }});
    }


    @GetMapping(value = "/stop")
    public ResponseEntity<?> stopCrawlTask() {
        modelCrawlService.stopCrawler();
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "idle");
        }});
    }

    /**
     * Launch web crawler.
     *
     * @return the response entity
     */
    @GetMapping(value = "/ghtorrent", params = "format")
    public ResponseEntity<?> crawlGHTorrent(@RequestParam(name = "format", required = false) String format) {
        if (!format.equals(ApiConstants.BPMN) && !format.equals(ApiConstants.EPML)) {
            throw new InvalidModelFormatException(format);
        }

        modelCrawlService.startCrawler(readGitHubLinksFromCSV("model-crawler/src/main/resources/crawler/repos.csv"));

        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("status", "running");
        }});
    }

    private List<String> readGitHubLinksFromCSV(String path) {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
