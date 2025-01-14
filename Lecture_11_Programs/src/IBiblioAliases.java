import java.net.*;
public class IBiblioAliases {
    public static void main (String args[]) {
        try {
            InetAddress host1 = InetAddress.getByName("www.qau.edu.pk");
            InetAddress host2 = InetAddress.getByName("qau.edu.pk");

            System.out.println(host1);
            System.out.println(host2);

            if (host1.equals(host2)) {
                System.out.println("Host1 is the same as host2");
            } else {
                System.out.println("Host1 is not the same as Host2");
            }
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
