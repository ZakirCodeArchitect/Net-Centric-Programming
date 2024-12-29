
// Separate Runnable Class
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Task is running in the background");
    }
}


