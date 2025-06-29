package Day5;

import java.util.HashSet;

public class Emailset {
    public static void main(String[] args) {
        // Create a HashSet to store unique emails
        HashSet<String> emails = new HashSet<>();

        // Add email addresses
        emails.add("nikhil@example.com");
        emails.add("anita@example.com");
        emails.add("ravi@example.com");
        emails.add("nikhil@example.com"); // Duplicate

        // Display all unique emails
        System.out.println("Unique Email Addresses:");
        for (String email : emails) {
            System.out.println(email);
        }
    }
}

