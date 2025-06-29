package Day6;

//Custom thread class
class MyThread extends Thread {
 String name;

 MyThread(String name) {
     this.name = name;
 }

 public void run() {
     for (int i = 1; i <= 3; i++) {
         System.out.println(name + " - Count: " + i);
         try {
             Thread.sleep(500); // Pause for 0.5 seconds
         } catch (InterruptedException e) {
             System.out.println(name + " interrupted.");
         }
     }
 }
}

//Main class
public class ThreadCoordination {
 public static void main(String[] args) {
     MyThread t1 = new MyThread("Thread A");
     MyThread t2 = new MyThread("Thread B");

     t1.start(); // Start first thread

     try {
         t1.join(); // Wait for t1 to finish before starting t2
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted.");
     }

     t2.start(); // Start second thread after t1 finishes
 }
}
