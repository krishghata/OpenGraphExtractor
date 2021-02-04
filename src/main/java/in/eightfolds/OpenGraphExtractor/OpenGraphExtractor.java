package in.eightfolds.OpenGraphExtractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenGraphExtractor {

    public static final String TITLE = "title";
    public static final String DESC = "description";
    public static final String IMAGE = "image";
    public static final String URL = "url";

    public static OpenGraphData extract(String url) throws IOException {
        return new OpenGraphData(extractToMapItem(url));
    }

    private static List<OpenGraphItem> extractToList(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        Elements metaElements = doc.getElementsByTag("meta");
        Elements titleElements = doc.getElementsByTag("title");
        if (titleElements != null) {
            metaElements.add(titleElements.first());
        }

        List<OpenGraphItem> openGraphItems = metaElements.stream()
                .map(meta -> {
                    String prop = meta.attr("property").toString();
                    if (prop == null || prop.trim().length() == 0) {
                        prop = meta.attr("name").toString();
                    }
                    if (prop == null || prop.trim().length() == 0) {
                        prop = meta.tagName();
                    }
                    String value = meta.attr("content").toString();

                    return new OpenGraphItem(prop, value);
                })
                .filter(itm -> itm.getProperty().startsWith("og")
                        || itm.getProperty().startsWith("twitter")
                        || itm.getProperty().equalsIgnoreCase("title")
                        || itm.getProperty().equalsIgnoreCase("description"))
                .sorted((itm1, itm2) -> {
                    if (itm1.getProperty().startsWith("og")) {
                        return -1;
                    } else if (itm1.getProperty().startsWith("twitter")
                            && !itm2.getProperty().startsWith("og")) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                .map(OpenGraphItem::Clean)
                .distinct()
                .collect(Collectors.toList());

        return openGraphItems;
    }

    private static Map<String, OpenGraphItem> extractToMapItem(String url) throws IOException {
        return extractToList(url).stream().collect(Collectors.toMap(OpenGraphItem::getProperty, OpenGraphItem::Clean));
    }

    public static Map<String, String> extractToMap(String url) throws IOException {
        return extractToList(url).stream().collect(Collectors.toMap(OpenGraphItem::getProperty, OpenGraphItem::getValue));
    }
}
