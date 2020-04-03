package html;

import java.util.List;

import html.base.Tag;

public interface ITagFactory {
    public List<Tag> createTags(int count);
}