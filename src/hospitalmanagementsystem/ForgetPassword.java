package hospitalmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import java.awt.event.*;
public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfuser,tfname,tfpass,tfans,tfpas;
    JButton search,retrieve,bak;
    ForgetPassword()
    { setBounds(350, 100, 850, 500);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
        /*JPanel p1 = new JPanel();
       // p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);*/
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fortgot1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 500);
        add(image);
        
        JLabel user = new JLabel("Username");
        user.setBounds(50, 50, 100, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 18));
        image.add(user);
        
        tfuser= new JTextField();
        tfuser.setBounds(210, 50, 180, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfuser);
        
        search = new JButton("Search");
        search.setBounds(400, 50, 100, 25);
        search.addActionListener(this);
        search.setForeground(Color.blue);
        search.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 130, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 18));
        image.add(name);
        
        tfname= new JTextField();
        tfname.setBounds(210, 100, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfname);
        
        JLabel pass = new JLabel("Question");
        pass.setBounds(50, 150, 150, 25);
        pass.setFont(new Font("Tahoma",Font.BOLD, 18));
        image.add(pass);
        
        tfpass= new JTextField();
        tfpass.setBounds(210, 150, 180, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpass);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(50, 210, 150, 25);
        ans.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(ans);
      
        tfans= new JTextField();
        tfans.setBounds(210, 210, 180, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfans);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(400, 210, 100, 25);
        retrieve.addActionListener(this);
        retrieve.setForeground(Color.blue);
        retrieve.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(retrieve);
        
        JLabel pas= new JLabel("Password");
        pas.setBounds(50, 260, 150, 25);
        pas.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(pas);
      
        tfpas= new JTextField();
        tfpas.setBounds(210, 260, 180, 25);
        tfpas.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpas);
        
        bak = new JButton("Back");
        bak.setBounds(160, 320, 100, 25);
        bak.setForeground(Color.blue);
        bak.addActionListener(this);
        bak.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(bak);
        
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac)
    
    { if(ac.getSource() ==search)
     {  try{
         String query= "select * from account where username = '"+tfuser.getText()+"'";
         Conn c = new Conn();
         
         ResultSet rs= c.s.executeQuery(query);
         while(rs.next())
            {
                tfname.setText(rs.getString("name"));
                tfpass.setText(rs.getString("security"));
             }
          }
       catch(Exception e){}
     }
    else if(ac.getSource() == retrieve)
     {
         try{
         String query= "select * from account where answer = '"+tfans.getText()+"'AND username = '"+tfuser.getText()+"'";
         Conn c = new Conn();
         
         ResultSet rs= c.s.executeQuery(query);
         while(rs.next())
            {
                tfpas.setText(rs.getString("password"));
                
             }
          }
       catch(Exception e){}
     }
      else 
      {
         setVisible(false);
         new Login();
     }
    }
    
    
public static void main(String args[])
    {
        new ForgetPassword();
    }
}

