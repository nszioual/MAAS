package eu.arrowhead.crawler.provider.commons;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Utils {
    public static String trimURL(String url) {
        if (url == null) return null;
        String r = url.split("\\?")[0].split("#")[0];
        if (r.endsWith("/")) {
            return r.substring(0, r.length() - 1);
        }
        return r;
    }

    public static WebClient getConfiguredWebClient() {
        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setActiveXNative(true);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.getOptions().setPrintContentOnFailingStatusCode(false);
        client.getOptions().setCssEnabled(false);
        client.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
        client.setCssErrorHandler(new SilentCssErrorHandler());
        return client;
    }

    public static String downloadModel(String url) throws IOException {
        URL u = new URL(url);
        try (InputStream in = u.openStream()) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public static String getDownloadURL(Document document) {
        return document.select("a#raw-url").stream()
                .map(e -> e.attr("abs:href"))
                .collect(Collectors.toList())
                .get(0);
    }

    public static String extractRepoName(String url) {
        String[] r = url.split("/");
        return "/" + r[3] + "/" + r[4] + "/";
    }
}
