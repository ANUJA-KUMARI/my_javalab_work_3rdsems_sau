 import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.AccessMode.*;

public class lab8_Q2{
    public static void main(String[] args) {

         
        Path filePath = Paths.get("C:\\Users\\ANUJA\\Desktop\\java labs\\lab8_Q2.java");

        System.out.println("Path is: " + filePath.toString());

        try {
            filePath.getFileSystem().provider().checkAccess(filePath, READ, EXECUTE);
            System.out.println("File can be read and executed");
        } catch (IOException e) {
            System.out.println("File cannot be used for this application");
        }
    }
}

