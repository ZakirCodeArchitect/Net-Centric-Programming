import java.net.NetworkInterface;
import java.net.SocketException;

public class NetworkInterfaceCheck {
    public static void main(String[] args) {
        try {
            // Replace "eth0" with the name of the network interface you want to check
            String interfaceName = "eth0";
            NetworkInterface ni = NetworkInterface.getByName(interfaceName);

            if (ni == null) {
                System.err.println("No such interface: " + interfaceName);
            } else {
                    System.out.println("Interface found: " + ni.getDisplayName());
            }
        } catch (SocketException ex) {
            System.err.println("Could not list sockets: " + ex.getMessage());
        }
    }
}
