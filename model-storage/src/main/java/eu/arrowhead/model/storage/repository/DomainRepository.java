package eu.arrowhead.model.storage.repository;

import eu.arrowhead.model.storage.model.Domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DomainRepository extends ElasticsearchRepository<Domain, String> {

    List<Domain> findByName(String name);

    List<Domain> findByNameContaining(String name);

    Page<Domain> findByNameContaining(String name, PageRequest pageRequest);
}
