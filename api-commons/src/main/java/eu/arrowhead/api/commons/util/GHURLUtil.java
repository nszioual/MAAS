package eu.arrowhead.api.commons.util;

import lombok.SneakyThrows;
import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class GHURLUtil {

    public static String getGitHubURL(String modelURL) {
        String[] urlParts = new String[5];
        int index = 0;
        for (String urlPart : modelURL.split("/")) {
            if (index == 5) break;
            urlParts[index] = urlPart;
            index++;
        }

        return String.join("/", urlParts);
    }

    @SneakyThrows
    public static String buildGitHubSearchURL(String format, Integer page, Integer lowerBound, Integer upperBound) {
        Map<String, String> params = new HashMap<>();
        params.put("extension", format);
        params.put("size", String.format("%s..%s", lowerBound, upperBound));

        return GHURLUtil.buildGitHubURL("github.com", "/search", params, page);
    }

    private static String buildGitHubURL(String host, String path, Map<String, String> params, Integer page) throws URISyntaxException {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            queryString.append(param.getKey()).append(":").append(param.getValue()).append(" ");
        }

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(host);
        builder.setPath(path);
        builder.setParameter("p", page.toString());
        builder.setParameter("q", queryString.substring(0, queryString.length() - 1));
        builder.setParameter("type", "code");

        return builder.build().toASCIIString();
    }
}
