package eu.arrowhead.model.storage.service;

import eu.arrowhead.model.storage.exception.DuplicateDomainException;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.repository.DomainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomainService {

    private static final Logger logger = LoggerFactory.getLogger(DomainService.class);

    private final DomainRepository domainRepository;

    @Autowired
    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public Optional<Domain> findById(final String Id) {
        return domainRepository.findById(Id);
    }

    public List<Domain> findByName(final String name) {
        return domainRepository.findByName(name);
    }

    public Page<Domain> findByNameContaining(final String name, PageRequest pageRequest) {
        return domainRepository.findByNameContaining(name, pageRequest);
    }

    public List<Domain> findAll() {
        List<Domain> domains = new ArrayList<>();
        domainRepository.findAll().forEach(domains::add);
        return domains;
    }

    public Page<Domain> findAll(PageRequest pageRequest) {
        return domainRepository.findAll(pageRequest);
    }

    public Domain create(Domain domain) {
        if (!findByName(domain.getName()).isEmpty()) {
            throw new DuplicateDomainException(domain.getName());
        }
        return domainRepository.save(domain);
    }

    public void delete(Domain domain) {
        domainRepository.delete(domain);
    }

    public Domain update(Domain oldDomain, Domain newDomain) {
        oldDomain.setName(newDomain.getName());
        oldDomain.setTags(newDomain.getTags());
        return domainRepository.save(oldDomain);
    }
}
