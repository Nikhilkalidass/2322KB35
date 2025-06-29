package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_db"; // Your DB name
        String user = "root"; // Your MySQL username
        String password = "Nikhil_0709"; // Your MySQL password

        String selectQuery = "SELECT * FROM students";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery)
        ) {
            System.out.println("ID\tName\t\tCourse\t\tMarks");
            System.out.println("--------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                int marks = rs.getInt("marks");

                System.out.printf("%d\t%-15s%-15s%d\n", id, name, course, marks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
