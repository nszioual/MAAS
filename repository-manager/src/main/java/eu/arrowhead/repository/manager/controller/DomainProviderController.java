package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.repository.manager.exception.DomainNotFoundException;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * The domain controller.
 */
@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping(ApiConstants.DOMAINS_URI)
public class DomainProviderController {

    private final DomainService domainService;

    @Autowired
    public DomainProviderController(DomainService domainService) {
        this.domainService = domainService;
    }

    @GetMapping(path = ApiConstants.BY_ID_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody public ResponseEntity<?> getDomain(@PathVariable String id) {
        if (domainService.findById(id).isEmpty()) {
            throw new DomainNotFoundException(id);
        }
        
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("domain", domainService.findById(id).get());
        }});
    }

    @PutMapping(path = ApiConstants.BY_ID_PATH)
    @ResponseBody public ResponseEntity<?> updateDomain(@RequestBody Domain newDomain, @PathVariable final String id) {
        return ResponseEntity.ok(domainService.findById(id)
                .map(domain -> domainService.update(domain, newDomain))
                .orElseGet(() -> domainService.create(newDomain)));
    }

    @DeleteMapping(path = ApiConstants.BY_ID_PATH)
    public ResponseEntity<?> deleteModel(@PathVariable(ApiConstants.PATH_VARIABLE_ID) final String id) {
        return domainService.findById(id).map(domain -> {
            domainService.delete(domain);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new DomainNotFoundException(id));
    }
}
