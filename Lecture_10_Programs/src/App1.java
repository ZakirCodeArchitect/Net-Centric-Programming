import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App1 {
    public App1() {
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(new Counter(this, 6)); //0,1,2,3,4,5,6
        taskList.execute(new Counter(this, 10)); //0,1,2,3,4,5,6,7,8,9,10
        taskList.execute(new Counter(this, 2)); //0,1
        taskList.shutdown();
    }

    public void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
