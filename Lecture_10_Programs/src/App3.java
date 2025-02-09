import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3
{

    public App3()
    {
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(new Counter(6));
        taskList.execute(new Counter(5));
        taskList.execute(new Counter(4));
        taskList.shutdown();
    }

    private void pause(double seconds)
    {
        try
        {
            Thread.sleep((long) (1000.0 * seconds));
        }
        catch (InterruptedException ie) {
        }
    }

    private class Counter implements Runnable { // Inner class
        private final int loopLimit;

        public Counter(int loopLimit) {
            this.loopLimit = loopLimit;
        }

        public void run() {
            for (int i = 0; i < loopLimit; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s: %d%n", threadName, i);
                pause(Math.random());
            }
        }
    }
}