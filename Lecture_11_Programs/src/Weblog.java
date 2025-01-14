import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Weblog {
    public static void main(String[] args) {
        // Create a Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the log file: ");
        String filePath = scanner.nextLine(); // User provides the file path

        try (FileInputStream fin = new FileInputStream(filePath);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {

            // Process each line in the file
            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // Separate out the IP address
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println("Could not resolve IP: " + entry);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error: The file was not found.");
        } catch (IOException ex) {
            System.err.println("Error reading the file: " + ex.getMessage());
        }

        scanner.close(); // Close the scanner
    }
}
