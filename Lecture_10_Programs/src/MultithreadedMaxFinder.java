import java.util.concurrent.*;

public class MultithreadedMaxFinder {

    public static int max(int[] data) throws InterruptedException, ExecutionException {

        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        return Math.max(future1.get(), future2.get());
    }

    public static void main(String arg[]) throws InterruptedException, ExecutionException {
        int[] data = {10, 20, 30, 40, 5, 7, 50};
        MultithreadedMaxFinder test = new MultithreadedMaxFinder();
        System.out.println(max(data));
    }
}