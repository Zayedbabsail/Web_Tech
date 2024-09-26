import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
    public static void main(String[] args) {
        // Database credentials
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        
        // JDBC driver name and database URL
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        // SQL update statement
        String updateQuery = "UPDATE Java SET Name='Humera Sana' WHERE Name='Humera'";
        // String anotherUpdateQuery = "UPDATE Java SET Marks=85, Grade='Ex' WHERE Name='Debasis'";

        try {
            // Load JDBC driver
            Class.forName(jdbcDriver);

            // Establish connection
            try (Connection conn = DriverManager.getConnection(url, userName, password);
                 Statement stmt = conn.createStatement()) {

                // Execute SQL update statement
                stmt.executeUpdate(updateQuery);
                // stmt.executeUpdate(anotherUpdateQuery);

                System.out.println("Records updated successfully.");
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server: " + e.getMessage());
        }
    }
}
