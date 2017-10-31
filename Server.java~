import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws Exeption
    {
        Server server = new Server();

        server.run();
    }

    public void run() throws Exeption
    {
        ServerSocket servSock = new ServerSocket(1337);
        Socket sock = servSock.accept();
        InputStreamReader IR = new inputStreamReader(sock.getInputStream());
        BufferedReader BR = new BufferedReader(IR);

        String message = BR.readLine();
        System.out.println(message);

        if(message != null) {
            PrintStream PS = new PrintStream(SOCK.getOutputStream());
            PS.println("Message recieved");
        }
    }

}
