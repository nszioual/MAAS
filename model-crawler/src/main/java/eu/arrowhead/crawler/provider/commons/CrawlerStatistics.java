package eu.arrowhead.crawler.provider.commons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrawlerStatistics {
    private int collectedModels = 0;
    private int nonValidModels = 0;
    private int totalLinksCount = 0;

    public void incrementCollectedModels() {
        collectedModels++;
    }

    public void incrementNonValidModels() {
        nonValidModels++;
    }

    public void incrementLinksCount(int linksCount) {
        totalLinksCount += linksCount;
    }
}
