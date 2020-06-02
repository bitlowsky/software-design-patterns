package threads;

import resources.RenderStack;

public class ConfigurationProcessor implements Runnable {
    private RenderStack rs;
    private int sleepTime;

    public ConfigurationProcessor(RenderStack rs, int sleepTime) {
        this.rs = rs;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            rs.processByThread();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Процессор конфигураций остановлен...");
    }
}
