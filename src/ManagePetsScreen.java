import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePetsScreen extends JFrame {
    private JPanel formPanel; // Panel to hold the form
    private JTextField nameField, ageField, petIdField;
    private JRadioButton catButton, dogButton, birdButton;
    private JRadioButton smallButton, mediumButton, largeButton;
    private JRadioButton healthyButton, sickButton;
    private JRadioButton adoptedYes, adoptedNo;

    public ManagePetsScreen() {
        setTitle("Manage Pets - Animal Shelter");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Set Background Image
        ImageIcon background = new ImageIcon("img2.png");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 800, 600);
        setContentPane(backgroundLabel);

        // Side Menu Panel
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new GridLayout(7, 1, 10, 10));
        sideMenu.setBounds(20, 50, 200, 500);
        sideMenu.setBackground(new Color(0, 0, 0, 10));
        sideMenu.setOpaque(true);

        String[] menuItems = {"Home", "Add Pet", "Update Pet", "Display Pet", "Delete Pet", "About Us", "Logout"};
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setFont(new Font("Arial", Font.BOLD, 14));
            menuButton.setForeground(Color.WHITE);
            menuButton.setBackground(new Color(100, 100, 200));
            sideMenu.add(menuButton);

            // Add action listeners for sidebar buttons
            if (item.equals("Add Pet")) {
                menuButton.addActionListener(e -> showPetForm("Add Pet"));
            }
            else if (item.equals("Update Pet")) {
                menuButton.addActionListener(e -> showPetForm("Update Pet"));
            }
            else if (item.equals("Delete Pet")) {
                menuButton.addActionListener(e -> showPetForm("Delete Pet"));
            }
        }
        add(sideMenu);

        // Form Panel (initially empty)
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(220, 50, 550, 500);
        formPanel.setBackground(new Color(255, 255, 255, 200));
        formPanel.setOpaque(true);
        add(formPanel);
        setVisible(true);
    }
    private void createFormPanel(String title) {
        formPanel.removeAll(); // Clear the form panel
        formPanel.revalidate();
        formPanel.repaint();
        // Form Title
        JLabel formTitle = new JLabel(title);
        formTitle.setFont(new Font("Arial", Font.BOLD, 24));
        formTitle.setBounds(200, 10, 200, 30);
        formPanel.add(formTitle);

       if(title.equals("Add Pet")){
           JButton addButton = new JButton("Add");
           addButton.setBounds(200, 400, 100, 30);
           addButton.setBackground(new Color(100, 200, 100));
           addButton.setForeground(Color.WHITE);
           addButton.addActionListener(e -> addPetToDatabase());
           formPanel.add(addButton);
           formPanel.revalidate();
           formPanel.repaint();
       }
       else if(title.equals("Update Pet")){
           JButton fetchButton = new JButton("Fetch");
           fetchButton.setBounds(290, 50, 80, 25);
           fetchButton.setBackground(new Color(100, 200, 100));
           fetchButton.setForeground(Color.WHITE);
           fetchButton.addActionListener(e -> fetchPetDetails());
           formPanel.add(fetchButton);

           JButton addButton = new JButton("Update");
           addButton.setBounds(200, 400, 100, 30);
           addButton.setBackground(new Color(100, 200, 100));
           addButton.setForeground(Color.WHITE);
           addButton.addActionListener(e -> updatePetInDatabase());
           formPanel.add(addButton);
           formPanel.revalidate();
           formPanel.repaint();
       }
       else if(title.equals("Delete Pet")){
           JButton fetchButton = new JButton("Fetch");
           fetchButton.setBounds(290, 50, 80, 25);
           fetchButton.setBackground(new Color(100, 200, 100));
           fetchButton.setForeground(Color.WHITE);
           fetchButton.addActionListener(e -> fetchPetDetails());
           formPanel.add(fetchButton);

           JButton addButton = new JButton("Delete");
           addButton.setBounds(200, 400, 100, 30);
           addButton.setBackground(new Color(255, 80, 80));
           addButton.setForeground(Color.WHITE);
           addButton.addActionListener(e -> deletePetInDatabase());
           formPanel.add(addButton);
           formPanel.revalidate();
           formPanel.repaint();
       }
    }
    private void fetchPetDetails() {
        int petId = Integer.parseInt(petIdField.getText());
        Pets pet = PetsDAO.getPetById(petId);
        if (pet != null) {
            nameField.setText(pet.getName());
            ageField.setText(String.valueOf(pet.getAge()));
            if (pet.getType().equals("Cat")) catButton.setSelected(true);
            else if (pet.getType().equals("Dog")) dogButton.setSelected(true);
            else birdButton.setSelected(true);
            if (pet.getSize().equals("Small")) smallButton.setSelected(true);
            else if (pet.getSize().equals("Medium")) mediumButton.setSelected(true);
            else largeButton.setSelected(true);
            if (pet.getHealthStatus().equals("Healthy")) healthyButton.setSelected(true);
            else sickButton.setSelected(true);
            if (pet.getisAdopted()) adoptedYes.setSelected(true);
            else adoptedNo.setSelected(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pet not found!");
        }
    }
    private void showPetForm(String name) {
        if(name.equals("Add Pet")){
            createFormPanel("Add Pet");
        }
        else if (name.equals("Update Pet")){
            createFormPanel("Update Pet");
        }
        else if (name.equals("Delete Pet")){
            createFormPanel("Delete Pet");
        }

        //pet id
        JLabel petIdLabel = new JLabel("Pet ID:");
        petIdLabel.setBounds(20, 50, 80, 25);
        petIdField = new JTextField();
        petIdField.setBounds(100, 50, 150, 25);
        formPanel.add(petIdLabel);
        formPanel.add(petIdField);

        // Animal Type
        JLabel animalTypeLabel = new JLabel("Animal:");
        animalTypeLabel.setBounds(20, 90, 80, 25);
        formPanel.add(animalTypeLabel);

        catButton = new JRadioButton("Cat");
        catButton.setBounds(100, 90, 60, 25);
        dogButton = new JRadioButton("Dog");
        dogButton.setBounds(160, 90, 60, 25);
        birdButton = new JRadioButton("Bird");
        birdButton.setBounds(220, 90, 60, 25);
        ButtonGroup animalGroup = new ButtonGroup();
        animalGroup.add(catButton);
        animalGroup.add(dogButton);
        animalGroup.add(birdButton);
        formPanel.add(catButton);
        formPanel.add(dogButton);
        formPanel.add(birdButton);

        // Name Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 130, 80, 25);
        nameField = new JTextField();
        nameField.setBounds(100, 130, 150, 25);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        // Age Field
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(20, 170, 80, 25);
        ageField = new JTextField();
        ageField.setBounds(100, 170, 150, 25);
        formPanel.add(ageLabel);
        formPanel.add(ageField);

        // Size Field
        JLabel sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(20, 210, 80, 25);
        smallButton = new JRadioButton("Small");
        smallButton.setBounds(100, 210, 80, 25);
        mediumButton = new JRadioButton("Medium");
        mediumButton.setBounds(180, 210, 80, 25);
        largeButton = new JRadioButton("Large");
        largeButton.setBounds(260, 210, 80, 25);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);
        formPanel.add(sizeLabel);
        formPanel.add(smallButton);
        formPanel.add(mediumButton);
        formPanel.add(largeButton);

        // Health Status Field
        JLabel healthLabel = new JLabel("Health Status:");
        healthLabel.setBounds(20, 250, 100, 25);
        healthyButton = new JRadioButton("Healthy");
        healthyButton.setBounds(120, 250, 80, 25);
        sickButton = new JRadioButton("Sick");
        sickButton.setBounds(200, 250, 80, 25);
        ButtonGroup healthGroup = new ButtonGroup();
        healthGroup.add(healthyButton);
        healthGroup.add(sickButton);
        formPanel.add(healthLabel);
        formPanel.add(healthyButton);
        formPanel.add(sickButton);

        // Is Adopted Field
        JLabel adoptedLabel = new JLabel("Is Adopted:");
        adoptedLabel.setBounds(20, 290, 100, 25);
        adoptedYes = new JRadioButton("Yes");
        adoptedYes.setBounds(120, 290, 80, 25);
        adoptedNo = new JRadioButton("No");
        adoptedNo.setBounds(200, 290, 80, 25);
        ButtonGroup adoptedGroup = new ButtonGroup();
        adoptedGroup.add(adoptedYes);
        adoptedGroup.add(adoptedNo);
        formPanel.add(adoptedLabel);
        formPanel.add(adoptedYes);
        formPanel.add(adoptedNo);

        formPanel.revalidate();
        formPanel.repaint();
    }

    private void addPetToDatabase() {
        String name = nameField.getText();
        String type = catButton.isSelected() ? "Cat" : dogButton.isSelected() ? "Dog" : "Bird";
        int age = Integer.parseInt(ageField.getText());
        String size = smallButton.isSelected() ? "Small" : mediumButton.isSelected() ? "Medium" : "Large";
        String healthStatus = healthyButton.isSelected() ? "Healthy" : "Sick";
        boolean isAdopted = adoptedYes.isSelected();

        Pets pet = new Pets(name, type, age, size, healthStatus, isAdopted);
        PetsDAO.addPet(pet);
        JOptionPane.showMessageDialog(this, "Pet added successfully!");
    }
    private void updatePetInDatabase() {
        int petId = Integer.parseInt(petIdField.getText());
        String name = nameField.getText();
        String type = catButton.isSelected() ? "Cat" : dogButton.isSelected() ? "Dog" : "Bird";
        int age = Integer.parseInt(ageField.getText());
        String size = smallButton.isSelected() ? "Small" : mediumButton.isSelected() ? "Medium" : "Large";
        String healthStatus = healthyButton.isSelected() ? "Healthy" : "Sick";
        boolean isAdopted = adoptedYes.isSelected();

        Pets pet = new Pets(petId, name, type, age, size, healthStatus, isAdopted);
        PetsDAO.updatePet(pet);
        JOptionPane.showMessageDialog(this, "Pet updated successfully!");
    }
    private void deletePetInDatabase() {
        try {
            int petId = Integer.parseInt(petIdField.getText()); // Get Pet ID from the text field
            PetsDAO.deletePet(petId); // Call the DAO method to delete the pet
            JOptionPane.showMessageDialog(this, "Pet with ID " + petId + " deleted successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Pet ID. Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting pet: " + e.getMessage());
        }
    }

}