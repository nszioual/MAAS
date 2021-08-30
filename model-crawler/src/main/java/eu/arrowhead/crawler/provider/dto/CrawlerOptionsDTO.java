package eu.arrowhead.crawler.provider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrawlerOptionsDTO {
    private String extension;
    private String userName;
    private String passWord;
}
