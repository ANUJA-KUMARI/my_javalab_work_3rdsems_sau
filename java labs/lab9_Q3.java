import java.io.*;

public class lab9_Q3{

    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("lab9_Q2_data.txt");
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream in = new DataInputStream(bis);

            System.out.println("Reading data from lab9_Q2data.txt:");

            while (in.available() > 0) {
                String item = in.readUTF();
                int qty = in.readInt();
                double price = in.readDouble();

                System.out.println(item + " | qty: " + qty + " | price: " + price);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
