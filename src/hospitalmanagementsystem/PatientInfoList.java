package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;



public class PatientInfoList extends JFrame implements ActionListener
{
    
    JTable table;
    JButton print,cancel,search;
    JTextField tfpatient;
 
     PatientInfoList()
    {
        JLabel heading = new JLabel("PATIENT INFORMATION LIST");
        heading.setBounds(350, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table = new JTable();
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from information");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1100,600);
        add(jsp);
        
        /*JLabel donar1 = new JLabel("Patient ID");
        donar1.setBounds(20, 60, 150, 30);
        donar1.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(donar1);

        tfpatient = new JTextField();
        tfpatient.setBounds(110, 60, 120, 30);
        add(tfpatient);*/
        
        print = new JButton("Print");
        print.setBounds(800, 60, 100, 30);
        //print.setBackground(Color.LIGHT_GRAY);
        print.setForeground(Color.black);
        print.addActionListener(this);
        print.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(930, 60, 100, 30);
        //cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(cancel);
        
        /*search = new JButton("Search");
        search.setBounds(250, 60, 100, 30);
        //search.setBackground(Color.LIGHT_GRAY);
        search.setForeground(Color.black);
        search.addActionListener(this);
        search.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(search);*/

          
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/list.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 1100, 600);
        add(image);
        
         setSize(1100,600);
         setLocation(150,100); 
         setVisible(true);
    }

    PatientInfoList(String patient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == print) {
                
                 try{
                     table.print();
                     
                 } catch(Exception e) {
                     e.printStackTrace();
                   
                 }
            } else {
                setVisible(false);
            }
            
        }

    
    public static void main(String[] args){
        new PatientInfoList();
    }
}
