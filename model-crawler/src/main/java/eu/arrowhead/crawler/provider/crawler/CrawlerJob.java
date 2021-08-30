package eu.arrowhead.crawler.provider.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class CrawlerJob implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(CrawlerJob.class);

    final ExecutorService executorService;
    final ConcurrentHashMap<String, Boolean> submitted;
    final String url;
    final PageProcessor processor;

    public CrawlerJob(ExecutorService executorService,
                      ConcurrentHashMap<String,Boolean> submitted,
                      String url, PageProcessor processor) {
        this.executorService = executorService;
        this.submitted = submitted;
        this.url = url;
        this.processor = processor;
    }

    @Override
    public void run() {
        logger.info("visiting {}", url);

        Set<String> hrefs = processor.processPage(url);

        hrefs.forEach(href -> {
            if (!submitted.getOrDefault(href, false)) {
                submitted.put(href, true);
                CrawlerJob job = new CrawlerJob(executorService, submitted, href, processor);
                executorService.submit(job);
            }
        });
    }
}
