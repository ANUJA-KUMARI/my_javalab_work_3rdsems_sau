// Program 1: Handling Arithmetic Exception
import java.util.Scanner;

public class lab7_Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();

            int result = a / b; // may throw ArithmeticException
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        }
        sc.close();
    }
}
