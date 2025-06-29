package Day4;

public class Zeroexception {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 0;

        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }

        System.out.println("End of program.");
    }
}

