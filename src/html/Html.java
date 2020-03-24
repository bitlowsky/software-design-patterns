package html;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Html {
    private List<Section> sections = new LinkedList<>();

    public Html() {
    }

    public void addSection(Section section) {
        if (section.getId() == null)
            section.setId("section_" + sections.size());
        sections.add(section);
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