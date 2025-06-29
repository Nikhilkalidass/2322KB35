package Day6;


	// Custom thread class
	class NumberPrinter extends Thread {
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            System.out.println("Number: " + i);
	            try {
	                Thread.sleep(500); // Pause for 0.5 seconds
	            } catch (InterruptedException e) {
	                System.out.println("Thread interrupted");
	            }
	        }
	    }
	}

	// Main class
	public class Threadex  {
	    public static void main(String[] args) {
	        NumberPrinter thread = new NumberPrinter(); // Create thread object
	        thread.start(); // Start the thread
	    }
	}


