import java.util.*;
import java.net.*;
import java.io.*;

public class EchoClientMT
{
     private static final int port = 1337;
    private static InetAddress host;

    public static void main(String[] args)
    {
        try {
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException uhEx) {
            System.out.println("HOST ID NOT FOUND!");
            System.exit(1);
        }

        sendMessages();
        
    }

    public static void sendMessages()
    {
        Socket link = null;
        
        try {
            link = new Socket(host, port);

            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);

            String sentMessage, recievedMessage;
            
            do {
                System.out.print("Client :> ");
                sentMessage = userEntry.nextLine();
                output.println(sentMessage);
                
                recievedMessage = input.nextLine();
                System.out.println("Server :> " + recievedMessage);

            } while (!sentMessage.equals("QUIT"));
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        finally {
            try {
                link.close();
                System.out.println("Connection closed");
            }
            catch (IOException ioEx) {
                System.out.println("Could not close the connection");
                System.exit(1);
            }
        }
    }


}
