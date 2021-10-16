package eu.arrowhead.api.commons.domain;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.tartarus.snowball.ext.PorterStemmer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PreprocessingService {

    private final List<String> stopwords;

    @SneakyThrows
    public PreprocessingService() {
        try (InputStream resource = getClass().getResourceAsStream("/domain/english_stopwords.txt")) {
            assert resource != null;
            this.stopwords =
                    new BufferedReader(new InputStreamReader(resource,
                            StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        }
    }

    public List<String> removeStopWords(List<String> sentences) {
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            result.addAll(removeAll(sentence));
        }
        return result;
    }

    public List<String> removeStopWordsAndStem(String input) {
        Set<String> wordsWithoutStopwords = removeAll(input);
        return wordsWithoutStopwords.stream()
                .map(word -> {
                    PorterStemmer stemmer = new PorterStemmer();
                    stemmer.setCurrent(word);
                    stemmer.stem();
                    return stemmer.getCurrent();
                }).collect(Collectors.toList());
    }

    private Set<String> removeAll(String input) {
        ArrayList<String> allWords = Stream.of(input.split(" "))
                .collect(Collectors.toCollection(ArrayList<String>::new));
        allWords.removeAll(stopwords);
        return new HashSet<>(allWords);
    }
}
