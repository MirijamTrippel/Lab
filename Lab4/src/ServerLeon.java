import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLeon {
    public static void main(String[] args) throws IOException {
        // Creates a                   server with the  port
        ServerSocket        server   = new ServerSocket(3000);
        // Creates a connection to the client and accepts all incoming msg's
        Socket              client   = server.accept();

        System.out.println("Client has connected");
        // Writes                               on the socket an Msg as a stream
        PrintWriter         writer   = new PrintWriter(client.getOutputStream(), true);
        // Gets the input                           from the socket as a Stream
        InputStreamReader   input    = new InputStreamReader(client.getInputStream());
        // Bufferes the input
        BufferedReader      reader   = new BufferedReader(input);
        // Looks for input from the cmd
        BufferedReader      keyboard = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                // reads the msg from the keyboard input
                String serverMessage = keyboard.readLine();
                // writes the msg to the client
                writer.println(serverMessage);
                // reads the msg from the client connection
                String clientResponse = reader.readLine();
                // displays the msg from the client in the cmd
                System.out.println("Client: " + clientResponse);
                }
        }
        // Closes all
        finally {
            writer.close();
            reader.close();
        }
    }
}