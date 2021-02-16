import in.eightfolds.OpenGraphExtractor.OpenGraphData;
import in.eightfolds.OpenGraphExtractor.OpenGraphExtractor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        String url = "https://www.rottentomatoes.com/m/back_to_the_future";
        String url = "https://www.youtube.com/watch?v=zGLQ9ZRntZo";
        OpenGraphData data = OpenGraphExtractor.extract(url);
//        System.out.println("Title: "+data.getTitle());
//        System.out.println("Desc: "+data.getDescription());
//        System.out.println("Image: "+data.getImage());
//        System.out.println("Url: "+data.getUrl());
//        System.out.println("Text: "+data.getProperty("text"));

//        System.out.println(data);

        data.toMap().entrySet().forEach(e -> {
            System.out.println(String.format("%s: %s", e.getKey(), e.getValue()));
        });
    }
}
