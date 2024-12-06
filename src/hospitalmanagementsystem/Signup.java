package hospitalmanagementsystem;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
   JButton create,back;
   JTextField tfans,tfpass,tfuser,tfname;
   Choice secu;
    Signup()
    {
       
        setBounds(350, 100, 900, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        /*JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);*/
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Signup1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 500);
       add(image);
       
        JLabel user = new JLabel("Username");
        user.setBounds(50, 30, 125, 25);
        user.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(user);
        
        tfuser= new JTextField();
        tfuser.setBounds(190, 30, 180, 25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfuser);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50, 80, 125, 25);
        name.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(190, 80, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfname);
        
        JLabel pass= new JLabel("Password");
        pass.setBounds(50, 130, 125, 25);
        pass.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(pass);
        
        tfpass= new JTextField();
        tfpass.setBounds(190, 130, 180, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpass);
        
        JLabel sec = new JLabel("Question");
        sec.setBounds(50, 180, 125, 25);
        sec.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(sec);
        
        
        secu= new Choice();
        secu.setBounds(190, 180, 180, 25);
        secu.add("Your Bestfriend");
        secu.add("Lucky Number");
        secu.add("Favorite Dish");
        image.add(secu);
        
        JLabel ans = new JLabel("Answer");
        ans.setBounds(50, 230, 125, 25);
        ans.setFont(new Font("Tahona",Font.BOLD, 18));
        image.add(ans);
      
        tfans= new JTextField();
        tfans.setBounds(190, 230, 180, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfans);
        
        create = new JButton("Create");
        create.setBounds(220, 280, 125, 25);
        create.addActionListener(this);
        create.setForeground(Color.blue);
        create.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(create);
        
        back = new JButton("Back");
        back.setBounds(220, 320, 125, 25);
        back.setForeground(Color.blue);
        back.addActionListener(this);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(back);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ac)
    { if(ac.getSource() == create)
     {  String username = tfuser.getText();
        String name = tfname.getText();
        String Password = tfpass.getText();
        String question = secu.getSelectedItem();
        String Answer= tfans.getText();
        
        String query ="insert into account values('"+username+"','"+name+"','"+Password+"','"+question+"','"+Answer+"')";
        try{ 
            Conn c =new Conn();
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Account Created Successfully");
             setVisible(false);
              new Login();
        }
        catch(Exception e){}
     }
    else if(ac.getSource() == back)
     {
         setVisible(false);
         new Login();
     }
    }
    public static void main(String args[])
    {
          new Signup();
    }
}
