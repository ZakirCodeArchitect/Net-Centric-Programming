import java.net.*;
import java.util.Scanner;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP addresses or domain names to check (comma-separated):");
        String input = scanner.nextLine();

        // Split input by commas and trim whitespace
        String[] addresses = input.split(",");
        for (String address : addresses) {
            address = address.trim();
            if (isSpammer(address)) {
                System.out.println(address + " is a known spammer.");
            } else {
                System.out.println(address + " appears legitimate.");
            }
        }

        scanner.close();
    }

    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg); // resolves the provided address (IP or domain) to an InetAddress object.
            byte[] quad = address.getAddress(); // method retrieves the raw bytes of the IP address (e.g., [192, 168, 1, 1]).
            String query = BLACKHOLE;
            // Reverse the IP and Append the Blacklist Domain
            for (byte octet : quad) {
                int unsignedByte = octet < 0 ? octet + 256 : octet;
                query = unsignedByte + "." + query;
            }
            // DNS lookup is performed on the constructed query.
            InetAddress.getByName(query);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
