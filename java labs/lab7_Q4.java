 // Program 4: Using throws keyword
public class lab7_Q4 {

    static int divideNumbers(int a, int b) throws ArithmeticException {
        return a / b; // may throw ArithmeticException
    }

    public static void main(String[] args) {
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
    }
}
