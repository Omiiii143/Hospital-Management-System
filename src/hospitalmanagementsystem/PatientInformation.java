package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PatientInformation extends JFrame implements ActionListener {
    Choice cp,gg,mar,wd;
    JTextField tp,tph,id,no,user,pr,name,aname,tup;
    String username;
    JButton check,bak,bpack;
    
    PatientInformation(String patient)
    {
        this.username= patient;
        setBounds(230,100,900,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/registration1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("PATIENT IMFORMATION");
        text.setBounds(300, 10, 300, 30);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        JLabel luser = new JLabel("Patient ID");
        luser.setBounds(70, 70, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(luser);
        
        user = new JTextField();
        user.setBounds(240, 70, 150, 25);
        user.setFont(new Font("Tahoma",Font.BOLD, 14));
        image.add(user);
        
        JLabel sp= new JLabel("Select Disease");
        sp.setBounds(70, 120, 150, 25);
        sp.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(sp);
        
        cp=new Choice();
        cp.add("SKIN PROBLEM");
        cp.add("BODY HEALTH CHECK");
        cp.add("DIALYSIS DEPARTMENT");
        cp.add("PATHOLOGY DEPARTMENT");
        cp.add("ECG DEPARTMENT");
        cp.add("BLOOD BANK");
        cp.add("GYNAECOLOGY");
        cp.add("DENTAL HEALTH");
        cp.add("OPERATIO THEATRE");
        cp.add("PHARMACY");
        cp.setBounds(240, 120, 150, 40);
        image.add(cp);
        
        
        JLabel ltp= new JLabel("Room Number");
        ltp.setBounds(70, 170, 150, 25);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(ltp);
        
        tp = new JTextField();
        tp.setBounds(240, 170, 150, 25);
        image.add(tp);
        
        JLabel lid= new JLabel("Bed Number");
        lid.setBounds(70, 220, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lid);
        
        id= new JTextField();
        id.setBounds(240, 220, 150, 25);
        id.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(id);
        
        JLabel lno= new JLabel("Age");
        lno.setBounds(70, 270, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lno);
        
        no= new JTextField();
        no.setBounds(240, 270, 150, 25);
        no.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(300, 370, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(p);
        
        tph = new JTextField();  
        tph.setBounds(440, 370, 150, 25);
        tph.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(tph);
                   
        JLabel lpr= new JLabel("Registration Date");
        lpr.setBounds(70, 320, 150, 25);
        lpr.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lpr);
        
        pr= new JTextField();
        pr.setBounds(240, 320, 150, 25);
        pr.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(pr);
        
        JLabel lfname = new JLabel("Full Name");
        lfname.setBounds(480, 70, 150, 25);
        lfname.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lfname);
        
        name = new JTextField();
        name.setBounds(640, 70, 150, 25);
        name.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(name);
        
        JLabel tu= new JLabel("Assigned Doctor");
        tu.setBounds(480, 120, 150, 25);
        tu.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(tu);
        
        tup=new JTextField();
        tup.setBounds(640, 120, 150, 25);
        tup.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(tup);
        
        JLabel lb = new JLabel("Blood Group");
        lb.setBounds(480, 220, 150, 25);
        lb.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lb);
        
        aname = new JTextField();
        aname.setBounds(640, 220, 150, 25);
        aname.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(aname);
        
        JLabel llname = new JLabel("Ward");
        llname.setBounds(480, 170, 150, 25);
        llname.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(llname);
        
        wd=new Choice();
        wd.add("GENERAL");
        wd.add("EMERGENCY");
        wd.setBounds(640, 170, 150, 40);
        image.add(wd);
        
        JLabel g= new JLabel("Gender");
        g.setBounds(480, 270, 150, 25);
        g.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(g);
        
        gg=new Choice();
        gg.add("MALE");
        gg.add("FEMALE");
        gg.setBounds(640, 270, 150, 40);
        image.add(gg);
        
        JLabel ms= new JLabel("Condition");
        ms.setBounds(480, 320, 150, 25);
        ms.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(ms);
        
        mar=new Choice();
        mar.add("NORMAL");
        mar.add("CRITICAL");
        mar.setBounds(640, 320, 150, 20);
        image.add(mar);
        
      
                       
        bak = new JButton("Back");
        bak.setBounds(220, 450, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        image.add(bak);
        
        bpack = new JButton("Add");
        bpack.setBounds(360, 450, 150, 25);
        bpack.setBackground(Color.black);
        bpack.setForeground(Color.white);
        bpack.addActionListener(this);
        image.add(bpack);

       
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bpack)
        {
            
        
         String patient = user.getText();
          String disease = cp.getSelectedItem();
          String room = tp.getText();
          String bed = id.getText();
          String age = no.getText();
          String phone = tph.getText();
          String registration = pr.getText();
          String fullname = name.getText();
          String assigneddoctor = tup.getText();
          String bloodg = aname.getText();
          String ward = wd.getSelectedItem();
          String gender = gg.getSelectedItem();
          String condition = mar.getSelectedItem();
             if(name.getText().trim().isEmpty()&&aname.getText().trim().isEmpty()&&name.getText().trim().isEmpty()&&user.getText().trim().isEmpty()&&tp.getText().trim().isEmpty()&&id.getText().trim().isEmpty()&&no.getText().trim().isEmpty()&&tph.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"please fill your details");
        }
             else{
                 
                 if (isValidName(age)) 
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid age");
            
            }
           else if(isNumeric(fullname))
            {
                JOptionPane.showMessageDialog(null, "please enter valid name");

            }
           else{
             try{
          Conn co = new Conn();
                String query = "insert into information values('"+patient+"','"+disease+"','"+room+"','"+bed+"','"+age+"','"+phone+"','"+registration+"','"+fullname+"','"+assigneddoctor+"','"+bloodg+"','"+ward+"','"+gender+"','"+condition+"')";
            
                co.s.executeUpdate(query);
             
            
            JOptionPane.showMessageDialog(null,"Patient Imformation Stored Successfully");
           }catch(Exception e){}}}
        }
        else
        {
            setVisible(false);
        }
    }
    
      private boolean isNumeric(String str)
     {
      return str.matches("\\d");
     }
    private boolean isValidName(String name) 
    {
     
      return name.matches("^[0-9]{12}$");
    }
    public static void main(String args[])
    {
        new PatientInformation("");
        
    }
   
    
}


