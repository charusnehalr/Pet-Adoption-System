import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserScreen extends JFrame {
    private JPanel formPanel; // Panel to hold the form
    private JTextField userIdField, nameField, emailField, passwordField;
    private JRadioButton visitorButton, adminButton, petOwnerButton;


    public ManageUserScreen() {
        setTitle("Manage User - Animal Shelter");
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

        String[] menuItems = {"Home", "Add User", "Update User", "Display User", "Delete User", "About Us", "Logout"};
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setFont(new Font("Arial", Font.BOLD, 14));
            menuButton.setForeground(Color.WHITE);
            menuButton.setBackground(new Color(100, 100, 200));
            sideMenu.add(menuButton);

            // Add action listeners for sidebar buttons
            if (item.equals("Add User")) {
                menuButton.addActionListener(e -> showUserForm("Add User"));
            }
            else if (item.equals("Update User")) {
                menuButton.addActionListener(e -> showUserForm("Update User"));
            }
            else if (item.equals("Delete User")) {
                menuButton.addActionListener(e -> showUserForm("Delete User"));
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

        if(title.equals("Add User")){
            JButton addButton = new JButton("Add");
            addButton.setBounds(200, 400, 100, 30);
            addButton.setBackground(new Color(100, 200, 100));
            addButton.setForeground(Color.WHITE);
           addButton.addActionListener(e -> {
                addUserToDatabase();
                resetFields();
            });
            formPanel.add(addButton);
            formPanel.revalidate();
            formPanel.repaint();
        }
        else if(title.equals("Update User")){
            JButton fetchButton = new JButton("Fetch");
            fetchButton.setBounds(290, 50, 80, 25);
            fetchButton.setBackground(new Color(100, 200, 100));
            fetchButton.setForeground(Color.WHITE);
            fetchButton.addActionListener(e -> {
                fetchUserDetails();
            });
            formPanel.add(fetchButton);

            JButton updateButton = new JButton("Update");
            updateButton.setBounds(200, 400, 100, 30);
            updateButton.setBackground(new Color(100, 200, 100));
            updateButton.setForeground(Color.WHITE);
            updateButton.addActionListener(e -> {
                updateUserInDatabase();
                resetFields();
            });
            formPanel.add(updateButton);
            formPanel.revalidate();
            formPanel.repaint();
        }
        else if(title.equals("Delete User")){
            JButton fetchButton = new JButton("Fetch");
            fetchButton.setBounds(290, 50, 80, 25);
            fetchButton.setBackground(new Color(100, 200, 100));
            fetchButton.setForeground(Color.WHITE);
            fetchButton.addActionListener(e -> fetchUserDetails());
            formPanel.add(fetchButton);

            JButton addButton = new JButton("Delete");
            addButton.setBounds(200, 400, 100, 30);
            addButton.setBackground(new Color(255, 80, 80));
            addButton.setForeground(Color.WHITE);
            addButton.addActionListener(e -> {
                deleteUserInDatabase();
                resetFields();
            });
            formPanel.add(addButton);
            formPanel.revalidate();
            formPanel.repaint();
        }
    }
    private void resetFields() {
        // Reset text fields
        userIdField.setText("");
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");

        // Reset radio buttons
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(adminButton);
        roleGroup.add(visitorButton);
        roleGroup.add(petOwnerButton);
        roleGroup.clearSelection(); // Deselect any selected radio button
    }
        private void fetchUserDetails() {
            try {
                int userId = Integer.parseInt(userIdField.getText());
                User user = UserDAO.getUserById(userId);
                if (user != null) {
                    // Populate the fields based on the user's details
                    nameField.setText(user.getName());
                    emailField.setText(user.getEmail());
                    if (user.getRole().equals("Admin")) adminButton.setSelected(true);
                    else if (user.getRole().equals("Visitor")) visitorButton.setSelected(true);
                    else petOwnerButton.setSelected(true);
//                    roleField.setText(user.getRole());
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid User ID!");
            }
        }

    private void showUserForm(String name) {
        if(name.equals("Add User")){
            createFormPanel("Add User");
        }
        else if (name.equals("Update User")){
            createFormPanel("Update User");
        }
        else if (name.equals("Delete User")){
            createFormPanel("Delete User");
        }
        //user id
        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(20, 50, 80, 25);
        userIdField = new JTextField();
        userIdField.setBounds(100, 50, 150, 25);
        formPanel.add(userIdLabel);
        formPanel.add(userIdField);

        // Name Field
        JLabel nameLabel = new JLabel("User Name:");
        nameLabel.setBounds(20, 90, 80, 25);
        nameField = new JTextField();
        nameField.setBounds(100, 90, 150, 25);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        // Email Filed
        JLabel emailLabel = new JLabel("User Email:");
        emailLabel.setBounds(20, 130, 80, 25);
        emailField = new JTextField();
        emailField.setBounds(100, 130, 150, 25);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        // password Field
        JLabel passwordLabel = new JLabel("User Password:");
        passwordLabel.setBounds(20, 170, 80, 25);
        passwordField = new JTextField();
        passwordField.setBounds(100, 170, 150, 25);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Role Field
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(20, 210, 80, 25);
        adminButton = new JRadioButton("Admin");
        adminButton.setBounds(100, 210, 80, 25);
        visitorButton = new JRadioButton("Visitor");
        visitorButton.setBounds(180, 210, 80, 25);
        petOwnerButton = new JRadioButton("Pet Owner");
        petOwnerButton.setBounds(260, 210, 100, 25);
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(adminButton);
        sizeGroup.add(visitorButton);
        sizeGroup.add(petOwnerButton);
        formPanel.add(roleLabel);
        formPanel.add(adminButton);
        formPanel.add(visitorButton);
        formPanel.add(petOwnerButton);
        formPanel.revalidate();
        formPanel.repaint();
    }

    private void addUserToDatabase() {
        int user_id = Integer.parseInt(userIdField.getText());
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = adminButton.isSelected() ? "Admin" : visitorButton.isSelected() ? "Visitor" : "Petowner";

        User user = UserDAO.getUserByEmail(email);
        if(user != null){
            JOptionPane.showMessageDialog(this, "User ID already exists! Cannot add duplicate users.");
            return;
        }

        if(role == "Admin"){
            User admin = new Admin(user_id, name, email, password, role);
            UserDAO.addUser(admin);
            JOptionPane.showMessageDialog(this, "New Admin added successfully!");
        }
        else if(role == "Visitor"){
            User visitor = new Visitor(user_id, name, email, password, role);
            UserDAO.addUser(visitor);
            JOptionPane.showMessageDialog(this, "New Visitor added successfully!");
        }
        else{
            User petowner = new PetOwner(user_id, name, email, password, role);
            UserDAO.addUser(petowner);
            JOptionPane.showMessageDialog(this, "New Pet Owner added successfully!");
        }
    }
    private void updateUserInDatabase() {
        int id = Integer.parseInt(userIdField.getText());
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String role = adminButton.isSelected() ? "Admin" : visitorButton.isSelected() ? "Visitor" : "Petowner";
        if(role == "Admin"){
            User admin = new Admin(id, name, email, password, role);
            UserDAO.updateUser(admin);
            JOptionPane.showMessageDialog(this, "New Admin updated successfully!");
        }
        else if(role == "Visitor"){
            User visitor = new Visitor(id, name, email, password, role);
            UserDAO.updateUser(visitor);
            JOptionPane.showMessageDialog(this, "New Visitor updated successfully!");
        }
        else{
            User user = new PetOwner(id, name, email, password, role);
            UserDAO.updateUser(user);
            JOptionPane.showMessageDialog(this, "New Pet Owner is updated successfully!");
        }
    }
    private void deleteUserInDatabase() {
        try {
            int userid = Integer.parseInt(userIdField.getText()); // Get Pet ID from the text field
            UserDAO.deleteUser(userid); // Call the DAO method to delete the pet
            JOptionPane.showMessageDialog(this, "User with ID " + userid + " deleted successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid user ID. Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting user: " + e.getMessage());
        }
    }


}
