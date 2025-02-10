
//This interface ensures that any class implementing it (like Pets, PetOwner, or Visitor) must provide implementations for add(), update(), and delete().
public interface Mangeable {
  void add(); // Adds an entity to the system
  void update(); // Updates an entity in the system
  void delete(); // Deletes an entity from the system
}
