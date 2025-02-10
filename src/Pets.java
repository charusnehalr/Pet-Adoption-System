public class Pets implements Adoptable {
  private int petId;
  private String name;
  private String type;
  private int age;
  private String size;
  private String healthStatus;
  private boolean isAdopted;

  // Constructor
  public Pets(int petId, String name, String type, int age, String size, String healthStatus, boolean isAdopted ) {
    this.petId = petId;
    this.name = name;
    this.type = type;
    this.age = age;
    this.size = size;
    this.healthStatus = healthStatus;
    this.isAdopted = isAdopted;
}
  // Overloaded constructor without petId (for new pets before they're saved in the database)
  public Pets(String name, String type, int age, String size, String healthStatus, boolean isAdopted) {
    this.name = name;
    this.type = type;
    this.age = age;
    this.size = size;
    this.healthStatus = healthStatus;
    this.isAdopted = isAdopted;
  }
  public int getId(){
    return petId;
  }
  public String getName() {
    return name;
}
  public String getType(){return type;}
  public int getAge() { return age; }
  public String getSize() { return size; }
  public String getHealthStatus() { return healthStatus; }
  public boolean getisAdopted() { return isAdopted; }
  //Methods
  @Override
  public void adopt(PetOwner owner){
    this.isAdopted = true; 
    System.out.println(name + " has been adopted by " + owner.getName());
  }
  @Override
  public String getAdoptionStatus(){
    return isAdopted ? "Adopted" : "Available";
  }
  // Implement Manageable methods
//  @Override
//  public void add() {
//      System.out.println("Pet added: " + name);
//  }
//
//  @Override
//  public void update() {
//      System.out.println("Pet updated: " + name);
//  }
//
//  @Override
//  public void delete() {
//      System.out.println("Pet deleted: " + name);
//  }

  public void displayDetails() {
    System.out.println("Pet ID: " + petId);
    System.out.println("Name: " + name);
    System.out.println("Type: " + type);
    System.out.println("Status: " + getAdoptionStatus());
}
}
