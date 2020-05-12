import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //Step1
        Socket server = new Socket("localHost", 3000);

        System.out.println("Connected to Server!");
        System.out.println("You can now start to chat!");
        
        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);

        InputStreamReader input = new InputStreamReader(server.getInputStream());
        BufferedReader chatReader = new BufferedReader(input);
        BufferedReader chatInput = new BufferedReader(new InputStreamReader(System.in));
        //Step 2
        /*
        while(true) {
            String message = chatInput.readLine();
            if (message.equals("quit")) {
                server.close();
                break;
            }
            writer.println("Client: " + message);
            String serverResponse = reader.readLine();
            System.out.println("Server: " + serverResponse);
        }
        */

        //Step 3
        Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String clientMessage = chatInput.readLine();
                        writer.println("Client: " + clientMessage);
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
                        String serverResponse = chatReader.readLine();
                        System.out.println(serverResponse);
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