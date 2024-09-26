import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
    public static void main(String[] args) {
        // Database credentials
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        
        // JDBC driver name and database URL
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        // SQL delete statement
        String deleteQuery = "DELETE FROM Java WHERE marks < 66";
        // String anotherDeleteQuery = "DELETE FROM JavaCourse";

        try {
            // Load JDBC driver
            Class.forName(jdbcDriver);

            // Establish connection
            try (Connection conn = DriverManager.getConnection(url, userName, password);
                 Statement stmt = conn.createStatement()) {

                // Execute SQL delete statement
                stmt.executeUpdate(deleteQuery);
                // stmt.executeUpdate(anotherDeleteQuery);

                System.out.println("Records deleted successfully.");
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
