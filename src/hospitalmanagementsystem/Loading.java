package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run()
    {try {
        for(int i =1;i<=101; i++)
          {
              int max = bar.getMaximum();
              int value = bar.getValue();
              
              if (value < max)
              {bar.setValue(bar.getValue()+ 1);
              }else
              { setVisible(false);
                new Dashboard(username);
              }
              Thread.sleep(50);
          }
       }
    catch(Exception e) {}
    }
    Loading(String username)
    {  t= new Thread(this);
    this.username =username;
    
        setBounds(230,50, 1000, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Hospital Management System");
        text.setBounds(200, 40, 600, 40);
        text.setFont(new Font("Times New Roman",Font.BOLD, 45));
        text.setForeground(Color.WHITE);
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(300, 250, 400, 35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, Please wait");
        loading.setBounds(300, 290, 150, 30);
        loading.setFont(new Font("Raleway",Font.BOLD, 14));
        loading.setForeground(Color.red);
        add(loading);
        
        JLabel user = new JLabel("Welcome"+" "+username);
        user.setBounds(20, 310, 400, 40);
        user.setFont(new Font("Raleway",Font.BOLD, 16));
        user.setForeground(Color.red);
        add(user);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Load.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 1000, 800);
        add(image);
        t.start();
        setVisible(true);
    }
    public static void main(String arge[])
    {
        new Loading("");
    }
}
