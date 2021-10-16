package eu.arrowhead.model.filter.provider.service;

import eu.arrowhead.model.filter.provider.service.criteria.ModelCriteriaBuilder;
import eu.arrowhead.model.filter.provider.service.criteria.spec.SearchCriteria;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Model query service.
 */
@Service
public class ModelQueryService {

    private final ModelSearchService modelSearchService;

    /**
     * Instantiates a new Model query service.
     *
     * @param modelSearchService the model search service
     */
    @Autowired
    public ModelQueryService(ModelSearchService modelSearchService) {
        this.modelSearchService = modelSearchService;
    }

    /**
     * Find models by criteria list.
     *
     * @param criterias the criterias
     * @return the list
     */
    public List<Model> findModelsByCriteria(List<SearchCriteria> criterias) {
        ModelCriteriaBuilder modelCriteriaBuilder = new ModelCriteriaBuilder();
        modelCriteriaBuilder.setCriterias(criterias);
        return modelSearchService.findAllModelsByCriteria(modelCriteriaBuilder.build());
    }
}
