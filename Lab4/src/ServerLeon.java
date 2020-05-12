import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLeon {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3000);
        Socket client = server.accept();

        System.out.println("Client has connected");

        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        InputStreamReader input  = new InputStreamReader(client.getInputStream());
        BufferedReader reader = new BufferedReader(input);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String serverMessage = keyboard.readLine();
                writer.println(serverMessage);
                String clientResponse = reader.readLine();
                System.out.println("Client: " + clientResponse);
                }
        }
        finally {
            writer.close();
            reader.close();
        }
    }
}