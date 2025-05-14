// package hospital.management.system;

// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.ResultSet;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTable;

// import hospital.management.conn;
// import net.proteanit.sql.DbUtils;

// public class Department extends JFrame{

//     Department(){

//         JPanel panel= new JPanel();
//         panel.setBounds(5,5,690,490);
//         panel.setLayout(null);
//         panel.setBackground(new Color(90,156,163));
//         add(panel);

//         JTable table =new JTable();
//         table.setBounds(0,40,700,350);
//         table.setBackground(new Color(90,156,250));
//         table.setFont(new Font("tahoma",Font.BOLD,14));
//         panel.add(table);

//         try {
//             conn c =new conn();
//             String q = "select * from department ";
//             ResultSet resultSet= c.statement.executeQuery(q);
//             table.setModel(DbUtils.resultSetToTableModel(resultSet));
            
            
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         JLabel label = new JLabel("Department");
//         label.setBounds(145,11,105,20);
//         label.setFont(new Font("tahoma",Font.BOLD,14));
//         panel.add(label);
        
//         JLabel label1 = new JLabel("Phone Number");
//         label1.setBounds(330,11,105,20);
//         label1.setFont(new Font("tahoma",Font.BOLD,14));
//         panel.add(label1);

//         JButton b1=new JButton("Back");
//         b1.setBounds(400,410,150,30);
//         b1.setBackground(Color.BLACK);
//         b1.setForeground(Color.white);
//         panel.add(b1);
//         b1.addActionListener(new ActionListener() {

//             @Override
//             public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//             }
            
//         });






//         setSize(700,500);
//         setLayout(null);
//         setLocation(350,250);
//         setVisible(true);



//     }
//     public static void main(String[] args) {
//         new Department();
        
//     }
// }
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

public class Department extends JFrame {

    Department() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        table.setRowHeight(25);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "SELECT * FROM department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label = new JLabel("Department");
        label.setBounds(145, 11, 105, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Phone Number");
        label1.setBounds(330, 11, 120, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JButton b1 = new JButton("Back");
        b1.setBounds(400, 410, 150, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 13));
        panel.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
