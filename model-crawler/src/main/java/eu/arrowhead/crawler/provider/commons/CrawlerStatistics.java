package eu.arrowhead.crawler.provider.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerStatistics {
    private int collectedModels = 0;
    private int nonValidModels = 0;
    private int totalLinksCount = 0;
    private String crawlerStatus = "standby";

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
