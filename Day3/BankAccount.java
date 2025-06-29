package Day3;

public class BankAccount {
    double balance = 0;

    // Method to deposit money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: ₹" + amount);
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    // Method to show balance
    void showBalance() {
        System.out.println("Balance: ₹" + balance);
    }

    // Main method to run the program
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();

        myAccount.deposit(1000);
        myAccount.withdraw(300);
        myAccount.withdraw(800); // This will show "Not enough balance"
        myAccount.showBalance();
    }
}
