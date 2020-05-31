package app;

import html.FileParser;
import html.SimpleTagFactory;

public class App {
    public static void main(String[] args) throws Exception {
        FileParser[] fParsers = { new FileParser(new SimpleTagFactory("div")),
                new FileParser(new SimpleTagFactory("p")), new FileParser(new SimpleTagFactory("a")) };

        for (int i = 0; i < 10; i++) {
            for (FileParser fp : fParsers) {
                new Thread(() -> System.out.println(fp.getHtml("html.txt"))).start();
            }
        }

    }

}