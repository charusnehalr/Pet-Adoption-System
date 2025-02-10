import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static void addUser(User user){
        String sql = "INSERT INTO User (user_id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        // in this try resource is automatically closed after use
        try(Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            //bind actual value of from pet obj to ? placeholder
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.executeUpdate(); //runs INSERT query
            System.out.println("User added to the database!");
        } catch (SQLException e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    // Method to update a user's details
    public static void updateUser(User user) {
        String sql = "UPDATE User SET name = ?, email = ?, password = ?, role = ? WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());
            statement.setInt(5, user.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pet with ID " + user.getId() + " updated in the database!");
            } else {
                System.out.println("No pet found with ID " + user.getId());
            }
        } catch (SQLException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }

    // Method to delete a user by ID
    public static void deleteUser(int id) {
        String sql = "DELETE FROM User WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("User deleted!");
        } catch (SQLException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }

    // Method to fetch a user by email
    public static User getUserByEmail(String email) {
        String sql = "SELECT * FROM User WHERE email = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                System.out.println(name);
                System.out.println(role);
                System.out.println(password);
                // Create the appropriate subclass based on the role
                switch (role) {
                    case "Admin":
                        return new Admin(id, name, email, password, role);
                    case "Visitor":
                        return new Visitor(id, name, email, password, role); // Add preferences if needed
                    case "PetOwner":
                        return new PetOwner(id, name, email, password, role);
                    default:
                        throw new IllegalArgumentException("Invalid role: " + role);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching user: " + e.getMessage());
        }
        return null; // Return null if no user is found
    }
    public static User getUserById(int userId) {
        String sql = "SELECT * FROM User WHERE user_id = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    switch (role) {
                        case "Admin":
                            return new Admin(id, name, email, password, role);
                        case "Visitor":
                            return new Visitor(id, name, email, password, role);
                        case "PetOwner":
                            return new PetOwner(id, name, email, password, role);
                        default:
                            throw new IllegalArgumentException("Invalid role: " + role);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pet by ID: " + e.getMessage());
        }
        return null; // Return null if no pet is found
    }



}
