package in.eightfolds.OpenGraphExtractor;

import com.google.common.collect.ImmutableMap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.stream.Collectors;

public class OpenGraphData {
    private final Map<String, OpenGraphItem> data;

    protected OpenGraphData(Map<String, OpenGraphItem> data) {
        this.data = data;
    }

    public String getTitle() {
        if (data != null) {
            OpenGraphItem openGraphItem = data.get(OpenGraphExtractor.TITLE);
            if(openGraphItem != null) {
                return openGraphItem.getValue();
            }
        }
        return null;
    }

    public String getDescription() {
        if (data != null) {
            OpenGraphItem openGraphItem = data.get(OpenGraphExtractor.DESC);
            if(openGraphItem != null) {
                return openGraphItem.getValue();
            }
        }
        return null;
    }

    public String getImage() {
        if (data != null) {
            OpenGraphItem openGraphItem = data.get(OpenGraphExtractor.IMAGE);
            if(openGraphItem != null) {
                return openGraphItem.getValue();
            }
        }
        return null;
    }

    public String getUrl() {
        if (data != null) {
            OpenGraphItem openGraphItem = data.get(OpenGraphExtractor.URL);
            if(openGraphItem != null) {
                return openGraphItem.getValue();
            }
        }
        return null;
    }

    public String getProperty(String property) {
        if (data != null) {
            OpenGraphItem openGraphItem = data.get(property);
            if(openGraphItem != null) {
                return openGraphItem.getValue();
            }
        }
        return null;
    }

    public Map<String, String> toMap() {
        return data.values().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(OpenGraphItem::getProperty, OpenGraphItem::getValue),
                        ImmutableMap::copyOf
                ));
    }


    @Override
    public String toString() {
        return data.values().stream()
                .map(entry -> String.format("%s[%s]: %s", entry.getProperty(), entry.getActualProperty(), entry.getValue()))
                .collect(Collectors.joining(",\n"));

    }
}
