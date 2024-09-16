import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class signuponeconn {
    Connection c;
    Statement s;

    public signuponeconn() { 
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish Connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Hanuman$123");
            
            // Create Statement object
            s = c.createStatement();
            
            // Check if connection and statement are successfully created
            if (c == null) {
                System.out.println("Connection is null. Check your database URL, username, and password.");
            } else if (s == null) {
                System.out.println("Statement is null. Check your connection.");
            } else {
                System.out.println("Database connection established successfully.");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database access error.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General exception occurred.");
            e.printStackTrace();
        }
    }

    // Optional method to close resources
    public void close() {
        try {
            if (s != null && !s.isClosed()) {
                s.close();
            }
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing resources.");
            e.printStackTrace();
        }
    }
}
