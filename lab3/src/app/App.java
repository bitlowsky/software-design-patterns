package app;

import html.FileParser;
import html.SimpleTagFactory;
import html.base.Html;

public class App {
    public static void main(String[] args) throws Exception {
        FileParser txt = new FileParser(new SimpleTagFactory("div"));
        Html html = txt.getHtml("html.txt");

        System.out.println(html);
    }

}