package eu.arrowhead.model.storage;

import java.util.Optional;

public class Utils {
    public static String extractFileNameFromURL(String URL) {
        String[] URLSplit = URL.split("/");
        return URLSplit[URLSplit.length-1];
    }

    public static Optional<String> getExtensionByStringHandling(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".") + 1));
    }
}
