package html;

public class Tag {
    private String name;
    private String body;
    private String style;

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    @Override
    public String toString() {
        String tagHead = "<" + name;
        String tagTail = "</" + name + ">";

        if (style != null)
            tagHead += " style=\"" + style + "\"";

        return tagHead + ">" + body + tagTail;
    }

}