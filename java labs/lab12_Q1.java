import java.net.*;

public class lab12_Q1 {

    public static int serverPort = 998;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int pos = 0;

        while (true) {
            int c = System.in.read();
            switch (c) {
                case -1:
                    System.out.println("Server Quits.");
                    return;
                case '\r':
                    break;
                case '\n':
                    ds.send(new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public static void TheClient() throws Exception {
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }

    public static void main(String args[]) throws Exception {

        if (args.length == 1) {
            ds = new DatagramSocket(serverPort);
            System.out.println("UDP Server Started...");
            TheServer();
        } else {
            ds = new DatagramSocket(clientPort);
            System.out.println("UDP Client Started...");
            TheClient();
        }
    }
}


//terminal 1 -- SERVER 
//java lab12_Q1 x
//terminhal2 -- Client
//java lab12_Q1
