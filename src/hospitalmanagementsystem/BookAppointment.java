package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookAppointment extends JFrame implements ActionListener {
    Choice ch,drn;
    JTextField nd,tp,tph,id,no,user;
    String username;
    JButton bak,bap;
    
    BookAppointment(String username)
    {
        this.username= username;
        setBounds(230,100,900,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/appointment1.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);
        
        JLabel text = new JLabel("BOOK APPOINTMENT");
        text.setBounds(100, 10, 250, 30);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        image.add(text);
        
        JLabel luser = new JLabel("Name");
        luser.setBounds(50, 70, 150, 25);
        luser.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(luser);
        
        user = new JTextField();
        user.setBounds(220, 70, 200, 25);
        user.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(user);
        
        JLabel sp= new JLabel("Gender");
        sp.setBounds(50, 120, 150, 25);
        sp.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(sp);
        
        ch=new Choice();
        ch.add("Male");
        ch.add("Female");               
        ch.setBounds(220, 120, 200, 40);
        image.add(ch);
        
        try 
        {
            Conn cn= new Conn();
            ResultSet rs =cn.s.executeQuery("select * from appointment");
            while(rs.next())
            {
                ch.add(rs.getString("name"));
            }
        }catch(Exception e){}
        
        JLabel ltp= new JLabel("Age");
        ltp.setBounds(50, 170, 150, 25);
        ltp.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(ltp);
        
        tp = new JTextField();
        tp.setBounds(220, 170, 200, 25);
        image.add(tp);
        
        JLabel lnd= new JLabel("Email");
        lnd.setBounds(50, 220, 150, 25);
        lnd.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lnd);
        
        nd = new JTextField();
        nd.setBounds(220, 220, 200, 25);
        image.add(nd);
               
        JLabel lid= new JLabel("Adress");
        lid.setBounds(50, 260, 150, 25);
        lid.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lid);
        
        id= new JTextField();
        id.setBounds(220, 260, 200, 25);
        id.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(id);
        
        JLabel lno= new JLabel("Appointment Date");
        lno.setBounds(50, 300, 150, 25);
        lno.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(lno);
        
        no= new JTextField();
        no.setBounds(220, 300, 200, 25);
        no.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(no);
        
        JLabel p = new JLabel("Phone No.");
        p.setBounds(50, 350, 150, 25);
        p.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(p);
        
        tph = new JTextField();  
        tph.setBounds(220, 350, 200, 25);
        tph.setFont(new Font("Tahoma",Font.PLAIN, 13));
        image.add(tph);
        
        JLabel dr= new JLabel("Doctor Name");
        dr.setBounds(50, 390, 150, 25);
        dr.setFont(new Font("Tahoma",Font.BOLD, 16));
        image.add(dr);
        
        drn=new Choice();
        drn.add("Dr.Waseem");
        drn.add("Dr.Seema Singh");
        drn.add("Dr.Rajesh Gaikwad");
        drn.add("Dr.Govind Rajpal");
        drn.add("Dr.Roshan Sodhi");
        drn.add("Dr.Nita Kumari");
        drn.add("Dr.Ishwar Dey");
        drn.add("Dr.Atmaram Bhide"); 
        drn.setBounds(220, 390, 200, 40);
        image.add(drn);
        
         try
        {
            Conn co = new Conn();
            ResultSet rs=co.s.executeQuery("select*from appointment where name='"+username+"'");
            /*         while(rs.next())
            */         
                }
        catch (Exception E){}
        
        bak = new JButton("Back");
        bak.setBounds(220, 490, 100, 25);
        bak.setBackground(Color.black);
        bak.setForeground(Color.white);
        bak.addActionListener(this);
        image.add(bak);
        
        bap = new JButton("Book Appointment");
        bap.setBounds(360, 490, 150, 25);
        bap.setBackground(Color.black);
        bap.setForeground(Color.white);
        bap.addActionListener(this);
        image.add(bap);

        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==bap)  
        { 
       
    
        
        {try{Conn c2 = new Conn();
            ResultSet rs=c2.s.executeQuery("select*from bookappointment where username='"+user.getText()+"'");
            while(rs.next())
            {                              
                int persons = Integer.parseInt(tp.getText());
                int days = Integer.parseInt(nd.getText());
                
                
            }
           }catch(Exception x){}}
        
        {
         try
         {Conn c= new Conn();
            c.s.executeUpdate("insert into bookappointment values('"+user.getText()+"','"+ch.getSelectedItem()+"','"+tp.getText()+"','"+nd.getText()+"','"+id.getText()+"','"+no.getText()+"','"+tph.getText()+"','"+drn.getSelectedItem()+"')");
            
            JOptionPane.showMessageDialog(null,"Appointment Booked Successfully");
         }catch(Exception e){}
        }
         if(ae.getSource()==bap)
        {
            setVisible(false);
        } 
         
        
    }
    else {
                  new Dashboard(""); 

      }    }
    public static void main(String args[])
    {
        new BookAppointment("");
    }
   
    
}
