package eu.arrowhead.api.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDataDTO {
    private String url;
    private int stars;
    private int forks;
    private int branches;
}
