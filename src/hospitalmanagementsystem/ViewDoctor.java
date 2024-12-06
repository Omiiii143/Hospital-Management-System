package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewDoctor extends JFrame implements ActionListener{
    JButton back;
    ViewDoctor(String username)
    {
        setBounds(230, 100, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(30, 50, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(luser);
        
        JLabel user = new JLabel();
        user.setBounds(220, 50, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(user);
        
        JLabel lid= new JLabel("Specializarion");
        lid.setBounds(30, 110, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lid);
        
        JLabel id= new JLabel();
        id.setBounds(220, 110, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(id);
        
        JLabel lno= new JLabel("Number");
        lno.setBounds(30, 170, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lno);
        
        JLabel no= new JLabel();
        no.setBounds(220, 170, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(no);
        
        JLabel lname= new JLabel("Name");
        lname.setBounds(30, 230, 150, 25);
        lname.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lname);
        
        JLabel name= new JLabel();
        name.setBounds(220, 230, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(name);
        
        JLabel lgender= new JLabel("Gender");
        lgender.setBounds(30, 290, 150, 25);
        lgender.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lgender);
        
        JLabel gender= new JLabel();
        gender.setBounds(220, 290, 150, 25);
        gender.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(gender);
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setBounds(500, 50, 150, 25);
        lcountry.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lcountry);
        
        JLabel country = new JLabel();
        country.setBounds(690, 50, 150, 25);
        country.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(country);
        
        
        JLabel lphone= new JLabel("Phone");
        lphone.setBounds(500, 110, 150, 25);
        lphone.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lphone);
        
        JLabel phone= new JLabel();
        phone.setBounds(690, 110, 150, 25);
        phone.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(phone);
        
        JLabel lemail= new JLabel("Email");
        lemail.setBounds(500, 170, 150, 25);
        lemail.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(lemail);
             
        JLabel email= new JLabel();
        email.setBounds(690, 170, 150, 25);
        email.setFont(new Font("Tahoma",Font.BOLD, 14));
        add(email);
        
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpetient.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(120, 400, 600, 200);
        add(image);
        
        try 
        {
            Conn c=new Conn();
            String query =("select* from doctor");
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                user.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                no.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                gender.setText(rs.getString("gender"));
                country.setText(rs.getString("country"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
                
            }
        }
        catch(Exception e){}
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    { 
        if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new ViewDoctor("");
    }
}

