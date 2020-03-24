package app;

import html.Html;
import html.Section;
import html.Tag;

public class App {
    public static void main(String[] args) throws Exception {
        Section section_0 = new Section("section");

        Tag div = new Tag("div", "hello");
        div.setBorder();
        section_0.addTag(div);

        section_0.addTag(new Tag("p"));

        Html html = new Html();

        html.addSection(section_0);
        html.addSection(section_0);

        System.out.println(html);

        html.saveToFile("index.html");
    }
}