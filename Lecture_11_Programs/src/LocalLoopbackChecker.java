import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class LocalLoopbackChecker {
    public static void main(String[] args) {
        try {
            // Hardcoded loopback address
            InetAddress local = InetAddress.getByName("127.0.0.1");

            // Get the network interface associated with the given InetAddress
            NetworkInterface ni = NetworkInterface.getByInetAddress(local);

            // Check if the network interface is null
            if (ni == null) {
                System.err.println("That's weird. No local loopback address.");
            } else {
                System.out.println("Local loopback interface found: " + ni.getDisplayName());
            }
        } catch (SocketException ex) {
            System.err.println("Could not list network interfaces.");
        } catch (UnknownHostException ex) {
            System.err.println("That's weird. Could not lookup 127.0.0.1.");
        }
    }
}
