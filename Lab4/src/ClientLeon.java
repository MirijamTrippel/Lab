import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientLeon {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localHost", 3000);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("Hi server!");
    }
}