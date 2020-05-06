import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {



        //Echo client that is reading and writing to the Socket

        //                PC name(IP), make sure that the host name you use is the fully qualified IP name of the computer to which you want to connect.
        String hostName = args[0];

        int portNumber = Integer.parseInt(args[1]);

        try (
                //               I use my local IP with CMD ipconfig,idk why it doesnt works

                //creates socket obj       uses args[0], port to use, example 7(Echo port)
                //Socket echoSocket = new Socket(hostName, portNumber);
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))

        )
        {}

    }



}
