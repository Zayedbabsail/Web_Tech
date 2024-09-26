import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AverageMarks {
    public static void main(String[] args) {
        // Database credentials
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        
        // JDBC driver name
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        
        // SQL query
        String query = "SELECT * FROM Java";

        int totalMarks = 0, numStudents = 0;
        float avgMarks;
        
        try {
            // Load JDBC driver
            Class.forName(jdbcDriver);

            // Establish connection and create statement
            try (Connection conn = DriverManager.getConnection(url, userName, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                System.out.println("\n\n -------  Results  ---------\n");
                while (rs.next()) {
                    String name = rs.getString("Name");
                    int roll = rs.getInt("Roll");
                    int marks = rs.getInt("Marks");
                    String grade = rs.getString("Grade");

                    totalMarks += marks;
                    numStudents++;

                    System.out.println("Name: " + name + "\t\t" + "Roll: " + roll + "\t\t" + "Marks: " + marks + "\t\t" + "Grade: " + grade + "\n");
                }

                if (numStudents > 0) {
                    avgMarks = (float) totalMarks / numStudents;
                    System.out.println("\n\n ------- AVERAGE Marks = " + avgMarks + " --------");
                } else {
                    System.out.println("No students found.");
                }
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
