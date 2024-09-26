import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Database credentials
            String userName = "root";
            String password = "db@12345";
            String url = "jdbc:mysql://localhost:3306/test";

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, userName, password);

            // Create statement object
            stmt = conn.createStatement();

            // SQL query to create a table
            String createTableSQL = "CREATE TABLE Java ("
                                  + "Roll INT PRIMARY KEY, "
                                  + "Name VARCHAR(30), "
                                  + "Marks INT NOT NULL, "
                                  + "Grade VARCHAR(2))";

            // Execute the query
            stmt.executeUpdate(createTableSQL);

            System.out.println("Table 'Java' created successfully!");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server: " + e.getMessage());
        } finally {
            // Close resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
        }
    }
}
