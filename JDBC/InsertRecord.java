import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
    public static void main(String[] args) {
        // Database credentials
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        
        // JDBC driver name and database URL
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        // SQL statements
        String[] insertStatements = {
            "INSERT INTO Java VALUES (1, 'Humera', 75, 'A')",
            "INSERT INTO Java VALUES (2, 'Qasim', 85, 'EX')",
            "INSERT INTO Java VALUES (3, 'Tauseef', 65, 'B')",
            "INSERT INTO Java VALUES (4, 'Rimsha', 78, 'A')"
        };

        try {
            // Load JDBC driver
            Class.forName(jdbcDriver);

            // Establish connection
            try (Connection conn = DriverManager.getConnection(url, userName, password);
                 Statement stmt = conn.createStatement()) {

                // Execute SQL insert statements
                for (String sql : insertStatements) {
                    stmt.executeUpdate(sql);
                }

                System.out.println("Records inserted successfully.");
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
