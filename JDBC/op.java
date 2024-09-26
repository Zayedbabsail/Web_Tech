import java.sql.*;

public class op {
    public static void main(String[] args) {
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established");

            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Java (Rollno INT PRIMARY KEY, Name VARCHAR(30), Marks INT NOT NULL)");
            System.out.println("Table Created");

            stmt.execute("INSERT INTO Java (Rollno, Name, Marks) VALUES "
                       + "(1, 'op', 75), "
                       + "(2, 'noob', 25), "
                       + "(3, 'ok', 50)");
            System.out.println("Data Inserted");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Error closing Statement: " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing Connection: " + e.getMessage());
                }
            }
        }
    }
}