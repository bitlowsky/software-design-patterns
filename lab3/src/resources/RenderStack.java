package resources;

import html.ITagFactory;
import html.base.Html;

public class RenderStack {
    private int[] stack;
    private int index = 0;
    private ITagFactory tagFactory;

    public RenderStack(int n, ITagFactory tagFactory) {
        stack = new int[n];
        this.tagFactory = tagFactory;
    }

    public int getStackLength() {
        return stack.length;
    }

    public int getIndex() {
        return index;
    }

    public void push(int numberOfTags) {
        stack[index] = numberOfTags;
        System.out.println("В очередь добавлена конфигурация " + index + " (" + stack[index] + ").");
        index++;
    }

    public void process() {
        System.out.println("Конфигурация " + (index - 1) + " (" + stack[index - 1] + ") обработана.");
        System.out.println(new Html(tagFactory.createTags(stack[index - 1])));
        index--;
    }

}
