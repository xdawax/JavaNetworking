import java.net.*;
import java.util.*;

public class GetAddress {


    public static void main(String[] args)
    {
        String host;
        Scanner in = new Scanner(System.in);
        InetAddress address;

        System.out.print("Enter hosname: ");
        host = in.next();

        try {
            address = InetAddress.getByName(host);
            System.out.println("IP Address: " +
                               address.toString());
        }
        catch (UnknownHostException uhEx) {
            System.out.println("Could now find the host: " +
                               host);
        }
    }
}
