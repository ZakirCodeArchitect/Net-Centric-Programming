import java.net.*;

public class IPCharacteristics {
    public static void main(String[] args) {
        try {
            // Resolve the input IP address or hostname
            InetAddress address = InetAddress.getByName(args[0]);

            // Check for wildcard address
            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }

            // Check for loopback address
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is a loopback address.");
            }

            // Check for link-local and site-local addresses
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }

            // Check if the address is multicast
            if (address.isMulticastAddress()) {
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address + " is an organization-wide multicast address.");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site-wide multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a link-local multicast address.");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } else {
                // If not multicast, it's a unicast address
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException ex) {
            // Handle invalid IP or hostname input
            System.err.println("Could not resolve " + args[0]);
        }
    }
}
