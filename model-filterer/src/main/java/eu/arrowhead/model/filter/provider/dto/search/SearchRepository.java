package eu.arrowhead.model.filter.provider.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRepository {
    String repositoryName;
    SearchElement numberOfForks;
    SearchElement numberOfStars;
}
