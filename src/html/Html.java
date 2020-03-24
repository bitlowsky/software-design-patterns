package html;

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

    @Override
    public String toString() {
        String html = "";
        for (Section section : sections) {
            html += section + "\n\n";
        }
        return html;
    }
}