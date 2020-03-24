package html;

public class Tag {
    private String name;
    private String text;
    private String id;
    private String style;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Tag(String name, String text, String id) {
        this.name = name;
        this.text = text;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setBorder() {
        setStyle("border:10px solid black");
    }

    @Override
    public String toString() {
        String tagHead = "<" + name;

        if (id != null)
            tagHead += " id=\"" + id + "\"";

        if (style != null)
            tagHead += " style=\"" + style + "\"";

        return tagHead + ">" + text + "</" + name + ">";
    }

}