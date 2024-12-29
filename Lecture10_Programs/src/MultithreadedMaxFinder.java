import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMaxFinder {
    public static int max(int[] data) throws InterruptedException, ExecutionException {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        ExecutorService service = Executors.newFixedThreadPool(2);

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        int result = Math.max(future1.get(), future2.get());

        service.shutdown();
        return result;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] data = {10, 20, 30, 40, 5, 7, 50};
        System.out.println("Maximum Value: " + max(data));
    }
}
