package html;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import html.base.Html;
import html.base.Section;

public class FileParser {
    private String file;

    public FileParser(String file) {
        this.file = file;
    }

    public Html getHtml(ITagFactory tagFactory) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(file));
        List<Section> sections = new LinkedList<Section>();

        while (scan.hasNextLine() & scan.hasNext()) {
            Scanner line = new Scanner(scan.nextLine());
            Section section = new Section(line.next());

            if (line.hasNextInt())
                section.addTags(tagFactory.createTags(line.nextInt()));

            sections.add(section);
        }
        scan.close();

        return new Html(sections);
    }
}