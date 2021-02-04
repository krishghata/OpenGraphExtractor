package in.eightfolds.OpenGraphExtractor;

import java.util.Map;

public class MetaData {
    private Map<String, MetaItem> data;

    protected MetaData() {
    }

    protected MetaData(Map<String, MetaItem> data) {
        this.data = data;
    }

    public Map<String, MetaItem> getData() {
        return data;
    }

    public void setData(Map<String, MetaItem> data) {
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
            MetaItem metaItem = data.get(MetaExtractor.TITLE);
            if(metaItem != null) {
                return metaItem.getValue();
            }
        }
        return null;
    }

    public String getDescription() {
        if (data != null) {
            MetaItem metaItem = data.get(MetaExtractor.DESC);
            if(metaItem != null) {
                return metaItem.getValue();
            }
        }
        return null;
    }

    public String getImage() {
        if (data != null) {
            MetaItem metaItem = data.get(MetaExtractor.IMAGE);
            if(metaItem != null) {
                return metaItem.getValue();
            }
        }
        return null;
    }

    public String getUrl() {
        if (data != null) {
            MetaItem metaItem = data.get(MetaExtractor.URL);
            if(metaItem != null) {
                return metaItem.getValue();
            }
        }
        return null;
    }

    public String getProperty(String property) {
        if (data != null) {
            MetaItem metaItem = data.get(property);
            if(metaItem != null) {
                return metaItem.getValue();
            }
        }
        return null;
    }
}
