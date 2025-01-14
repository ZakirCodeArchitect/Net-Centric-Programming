import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceLister {
    public static void main(String[] args) {
        // Hardcoded network interface name
        String hardcodedInterfaceName = "eth0"; // Replace "eth0" with the interface you want to check

        try {
            NetworkInterface ni = NetworkInterface.getByName(hardcodedInterfaceName);

            if (ni == null) {
                System.out.println("No such interface: " + hardcodedInterfaceName);
            } else {
                System.out.println("Details for Interface: " + hardcodedInterfaceName);
                System.out.println("---------------------------------------------------");
                System.out.println("Interface Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());
                System.out.println("Is Up: " + ni.isUp());
                System.out.println("Is Loopback: " + ni.isLoopback());
                System.out.println("Is Virtual: " + ni.isVirtual());
                System.out.println("Supports Multicast: " + ni.supportsMulticast());
            }
        } catch (SocketException e) {
            System.err.println("Error retrieving network interface: " + e.getMessage());
        }
    }
}
