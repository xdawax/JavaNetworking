import java.io.*;
import java.net.*;

public class EchoServerMT
{

    private static ServerSocket serverSocket;
    private static final int port = 1337;

    public static void main(String[] args)
    {
        try {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException ioEx) {
            System.out.println("Failed to setup the serversocket!");
            System.exit(0);
        }

        do {
            // Wait for client
            try {
            Socket client = serverSocket.accept();
            System.out.println("New connection accepted from: " + client.getLocalAddress().getHostName());

            ClientHandler handler = new ClientHandler(client);
            handler.start(); // kallar på run i klassen ClientHandler
            }
            catch (IOException ioEx) {
                System.out.println("Could not accept the connection...");
            }
            
        } while (true);
    }

}
