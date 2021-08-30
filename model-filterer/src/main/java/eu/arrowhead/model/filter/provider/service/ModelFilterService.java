package eu.arrowhead.model.filter.provider.service;

import eu.arrowhead.model.filter.provider.dto.SearchFormDTO;
import eu.arrowhead.model.filter.provider.dto.search.SearchElement;
import eu.arrowhead.model.filter.provider.dto.search.SearchRepository;
import eu.arrowhead.model.filter.provider.service.criteria.spec.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ModelFilterService {

    public List<SearchCriteria> getSearchCriteria(SearchFormDTO searchFormDTO) {
        List<SearchCriteria> params = new ArrayList<>();

        if (searchFormDTO.getName() != null && !searchFormDTO.getName().isEmpty()) {
            params.add(new SearchCriteria("name", searchFormDTO.getName(), "~"));
        }

        if (searchFormDTO.getFormat() != null && !searchFormDTO.getFormat().isEmpty()) {
            params.add(new SearchCriteria("modeling_language", searchFormDTO.getFormat(), ":"));
        }

        if (searchFormDTO.getElements() != null && !searchFormDTO.getElements().isEmpty()) {
            params.addAll(buildParamsListFromElements(searchFormDTO.getElements()));
        }

        if (searchFormDTO.getRepository() != null) {
            params.addAll(buildParamsListFromRepository(searchFormDTO.getRepository()));
        }

        return params;
    }

    public List<SearchCriteria> getSearchCriteria(String name, String format, String elems, String repo) {
        List<SearchCriteria> params = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            params.add(new SearchCriteria("name", name, "~"));
        }

        if (format != null && !format.isEmpty()) {
            params.add(new SearchCriteria("modeling_language", format, ":"));
        }

        if (elems != null && !elems.isEmpty()) {
            params.addAll(buildParamsList("elements", elems));
        }

        if (repo != null && !repo.isEmpty()) {
            params.addAll(buildParamsList("repository", elems));
        }

        return params;
    }

    private List<SearchCriteria> buildParamsListFromElements(HashMap<String, SearchElement> elements) {
        List<SearchCriteria> params = new ArrayList<>();
        for (Map.Entry<String, SearchElement> entry : elements.entrySet()) {
            String field = entry.getKey();
            SearchElement searchElement = entry.getValue();
            params.add(new SearchCriteria("elements" + "." + field, searchElement.getValue(), searchElement.getPredicate()));
        }
        return params;
    }

    private List<SearchCriteria> buildParamsListFromRepository(SearchRepository repository) {
        List<SearchCriteria> params = new ArrayList<>();
        params.add(new SearchCriteria("repository" + "." + "repository", repository.getRepositoryName(), "~"));
        params.add(new SearchCriteria("repository" + "." + "numberOfForks", repository.getNumberOfForks().getValue(), repository.getNumberOfForks().getPredicate()));
        params.add(new SearchCriteria("repository" + "." + "numberOfStars", repository.getNumberOfStars().getValue(), repository.getNumberOfStars().getPredicate()));
        return params;
    }

    private List<SearchCriteria> buildParamsList(String prefix, String query) {
        List<SearchCriteria> params = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|!)(\\w+?),");
        Matcher matcher = pattern.matcher(query + ",");
        while (matcher.find()) {
            params.add(new SearchCriteria(prefix + "." + matcher.group(1), matcher.group(3), matcher.group(2)));
        }
        return params;
    }
}
