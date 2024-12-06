package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class DeleteDetails extends JFrame implements ActionListener{
    JButton back;
    String labeluid;
    DeleteDetails(String patient)
    { this.labeluid = labeluid;
        setBounds(230, 100, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("DELETE PATIENTS DETAILS");
        text.setBounds(300, 20, 300, 25);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        
        JLabel luser = new JLabel("Patient ID");
        luser.setBounds(40, 80, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(luser);
        
        JLabel labeluid = new JLabel();
        labeluid.setBounds(230, 80, 150, 25);
        labeluid.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(labeluid);
        
        JLabel lid= new JLabel("ID");
        lid.setBounds(40, 130, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lid);
        
        JLabel id= new JLabel();
        id.setBounds(230, 130, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(id);
        
        JLabel lno= new JLabel("Number");
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
        
        JLabel laddress= new JLabel("Address");
        laddress.setBounds(500, 130, 150, 25);
        laddress.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(laddress);
        
        JLabel address= new JLabel();
        address.setBounds(650, 130, 150, 25);
        address.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(address);
        
        JLabel lphone= new JLabel("Phone");
        lphone.setBounds(500, 190, 150, 25);
        lphone.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lphone);
        
        JLabel phone= new JLabel();
        phone.setBounds(650, 190, 150, 25);
        phone.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(phone);
        
        JLabel lemail= new JLabel("Email");
        lemail.setBounds(500, 250, 150, 25);
        lemail.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lemail);
             
        JLabel email= new JLabel();
        email.setBounds(650, 250, 150, 25);
        email.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(email);
        
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 400, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        
        try 
        {
            Conn c=new Conn();
            String query =("select* from patient where patient");
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                labeluid.setText(rs.getString("patient"));
                id.setText(rs.getString("card"));
                no.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                gender.setText(rs.getString("gender"));
                country.setText(rs.getString("country"));
                address.setText(rs.getString("address"));
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
            c.s.executeUpdate ("delete from patient where patient");
            //c.s.executeUpdate("delete from viewpatient where patientID='"+labeluid+"'");
            //c.s.executeUpdate("delete from patientlist where patientID='"+labeluid+"'");
            //c.s.executeUpdate("delete from bookappointment where username='"+username+"'");
           
            
            JOptionPane.showMessageDialog(null,"Data Deleted Sucessfuly");
            
                   
        }
        catch(Exception e){}
    }
    public static void main(String args[])
    {
        new DeleteDetails("");
    }
}

