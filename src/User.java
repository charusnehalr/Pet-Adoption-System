
//  User is abstract as
// 1. All users (Admin, PetOwner, Visitor) share attributes like id, name and email
// 2. Common methods: All users need methods like login() and logout()

public abstract class User{
  //can only be accessed within User class
    private int id; 
    private String name;
    private String email;
    private String password;
    private String role;

    public User(int id, String name, String email, String password, String role){
      // constructor - special method to initialize objects of the class
      // we need inital values when User obj is created 
      this.id = id;
      this.email = email; 
      this.name = name;
      this.password = password;
      this.role = role;
      // this because compiler does not know whether id refers to class attribute / constructor parameter
    }
    public abstract void login();
    public abstract void logout();

    // Getters: methods to retrieve the values of private attributes
    public int getId(){ return id;}
    public String getName(){
      return name;
    }
    public String getEmail(){
      return email; 
    }
    public String getPassword(){
    return password;
  }
    public String getRole(){ return role;}

//    public void setName(String name){this.name = name;}
//    public void setEmail(String email) { this.email = email;}
//    public void setPassword(String password) { this.password = password;}
//    public void setRole(String role) {this.role = role;}
    //concrete method
    public void displayDetails() {
      System.out.println("ID: " + id);
      System.out.println("Name: " + name);
      System.out.println("Email: " + email);
    }
}
    
// Design: 
// Encapsulation: attributes private and with getters we control how data is accessed and modified
// with private, external code is used to modify (setter we can keep a validation), so we control the change
// No setter as attributes are meant to be immutable (unchangeable) 
// Without setter, User is consistent, no changes can be done and Thread safe(immutable obj are thread safe)