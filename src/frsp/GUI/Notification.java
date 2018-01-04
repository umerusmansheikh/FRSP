package frsp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Notification extends JPanel
{
    JButton returnTo;

    public Notification(String message) {
        ImageIcon headerImage = new ImageIcon(
                        "images/header.png");
        JLabel headerImageLabel = new JLabel(headerImage);

        JButton placeholder = new JButton();
        placeholder.setFocusPainted(false);
        placeholder.setBorder(null);
        placeholder.setForeground(Color.WHITE);
        placeholder.setBackground(Color.decode("#333333"));
        placeholder.setFont(new Font("Avenir", Font.PLAIN, 15));
        placeholder.setPreferredSize(new Dimension(200, 48));
        placeholder.setOpaque(true);

        JPanel header = new JPanel();
        header.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        header.setBorder(new EmptyBorder(0, 0, 0, -1));
        header.setBackground(Color.WHITE);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        header.add(headerImageLabel, c);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        header.add(placeholder, c);

        ImageIcon successImage = new ImageIcon(
                        "images/notification.gif");
        JLabel success = new JLabel(successImage);
        success.setBorder(new EmptyBorder(0, 0, 0, 20));

        JLabel successTitle = new JLabel("Notification! ");
        successTitle.setForeground(Color.decode("#D62027"));
        successTitle.setFont(new Font("Avenir", Font.BOLD, 30));
        successTitle.setBorder(new EmptyBorder(20, 20, 20, 0));

        JLabel successMessageLabel1 = new JLabel(message);
        successMessageLabel1.setFont(new Font("Avenir", Font.BOLD, 18));
        successMessageLabel1.setBorder(new EmptyBorder(20, 20, 20, 0));


        returnTo = new JButton("Return to Home");
        returnTo.setFocusPainted(false);
        returnTo.setText("Return to Home");
        returnTo.setBorder(null);
        returnTo.setForeground(Color.WHITE);
        returnTo.setBackground(Color.decode("#D62027"));
        returnTo.setFont(new Font("Avenir", Font.PLAIN, 15));
        returnTo.setPreferredSize(new Dimension(40, 40));
        returnTo.setOpaque(true);

        JPanel successPanel = new JPanel();
        successPanel.setLayout(new GridLayout(4, 0));
        successPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        successPanel.setBackground(Color.WHITE);
        successPanel.add(successTitle);
        successPanel.add(successMessageLabel1);

        this.setLayout(new BorderLayout(10, 15));
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setBackground(Color.WHITE);
        this.add(header, BorderLayout.NORTH);
        this.add(successPanel, BorderLayout.WEST);
        this.add(success, BorderLayout.EAST);
        this.add(returnTo, BorderLayout.SOUTH);
    }
    public JButton getReturnBtn(){
        return returnTo;
    }
}
