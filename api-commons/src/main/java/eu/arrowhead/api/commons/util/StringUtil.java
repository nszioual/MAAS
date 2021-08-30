package eu.arrowhead.api.commons.util;

import java.util.Optional;

public class StringUtil {
    public static Optional<String> getExtensionByStringHandling(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".") + 1));
    }
}
