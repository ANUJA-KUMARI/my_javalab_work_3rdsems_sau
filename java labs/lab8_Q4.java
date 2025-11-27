import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class lab8_Q4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

         
        Path file = Paths.get("C:\\Users\\ANUJA\\Desktop\\java labs\\lab8_Q4.java");

        final int QUIT = 999;
        String delimiter = ",";

        try {

            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            System.out.print("Enter employee ID number >> ");
            int id = input.nextInt();

            while (id != QUIT) {

                input.nextLine(); // Consume newline

                System.out.print("Enter name for employee #" + id + " >> ");
                String name = input.nextLine();

                System.out.print("Enter pay rate >> ");
                double payRate = input.nextDouble();

                String record = id + delimiter + name + delimiter + payRate;
                writer.write(record);
                writer.newLine();

                System.out.print("Enter next ID number or " + QUIT + " to quit >> ");
                id = input.nextInt();
            }

            writer.close();
            System.out.println("Employee file saved successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
