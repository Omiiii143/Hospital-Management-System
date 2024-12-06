package hospitalmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class AddDoctor extends JFrame implements ActionListener {
   JComboBox cid;
   JTextField tc,idno,tad,te,tp,lname,user;
   JRadioButton GM,GF;
   JButton bak,add;
    AddDoctor(String username)
    {
        setBounds(230, 100, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adddoctor1.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("ADD DOCTOR");
        text.setBounds(100, 20, 300, 25);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        
        JLabel luser = new JLabel("Username");
        luser.setBounds(40, 70, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(luser);
        
        user = new JTextField();  
        user.setBounds(220, 70, 200, 25);
        image.add(user);
        
        JLabel id = new JLabel("Specializarion");
        id.setBounds(40, 110, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(id);
        
        
        cid= new JComboBox(new String[]{"Skin Specialist","Body Health Checkup","Dialysis","Pathology","ECG","Gynaecologist","Dentist","Operation Theatre"});
        cid.setBounds(220, 110, 200, 25);
        cid.setBackground(Color.white);
        image.add(cid);
        
        JLabel idn = new JLabel("Room No.");
        idn.setBounds(40, 150, 150, 25);
        idn.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(idn);
        
        idno = new JTextField();  
        idno.setBounds(220, 150, 200, 25);
        image.add(idno);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40, 190, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(name);
        
        lname = new JTextField();
        lname.setBounds(220, 190, 200, 25);
        lname.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(lname);
        
        JLabel g = new JLabel("Gender");
        g.setBounds(40, 230, 150, 25);
        g.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(g);
        
        GM=new JRadioButton("Male");
        GM.setBounds(220, 230, 70, 25);
        GM.setBackground(Color.white);
        image.add(GM);
        
        GF=new JRadioButton("Female");
        GF.setBounds(300, 230, 70, 25);
        GF.setBackground(Color.white);
        image.add(GF);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(GM);
        bg.add(GF);
        
        JLabel c = new JLabel("Country");
        c.setBounds(40, 270, 150, 25);
        c.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(c);
        
        tc = new JTextField();  
        tc.setBounds(220, 270, 200, 25);
        image.add(tc);
        
        
        JLabel e = new JLabel("Email ID");
        e.setBounds(40, 310, 150, 25);
        e.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(e);
        
        te = new JTextField();  
        te.setBounds(220, 310, 200, 25);
        image.add(te);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(40, 350, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(p);
        
        tp = new JTextField();  
        tp.setBounds(220, 350, 200, 25);
        image.add(tp);
        
        add = new JButton("Add");
        add.setBounds(70, 450, 100, 25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        image.add(add);
        
        bak = new JButton("Back");
        bak.setBounds(220, 450, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        image.add(bak);
        
        
        try
        {
            Conn co = new Conn();
            //ResultSet rs=co.s.executeQuery("select*from doctor where username='"+username+"'");
            //while(rs.next())
            {
            }
        }
        catch (Exception E){}
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        { 
             String username = user.getText();
            String id =(String) cid.getSelectedItem();
            String number = idno.getText();
            String name = lname.getText();
            String gender= null;
            if(GM.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
            String country = tc.getText();
            String phone = tp.getText();
            String email = te.getText();
            
            if(idno.getText().trim().isEmpty()&&tc.getText().trim().isEmpty()&&tad.getText().trim().isEmpty()&&tp.getText().trim().isEmpty()&&te.getText().trim().isEmpty())
        
            {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
            
            else{
           
             if(!isValidEmail(email))
            {
                JOptionPane.showMessageDialog(null, "please enter valid email");

            }
             else if(!isValidPhoneNumber(phone))
            {
                JOptionPane.showMessageDialog(null, "please enter valid phone");

            }
             else if(isValidName(name))
            {
                JOptionPane.showMessageDialog(null, "please enter valid name");

            }
             
              else if(!isNumeric(number))
            {
                JOptionPane.showMessageDialog(null, "please enter valid room no.");

            }
             
             
             
             else{
            
            
            try
            {
                Conn co = new Conn();
                String query = "insert into doctor values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+phone+"','"+email+"')";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Doctor Details Added Succesfully");
                setVisible(false);
            }
            catch(Exception E){}
        }}}
        else
        {
            setVisible(false);
            
                }
    }
    
      private boolean isValidPhoneNumber(String phone) 
    {
     String phoneRegex = "^[0-9]{10}$";
     return phone.matches(phoneRegex);
    }
    
    private boolean isValidEmail(String email) 
    {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+\\.com)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
     private boolean isNumeric(String str)
{
return str.matches("\\d");
}
    private boolean isValidName(String name) 
    {
     
      return name.matches("^[0-9]+$");
    }
    
    public static void main(String args[])
    {
        new AddDoctor("mj");
    }
}


