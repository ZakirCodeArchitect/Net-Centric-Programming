import java.net.*;

public class ProtocolTester {
    public static void main(String[] args) {
        // Testing different types of protocols
        testProtocol("http://www.adc.org");  // HyperText Transfer Protocol (HTTP)
        testProtocol("https://www.amazon.com/exec/obidos/order2/");  // Secure HTTP (HTTPS)
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq/");  // File Transfer Protocol (FTP)
        testProtocol("mailto:elharo@ibiblio.org");  // Email (mailto)
        testProtocol("telnet://dibner.poly.edu/");  // Telnet Protocol
        testProtocol("file:///etc/passwd");  // Local file access (file protocol)
        testProtocol("gopher://gopher.anc.org.za/");  // Gopher Protocol (legacy)
        testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?postalAddress");  // LDAP Protocol (Lightweight Directory Access)
    }

    public static void testProtocol(String url) {
        try {
            URL u = new URL(url);  // Create a URL object
            System.out.println(u.getProtocol() + " is supported.");  // Output the protocol
        } catch (MalformedURLException e) {
            System.err.println(url + " is not a valid URL or not supported: " + e.getMessage());
        }
    }
}
