package eu.arrowhead.api.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateModelDTO {
    private String name;
    private String description;
    private String path;
    private String type;
    private String repoUrl;
    private String versionNumber = "1.0.0";
    private int stars = 0;
    private int forks = 0;
    private int branches = 0;
}
