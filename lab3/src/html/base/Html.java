package html.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Html {
    private List<Tag> tags = new LinkedList<Tag>();

    public Html() {
    }

    public Html(List<Tag> tags) {
        this.tags = tags;
    }

    public Tag[] getSections() {
        return tags.toArray(new Tag[tags.size()]);
    }

    public void setSections(List<Tag> tags) {
        this.tags = tags;
    }

    public void addSection(Tag tag) {
        tags.add(tag);
    }

    public void addSections(List<Tag> tags) {
        for (Tag tag : tags) {
            addSection(tag);
        }
    }

    public void saveToFile(String fileName) throws IOException {
        FileWriter file = new FileWriter(fileName);
        file.write(toString());
        file.close();
    }

    @Override
    public String toString() {
        String html = "";
        for (Tag tag : tags) {
            if (tag.getInnerTags().length != 0)
                html += tag + "\n\n";
            else {
                html += tag + "\n";
            }
        }
        return html;
    }

}