package Day2;

import java.util.Scanner;

public class MiniAddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays to store contact info
        String[] names = new String[100];
        String[] phones = new String[100];
        String[] emails = new String[100];

        int count = 0;  // number of contacts

        while (true) {
            System.out.println("\n--- Mini Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            if (choice == 1) {
                // Add contact
                if (count < 100) {
                    System.out.print("Enter Name  : ");
                    names[count] = sc.nextLine();
                    System.out.print("Enter Phone : ");
                    phones[count] = sc.nextLine();
                    System.out.print("Enter Email : ");
                    emails[count] = sc.nextLine();
                    count++;
                    System.out.println("Contact added successfully!");
                } else {
                    System.out.println("Address book is full!");
                }

            } else if (choice == 2) {
                // Display contacts
                if (count == 0) {
                    System.out.println("No contacts to display.");
                } else {
                    System.out.println("\n--- Contact List ---");
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". Name : " + names[i]);
                        System.out.println("   Phone: " + phones[i]);
                        System.out.println("   Email: " + emails[i]);
                        System.out.println();
                    }
                }

            } else if (choice == 3) {
                // Exit
                System.out.println("Exiting Address Book. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
