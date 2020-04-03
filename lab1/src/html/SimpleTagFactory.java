package html;

import java.util.LinkedList;
import java.util.List;

import html.base.Tag;

public class SimpleTagFactory implements ITagFactory {
    final public String name;

    public SimpleTagFactory(String name) {
        this.name = name;
    }

    public List<Tag> createTags(int count) {
        List<Tag> tags = new LinkedList<Tag>();
        for (int i = 0; i < count; i++) {
            tags.add(new Tag(name, name + "_" + i));
        }
        return tags;
    }

}