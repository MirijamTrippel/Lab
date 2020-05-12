import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int portNumber = 123 ;

    //creates server with a Port // default port 123
    public Server(int port) throws IOException {
        this.portNumber = port;
        ServerSocket server = new ServerSocket(portNumber);
        Socket connection = server.accept();

        //                         Reading data from     client     stream
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        //                         Buffering the Data from the reader
        BufferedReader input = new BufferedReader(reader);


        //Makes msg      takes Buffered data
        String message = input.readLine();
        //                 Echoes the data as a String
        System.out.println("Echo: " + message);


    }



}