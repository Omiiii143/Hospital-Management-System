package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;



public class DischargeList extends JFrame implements ActionListener
{
    
    JTable table;
    JButton print,cancel;
    
 
     DischargeList()
    {
        JLabel heading = new JLabel("DISCHARGE");
        heading.setBounds(450, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        add(heading);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        table = new JTable();
        
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from discharge");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1100,600);
        add(jsp);
        
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

    DischargeList(String username) {
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
        new DischargeList();
    }
}