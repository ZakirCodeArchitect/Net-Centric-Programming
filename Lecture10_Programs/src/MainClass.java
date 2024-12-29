import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Main Class to Execute Runnable Tasks
public class MainClass {
    public void startThreads() {
        int poolSize = 3; // Number of threads in the pool
        ExecutorService taskList = Executors.newFixedThreadPool(poolSize);

        for (int i = 0; i < 5; i++) {
            taskList.execute(new MyRunnable());
        }

        taskList.shutdown();
    }

    public static void main(String[] args) {
        new MainClass().startThreads();
    }
}