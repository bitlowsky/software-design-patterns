package app;

import java.util.ArrayList;
import java.util.List;

import html.SimpleTagFactory;
import resources.RenderStack;
import threads.ConfigurationGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        RenderStack rs = new RenderStack(3, new SimpleTagFactory("div"));
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1; i++)
            threads.add(new Thread(new ConfigurationGenerator(rs, 100)));

        for (int i = 0; i < 3; i++)
            threads.add(new Thread(new threads.ConfigurationProcessor(rs, 500)));

        for (Thread thread : threads)
            thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        for (Thread thread : threads)
            thread.interrupt();
    }

}