package html.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Html {
    private List<Section> sections = new LinkedList<Section>();

    public Html() {
    }

    public Html(List<Section> sections) {
        this.sections = sections;
    }

    public Section[] getSections() {
        return sections.toArray(new Section[sections.size()]);
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void addSections(List<Section> sections) {
        for (Section section : sections) {
            addSection(section);
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
        for (Section section : sections) {
            html += section + "\n\n";
        }
        return html;
    }

}