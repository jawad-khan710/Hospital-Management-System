
package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

import hospital.management.conn;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    login() {
        // NAV BAR
        JPanel navBar = new JPanel();
        navBar.setBackground(Color.BLACK);
        navBar.setBounds(0, 0, 400, 50);
        navBar.setLayout(null);

        JLabel title = new JLabel("Login");
        title.setFont(new Font("Tahoma", Font.BOLD, 16));
        title.setForeground(Color.WHITE);
        title.setBounds(20, 10, 200, 30);
        navBar.add(title);
        add(navBar);

        // Labels
        JLabel nameLabel = new JLabel("Username:");
        nameLabel.setBounds(30, 70, 100, 25);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLabel.setForeground(Color.WHITE);
        add(nameLabel);

        JLabel password = new JLabel("Password:");
        password.setBounds(30, 110, 100, 25);
        password.setFont(new Font("Tahoma", Font.BOLD, 13));
        password.setForeground(Color.WHITE);
        add(password);

        // Text Fields
        textField = new JTextField();
        textField.setBounds(130, 70, 180, 28);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(130, 110, 180, 28);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
        jPasswordField.setBackground(Color.WHITE);
        jPasswordField.setForeground(Color.BLACK);
        add(jPasswordField);

        // Buttons
        b1 = new JButton("Login");
        b1.setBounds(130, 160, 85, 32);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(225, 160, 85, 32);
        b2.setFont(new Font("Tahoma", Font.BOLD, 13));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        // Frame Settings
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);
        setSize(400, 250);
        setLocation(550, 300);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());
                String q = "SELECT * FROM login WHERE ID = '" + user + "' AND pw='" + pass + "'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid login", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == b2) {
            System.exit(0);
        }
    }
}
