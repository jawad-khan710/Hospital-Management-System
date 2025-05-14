
package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import hospital.management.conn;
import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame {
    Employee_info() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(Color.BLACK);  // Black background for the panel
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setBackground(Color.BLACK);  // Black background for the table
        table.setForeground(Color.WHITE);  // White text in the table
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "SELECT * FROM Emp_INFO";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(10, 9, 70, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 16));
        label.setForeground(Color.WHITE);  // White text for labels
        panel.add(label);

        JLabel label1 = new JLabel("Age");
        label1.setBounds(170, 11, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);  // White text for labels
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(350, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);  // White text for labels
        panel.add(label2);

        JLabel label3 = new JLabel("Salary");
        label3.setBounds(500, 11, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
        label3.setForeground(Color.WHITE);  // White text for labels
        panel.add(label3);

        JLabel label4 = new JLabel("Email");
        label4.setBounds(700, 11, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        label4.setForeground(Color.WHITE);  // White text for labels
        panel.add(label4);

        JLabel label5 = new JLabel("CNIC");
        label5.setBounds(830, 11, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 16));
        label5.setForeground(Color.WHITE);  // White text for labels
        panel.add(label5);

        JButton button = new JButton("Back");
        button.setBounds(350, 500, 120, 30);
        button.setBackground(Color.BLACK);  // Black background for the button
        button.setForeground(Color.WHITE);  // White text on the button
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(1000, 600);
        setLayout(null);
        setLocation(350, 230);
        getContentPane().setBackground(Color.BLACK);  // Black background for the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
