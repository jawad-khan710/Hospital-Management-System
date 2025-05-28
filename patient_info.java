
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

public class patient_info extends JFrame {

    patient_info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(Color.BLACK);  // Black background
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(Color.BLACK);  // Black background for the table
        table.setForeground(Color.WHITE);  // White text in the table
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "SELECT * FROM patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel("ID");
        label.setBounds(31, 11, 100, 14);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(Color.WHITE);  // White text
        panel.add(label);

        JLabel label1 = new JLabel("Number");
        label1.setBounds(150, 11, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);  // White text
        panel.add(label1);

        JLabel label4 = new JLabel("Name");
        label4.setBounds(270, 11, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);  // White text
        panel.add(label4);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(360, 11, 100, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);  // White text
        panel.add(label2);

        JLabel label3 = new JLabel("Disease");
        label3.setBounds(480, 11, 100, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);  // White text
        panel.add(label3);

        JLabel label5 = new JLabel("Deposited");
        label5.setBounds(800, 11, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);  // White text
        panel.add(label5);

        JLabel label6 = new JLabel("Time");
        label6.setBounds(700, 11, 100, 14);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.WHITE);  // White text
        panel.add(label6);

        JButton button = new JButton("Back");
        button.setBounds(450, 510, 120, 30);
        button.setBackground(Color.BLACK);  // Black background for the button
        button.setForeground(Color.WHITE);  // White text
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        getContentPane().setBackground(Color.BLACK);  // Black background for the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_info();
    }
}
