import java.net.*;

public class AddressTests {
    public static int getVersion(InetAddress ia) {
        byte[] address = ia.getAddress();
        if (address.length == 4) return 4;
        else if (address.length == 16) return 6;
        else return -1;
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress ipv4 = InetAddress.getByName("192.168.0.1");
        InetAddress ipv6 = InetAddress.getByName("2001:db8::ff00:42:8329");

        System.out.println("IPv4 Address: " + ipv4.getHostAddress() + " Version: " + getVersion(ipv4));
        System.out.println("IPv6 Address: " + ipv6.getHostAddress() + " Version: " + getVersion(ipv6));
    }
}
