
package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;
import javax.swing.*;
import hospital.management.conn;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        String[] labelTexts = {"ID:", "Number:", "Name:", "Gender:", "Disease:", "Room:", "Date:", "Deposite:"};
        int[] yPositions = {76, 111, 151, 191, 231, 274, 316, 359};

        for (int i = 0; i < labelTexts.length; i++) {
            JLabel labelTemp = new JLabel(labelTexts[i]);
            labelTemp.setBounds(35, yPositions[i], 200, 14);
            labelTemp.setFont(new Font("Tahoma", Font.BOLD, 14));
            labelTemp.setForeground(Color.WHITE);
            panel.add(labelTemp);
        }

        comboBox = new JComboBox<>(new String[]{"CNIC", "Sehat Card", "Driving License"});
        comboBox.setBounds(200, 75, 150, 20);
        comboBox.setBackground(Color.BLACK);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(200, 111, 150, 20);
        textFieldNumber.setBackground(Color.BLACK);
        textFieldNumber.setForeground(Color.WHITE);
        panel.add(textFieldNumber);

        textName = new JTextField();
        textName.setBounds(200, 151, 151, 20);
        textName.setBackground(Color.BLACK);
        textName.setForeground(Color.WHITE);
        panel.add(textName);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(Color.BLACK);
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(Color.BLACK);
        r2.setBounds(200, 191, 80, 15);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(200, 231, 150, 20);
        textFieldDisease.setBackground(Color.BLACK);
        textFieldDisease.setForeground(Color.WHITE);
        panel.add(textFieldDisease);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(Color.BLACK);
        panel.add(c1);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(200, 316, 250, 14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(200, 359, 150, 20);
        textFieldDeposite.setBackground(Color.BLACK);
        textFieldDeposite.setForeground(Color.WHITE);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 20);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 20);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = gender;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try {
                String q = "insert into patient_info values('" + s1 + "', '" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s7 + "','" + s8 + "')";
                String q1 = "update Room set Avalibility = 'Occupied' where room_number = '" + s6 + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Added successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }
}
