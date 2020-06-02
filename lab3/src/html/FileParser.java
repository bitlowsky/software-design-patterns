package html;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import html.base.Html;
import html.base.Tag;

public class FileParser {
    private ITagFactory tagFactory;

    public FileParser(ITagFactory tagFactory) {
        this.tagFactory = tagFactory;
    }

    public Html getHtml(String file) {
        Scanner scan;
        try {
            scan = new Scanner(new FileReader(file));
            List<Tag> sections = new LinkedList<Tag>();

            while (scan.hasNextLine() & scan.hasNext()) {
                Scanner line = new Scanner(scan.nextLine());
                Tag section = new Tag(line.next());

                if (line.hasNextInt())
                    section.addInnerTags(tagFactory.createTags(line.nextInt()));

                sections.add(section);
            }
            scan.close();

            return new Html(sections);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return new Html();
        }
    }

}