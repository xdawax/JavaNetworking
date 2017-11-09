import java.io.*;
import java.net.*;
import java.util.Scanner;

class ClientHandler extends Thread
{
    private static Socket client;
    private static Scanner input;
    private static PrintWriter output;

    public ClientHandler(Socket socket)
    {
        this.client = socket;

        try {
            input = new Scanner(client.getInputStream());
            output = new PrintWriter(client.getOutputStream(), true);
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public void run()
    {
        String recieved;

        do {
            recieved = input.nextLine();
            output.println("* SERVER RECIEVED: " + recieved + " *");
        } while (!recieved.equals("QUIT"));

        try {
            if (client != null) {
                client.close();
                System.out.println("* SERVER CONNECTION CLOSED! *");
            }
        }
        catch (IOException ioEx) {
            System.out.println("* SERVER COULD NOT TERMINATE THE CONNECTION *");
        }
                          
    }
    
}
