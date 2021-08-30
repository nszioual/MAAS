package eu.arrowhead.model.filter.provider.service.criteria;

import eu.arrowhead.model.filter.provider.service.criteria.spec.BetweenOperator;
import eu.arrowhead.model.filter.provider.service.criteria.spec.SearchCriteria;
import eu.arrowhead.model.filter.provider.service.criteria.spec.SearchOperation;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

public class ModelCriteriaBuilder {

    private List<SearchCriteria> criterias;

    public ModelCriteriaBuilder() {
        this.criterias = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        criterias.add(criteria);
    }

    public void setCriterias(List<SearchCriteria> criterias) {
        this.criterias = criterias;
    }

    public Criteria build() {
        // Build a new criteria query
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria());

        // Add criteria to query
        for (SearchCriteria criteria : criterias) {
            if (criteria.getOperation() == null
                    || criteria.getValue() == null
                    || criteria.getValue().toString().isEmpty()) {
                continue;
            }
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).greaterThan(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).lessThan(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).greaterThanEqual(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).lessThanEqual(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).not().is(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).is(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.BETWEEN)) {
                BetweenOperator betweenOperator = (BetweenOperator) criteria.getValue();
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).between(betweenOperator.getLower(), betweenOperator.getUpper()));
            } else if (criteria.getOperation().equals(SearchOperation.LIKE)) {
                criteriaQuery.addCriteria(new Criteria(criteria.getKey()).contains(criteria.getValue().toString()));
            }
        }

        return criteriaQuery.getCriteria();
    }
}
