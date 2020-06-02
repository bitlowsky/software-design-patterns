package threads;

import java.util.Random;

import resources.RenderStack;

public class ConfigurationGenerator implements Runnable {
    private RenderStack rs;
    private Random random = new Random();
    private int sleepTime;

    public ConfigurationGenerator(RenderStack rs, int sleepTime) {
        this.rs = rs;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            rs.pushByThread(random.nextInt(10) + 1);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Генератор конфигураций остановлен...");
    }
}
