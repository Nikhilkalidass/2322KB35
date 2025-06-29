package Day4;

import java.io.*;
import java.util.Scanner;

public class SimpleEmployeeSystem {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                // Add employee
                System.out.print("Enter ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Salary: ");
                String salary = sc.nextLine();

                FileWriter fw = new FileWriter("employees.txt", true);
                fw.write(id + "," + name + "," + salary + "\n");
                fw.close();

                System.out.println("Employee added.");
            }

            else if (choice == 2) {
                // View employees
                File file = new File("employees.txt");

                if (!file.exists()) {
                    System.out.println("No employee records found.");
                } else {
                    Scanner reader = new Scanner(file);
                    System.out.println("\nEmployee Records:");
                    while (reader.hasNextLine()) {
                        String line = reader.nextLine();
                        String[] parts = line.split(",");
                        System.out.println("ID: " + parts[0] + ", Name: " + parts[1] + ", Salary: ₹" + parts[2]);
                    }
                    reader.close();
                }
            }

        } while (choice != 3);

        System.out.println("Exited.");
        sc.close();
    }
}

