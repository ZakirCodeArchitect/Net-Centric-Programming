import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class PooledWeblog {
    private final static int NUM_THREADS = 4;

    public static void main(String[] args) throws IOException {
        // Create a thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // Queue to hold the results
        Queue<LogEntry> results = new LinkedList<>();

        // Using Scanner to take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter log entries (type 'exit' to stop):");

        // Continuously read log entries from the user input until 'exit' is entered
        String entry;
        while (!(entry = scanner.nextLine()).equals("exit")) {
            // Submit a task for each log entry to lookup the hostname
            LookupTask task = new LookupTask(entry);
            Future<String> future = executor.submit(task);

            // Add the result to the queue
            LogEntry result = new LogEntry(entry, future);
            results.add(result);
        }

        // Start printing the results (blocking until each future is ready)
        for (LogEntry result : results) {
            try {
                // Print the resolved log entry (hostname replaced)
                System.out.println(result.future.get());
            } catch (InterruptedException | ExecutionException ex) {
                // If an error occurs, print the original log entry
                System.out.println(result.original);
            }
        }

        // Shutdown the executor service
        executor.shutdown();

        // Close the scanner
        scanner.close();
    }

    private static class LogEntry {
        String original;
        Future<String> future;

        LogEntry(String original, Future<String> future) {
            this.original = original;
            this.future = future;
        }
    }
}
