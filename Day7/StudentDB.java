package Day7;

import java.sql.*;
import java.util.Scanner;

public class StudentDB {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db"; // Replace with your DB
    static final String USER = "root";
    static final String PASS = "Nikhil_0709"; // Replace with your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Student DB Manager ====");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> insertStudent(sc);
                case 2 -> viewStudents();
                case 3 -> searchStudent(sc);
                case 4 -> deleteStudent(sc);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void insertStudent(Scanner sc) {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();
        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        String query = "INSERT INTO students (name, course, marks) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, course);
            pstmt.setInt(3, marks);

            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void viewStudents() {
        String query = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID\tName\t\tCourse\t\tMarks");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                int marks = rs.getInt("marks");

                System.out.printf("%d\t%-15s%-15s%d\n", id, name, course, marks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void searchStudent(Scanner sc) {
        System.out.print("Enter name to search: ");
        String nameSearch = sc.nextLine();

        String query = "SELECT * FROM students WHERE name LIKE ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + nameSearch + "%");

            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                if (!found) {
                    System.out.println("ID\tName\t\tCourse\t\tMarks");
                    System.out.println("------------------------------------------------");
                    found = true;
                }
                System.out.printf("%d\t%-15s%-15s%d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getInt("marks"));
            }

            if (!found) {
                System.out.println("No student found with name containing: " + nameSearch);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
