
// Registration.java
import java.time.LocalDate;

public class Registration {
    private int registrationId; // Unique ID for the registration
    private int visitorId; // ID of the visitor being registered
    private String email; // Email of the visitor
    private String password; // Password for the visitor's account
    private LocalDate registrationDate; // Date of registration
    private String name;

    // Constructor
    public Registration( int visitorId, String email, String password, LocalDate registrationDate, String name) {
        this.registrationId = registrationId;
        this.visitorId = visitorId;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.name = name;
    }

    // Getters and Setters
    public int getRegistrationId() {
        return registrationId;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }


    // Validate login credentials
    public boolean validateLogin(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    // Display registration details
    public void displayDetails() {
        System.out.println("Registration ID: " + registrationId);
        System.out.println("Visitor ID: " + visitorId);
        System.out.println("Email: " + email);
        System.out.println("Registration Date: " + registrationDate);
    }
}
