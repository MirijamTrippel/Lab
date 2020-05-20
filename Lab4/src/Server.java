import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //Step 1
        System.out.println("Waiting for Client...");

        ServerSocket server = new ServerSocket(3000);
        Socket client = server.accept();

        System.out.println("Client connected!");
        System.out.println("You can now start to chat!");

        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

        InputStreamReader input = new InputStreamReader(client.getInputStream());
        BufferedReader chatReader = new BufferedReader(input);
        BufferedReader chatInput = new BufferedReader(new InputStreamReader(System.in));

        //Step 2
        /*try {
            while (true) {
                String serverMessage = chatInput.readLine();
                writer.println("Server: " + serverMessage);
                String clientResponse = chatReader.readLine();
                System.out.println("Client: " + clientResponse);
            }
        } finally {
            writer.close();
            reader.close();
        }
        */

        //Step 3

        Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String serverMessage = chatInput.readLine();
                        writer.println("Server: " + serverMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String clientResponse = chatReader.readLine();
                        System.out.println(clientResponse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        send.start();
        read.start();
    }
}