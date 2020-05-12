import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLeon {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);
        Socket client = server.accept();

        System.out.println("Client has connected");

        InputStreamReader input  = new InputStreamReader(client.getInputStream());
        BufferedReader reader = new BufferedReader(input);

        String message = reader.readLine();
        System.out.println("Client: " + message);
    }
}