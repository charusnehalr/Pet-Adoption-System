
public class Visitor extends User{
  private String preferences; // Preferences for pets (e.g., type, size, age)
  // Constructor
  public Visitor(int id, String name, String email, String password, String preferences) {
      super(id, name, email, password, "visitor"); // Call the constructor of the User class
      this.preferences = preferences;
    }

  // Implement abstract methods from User
  @Override
  public void login() {
      System.out.println("Visitor " + getName() + " logged in.");
    }

  @Override
  public void logout() {
      System.out.println("Visitor " + getName() + " logged out.");
    }
  // Getters and setters
  public String getPreferences() {
      return preferences;
    }

  public void setPreferences(String preferences) {
      this.preferences = preferences;
    }
    
}


  
