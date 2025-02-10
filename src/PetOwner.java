
public class PetOwner extends User {
  // Constructor
  public PetOwner(int id, String name, String email,String password, String role) {
      super(id, name, email,password, "pet owner");
  }
  // Implement abstract methods
  @Override
  public void login() {
      System.out.println("Pet Owner " + getName() + " logged in.");
  }

  @Override
  public void logout() {
      System.out.println("Pet Owner " + getName() + " logged out.");
  }
      // PetOwner-specific methods
      public void adoptPet(Pets pet) {
          pet.adopt(this);
      }
    public void viewAdoptedPets() {
      System.out.println(getName() + "'s adopted pets: (To be implemented)");
    }

}
