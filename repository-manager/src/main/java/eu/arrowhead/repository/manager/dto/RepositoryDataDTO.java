package eu.arrowhead.repository.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDataDTO {
    private String repository;
    private int stars;
    private int forks;
    private int branches;
}
