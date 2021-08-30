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
        if (model.getElements().getNodeNames().isEmpty()) {
            return;
        }

        model.setDomains(new HashMap<>());

        for (Domain domain : domains) {
            if (domain.getTags().isEmpty()) continue;
            double similarity = 0.0;
            List<String> processedNames = preprocessingService.removeStopwords(model.getElements().getNodeNames());
            for (String nodeName : model.getElements().getNodeNames()) {
                for (String tag : domain.getTags()) {
                    similarity += new Jaccard(2).similarity(tag, nodeName);
                }
            }
            model.getDomains().put(domain.getName(), similarity / (processedNames.size() * domain.getTags().size()));
        }
    }
}
