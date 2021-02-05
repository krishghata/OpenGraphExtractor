package in.eightfolds.OpenGraphExtractor;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class OpenGraphItem {
    private String property;
    private String actualProperty;
    private String value;

    protected OpenGraphItem() {
    }

    protected OpenGraphItem(String property, String value) {
        this.property = property;
        this.actualProperty = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getActualProperty() {
        return actualProperty;
    }

    @Override
    public String toString() {
        return "OpenGraphItem{" +
                "property='" + property + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public OpenGraphItem Clean() {
        if(property.contains(":")) {
            String prop = Arrays.stream(getProperty().split(":")).skip(1).collect(Collectors.joining("_"));
            setProperty(prop);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenGraphItem openGraphItem = (OpenGraphItem) o;
        return Objects.equals(property, openGraphItem.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(property);
    }
}
