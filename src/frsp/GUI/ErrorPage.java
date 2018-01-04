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

public class ErrorPage extends JPanel
{
    JButton returnTo;

    public ErrorPage(String errorMessage) {
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

        ImageIcon errorImage = new ImageIcon(
                        "images/error.gif");
        JLabel error = new JLabel(errorImage);
        error.setBorder(new EmptyBorder(0, 0, 0, 50));

        JLabel errorTitle = new JLabel("Oops! ");
        errorTitle.setForeground(Color.decode("#D62027"));
        errorTitle.setFont(new Font("Avenir", Font.BOLD, 30));
        errorTitle.setBorder(new EmptyBorder(20, 20, 20, 0));

        JLabel errorLabel = new JLabel("There seems to have been a problem... ");
        errorLabel.setFont(new Font("Avenir", Font.BOLD, 20));
        errorLabel.setBorder(new EmptyBorder(20, 20, 20, 0));

        JLabel errorMessageLabel = new JLabel(errorMessage);
        errorMessageLabel.setFont(new Font("Avenir", Font.BOLD, 15));
        errorMessageLabel.setBorder(new EmptyBorder(20, 20, 20, 0));

        returnTo = new JButton("Return to Home");
        returnTo.setFocusPainted(false);
        returnTo.setText("Return to Home");
        returnTo.setBorder(null);
        returnTo.setForeground(Color.WHITE);
        returnTo.setBackground(Color.decode("#D62027"));
        returnTo.setFont(new Font("Avenir", Font.PLAIN, 15));
        returnTo.setPreferredSize(new Dimension(40, 40));
        returnTo.setOpaque(true);

        JPanel errorPanel = new JPanel();
        errorPanel.setLayout(new GridLayout(4, 0));
        errorPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        errorPanel.setBackground(Color.WHITE);
        errorPanel.add(errorTitle);
        errorPanel.add(errorLabel);
        errorPanel.add(errorMessageLabel);

        this.setLayout(new BorderLayout(10, 15));
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setBackground(Color.WHITE);
        this.add(header, BorderLayout.NORTH);
        this.add(errorPanel, BorderLayout.WEST);
        this.add(error, BorderLayout.EAST);
        this.add(returnTo, BorderLayout.SOUTH);
    }
    public JButton getReturnBtn(){
        return returnTo;
    }
}
