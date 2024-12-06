package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class DeleteDoctor extends JFrame implements ActionListener{
    JButton del;
    String username;
    DeleteDoctor(String username)
    { this.username = username;
        setBounds(230, 100, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("DELETE DOCTOR DETAILS");
        text.setBounds(300, 20, 300, 25);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(40, 80, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(luser);
        
        JLabel user = new JLabel();
        user.setBounds(230, 80, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(user);
        
        JLabel lid= new JLabel("Specialization");
        lid.setBounds(40, 130, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lid);
        
        JLabel id= new JLabel();
        id.setBounds(230, 130, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(id);
        
        JLabel lno= new JLabel("Room No.");
        lno.setBounds(40, 190, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lno);
        
        JLabel no= new JLabel();
        no.setBounds(230, 190, 150, 25);
        no.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(no);
        
        JLabel lname= new JLabel("Name");
        lname.setBounds(40, 250, 150, 25);
        lname.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lname);
        
        JLabel name= new JLabel();
        name.setBounds(230, 250, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(name);
        
        JLabel lgender= new JLabel("Gender");
        lgender.setBounds(40, 310, 150, 25);
        lgender.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lgender);
        
        JLabel gender= new JLabel();
        gender.setBounds(230, 310, 150, 25);
        gender.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(gender);
        
        JLabel lcountry = new JLabel("Country");
        lcountry.setBounds(500, 80, 150, 25);
        lcountry.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lcountry);
        
        JLabel country = new JLabel();
        country.setBounds(650, 80, 150, 25);
        country.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(country);
        
        JLabel lphone= new JLabel("Phone");
        lphone.setBounds(500, 140, 150, 25);
        lphone.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lphone);
        
        JLabel phone= new JLabel();
        phone.setBounds(650, 140, 150, 25);
        phone.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(phone);
        
        JLabel lemail= new JLabel("Email");
        lemail.setBounds(500, 200, 150, 25);
        lemail.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lemail);
             
        JLabel email= new JLabel();
        email.setBounds(650, 200, 150, 25);
        email.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(email);
        
        del = new JButton("Delete");
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBounds(350, 400, 100, 25);
        del.addActionListener(this);
        image.add(del);
        
        
        try 
        {
            Conn c=new Conn();
            String query ="select* from doctor ";
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
        try 
        {
            Conn c=new Conn();
            c.s.executeUpdate("delete from doctor");
            //c.s.executeUpdate("delete from patient where username='"+username+"'");
            //c.s.executeUpdate("delete from patientregistration where username='"+username+"'");
            //c.s.executeUpdate("delete from bookappointment where username='"+username+"'");
           
            
            JOptionPane.showMessageDialog(null,"Data Deleted Sucessfuly");
            
                   
        }
        catch(Exception e){}
    }
    public static void main(String args[])
    {
        new DeleteDoctor("");
    }
}

