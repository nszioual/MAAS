package eu.arrowhead.api.commons.domain;

import eu.arrowhead.model.storage.model.Domain;
import eu.arrowhead.model.storage.model.Model;
import info.debatty.java.stringsimilarity.Jaccard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DomainLinkerService {

    private final PreprocessingService preprocessingService;

    @Autowired
    public DomainLinkerService(PreprocessingService preprocessingService) {
        this.preprocessingService = preprocessingService;
    }

    public void linkModelToDomains(Model model, List<Domain> domains) {
        model.setDomains(new HashMap<>());
        for (Domain domain : domains) {
            if (domain.getTags().isEmpty()) continue;
            if (model.getElements().getNodeNames().isEmpty()) {
                model.getDomains().put(domain.getName(), 0.0);
            } else {
                model.getDomains().put(domain.getName(), computeSimilarity(domain, model));
            }
        }
    }

    private double computeSimilarity(Domain domain, Model model) {
        double similarity = 0.0;
        List<String> processedNames = preprocessingService.removeStopWords(model.getElements().getNodeNames());
        for (String nodeName : processedNames) {
            for (String tag : domain.getTags()) {
                similarity += new Jaccard(2).similarity(tag, nodeName);
            }
        }
        return similarity / (processedNames.size() * domain.getTags().size());
    }
}
