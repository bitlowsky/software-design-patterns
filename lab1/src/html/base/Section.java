package html.base;

import java.util.LinkedList;
import java.util.List;

public class Section extends Tag {
    private List<Tag> tags = new LinkedList<Tag>();

    public Section(String name) {
        super(name);
    }

    public Section(String name, List<Tag> tags) {
        super(name);
        this.tags = tags;
    }

    public Section[] getTags() {
        return tags.toArray(new Section[tags.size()]);
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addTags(List<Tag> tags) {
        for (Tag tag : tags) {
            addTag(tag);
        }
    }

    @Override
    public String toString() {
        String tagHead = "<" + name;
        String tagBody = "";
        String tagTail = "\n</" + name + ">";

        if (style != null)
            tagHead += " style='" + style + "'";

        tagHead += ">";

        for (Tag tag : tags) {
            tagBody += "\n\t" + tag;
        }

        return tagHead + tagBody + tagTail;
    }

}