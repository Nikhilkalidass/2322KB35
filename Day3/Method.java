package Day3;

public class Method {
	

	    // Method to sum two integers
	    static int sum(int a, int b) {
	        return a + b;
	    }

	    // Method to sum two double values
	    static double sum(double a, double b) {
	        return a + b;
	    }

	    public static void main(String[] args) {
	        // Call sum with integers
	        int result1 = sum(10, 20);
	        System.out.println("Sum of integers: " + result1);

	        // Call sum with doubles
	        double result2 = sum(5.5, 3.2);
	        System.out.println("Sum of doubles: " + result2);
	    }
	}


