package html.base;

import java.util.LinkedList;
import java.util.List;

public class Tag {
    private String name;
    private String text;
    private String style;
    private List<Tag> innerTags = new LinkedList<Tag>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Tag(String name, List<Tag> innerTags) {
        this.name = name;
        this.innerTags = innerTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setBorder(int thickness, String color) {
        setStyle("border:" + thickness + "px solid " + color);
    }

    public Tag[] getInnerTags() {
        return innerTags.toArray(new Tag[innerTags.size()]);
    }

    public void setInnerTags(List<Tag> tags) {
        this.innerTags = tags;
    }

    public void addInnerTag(Tag tag) {
        innerTags.add(tag);
    }

    public void addInnerTags(List<Tag> tags) {
        for (Tag tag : tags) {
            addInnerTag(tag);
        }
    }

    @Override
    public String toString() {
        String tagHead = "<" + name;
        String tagBody = "";
        String tagTail = "";

        if (text != null)
            tagBody += text;

        if (innerTags.size() != 0) {
            tagTail = "\n</" + name + ">";
            for (Tag tag : innerTags) {
                tagBody += "\n\t" + tag;
            }
        } else {
            tagTail = "</" + name + ">";
        }

        if (style != null)
            tagHead += " style='" + style + "'";

        tagHead += ">";

        return tagHead + tagBody + tagTail;
    }

}