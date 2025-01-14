import java.net.*;

public class ipList {
    public  static void main(String[] args) {
        try
        {
            InetAddress[] ip = InetAddress.getAllByName("www.google.com");
            for(InetAddress address: ip)
            {
                System.out.println(address);
            }
        }catch (UnknownHostException e)
        {
            System.out.println(e);
        }
    }
}
