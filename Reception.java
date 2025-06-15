

package hospital.management.system;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import hospital.management.patient_discharge;

public class Reception extends JFrame {
    Reception() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(Color.BLACK); // Background changed to black
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(Color.BLACK); // Background changed to black
        add(panel1);

        Color buttonBackground = Color.WHITE;
        Color buttonForeground = Color.BLACK;

        JButton btn1 = new JButton("Add new Patient");
        btn1.setBounds(30, 15, 200, 30);
        btn1.setBackground(buttonBackground);
        btn1.setForeground(buttonForeground);
        panel1.add(btn1);
        btn1.addActionListener(e -> new NEW_PATIENT());

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        btn2.setBackground(buttonBackground);
        btn2.setForeground(buttonForeground);
        panel1.add(btn2);
        btn2.addActionListener(e -> new Room());

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        btn3.setBackground(buttonBackground);
        btn3.setForeground(buttonForeground);
        panel1.add(btn3);
        btn3.addActionListener(e -> new Department());

        JButton btn4 = new JButton("All employee info");
        btn4.setBounds(270, 15, 200, 30);
        btn4.setBackground(buttonBackground);
        btn4.setForeground(buttonForeground);
        panel1.add(btn4);
        btn4.addActionListener(e -> new Employee_info());

        JButton btn5 = new JButton("Patient info");
        btn5.setBounds(270, 58, 200, 30);
        btn5.setBackground(buttonBackground);
        btn5.setForeground(buttonForeground);
        panel1.add(btn5);
        btn5.addActionListener(e -> new patient_info());

        JButton btn6 = new JButton("Patient discharge");
        btn6.setBounds(270, 100, 200, 30);
        btn6.setBackground(buttonBackground);
        btn6.setForeground(buttonForeground);
        panel1.add(btn6);
        btn6.addActionListener(e -> new patient_discharge());

        JButton btn7 = new JButton("Update patient details");
        btn7.setBounds(510, 15, 200, 30);
        btn7.setBackground(buttonBackground);
        btn7.setForeground(buttonForeground);
        panel1.add(btn7);
        btn7.addActionListener(e -> new update_patient_details());

        JButton btn8 = new JButton("Ambulance");
        btn8.setBounds(510, 58, 200, 30);
        btn8.setBackground(buttonBackground);
        btn8.setForeground(buttonForeground);
        panel1.add(btn8);
        btn8.addActionListener(e -> new Ambulance());

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(510, 100, 200, 30);
        btn9.setBackground(buttonBackground);
        btn9.setForeground(buttonForeground);
        panel1.add(btn9);
        btn9.addActionListener(e -> new SearchRoom());

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(750, 15, 200, 30);
        btn10.setBackground(buttonBackground);
        btn10.setForeground(buttonForeground);
        panel1.add(btn10);
        btn10.addActionListener(e -> {
            setVisible(false);
            new login();
        });

        ImageIcon imageIcon=new   ImageIcon(ClassLoader.getSystemResource("icon/video.gif"));

        Image image=imageIcon.getImage().getScaledInstance(1950,1097,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,0,1520,625);
        panel.add(label);

        setSize(1950, 1090);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); // Frame background black
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
