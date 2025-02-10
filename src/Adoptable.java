
// This interface ensures that any class implementing ti must provide implementation of adopt() and getAdoptionStatus()
public interface Adoptable 
{
  void adopt(PetOwner owner); 
  String getAdoptionStatus();
}

