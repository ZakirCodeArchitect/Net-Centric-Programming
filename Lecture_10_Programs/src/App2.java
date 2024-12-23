import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 implements Runnable {
    private final int loopLimit;

    public App2(int loopLimit) {
        this.loopLimit = loopLimit;

        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);
        taskList.shutdown();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((long) (1000.0 * seconds));
        } catch (InterruptedException ie) { }
    }

    public void run() {
        for (int i = 0; i < loopLimit; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %d%n", threadName, i);
            pause(Math.random());
        }
    }
}