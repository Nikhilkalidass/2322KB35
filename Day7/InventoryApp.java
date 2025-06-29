package Day7;
import java.sql.*;
import java.util.Scanner;

public class InventoryApp {
    static final String DB_URL = "jdbc:mysql://localhost:3306/product_db"; // Change DB name if needed
    static final String USER = "root"; // Your MySQL username
    static final String PASS = "your_password"; // Your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> viewProducts();
                case 3 -> searchProduct(sc);
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addProduct(Scanner sc) {
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        String query = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, price);

            pstmt.executeUpdate();
            System.out.println("Product added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void viewProducts() {
        String query = "SELECT * FROM products";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("ID\tName\t\tQuantity\tPrice");
            System.out.println("----------------------------------------------");

            while (rs.next()) {
                System.out.printf("%d\t%-15s%d\t\t%.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void searchProduct(Scanner sc) {
        System.out.print("Enter product name to search: ");
        String keyword = sc.nextLine();

        String query = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                if (!found) {
                    System.out.println("ID\tName\t\tQuantity\tPrice");
                    System.out.println("----------------------------------------------");
                    found = true;
                }
                System.out.printf("%d\t%-15s%d\t\t%.2f\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
            }

            if (!found) {
                System.out.println("No products found with name containing: " + keyword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
