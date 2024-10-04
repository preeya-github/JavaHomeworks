

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) {
        // JDBC URL, username, and password for MySQL connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/sept2024";
        String username = "root";
        String password = "admin";
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute an SQL query (insert data into 'person' table)
            String sql = "INSERT INTO person VALUES (1, 'Gupta', 'Ram', 'Cary')";
            statement.executeUpdate(sql);
            
            System.out.println("Data inserted successfully!");
            
        } catch (ClassNotFoundException e) {
            // Handle error if the JDBC driver class is not found
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL-related errors
            e.printStackTrace();
        } finally {
            // Ensure resources are closed to avoid memory leaks
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
