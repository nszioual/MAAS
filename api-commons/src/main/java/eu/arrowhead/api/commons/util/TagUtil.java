package eu.arrowhead.api.commons.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TagUtil {

    public static Set<String> readTags(String data) {
        Set<String> tags = new HashSet<>();
        data = removeSpecialCharacters(data);
        String[] values = data.split(",");
        Collections.addAll(tags, values);
        return tags;
    }

    private static String removeSpecialCharacters(String data) {
        return data.replaceAll("\\s+", "");
    }
}
