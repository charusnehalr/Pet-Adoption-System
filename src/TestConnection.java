
// TestConnection.java
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseUtil.getConnection();
            System.out.println("Connected to the database!");
       // see how to print the url, name of the connected db?
            connection.close();
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
