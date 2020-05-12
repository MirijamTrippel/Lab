import java.io.*;
import java.net.Socket;

public class ClientLeon {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost", 3000);

        System.out.println("Connected to Server");

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        InputStreamReader input = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(input);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String message = keyboard.readLine();
            if (message.equals("quit")) {
                socket.close();
                break;
            }
            writer.println(message);
            String serverResponse = reader.readLine();
            System.out.println("Server: " + serverResponse);
        }
    }
}