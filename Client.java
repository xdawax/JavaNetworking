import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
    public static void main(String[] args) throws Exception
    {
        Client client = new Client();
        client.run();
    }

    public void run() throws Exception
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Client is starting...");
        Socket sock = new Socket("localhost", 1337);

        PrintStream PS = new PrintStream(sock.getOutputStream());
        PS.println("Hello to server from client!");

        InputStreamReader ISR = new InputStreamReader(sock.getInputStream());
        BufferedReader BR = new BufferedReader(ISR);

        String message = BR.readLine();
        System.out.println(message);

        char c = 'y';
        
        while (c == 'y') {
            String sendMessage = in.next();
            PS.println(sendMessage);
            System.out.print("Do  you want to continue? (y) ");
            c = in.next().charAt(0);
        }

        PS.println("Quit");
    }
}
