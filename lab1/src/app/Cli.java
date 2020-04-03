package app;

import java.io.IOException;
import java.util.Scanner;

import html.base.Html;
import html.base.Section;
import html.base.Tag;

public class Cli {
    private Html html;
    private Scanner in = new Scanner(System.in);
    private int ans;

    public Cli(Html html) {
        this.html = html;
    }

    public void start() throws IOException {
        do {
            mainMenu();
        } while (ans != 3);

        saveMenu();
        in.close();
    }

    private void mainMenu() {
        System.out.println(html);
        System.out.println("1.Add section border\n2.Add tag border\n3.Exit");
        System.out.print(">>>");
        ans = in.nextInt();

        if (ans == 1) {
            Section section = sectionMenu();
            section.setBorder(5, "black");
        }

        if (ans == 2) {
            Tag tag = TagMenu();
            tag.setBorder(5, "black");
        }
    }

    private Section sectionMenu() {
        Section[] sections = html.getSections();

        for (int i = 0; i < sections.length; i++) {
            System.out.println(i + "." + sections[i].getName());
        }

        System.out.print(">>>");
        return sections[in.nextInt()];
    }

    private Tag TagMenu() {
        Section section = sectionMenu();
        Tag[] tags = section.getTags();

        for (int i = 0; i < tags.length; i++) {
            System.out.println(i + "." + tags[i]);
        }

        System.out.print(">>>");
        return tags[in.nextInt()];
    }

    private void saveMenu() throws IOException {
        System.out.println("\nSave the file as index.html?\n1.Yes\n2.No");
        ans = in.nextInt();

        if (ans == 1)
            html.saveToFile("index.html");
    }

}