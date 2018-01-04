package frsp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JPanel
{
    private JTextField loginUsernameField;
    private JTextField loginPasswordField;
    private JTextField registerNameField;
    private JTextField registerUsernameField;
    private JTextField registerPasswordField;
    private JButton login;
    private JButton register;

    public Login() {
        createUI();
    }
    public String getLoginEmail(){
        return loginUsernameField.getText();
    }
    public String getLoginPass(){
        return loginPasswordField.getText();
    }
    public JButton getLoginBtn(){
        return login;
    }
    public String getRegisterName(){
        return registerNameField.getText();
    }
    public String getRegisterUsername(){
        return registerUsernameField.getText();
    }
    public String getRegisterPass(){
        return registerPasswordField.getText();
    }
    public JButton getRegisterBtn(){
        return register;
    }
    public void setRegisterEmpty(){
        registerNameField.setText("");
        registerUsernameField.setText("");
        registerPasswordField.setText("");
    }
    public void setLoginEmpty(){
        loginUsernameField.setText("");
        loginPasswordField.setText("");
    }
    public void createUI(){
        JPanel loginUserPanel = new JPanel();
            JPanel loginPasswordPanel = new JPanel();
            JPanel loginFieldsPanel = new JPanel();

            JPanel registerNamePanel = new JPanel();
            JPanel registerUserPanel = new JPanel();
            JPanel registerPasswordPanel = new JPanel();
            JPanel registerFieldsPanel = new JPanel();

            ImageIcon headerImage = new ImageIcon(
                            "images/header_main.png");
            JLabel header = new JLabel(headerImage);

            ImageIcon dividerImage = new ImageIcon(
                            "images/line.png");
            JLabel divider = new JLabel(dividerImage);

            loginFieldsPanel.setLayout(new BorderLayout());
            loginFieldsPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
            loginFieldsPanel.setBackground(Color.WHITE);

            JLabel loginLabel = new JLabel("Log In");
            loginLabel.setForeground(Color.decode("#D62027"));
            loginLabel.setFont(new Font("Avenir", Font.BOLD, 25));
            loginLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

            loginUserPanel.setBackground(Color.WHITE);
            JLabel loginUsernameLabel = new JLabel("Email");
            loginUsernameLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            loginUsernameField = new JTextField();
            loginUsernameField.setPreferredSize(new Dimension(40, 40));
            loginUsernameField.setColumns(20);
            loginUserPanel.setLayout(new BorderLayout());
            loginUserPanel.add(loginLabel, BorderLayout.NORTH);
            loginUserPanel.add(loginUsernameLabel, BorderLayout.CENTER);
            loginUserPanel.add(loginUsernameField, BorderLayout.SOUTH);

            loginPasswordPanel.setBackground(Color.WHITE);
            JLabel loginPasswordLabel = new JLabel("Password");
            loginPasswordLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            loginPasswordField = new JPasswordField();
            loginPasswordField.setPreferredSize(new Dimension(40, 40));
            loginPasswordField.setColumns(20);
            loginPasswordPanel.setBorder(new EmptyBorder(15, 0, 0, 0));
            loginPasswordPanel.setLayout(new BorderLayout());
            loginPasswordPanel.add(loginPasswordLabel, BorderLayout.NORTH);
            loginPasswordPanel.add(loginPasswordField, BorderLayout.SOUTH);

            loginFieldsPanel.add(loginUserPanel, BorderLayout.NORTH);
            loginFieldsPanel.add(loginPasswordPanel, BorderLayout.SOUTH);

            login = new JButton("Login");
            login.setFocusPainted(false);
            login.setText("Login");
            login.setBorder(null);
            login.setForeground(Color.WHITE);
            login.setBackground(Color.decode("#D62027"));
            login.setFont(new Font("Avenir", Font.PLAIN, 15));
            login.setPreferredSize(new Dimension(40, 40));
            login.setOpaque(true);

            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(new BorderLayout());
            loginPanel.setBorder(new EmptyBorder(0, 50, 50, 0));
            loginPanel.setBackground(Color.WHITE);
            loginPanel.add(loginFieldsPanel, BorderLayout.NORTH);
            loginPanel.add(login, BorderLayout.SOUTH);

            registerFieldsPanel.setLayout(new BorderLayout());
            registerFieldsPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
            registerFieldsPanel.setBackground(Color.WHITE);

            JLabel registerLabel = new JLabel("Register");
            registerLabel.setForeground(Color.decode("#D62027"));
            registerLabel.setFont(new Font("Avenir", Font.BOLD, 25));
            registerLabel.setBorder(new EmptyBorder(20, 0, 20, 0));

            registerNamePanel.setBackground(Color.WHITE);
            JLabel registerNameLabel = new JLabel("Name");
            registerNameLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            registerNameField = new JTextField();
            registerNameField.setPreferredSize(new Dimension(40, 40));
            registerNameField.setColumns(20);
            registerNamePanel.setLayout(new BorderLayout());
            registerNamePanel.add(registerLabel, BorderLayout.NORTH);
            registerNamePanel.add(registerNameLabel, BorderLayout.CENTER);
            registerNamePanel.add(registerNameField, BorderLayout.SOUTH);

            registerUserPanel.setBackground(Color.WHITE);
            JLabel registerUsernameLabel = new JLabel("Email");
            registerUsernameLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            registerUsernameField = new JTextField();
            registerUsernameField.setPreferredSize(new Dimension(40, 40));
            registerUsernameField.setColumns(20);
            registerUserPanel.setBorder(new EmptyBorder(15, 0, 10, 0));
            registerUserPanel.setLayout(new BorderLayout());
            registerUserPanel.add(registerUsernameLabel, BorderLayout.NORTH);
            registerUserPanel.add(registerUsernameField, BorderLayout.SOUTH);

            registerPasswordPanel.setBackground(Color.WHITE);
            JLabel registerPasswordLabel = new JLabel("Password");
            registerPasswordLabel.setFont(new Font("Avenir", Font.PLAIN, 15));
            registerPasswordField = new JPasswordField();
            registerPasswordField.setPreferredSize(new Dimension(40, 40));
            registerPasswordField.setColumns(20);
            registerPasswordPanel.setBorder(new EmptyBorder(15, 0, 10, 0));
            registerPasswordPanel.setLayout(new BorderLayout());
            registerPasswordPanel.add(registerPasswordLabel, BorderLayout.NORTH);
            registerPasswordPanel.add(registerPasswordField, BorderLayout.SOUTH);

            registerFieldsPanel.add(registerNamePanel, BorderLayout.NORTH);
            registerFieldsPanel.add(registerUserPanel, BorderLayout.CENTER);
            registerFieldsPanel.add(registerPasswordPanel, BorderLayout.SOUTH);

            register = new JButton("Register");
            register.setFocusPainted(false);
            register.setText("Register");
            register.setBorder(null);
            register.setForeground(Color.WHITE);
            register.setBackground(Color.decode("#D62027"));
            register.setFont(new Font("Avenir", Font.PLAIN, 15));
            register.setPreferredSize(new Dimension(40, 40));
            register.setOpaque(true);

            JPanel registerPanel = new JPanel();
            registerPanel.setLayout(new BorderLayout());
            registerPanel.setBorder(new EmptyBorder(0, 0, 50, 50));
            registerPanel.setBackground(Color.WHITE);
            registerPanel.add(registerFieldsPanel, BorderLayout.NORTH);
            registerPanel.add(register, BorderLayout.SOUTH);

            this.setLayout(new BorderLayout(10, 15));
            this.setBorder(new EmptyBorder(0, 0, 0, 0));
            this.setBackground(Color.WHITE);
            this.add(header, BorderLayout.NORTH);
            this.add(loginPanel, BorderLayout.WEST);
            this.add(divider, BorderLayout.CENTER);
            this.add(registerPanel, BorderLayout.EAST);
    }
}
