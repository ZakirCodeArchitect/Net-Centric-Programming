import java.net.*;
import java.util.concurrent.*;
import java.io.*;

public class LookupTask implements Callable<String> {
    private String line;

    public LookupTask(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        try {
            // Separate out the IP address
            int index = line.indexOf(' ');
            String address = line.substring(0, index);
            String theRest = line.substring(index);

            // Get the hostname using DNS lookup
            String hostname = InetAddress.getByName(address).getHostName();
            return hostname + " " + theRest;
        } catch (Exception ex) {
            // If error occurs, return the original log entry
            return line;
        }
    }
}


