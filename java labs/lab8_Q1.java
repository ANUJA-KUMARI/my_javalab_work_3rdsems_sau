import java.nio.file.*;

public class lab8_Q1 {
    public static void main(String[] args) {

        // Change this path according to YOUR PC  
        Path filePath = Paths.get("C:\\Users\\ANUJA\\Desktop\\java labs\\lab8_Q1.java");

        int count = filePath.getNameCount();

        System.out.println("Path is: " + filePath.toString());
        System.out.println("File name is: " + filePath.getFileName());
        System.out.println("There are " + count + " elements in the file path");

        for (int i = 0; i < count; i++) {
            System.out.println("Element " + i + " is " + filePath.getName(i));
        }
    }
}

