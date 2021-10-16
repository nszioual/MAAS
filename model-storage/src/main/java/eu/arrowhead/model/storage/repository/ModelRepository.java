package eu.arrowhead.model.storage.repository;

import eu.arrowhead.model.storage.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends ElasticsearchRepository<Model, String> {

    List<Model> findByName(String name);

    List<Model> findByNameContaining(String name);

    Page<Model> findByNameContaining(String name, PageRequest pageRequest);
}
