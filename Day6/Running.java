package Day6;

//Class that implements Runnable
class MessagePrinter implements Runnable {
 String message;

 // Constructor to accept custom message
 MessagePrinter(String msg) {
     this.message = msg;
 }

 public void run() {
     // Print message 5 times
     for (int i = 1; i <= 5; i++) {
         System.out.println(message + " (from " + Thread.currentThread().getName() + ")");
         try {
             Thread.sleep(300); // Optional delay
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted");
         }
     }
 }
}

//Main class
public class Running {
 public static void main(String[] args) {
     // Create Runnable objects
     Runnable r1 = new MessagePrinter("Hello");
     Runnable r2 = new MessagePrinter("Welcome");

     // Wrap them in Thread objects
     Thread t1 = new Thread(r1, "Thread-1");
     Thread t2 = new Thread(r2, "Thread-2");

     // Start the threads
     t1.start();
     t2.start();
 }
}
