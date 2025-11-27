// Program 2: Multiple Catch with Finally Block
public class lab7_Q2 {
    public static void main(String[] args) {
        try {
            int[] arr = new int[3];
            arr[5] = 10; // may throw ArrayIndexOutOfBoundsException

            int x = 10 / 0; // may throw ArithmeticException
            System.out.println("Result: " + x);
        } 
        catch (ArithmeticException e) {
            System.out.println("Caught Arithmetic Exception: " + e.getMessage());
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Array Index Out Of Bounds Exception: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        } 
        finally {
            System.out.println("Finally block executed — resources released.");
        }
    }
}
