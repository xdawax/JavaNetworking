import java.net.*;

public class GetLocalAddress
{
    public static void main(String[] args)
    {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Local address: "
                               + address);
        }
        catch (UnknownHostException uhEx) {
                System.out.println("Could not find the local address!");
        }
    }
}

