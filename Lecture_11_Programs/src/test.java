import java.net.*;

public class test {
    public static void main(String[] args) {
        try
        {
            byte[] address = {107, 23, (byte) 216, (byte) 196}; // The (byte) cast is used for values above 127 to ensure they are correctly represented as signed bytes.
            InetAddress google = InetAddress.getByAddress(address);
            InetAddress google_name = InetAddress.getByAddress("www.google.com", address);

            System.out.println(google);
            System.out.println(google_name);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
