import java.io.*;
import java.net.Socket;

public class ClientLeon {
    public static void main(String[] args) throws IOException {
        //Step1
        Socket server = new Socket("localHost", 3000);

        System.out.println("Connected to Server");

        PrintWriter writer = new PrintWriter(server.getOutputStream(), true);

        InputStreamReader input = new InputStreamReader(server.getInputStream());
        BufferedReader reader = new BufferedReader(input);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        //Step 2
        /*
        while(true) {
            String message = keyboard.readLine();
            if (message.equals("quit")) {
                server.close();
                break;
            }
            writer.println(message);
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
                        String clientMessage = keyboard.readLine();
                        writer.println(clientMessage);
                        if (clientMessage.equals("quit")) {
                            server.close();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        send.start();

        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String serverResponse = reader.readLine();
                        System.out.println("Client: " + serverResponse);
                        if (serverResponse.equals("quit")) {
                            server.close();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        read.start();
    }
}