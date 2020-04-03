package app;

import html.Tag;

public class NewApp {
    public static void main(String[] args) {
        Tag test = new Tag("div", "Hello world");
        test.setId("content");
        test.setBorder(10, "black");
        System.out.println(test);
    }
}