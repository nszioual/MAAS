package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

/**
 * The domain controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.DOMAINS_URI)
public class DomainsProviderController {

    private final DomainService domainService;

    @Autowired
    public DomainsProviderController(DomainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping(path = "")
    @ResponseBody public ResponseEntity<?> createDomain(@RequestBody Domain domain) {
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("domain", domainService.create(domain));
        }});
    }

    /**
     * Gets models.
     *
     * @param name the name
     * @return the models
     */
    @GetMapping(value = "")
    @ResponseBody public ResponseEntity<?> getDomains(@RequestParam(value = ApiConstants.REQUEST_PARAM_MODEL_NAME, required = false) Optional<String> name,
                                                      @RequestParam(value = ApiConstants.REQUEST_PARAM_MODELS_PAGE, required = false) Optional<Integer> page) {
        Page<Domain> domains = name.isEmpty() ? domainService.findAll(PageRequest.of(page.orElse(0), 8)) : domainService.findByNameContaining(name.get(), PageRequest.of(page.orElse(0), 8));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("domains", domains.getContent());
            put("totalElements", domains.getTotalElements());
            put("totalPages", domains.getTotalPages());
        }});
    }
}
