import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static int portNumber = 123 ;

    //creates client with a Port // default port 123
    public Client(int port) throws IOException {
        this.portNumber = port;
        Socket connection = new Socket("localHost",portNumber);

        //
        // TODO -Miri: Ich weiß nicht wieso immer connection refused kommt.
        //

        // output in the socket to the       server via stream
        PrintWriter output = new PrintWriter(connection.getOutputStream());

        //message for the server
        output.println("Hello Server, I am a Client.");
        output.flush();

    }



}
