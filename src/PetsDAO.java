// PetsDAO.java
// DAO - data access object class is responsible for interacting with the databases
// Each entity (pets, user etc) should have it's own DAO class
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetsDAO {
    // Method to add a pet to the database
    // static --> so method can be called without creating instance. Directly using class name
    public static void addPet(Pets pet) {
        String sql = "INSERT INTO Pets (name, type, age, size, healthStatus, isAdopted) VALUES (?, ?, ?, ?, ?, ?)";
        // in this try resource is automatically closed after use
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            //bind actual value of from pet obj to ? placeholder
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getSize());
            statement.setString(5, pet.getHealthStatus());
            statement.setString(6, String.valueOf(pet.getisAdopted()));
            statement.executeUpdate(); //runs INSERT query
            System.out.println("Pet added to the database!");
        } catch (SQLException e) {
            System.out.println("Error adding pet: " + e.getMessage());
        }
    }

    // Method to delete a pet from the database
    public static void deletePet(int petId) {
        String sql = "DELETE FROM Pets WHERE petId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, petId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pet with ID " + petId + " deleted from the database!");
            } else {
                System.out.println("No pet found with ID " + petId);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting pet: " + e.getMessage());
        }
    }

    // Method to update a pet's details in the database
    public static void updatePet(Pets pet) {
        String sql = "UPDATE Pets SET name = ?, type = ?, age = ?, size = ?, healthStatus = ?, isAdopted = ? WHERE petId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getType());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getSize());
            statement.setString(5, pet.getHealthStatus());
            statement.setString(6, String.valueOf(pet.getisAdopted()));
            statement.setInt(7, pet.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pet with ID " + pet.getId() + " updated in the database!");
            } else {
                System.out.println("No pet found with ID " + pet.getId());
            }
        } catch (SQLException e) {
            System.out.println("Error updating pet: " + e.getMessage());
        }
    }
    public static Pets getPetById(int petId) {
        String sql = "SELECT * FROM Pets WHERE petId = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, petId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Pets(
                            resultSet.getInt("petId"),
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("age"),
                            resultSet.getString("size"),
                            resultSet.getString("healthStatus"),
                            resultSet.getBoolean("isAdopted")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pet by ID: " + e.getMessage());
        }
        return null; // Return null if no pet is found
    }
    //Method to get all pets from the database
    public static List<Pets> getAllPets() {
        List<Pets> petsList = new ArrayList<>();
        String sql = "SELECT * FROM Pets";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pets pet = new Pets(
                        resultSet.getInt("petId"),
                        resultSet.getString("name"),
                        resultSet.getString("type"),
                        resultSet.getInt("age"),
                        resultSet.getString("size"),
                        resultSet.getString("healthStatus"),
                        resultSet.getBoolean("isAdopted")
                );
                petsList.add(pet);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching pets: " + e.getMessage());
        }
        return petsList;
    }
}
