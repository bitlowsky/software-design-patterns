package app;

import java.io.FileReader;
import java.util.Scanner;

import html.Html;
import html.Section;
import html.TagFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new FileReader("html.txt"));
        Html html = new Html();

        while (scan.hasNextLine() & scan.hasNext()) {
            Scanner line = new Scanner(scan.nextLine());
            Section section = new Section(line.next());

            if (line.hasNextInt())
                section.addTags(TagFactory.getTags(line.nextInt()));

            if (line.hasNext())
                if (line.hasNextInt()) {
                    int index = line.nextInt();

                    if (index < section.getTags().length)
                        section.getTags()[index].setBorder();

                } else
                    section.setBorder();

            html.addSection(section);
        }
        scan.close();

        System.out.println(html);
        html.saveToFile("index.html");
    }
}