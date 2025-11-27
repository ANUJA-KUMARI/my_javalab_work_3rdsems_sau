import java.util.Scanner;

public class  lab_Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int a = 0, b = 1;

        System.out.println("Fibonacci series till " + n + ":");

        
        while (a <= n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }

        sc.close();
    }
}

