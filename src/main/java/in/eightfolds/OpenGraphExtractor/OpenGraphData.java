package in.eightfolds.OpenGraphExtractor;

import java.util.Map;

public class OpenGraphData {
    private Map<String, OpenGraphItem> data;

    protected OpenGraphData() {
    }

    protected OpenGraphData(Map<String, OpenGraphItem> data) {
        this.data = data;
    }

    public Map<String, OpenGraphItem> getData() {
        return data;
    }

    public void setData(Map<String, OpenGraphItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "in.eightfolds.OpenGraphExtractor.MetaData{" +
                "data=" + data +
                '}';
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
}
