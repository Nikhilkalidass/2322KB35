package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/invent_db"; // Replace with your DB name
        String user = "root"; // Replace with your MySQL username
        String password = "Nikhil_0709"; // Replace with your MySQL password

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        String insertQuery = "INSERT INTO students (name, course, marks) VALUES (?, ?, ?)";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(insertQuery)
        ) {
            pstmt.setString(1, name);
            pstmt.setString(2, course);
            pstmt.setInt(3, marks);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student record inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

