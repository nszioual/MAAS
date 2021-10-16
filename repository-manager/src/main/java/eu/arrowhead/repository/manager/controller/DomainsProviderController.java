package eu.arrowhead.repository.manager.controller;

import eu.arrowhead.api.commons.constants.ApiConstants;
import eu.arrowhead.api.commons.util.TagUtil;
import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.service.DomainService;
import eu.arrowhead.repository.manager.exception.InvalidDomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Optional;

/**
 * The Domains provider controller.
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

    /**
     * Create a domain
     *
     * @param domainData the domain
     * @return the created domain
     */
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<?> createDomain(
            @Valid @RequestPart("domain") Domain domainData,
            @RequestPart("file") MultipartFile file) throws IOException {
        if (domainData.getTags().isEmpty()) {
            if (file.isEmpty()) {
                throw new InvalidDomainException();
            } else {
                domainData.setTags(TagUtil.readTags(new String(file.getBytes(), StandardCharsets.UTF_8)));
            }
        }
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("domain", domainService.create(domainData));
        }});
    }

    /**
     * Gets domains
     *
     * @param name the name
     * @param offset the offset
     * @param limit the limit
     * @return the domains
     */
    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> getDomains(
            @RequestParam(value = ApiConstants.REQUEST_PARAM_NAME, required = false) Optional<String> name,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_OFFSET, required = false, defaultValue = "0") int offset,
            @RequestParam(value = ApiConstants.REQUEST_PARAM_LIMIT, required = false, defaultValue = "8") int limit) {
        Page<Domain> domains = name.isEmpty()
                ? domainService.findAll(PageRequest.of(offset, limit))
                : domainService.findByNameContaining(name.get(), PageRequest.of(offset, limit));
        return ResponseEntity.ok(new HashMap<String, Object>() {{
            put("domains", domains.getContent());
            put("totalElements", domains.getTotalElements());
            put("totalPages", domains.getTotalPages());
        }});
    }
}
