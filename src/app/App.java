package app;

import html.Html;
import html.Section;
import html.Tag;
import html.TagFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Section header = new Section("header");

        header.addTags(TagFactory.getTags("div", 5));

        Tag p = new Tag("p", "Lorem upsum");
        p.setBorder();
        header.addTag(p);

        header.addTags(TagFactory.getTags("div", 5));

        Html html = new Html();
        html.addSection(header);

        System.out.println(html);
        html.saveToFile("index.html");
    }
}