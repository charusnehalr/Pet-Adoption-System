import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {
    public AdminDashboard(User user) {
        setTitle("Admin Dashboard");
        setSize(400, 300);  setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon backgroundImage = new ImageIcon("img2.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(null); // Allows manual positioning of components
        backgroundLabel.setBounds(0, 0, 600, 700);

        JPanel panel = new JPanel(null);
        panel.setBounds(50, 50, 500, 600);
        placeComponents(panel, user);
        panel.setOpaque(false);
        backgroundLabel.add(panel);
        setContentPane(backgroundLabel);
        setVisible(true);
    }

    private void placeComponents(JPanel panel, User user) {
        panel.setLayout(null);

        // Welcome Message
        JLabel welcomeLabel = new JLabel("Welcome, " + user.getName() + " (Admin)");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(10, 20, 300, 25);
        panel.add(welcomeLabel);

        // Manage Pets Button
        JButton managePetsButton = new JButton("Manage Pets");
        managePetsButton.setBounds(10, 50, 150, 25);
        managePetsButton.setForeground(Color.WHITE);
        managePetsButton.setBackground(new Color(100, 100, 200));
        panel.add(managePetsButton);

        // Manage Users Button
        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.setBounds(10, 80, 150, 25);
        manageUsersButton.setForeground(Color.WHITE);
        manageUsersButton.setBackground(new Color(100, 100, 200));
        panel.add(manageUsersButton);

//         Add action listeners for buttons
        managePetsButton.addActionListener(e -> {
            new ManagePetsScreen().setVisible(true);
        });
//
        manageUsersButton.addActionListener(e -> {
            new ManageUserScreen().setVisible(true);
        });
    }
}