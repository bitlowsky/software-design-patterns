package app;

import html.Html;
import html.Section;
import html.Tag;

public class App {
    public static void main(String[] args) throws Exception {
        Section test = new Section("section");
        Tag div = new Tag("div", "hello");
        div.setBorder();
        test.addTag(div);
        test.addTag(new Tag("p", "Lorem"));
        Html html = new Html();
        html.addSection(test);
        html.addSection(test);

        System.out.println(html);

        html.saveToFile("index.html");
    }
}