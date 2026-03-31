import java.awt.*;
import javax.swing.*;

public class Frontend {

    public static void main(String[] args) {

        // Frame (acts like phone screen)
        JFrame frame = new JFrame("Secure Login");
        frame.setSize(360, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main panel (dark background)
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(18, 18, 18));
        mainPanel.setLayout(new GridBagLayout());

        // Card panel (like mobile UI card)
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(300, 420));
        card.setBackground(new Color(30, 30, 30));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

        // Title
        JLabel title = new JLabel("🔐 Secure Login");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Email field
        JTextField emailField = new JTextField();
        styleTextField(emailField);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        styleTextField(passwordField);

        // Show password checkbox
        JCheckBox showPassword = new JCheckBox("Show Password");
        showPassword.setForeground(Color.LIGHT_GRAY);
        showPassword.setBackground(new Color(30, 30, 30));

        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });

        // Buttons
        JButton loginButton = new JButton("Login");
        styleButton(loginButton, new Color(0, 150, 255));

        JButton registerButton = new JButton("Register");
        styleButton(registerButton, new Color(100, 100, 100));

        // 🔐 LOGIN
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try {
                boolean success = UserService.loginUser(email, password);

                if (success) {
                    JOptionPane.showMessageDialog(frame, "Login Successful ✅");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials ❌");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }

            emailField.setText("");
            passwordField.setText("");
        });

        // 📝 REGISTER
        registerButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            try {
                UserService.registerUser(email, password);
                JOptionPane.showMessageDialog(frame, "Registration Successful ✅");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }

            emailField.setText("");
            passwordField.setText("");
        });

        // Add components to card
        card.add(title);
        card.add(Box.createVerticalStrut(30));

        card.add(label("Email"));
        card.add(emailField);
        card.add(Box.createVerticalStrut(15));

        card.add(label("Password"));
        card.add(passwordField);
        card.add(showPassword);
        card.add(Box.createVerticalStrut(25));

        card.add(loginButton);
        card.add(Box.createVerticalStrut(10));
        card.add(registerButton);

        mainPanel.add(card);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // 🔹 Styled label
    private static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.LIGHT_GRAY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    // 🔹 Styled text field
    private static void styleTextField(JTextField field) {
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    // 🔹 Styled button
    private static void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}