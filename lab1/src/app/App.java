package app;

import html.FileParser;
import html.Html;
import html.SimpleTagFactory;

public class App {
    public static void main(String[] args) throws Exception {
        FileParser txt = new FileParser("html.txt");
        Html html = txt.getHtml(new SimpleTagFactory("div"));
        System.out.println(html);
    }
}