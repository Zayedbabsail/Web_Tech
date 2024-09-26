import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/test";
            String userName = "root";
            String password = "db@12345";

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to connect to database: " + e.getMessage());
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection closed");
                } catch (SQLException e) {
                    System.err.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
    }
}
