package app;

import java.util.Scanner;

import html.FileParser;
import html.SimpleTagFactory;
import html.base.Html;
import html.base.Section;
import html.base.Tag;

public class App {
    public static void main(String[] args) throws Exception {
        FileParser txt = new FileParser("html.txt");
        Html html = txt.getHtml(new SimpleTagFactory("div"));

        Menu(html);
    }

    public static void Menu(Html html) {
        Scanner in = new Scanner(System.in);
        int ans;

        do {
            System.out.println(html);
            System.out.println("1.Add section border\n2.Add tag border\n3.Exit");
            System.out.print(">>>");
            ans = in.nextInt();

            if (ans == 1) {
                Section section = sectionMenu(in, html);
                section.setBorder(5, "black");
            }

            if (ans == 2) {
                Tag tag = TagMenu(in, html);
                tag.setBorder(5, "black");
            }

        } while (ans != 3);

        in.close();
    }

    public static Section sectionMenu(Scanner in, Html html) {
        Section[] sections = html.getSections();

        for (int i = 0; i < sections.length; i++) {
            System.out.println(i + "." + sections[i].getName());
        }

        System.out.print(">>>");
        return sections[in.nextInt()];
    }

    public static Tag TagMenu(Scanner in, Html html) {
        Section section = sectionMenu(in, html);
        Tag[] tags = section.getTags();

        for (int i = 0; i < tags.length; i++) {
            System.out.println(i + "." + tags[i]);
        }

        System.out.print(">>>");
        return tags[in.nextInt()];
    }

}