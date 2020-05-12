import java.io.IOException;

public class Main {

    static int port = 255;


    // enter here your port Number
    public static void main(String[] args) throws IOException {
        start(port);

    }

    // Creates a Client + Server with a Port
    public static void start(int port) throws IOException {

        Client client = new Client(port);
        Server server = new Server(port);

    }



}
