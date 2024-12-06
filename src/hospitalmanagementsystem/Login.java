package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfuser;
    JPasswordField tfpass;

    Login() {
        setSize(900, 500);
        setLocation(230, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        /*JLabel log = new JLabel("Login in");
        log.setBounds(400, 22, 100, 30);
        log.setFont(new Font("TIMES NEW ROMAN",Font.BOLD, 26));
        add(log);*/
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        JLabel user = new JLabel("Username");
        user.setBounds(500, 60, 100, 25);
        user.setFont(new Font("SAN SERIF", Font.PLAIN, 22));
        image.add(user);

        tfuser = new JTextField();
        tfuser.setBounds(500, 100, 300, 30);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfuser);

        JLabel pass = new JLabel("Password");

        pass.setBounds(500, 160, 100, 25);
        pass.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        image.add(pass);

        tfpass = new JPasswordField();
        tfpass.setBounds(500, 200, 300, 30);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        image.add(tfpass);

        login = new JButton("Login");
        login.setBounds(500, 260, 130, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(login);

        /*signup = new JButton("Signup");
        signup.setBounds(670, 260, 130, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(signup);*/
 /*password= new JButton("Forget Password");
        password.setBounds(570, 310, 130, 30);
        password.setBackground(Color.BLACK);
        password.setForeground(Color.WHITE);
        password.addActionListener(this);
        password.setBorder(new LineBorder(new Color(133, 193, 233)));
        image.add(password);*/
        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(740, 300, 150, 20);
        text.setForeground(Color.red);
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
        if (ac.getSource() == login) {
            try {
                String username = tfuser.getText();
                String password = tfpass.getText();

                String query = "select * from account where username = '" + username + "'AND password = '" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (Exception e) {
            }
        } else if (ac.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String args[]) {
        new Login();
    }

}
