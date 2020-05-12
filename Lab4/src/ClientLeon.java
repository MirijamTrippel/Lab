import java.io.*;
import java.net.Socket;

public class ClientLeon {
    public static void main(String[] args) throws IOException {
        // creates a connection to the server                     via port
        Socket              socket   = new Socket("localHost", 3000);

        System.out.println("Connected to Server");
        // Writes                               on the socket an Msg as a stream
        PrintWriter         writer   = new PrintWriter(socket.getOutputStream(), true);
        // Gets the input                           from the socket as a Stream
        InputStreamReader   input    = new InputStreamReader(socket.getInputStream());
        // Bufferes the input
        BufferedReader      reader   = new BufferedReader(input);
        // Looks for input from the cmd
        BufferedReader      keyboard = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            // reads the msg from the keyboard input
            String message = keyboard.readLine();
            // closing the client
            if (message.equals("quit")) {
                socket.close();
                break;
            }
            // sends the msg via connection to server
            writer.println(message);
            // reads the msg's from the server
            String serverResponse = reader.readLine();
            // displays the msg from the server in the cmd
            System.out.println("Server: " + serverResponse);
        }
    }
}