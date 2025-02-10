// LoginScreen.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    //constructor
    public LoginScreen() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("img2.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null); // Allows manual positioning of components
        backgroundLabel.setBounds(0, 0, 400, 300);
//layout null --> manual positioning of child components
        JPanel panel = new JPanel(null);
        panel.setBounds(50, 50, 300, 200);
        panel.setOpaque(false);

        placeComponents(panel);
        // overlay panel on background
        backgroundLabel.add(panel);
        setContentPane(backgroundLabel);
        setVisible(true);
// add the background (image) --> add panel on it --> on the panel place email etc
// Jframe --> canvas (outermost window) --> backgroundLabel (photoframe covering canvas) --> panel (a sheet on top of photoframe) --> components (pinned on sheet)
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Email Label and Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 20, 80, 25);
            emailLabel.setForeground(Color.BLACK); // To ensure it's visible on the background
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(100, 20, 165, 25);
        panel.add(emailField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        // Login Button Action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Validate login using UserDAO
                User user = UserDAO.getUserByEmail(email);
                if (user != null && user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login successful!");

//                     Redirect based on user role
                    redirectUser(user);
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Invalid email or password.");
                }
            }
        });
    }

    // Method to redirect user based on role
    private void redirectUser(User user) {
        switch (user.getRole()) {
            case "admin":
                new AdminDashboard(user).setVisible(true);
                break;
//            case "Visitor":
//                new VisitorDashboard(user).setVisible(true);
//                break;
//            case "PetOwner":
//                new PetOwnerDashboard(user).setVisible(true);
//                break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid user role.");
        }
        this.dispose(); // Close the login screen
    }

    public static void main(String[] args) {
        new LoginScreen();
    }
}
