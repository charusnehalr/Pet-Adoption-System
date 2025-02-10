import java.time.LocalDate;
import java.util.List;

public class Main {
  public static void main(String[] args){
        User admin = new Admin(101, "charu", "charu@example.com", "charu123", "admin");
        UserDAO.updateUser(admin);
//      User visitor = new Visitor(102, "Joe", "joe@example.com", "password123", "dog");
//      Registration registration = new Registration(102, "joe@example.com", "jack1234", LocalDate.now(), "Jck");
//      registrationDAO.deleteRegistration(101);


//    User user1 = new Admin(1, "Doe", "jn@example.com", "password123", "Admin");
//    UserDAO.addUser(user1);
//    user1.displayDetails();

//    UserDAO.deleteUser(6);
//    user1.displayDetails();


//    User visitor1 = new Visitor(1, "John Doe", "john@example.com", "password123", "Admin");
//    UserDAO.addUser(user1);
//    user1.displayDetails();

    // Step 1: Create a new pet
//    Pets pet1 = new Pets(1, "Chubby", "Dog", 2, "Large", "Healthy", true);
//    Pets pet2 = new Pets(2, "lubby", "Cat", 1, "Small", "Healthy", false);
    // Step 2: Add pets to the database
//    PetsDAO.updatePet(pet2);
//    PetsDAO.addPet(pet2);

    // Step 3: Fetch all pets from the database
//    List<Pets> petsList = PetsDAO.getAllPets();
//
//    // Step 4: Display all pets
//    System.out.println("All Pets in the Database:");
//    for (Pets pet : petsList) {
//      pet.displayDetails();
//      System.out.println(); // Add a blank line for readability
//    }
//    Admin admin = new Admin(1, "Charu", "charu@gmail.com");
//    admin.login();
//
//    Pets pet1 = new Pets(101, "buddy", "dog");
//
//    pet1.displayDetails();
//
//    PetOwner owner1 = new PetOwner(2, "Jane Smith", "jane@example.com");
//    owner1.login();
//
//    Visitor visitor1 = new Visitor(3, "Alice","alice@gmail.xom", "Prefers cats");
//    Registration registration1 = new Registration(1, 3, "alice@example.com", "password123", LocalDate.now());
//    registration1.displayDetails();
//    boolean isValidLogin = registration1.validateLogin("alice@example.com", "password123");
//    System.out.println("Login validation: " + isValidLogin);
//
//    admin.logout();

  }  
}
