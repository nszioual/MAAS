package eu.arrowhead.model.filter.provider.service;

import eu.arrowhead.model.filter.provider.service.criteria.ModelCriteriaBuilder;
import eu.arrowhead.model.filter.provider.service.criteria.spec.SearchCriteria;
import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.service.ModelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelQueryService {

    private final ModelSearchService modelSearchService;

    @Autowired
    public ModelQueryService(ModelSearchService modelSearchService) {
        this.modelSearchService = modelSearchService;
    }

    public List<Model> findModelsByCriteria(List<SearchCriteria> criterias) {
        ModelCriteriaBuilder modelCriteriaBuilder = new ModelCriteriaBuilder();
        modelCriteriaBuilder.setCriterias(criterias);
        return modelSearchService.findAllModelsByCriteria(modelCriteriaBuilder.build());
    }
}
