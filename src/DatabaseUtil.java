
// DatabaseUtil.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/PetAdoptionSystem";
    private static final String USER = "PetApplication"; // Database username
    private static final String PASSWORD = "root"; // Database password

    // Method to get a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}