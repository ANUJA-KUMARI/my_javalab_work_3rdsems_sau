import java.io.*;
import java.net.*;

public class lab12_Q2 {

    static final int DEFAULT_PORT = 1728;
    static final String HANDSHAKE = "CLChat";
    static final char MESSAGE = '0';
    static final char CLOSE = '1';

    public static void main(String[] args) {

        int port;
        ServerSocket listener;
        Socket connection;
        BufferedReader incoming;
        PrintWriter outgoing;
        String messageOut;
        String messageIn;
        BufferedReader userInput;

        // Choose port
        if (args.length == 0) {
            port = DEFAULT_PORT;
        } else {
            try {
                port = Integer.parseInt(args[0]);
                if (port < 0 || port > 65535) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Illegal port number: " + args[0]);
                return;
            }
        }

        try {
            listener = new ServerSocket(port);
            System.out.println("Listening on port " + listener.getLocalPort());

            connection = listener.accept();
            listener.close();

            incoming = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            outgoing = new PrintWriter(connection.getOutputStream());

            // Handshake
            outgoing.println(HANDSHAKE);
            outgoing.flush();

            messageIn = incoming.readLine();
            if (!HANDSHAKE.equals(messageIn)) {
                throw new Exception("Connected program is not CLChat!");
            }

            System.out.println("Connected to client...");
        }
        catch (Exception e) {
            System.out.println("Error opening connection:");
            System.out.println(e);
            return;
        }

        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter 'quit' to exit.\n");

            while (true) {

                System.out.println("WAITING...");
                messageIn = incoming.readLine();

                if (messageIn == null) break;

                if (messageIn.charAt(0) == CLOSE) {
                    System.out.println("Client closed connection.");
                    connection.close();
                    break;
                }

                messageIn = messageIn.substring(1);
                System.out.println("RECEIVED: " + messageIn);

                System.out.print("SEND: ");
                messageOut = userInput.readLine();

                if (messageOut.equalsIgnoreCase("quit")) {
                    outgoing.println(CLOSE);
                    outgoing.flush();
                    connection.close();
                    break;
                }

                outgoing.println(MESSAGE + messageOut);
                outgoing.flush();
            }
        }
        catch (Exception e) {
            System.out.println("Connection lost:");
            System.out.println(e);
        }
    }
}

// to run the instruction of this program 
//javac lab12_Q2.java
//java lab12_Q2
