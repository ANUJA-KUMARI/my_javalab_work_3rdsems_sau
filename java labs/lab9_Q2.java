import java.io.*;

public class  lab9_Q2{

    static final double[] price = {15.43, 10.12, 50.8, 249.56, 18.99};
    static final int[] qty = {10, 23, 45, 14, 2};
    static final String[] items = {"board", "mike", "ebook", "ups", "pen drive"};

    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("lab9_Q2_data.txt");
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream out = new DataOutputStream(bos);

            for (int i = 0; i < price.length; i++) {
                out.writeUTF(items[i]);
                out.writeInt(qty[i]);
                out.writeDouble(price[i]);
            }

            System.out.println("Data successfully written to lab9_Q2_data.txt");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
