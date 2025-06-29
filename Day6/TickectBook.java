package Day6;

//TicketBooking class handles synchronized booking
class TicketBooking {
 int availableSeats = 5;

 // Synchronized method to avoid race conditions
 public synchronized void bookTicket(String user, int seatsRequested) {
     System.out.println(user + " is trying to book " + seatsRequested + " seat(s)...");

     try {
         Thread.sleep(1000); // Simulate delay
     } catch (InterruptedException e) {
         System.out.println("Interrupted");
     }

     if (seatsRequested <= availableSeats) {
         availableSeats -= seatsRequested;
         System.out.println("Booking successful for " + user + ". Seats left: " + availableSeats);
     } else {
         System.out.println("Booking failed for " + user + ". Not enough seats.");
     }
 }
}

//Thread class for each user
class UserThread extends Thread {
 TicketBooking bookingSystem;
 String userName;
 int seatsToBook;

 UserThread(TicketBooking system, String name, int seats) {
     this.bookingSystem = system;
     this.userName = name;
     this.seatsToBook = seats;
 }

 public void run() {
     bookingSystem.bookTicket(userName, seatsToBook);
 }
}

//Main class
public class TickectBook {
 public static void main(String[] args) {
     TicketBooking system = new TicketBooking();

     // Creating user threads
     UserThread u1 = new UserThread(system, "Alice", 2);
     UserThread u2 = new UserThread(system, "Bob", 3);
     UserThread u3 = new UserThread(system, "Charlie", 1);

     // Start booking
     u1.start();
     u2.start();
     u3.start();
 }
}

