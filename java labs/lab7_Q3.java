// Program 3: Using throw keyword
import java.util.Scanner;

public class lab7_Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new ArithmeticException("Age must be 18 or older.");
            } else {
                System.out.println("Welcome! You are eligible.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        sc.close();
    }
}

