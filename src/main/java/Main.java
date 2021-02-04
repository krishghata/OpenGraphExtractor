import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://www.rottentomatoes.com/m/back_to_the_future";
        MetaData data = MetaExtractor.extract(url);
        System.out.println("Title: "+data.getTitle());
        System.out.println("Desc: "+data.getDescription());
        System.out.println("Image: "+data.getImage());
        System.out.println("Url: "+data.getUrl());
        System.out.println("Text: "+data.getProperty("text"));
        System.out.println("Unknown: "+data.getProperty("unknown"));
    }
}
