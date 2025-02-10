public class Admin extends User {
    //constructor
    public Admin(int id, String name, String email, String password, String role){
        super(id, name, email, password, "admin");
    }

    @Override
    public void login() {
        System.out.println("Admin: " + getName() + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println("Admin: " + getName() + " logged out.");
    }
    //Admin-specific methods
    public void addPet(Pets pet){
        System.out.println("Pet added: " + pet.getId());
        PetsDAO.addPet(pet);
    }
    public void deletePet(int petId) {
        System.out.println("Pet deleted with ID: " + petId);
        PetsDAO.deletePet(petId);
    }
}
