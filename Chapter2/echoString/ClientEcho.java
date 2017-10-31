import java.io.*;
import java.util.*;
import java.net.*;

public class ClientEcho
{

    private static final int port = 1337;
    private static InetAddress host;
    
    public static void main(String[] args)
    {
        try {
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException unhEx) {
            System.out.println("Could not resolve the host");
            System.exit(1);
        }

        accessServer();
    }

    public static void accessServer()
    {
        Socket link = null;

        try {
            link = new Socket(host, port);

            Scanner in = new Scanner(link.getInputStream());
            PrintWriter out = new PrintWriter(link.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);

            String message, response;

            do {
                System.out.print("Enter message: ");
                message = userEntry.nextLine();
                out.println(message);
                response = in.nextLine();
                System.out.println("\nSERVER> " + response);
            }while (!message.equals("***CLOSE***"));
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        finally {
            try {
                System.out.println("\n* Closing connection *");
                link.close();
            }
            catch (IOException ioEx) {
                System.out.println("Unable to disconnect...");
                System.exit(1);
            }
        }
    }
}
