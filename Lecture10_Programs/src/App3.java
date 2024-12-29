import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
    public App3() {
        ExecutorService taskList = Executors.newFixedThreadPool(3);

        taskList.execute(new Counter(5));
        taskList.execute(new Counter(4));
        taskList.execute(new Counter(3));

        taskList.shutdown();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    private class Counter implements Runnable {
        private final int loopLimit;

        public Counter(int loopLimit) {
            this.loopLimit = loopLimit;
        }

        @Override
        public void run() {
            for (int i = 0; i < loopLimit; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s: %d%n", threadName, i);
                pause(Math.random());
            }
        }
    }

    public static void main(String[] args) {
        new App3();
    }
}
