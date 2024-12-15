import java.net.*;
public class Main{
    public static void main(String[] args)
    {
        try{
            // lookup the DNS for that hostname and returns its IP name, otherwise if not able to find it gives Error.
//            InetAddress[] addresses = InetAddress.getAllByName("www.google.com");

//            System.out.println(address);
            // Stack    Trace, what does it tell?

//            InetAddress address = InetAddress.getLocalHost();
//            System.out.println(address);

//            for(InetAddress address: addresses)
//            {
//                System.out.println(address);
//            }

            byte[] address = {107,23,(byte)216,(byte)196};  // because both of them are in the range of 128, that's why error is not coming-> only runs if it is a valid adddress otherwise it'll give error.
            InetAddress google = InetAddress.getByAddress(address);

            InetAddress google_name = InetAddress.getByAddress("www.google.com", address);

            System.out.println(google_name);

        }catch (UnknownHostException ex)
        {
            System.out.println("Not able to Find");
        }
    }
}