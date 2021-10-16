package eu.arrowhead.model.storage.service;

import eu.arrowhead.model.storage.model.Model;
import eu.arrowhead.model.storage.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelSearchService {

    private static final String MODEL_INDEX = "model";

    private final ElasticsearchOperations elasticsearchOperations;

    private final ModelRepository modelRepository;

    @Autowired
    public ModelSearchService(ElasticsearchOperations elasticsearchOperations, final ModelRepository modelRepository) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.modelRepository = modelRepository;
    }

    public List<Model> findAllModelsByCriteria(Criteria criteria) {
        Query searchQuery = new CriteriaQuery(criteria);
        SearchHits<Model> modelSearchHits =
                elasticsearchOperations
                        .search(searchQuery,
                                Model.class,
                                IndexCoordinates.of(MODEL_INDEX));

        List<Model> modelSearchMatches = new ArrayList<>();
        modelSearchHits.forEach(searchHit -> modelSearchMatches.add(searchHit.getContent()));
        return modelSearchMatches;
    }

    public Page<Model> findByModelMatchingNames(final String modelName, PageRequest pageRequest) {
        return modelRepository.findByNameContaining(modelName, pageRequest);
    }
}
