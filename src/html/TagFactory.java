package html;

import java.util.LinkedList;
import java.util.List;

public class TagFactory {

    private TagFactory() {
    }

    public static List<Tag> getTags(String tagName, int count) {
        List<Tag> tags = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            tags.add(new Tag(tagName, tagName + "_" + i));
        }

        return tags;
    }

}