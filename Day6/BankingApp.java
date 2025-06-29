package Day6;

//Account class to represent the bank account
class BankAccount {
 private int balance = 1000; // initial balance

 // synchronized method to prevent overdrawing
 public synchronized void withdraw(int amount) {
     String threadName = Thread.currentThread().getName();
     System.out.println(threadName + " is trying to withdraw ₹" + amount);

     // Simulate transaction delay
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         System.out.println(threadName + " was interrupted.");
     }

     if (amount <= balance) {
         balance -= amount;
         System.out.println(threadName + " successfully withdrew ₹" + amount + ". Remaining balance: ₹" + balance);
     } else {
         System.out.println(threadName + " failed to withdraw ₹" + amount + " (Insufficient funds). Balance: ₹" + balance);
     }
 }
}

//Thread class to simulate a user
class User extends Thread {
 BankAccount account;
 int amount;

 User(BankAccount acc, int amt, String name) {
     super(name); // set thread name
     this.account = acc;
     this.amount = amt;
 }

 public void run() {
     account.withdraw(amount);
 }
}

//Main class
public class BankingApp {
 public static void main(String[] args) {
     BankAccount sharedAccount = new BankAccount();

     // Create users (threads) with predefined amounts
     User u1 = new User(sharedAccount, 300, "User-1");
     User u2 = new User(sharedAccount, 500, "User-2");
     User u3 = new User(sharedAccount, 400, "User-3");

     // Start threads
     u1.start();
     u2.start();
     u3.start();
 }
}
