package eu.arrowhead.model.filter.provider.service.criteria.spec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria(String key, Object value, String operation) {
        this.key = key;
        this.value = value.toString();
        this.operation = SearchOperation.getSearchOperation(operation);
    }
}
