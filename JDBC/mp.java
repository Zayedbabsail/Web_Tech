import java.sql.*;

public class mp {
    public static void main(String[] args){
        String userName = "root";
        String password = "db@12345";
        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = null;
        Statement smt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("con established");

            smt = conn.createStatement();
            smt.execute("create table java(Rollno int primary key,name varchar(30),marks int not null)");
            System.out.println("table created");

            smt.execute("insert into java (Rollno,name,marks) values"
            +"(1,'op',75),"
            +"(2,'noob',25),"
            +"(3,'ok',50)");
            System.out.println("inserted values");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Exception"+e.getMessage());
        }finally{
            if(smt != null){
                try{
                    smt.close();
                } catch(SQLException e){
                    System.out.println("Error c smt"+e.getMessage());
                }
            }
            if (conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    System.out.println("Error closing conn"+e.getMessage());
                }
            }
        }
    }
}