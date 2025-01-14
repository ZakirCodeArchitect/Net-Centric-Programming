import java.net.*;

public class localhost {
    public  static void main(String[] args) {
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
//            String localHost = ip.getCanonicalHostName();
            String localHost = ip.getHostName();
            System.out.println("Local Host name: "+localHost);
            String localIp = ip.getHostAddress();
            System.out.println("Local IP Address : " + localIp);
        }catch (UnknownHostException e)
        {
            System.out.println(e);
        }

    }
}
