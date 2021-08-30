package eu.arrowhead.api.commons.domain;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.tartarus.snowball.ext.PorterStemmer;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PreprocessingService {

    private final List<String> stopwords;

    @SneakyThrows
    public PreprocessingService() {
        try (InputStream resource = getClass().getResourceAsStream("/domain/english_stopwords.txt")) {
            this.stopwords =
                    new BufferedReader(new InputStreamReader(resource,
                            StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
        }
    }

    public List<String> removeStopwordsAndStem(String input) {
        Set<String> wordsWithoutStopwords = removeAll(input);
        return wordsWithoutStopwords.stream()
                .map(word -> {
                    PorterStemmer stemmer = new PorterStemmer();
                    stemmer.setCurrent(word);
                    stemmer.stem();
                    return stemmer.getCurrent();
                }).collect(Collectors.toList());
    }

    public List<String> removeStopwords(List<String> sentences) {
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            result.addAll(removeAll(sentence));
        }
        return result;
    }

    private Set<String> removeAll(String input) {
        ArrayList<String> allWords = Stream.of(input.split(" "))
                .collect(Collectors.toCollection(ArrayList<String>::new));
        allWords.removeAll(stopwords);
        return new HashSet<>(allWords);
    }
}
