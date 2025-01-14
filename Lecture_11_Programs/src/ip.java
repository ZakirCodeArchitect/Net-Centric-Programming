import java.net.*;

public class ip {
    public static void main(String[] args) {
        try {
            // Create an InetAddress object using the specified IP address
            InetAddress ip = InetAddress.getByName("192.178.24.196");
            // Print the IP address
            System.out.println("IP Address: " + ip.getHostAddress());
            // Print the hostname
            System.out.println("Host Name: " + ip.getHostName());
        } catch (UnknownHostException e) {
            // Handle the case where the IP address cannot be resolved
            System.out.println("Could not find host: " + e.getMessage());
        }
    }
}
