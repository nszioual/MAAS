package eu.arrowhead.crawler.provider.crawler;

import eu.arrowhead.crawler.provider.commons.CrawlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Crawler {

    private static final Logger logger = LoggerFactory.getLogger(Crawler.class);

    private final PageProcessor pageProcessor;
    private final ConcurrentHashMap<String, Boolean> submitted;
    private final CrawlerThreadPoolExecutor executorService;

    public Crawler(PageProcessor pageProcessor) {
        this.pageProcessor = pageProcessor;
        this.submitted = new ConcurrentHashMap<>();
        this.executorService = new CrawlerThreadPoolExecutor(Runtime.getRuntime().availableProcessors());
    }

    public void crawl() {
        while (true) {
            try {
                Thread.sleep(1000);
                long idleNano = System.nanoTime() - executorService.getLastExecutionTimeNano();
                if (executorService.getQueue().size() == 0 && idleNano >= CrawlerConstants.MAX_IDLE_NANO) {
                    if (stopExecutorService(10)) break;
                }
            } catch (InterruptedException e) {
                logger.error(e.toString());
                break;
            }
        }
    }

    public boolean stopExecutorService(int awaitTimeInSeconds) throws InterruptedException {
        executorService.shutdownNow();
        boolean terminated = executorService.awaitTermination(awaitTimeInSeconds, TimeUnit.SECONDS);
        if (terminated) {
            logger.info("Finished: terminating executor service...");
            return true;
        }
        return false;
    }

    public void addUrl(String url) {
        submitted.put(url, true);
        executorService.submit(new CrawlerJob(executorService, submitted, url, pageProcessor));
    }
}
