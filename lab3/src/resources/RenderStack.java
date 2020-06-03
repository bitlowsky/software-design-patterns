package resources;

import java.io.FileOutputStream;
import java.io.IOException;

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

    private void push(int numberOfTags) {
        stack[index] = numberOfTags;
        System.out.println("В очередь добавлена конфигурация " + index + " (" + stack[index] + ").");
        index++;
    }

    private void process() {
        Html html = new Html(tagFactory.createTags(stack[index - 1]));
        try {
            FileOutputStream fos = new FileOutputStream("out.txt", true);
            fos.write((html.toString() + "\n").getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Конфигурация " + (index - 1) + " (" + stack[index - 1] + ") обработана.\n" + html);
        index--;
    }

    public synchronized void pushByThread(int numberOfTags) {
        while (index == stack.length)
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        if (index != stack.length) {
            push(numberOfTags);
            notifyAll();
        }
    }

    public synchronized void processByThread() {
        while (index == 0)
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        if (index != 0) {
            process();
            notifyAll();
        }
    }
}
