package eu.arrowhead.model.filter.provider.dto;

import eu.arrowhead.model.filter.provider.dto.search.SearchElement;
import eu.arrowhead.model.filter.provider.dto.search.SearchRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchFormDTO {
    private String name;
    private String format;
    private HashMap<String, SearchElement> elements;
    private SearchRepository repository;
}


