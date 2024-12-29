import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 implements Runnable {
    private final int loopLimit;

    public App2(int loopLimit) {
        this.loopLimit = loopLimit;
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < loopLimit; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %d%n", threadName, i);
            pause(Math.random());
        }
    }

    public static void main(String[] args) {
        int poolSize = 3;
        ExecutorService taskList = Executors.newFixedThreadPool(poolSize);

        App2 app = new App2(5);
        taskList.execute(app);
        taskList.execute(app);
        taskList.execute(app);

        taskList.shutdown();
    }
}
