 // Program 5: Custom Exception Example
import java.util.Scanner;

// Step 1: Create custom exception
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class lab7_Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            if (num < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed!");
            } else {
                System.out.println("Square of number: " + (num * num));
            }
        } catch (NegativeNumberException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
        sc.close();
    }
}

