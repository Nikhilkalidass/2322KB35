package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/invent_db"; 
        String user = "root";  
        String password = "Nikhil_0709"; 

        // Connection object
        Connection conn = null;

        try {
            // Step 1: Load MySQL JDBC Driver (optional for JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Use the connection (example output)
            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        } finally {
            // Step 4: Close the connection
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
