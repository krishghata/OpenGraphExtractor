import in.eightfolds.OpenGraphExtractor.MetaData;
import in.eightfolds.OpenGraphExtractor.MetaExtractor;

import java.io.IOException;

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
