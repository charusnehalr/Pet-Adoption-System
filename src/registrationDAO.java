import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class registrationDAO {
    public static void addRegistration(Registration registration) {
        String sql = "INSERT INTO Registration (visitorId, email, password, registrationDate, name) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registration.getVisitorId());
            statement.setString(2, registration.getEmail());
            statement.setString(3, registration.getPassword());
            statement.setDate(4, java.sql.Date.valueOf(registration.getRegistrationDate()));
            statement.setString(5, registration.getName());
            statement.executeUpdate();
            System.out.println("Registration added to the database!");
        } catch (SQLException e) {
            System.out.println("Error adding registration: " + e.getMessage());
        }
    }

    // RegistrationDAO.java
    public static void updateRegistration(Registration registration) {
        String sql = "UPDATE Registration SET email = ?, password = ?, registrationDate = ?, name = ? WHERE visitorId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, registration.getEmail());
            statement.setString(2, registration.getPassword());
            statement.setDate(3, java.sql.Date.valueOf(registration.getRegistrationDate()));
            statement.setString(4, registration.getName());
            statement.setInt(5, registration.getVisitorId());
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Registration updated!");
            }
            else {
                System.out.println("No registration found with ID " + registration.getVisitorId());
            }
        } catch (SQLException e) {
            System.out.println("Error updating registration: " + e.getMessage());
        }
    }

    // RegistrationDAO.java
    public static void deleteRegistrationUsingReg(int registrationId) {
        String sql = "DELETE FROM Registration WHERE registrationId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registrationId); // Use registrationId to identify the record
            statement.executeUpdate();
            System.out.println("Registration deleted!");
        } catch (SQLException e) {
            System.out.println("Error deleting registration: " + e.getMessage());
        }
    }
    public static void deleteRegistrationUsingVisitor(int visitorId) {
        String sql = "DELETE FROM Registration WHERE registrationId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, visitorId);
            statement.executeUpdate();
            System.out.println("Registration deleted!");
        } catch (SQLException e) {
            System.out.println("Error deleting registration: " + e.getMessage());
        }
    }

    // Method to validate login credentials
    public static boolean validateLogin(String email, String password) {
        String sql = "SELECT * FROM Registration WHERE email = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if a match is found
        } catch (SQLException e) {
            System.out.println("Error validating login: " + e.getMessage());
            return false;
        }
    }

}
