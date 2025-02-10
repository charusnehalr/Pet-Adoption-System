# Pet Adoption System
The Pet Adoption System is a Java-based desktop application designed to streamline the management of pets and users in an adoption center. The application provides an intuitive graphical user interface (GUI) built using Java Swing, allowing shelter staff to efficiently manage pet records, user accounts, and adoption processes.

## Why This Project?
This project is designed to:

Simplify the management of pets and user by using role based access.

Provide a user-friendly interface for shelter staff to perform daily tasks efficiently.

Demostrate the real-life usage of OOPs and java concepts. 
Demonstrate the use of Java Swing for building desktop applications and JDBC for database integration.
Improve overall code by implementing efficient designs. 


# Key Features
## Pet Management:

Add Pets: Add new pets to the shelter database with details such as name, type (cat, dog, bird), age, size, health status, and adoption status.

Update Pets: Modify existing pet records, including updating health status or adoption status.

Delete Pets: Remove pets from the database when they are adopted or relocated.

Display Pet Details: Fetch and display detailed information about a specific pet using its unique ID.

## User Management:

Fetch User Details: Retrieve and display user information (name, email, password, and role) using the user ID.

Role-Based Access: Users are categorized into roles such as Admin, Visitor, and Pet Owner, enabling role-specific functionalities.

## Registration Management:

To book and track number of visitors and times of visits using the registration form and registration database. 

## Intuitive User Interface:

Sidebar Navigation: A sidebar provides quick access to different functionalities like adding pets, updating pets, deleting pets, and displaying pet details.

Dynamic Forms: The form panel dynamically updates based on the selected functionality (e.g., displaying the "Add Pet" form or "Update Pet" form).

## Database Integration:

The application interacts with a database (e.g., MySQL) using JDBC to store and retrieve pet and user information.

Data Access Objects (DAOs): Separate DAO classes (PetsDAO, UserDAO and RegistrationDAO) handle database operations, ensuring clean and modular code.

Error Handling:

The application includes robust error handling to manage invalid inputs, database errors, and other exceptions, providing meaningful feedback to the user.

# Technologies Used

Programming Language: Java

GUI Framework: Java Swing

Database: MySQL

Database Connectivity: JDBC (Java Database Connectivity)

Tools: IntelliJ IDEA

# GUI
## Login Screen
![image](https://github.com/user-attachments/assets/e998c1bb-808e-4130-a475-0e595317de81)


## Dashboard
![image](https://github.com/user-attachments/assets/43aaf0c4-b61f-4916-b4c8-f87268936e5c)

## Manage Pets 

## Add Pets 
![image](https://github.com/user-attachments/assets/609d1226-89e1-4389-949c-1db7724fb2ac)


## Update Pets
![image](https://github.com/user-attachments/assets/af66d53c-3967-4653-8d30-a2af2d581e35)

## Delete Pets
![image](https://github.com/user-attachments/assets/74a800b4-7a11-4754-a8dd-b0ca6e1d2bdf)

## Manage User
![image](https://github.com/user-attachments/assets/c115b7bb-89c3-4fc5-923e-0136994b446f)

## Database tables 

![image](https://github.com/user-attachments/assets/9646a9fd-e80a-426b-9153-88492b8012d2)

![image](https://github.com/user-attachments/assets/be7793ec-c1f5-47a0-961a-7ece71b61ba4)

![image](https://github.com/user-attachments/assets/05639740-bc80-4a77-82a9-5bd3cae90a5e)

## Future Enhancements
Adoption Management:
Add functionality to manage pet adoption requests and track adoption status timeline.

Reporting:
Generate reports for Admin, Visitor and Pet Owner. 
Adoption statistics (e.g., number of pets, adoption rates) and analysis. 

Search Functionality:
Allow users to search for pets based on criteria like type, age, or health status.








