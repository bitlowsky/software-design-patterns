package html;

import java.util.LinkedList;
import java.util.List;

public class Section extends Tag {
    private List<Tag> tags = new LinkedList<>();

    public Section(String name) {
        super(name);
    }

    public Section(String name, String text) {
        super(name, text);
    }

    public Section(String name, String text, String id) {
        super(name, text, id);
    }

    public void addTag(Tag tag) {
        if (tag.getId() == null)
            tag.setId("block_" + tags.size());
        tags.add(tag);
    }

    @Override
    public String toString() {
        String sectionBody = "";
        String tagHead = "<" + super.getName();
        String tagTail = "";

        if (super.getId() != null)
            tagHead += " id=\"" + super.getId() + "\"";
        if (super.getStyle() != null)
            tagHead += " style=\"" + super.getStyle() + "\"";

        tagHead += ">";

        for (Tag tag : tags) {
            sectionBody += "\n\t" + tag;
        }

        tagTail = "\n</" + super.getName() + ">";

        return tagHead + sectionBody + tagTail;
    }

}