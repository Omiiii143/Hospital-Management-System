package hospitalmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableModel;

public class AddPatient extends JFrame implements ActionListener {

   /* static TableModel resultSetToTableModel(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static TableModel resultSetToAddPatient(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
   JComboBox cid;
   JLabel labeluid;
   JTextField tc,idno,tad,te,tp,lname;
   JRadioButton GM,GF;
   JButton bak,add;
   
    Random ran = new Random();
    long first2 = Math.abs((ran.nextLong() % 90L) + 10L);

    AddPatient(String username)
    {
        setBounds(230, 100, 900, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/addpatient1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("ADD PATIENT");
        text.setBounds(100, 10, 300, 25);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        
        JLabel luser = new JLabel("Patient ID");
        luser.setBounds(40, 60, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(luser);
        
        labeluid = new JLabel("10"+first2);
        labeluid.setBounds(200,60,150,25);
        labeluid.setFont(new Font("serif",Font.BOLD, 20 ));
        image.add(labeluid);

        
        JLabel id = new JLabel("Card");
        id.setBounds(40, 100, 150, 25);
        id.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(id);
        
        
        cid= new JComboBox(new String[]{"Aadhar Card","Pan Card","Ration Card"});
        cid.setBounds(200, 100, 200, 25);
        cid.setBackground(Color.white);
        image.add(cid);
        
        JLabel idn = new JLabel("ID Number");
        idn.setBounds(40, 140, 150, 25);
        idn.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(idn);
        
        idno = new JTextField();  
        idno.setBounds(200, 140, 200, 25);
        image.add(idno);
        
        JLabel name = new JLabel("Full Name");
        name.setBounds(40, 180, 150, 25);
        name.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(name);
        
        lname = new JTextField();
        lname.setBounds(200, 180, 200, 25);       
        image.add(lname);
        
        JLabel g = new JLabel("Gender");
        g.setBounds(40, 220, 150, 25);
        g.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(g);
        
        GM=new JRadioButton("Male");
        GM.setBounds(200, 220, 70, 25);
        GM.setBackground(Color.white);
        image.add(GM);
        
        GF=new JRadioButton("Female");
        GF.setBounds(300, 220, 70, 25);
        GF.setBackground(Color.white);
        image.add(GF);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(GM);
        bg.add(GF);
        
        JLabel c = new JLabel("Country");
        c.setBounds(40, 260, 150, 25);
        c.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(c);
        
        tc = new JTextField();  
        tc.setBounds(200, 260, 200, 25);
        image.add(tc);
        
        JLabel ad = new JLabel("Address");
        ad.setBounds(40, 300, 150, 25);
        ad.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(ad);
        
        tad = new JTextField();  
        tad.setBounds(200, 300, 200, 25);
        image.add(tad);
        
        JLabel e = new JLabel("Email ID");
        e.setBounds(40, 340, 150, 25);
        e.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(e);
        
        te = new JTextField();  
        te.setBounds(200, 340, 200, 25);
        image.add(te);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(40, 380, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 15));
        image.add(p);
        
        tp = new JTextField();  
        tp.setBounds(200, 380, 200, 25);
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
        
        
        
        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        { if(idno.getText().trim().isEmpty()&&tc.getText().trim().isEmpty()&&tad.getText().trim().isEmpty()&&tp.getText().trim().isEmpty()&&te.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
    else if(idno.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter id no.");
          }
     else if(tc.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter country");
          }
      else if(tad.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter address");
          }
       else if(te.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your email");
          }
       else if(tp.getText().trim().isEmpty())
          {
              JOptionPane.showMessageDialog(null,"please enter your phone no.");
          }
       
        else
       {   String card =(String) cid.getSelectedItem();
            String number = idno.getText();
           boolean isValidIdNumber = false;
            
            
            if ("Aadhar Card".equals(card)) {
                isValidIdNumber = isValidAadharCardNumber(number);
            } else if ("Pan Card".equals(card)) {
                isValidIdNumber = isValidPanCardNumber(number);
            } else if ("Ration Card".equals(card)) {
                isValidIdNumber = isValidRationCardNumber(number);
            }
            String patient = labeluid.getText();
            //String id =(String) cid.getSelectedItem();
            //String number = idno.getText();
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
            String address = tad.getText();
            String phone = tp.getText();
            String email = te.getText();
            if(!isValidEmail(email))
            {
                JOptionPane.showMessageDialog(null, "please enter valid email");

            }
            else if(!isValidPhoneNumber(phone))
            {
                JOptionPane.showMessageDialog(null, "please enter valid phone");

            }
           else if (!isValidIdNumber) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid " + card + " number.");
            
            }
           else if(isValidName(name))
            {
                JOptionPane.showMessageDialog(null, "please enter valid name");

            }
             
            
          
           
            else{
            try
            {
                Conn co = new Conn();
                String query = "insert into patient values('"+patient+"','"+card+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                co.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Patient Details Added Succesfully");
                setVisible(false);
            }
            catch(Exception E){}
        }}}
        else
        {
            setVisible(false);
            
                }
    }
    private boolean isValidRationCardNumber(String rationCardNumber) 
    {
    String rationCardRegex = "^[0-9]{12}$";
    return rationCardNumber.matches(rationCardRegex);
    }
    
    private boolean isValidPanCardNumber(String panCardNumber)
    {
    String panCardRegex = "^[A-Z]{5}\\d{4}[A-Z]$";
    return panCardNumber.matches(panCardRegex);
    }
    
    private boolean isValidAadharCardNumber(String aadharCardNumber)
    {
    
    String aadharCardRegex = "^[0-9]{12}$";
    return aadharCardNumber.matches(aadharCardRegex);
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
        new AddPatient("");
    }
}

