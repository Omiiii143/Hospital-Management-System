package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class PatientInfo extends JFrame implements ActionListener {

    JLabel tfname, tfdname, tfrno, tfage, tfdoct, tfbgroup, tfgen, tfrdate, tfwar, tfbno, tfcon, tfphone;
    JButton cancel, update, search;
    JTextField tfpatient;

    PatientInfo(String patient) {
        setSize(900, 600);
        setLocation(230, 100);
        setLayout(null);

        JLabel heading = new JLabel("VIEW PATIENT INFORMATION");
        heading.setBounds(200, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel donar1 = new JLabel("Patient ID");
        donar1.setBounds(200, 80, 150, 30);
        donar1.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(donar1);

        tfpatient = new JTextField();
        tfpatient.setBounds(330, 80, 150, 30);
        add(tfpatient);

        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(name);

        tfname = new JLabel();
        tfname.setBounds(200, 150, 180, 30);
        add(tfname);

        JLabel dname = new JLabel("Select Disease");
        dname.setBounds(50, 200, 150, 30);
        dname.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(dname);

        tfdname = new JLabel();
        tfdname.setBounds(200, 200, 180, 30);
        add(tfdname);

        JLabel rno = new JLabel("Room Number");
        rno.setBounds(50, 250, 150, 30);
        rno.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(rno);

        tfrno = new JLabel();
        tfrno.setBounds(200, 250, 180, 30);
        add(tfrno);

        JLabel bno = new JLabel("Bed Number");
        bno.setBounds(50, 300, 200, 30);
        bno.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(bno);

        tfbno = new JLabel();
        tfbno.setBounds(200, 300, 180, 30);
        add(tfbno);

        JLabel age = new JLabel("Age");
        age.setBounds(50, 350, 150, 30);
        age.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(age);

        tfage = new JLabel();
        tfage.setBounds(200, 350, 180, 30);
        add(tfage);

        JLabel rdate = new JLabel("Registration Date");
        rdate.setBounds(50, 400, 150, 30);
        rdate.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(rdate);

        tfrdate = new JLabel();
        tfrdate.setBounds(200, 400, 180, 30);
        add(tfrdate);

        JLabel doct = new JLabel("Assigned Doctor");
        doct.setBounds(450, 150, 200, 30);
        doct.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(doct);

        tfdoct = new JLabel();
        tfdoct.setBounds(630, 150, 180, 30);
        add(tfdoct);

        JLabel war = new JLabel("Ward");
        war.setBounds(450, 200, 200, 30);
        war.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(war);

        tfwar = new JLabel();
        tfwar.setBounds(630, 200, 180, 30);
        add(tfwar);

        JLabel bgroup = new JLabel("Blood Group");
        bgroup.setBounds(450, 250, 200, 30);
        bgroup.setFont(new Font("TimesRoman ", Font.BOLD, 20));
        add(bgroup);

        tfbgroup = new JLabel();
        tfbgroup.setBounds(630, 250, 180, 30);
        add(tfbgroup);

        JLabel gen = new JLabel("Gender");
        gen.setBounds(450, 300, 200, 30);
        gen.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(gen);
        
        tfgen = new JLabel();
        tfgen.setBounds(630, 300, 180, 30);
        add(tfgen);
        
        JLabel con = new JLabel("Condition");
        con.setBounds(450, 350, 200, 30);
        con.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(con);
        
        tfcon = new JLabel();
        tfcon.setBounds(630, 350, 180, 30);
        add(tfcon);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(450, 400, 200, 30);
        phone.setFont(new Font("TimesRoman", Font.BOLD, 20));
        add(phone);
        
        tfphone = new JLabel();
        tfphone.setBounds(630, 400, 180, 30);
        add(tfphone);

        /*update = new JButton("Update");
        update.setBounds(400, 480, 100, 30);
        //update.setBackground(Color.LIGHT_GRAY);
        update.setForeground(Color.black);
        update.addActionListener(this);
        update.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(update);*/

        cancel = new JButton("Cancel");
        cancel.setBounds(600, 480, 100, 30);
        //cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(cancel);

        search = new JButton("Search");
        search.setBounds(550, 80, 100, 30);
        //search.setBackground(Color.LIGHT_GRAY);
        search.setForeground(Color.black);
        search.addActionListener(this);
        search.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(search);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/registration1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource() == search){
           
           try {
                String query = "select * from information where patient= '"+tfpatient.getText()+"'";
                Conn c = new Conn();
                
                 ResultSet rs = c.s.executeQuery(query);
                 while(rs.next()){
                       tfname.setText(rs.getString("fullname"));
                        tfdname.setText(rs.getString("disease"));
                        tfrno.setText(rs.getString("room"));
                        tfbno.setText(rs.getString("bed"));
                        tfage.setText(rs.getString("age"));
                        tfrdate.setText(rs.getString("registration"));
                        tfdoct.setText(rs.getString("assigneddoctor"));
                        tfphone.setText(rs.getString("phone"));
                        tfwar.setText(rs.getString("ward"));
                        tfbgroup.setText(rs.getString("bloodgroup"));
                        tfgen.setText(rs.getString("gender"));
                        tfcon.setText(rs.getString("pcondition"));
                        tfpatient.setText(rs.getString("patient"));
                    
                 }
            } catch(Exception e){
                e.printStackTrace();
            }
       
        
        } else if (ae.getSource() == update) {
            { 
            String patient= tfpatient.getText();    
            String fullname = tfname.getText();
            String disease = tfdname.getText();
            String room = tfrno.getText();
            String phone = tfphone.getText();
            String gen = tfgen.getText();
            String con = tfcon.getText();
            String bloodg = tfbgroup.getText();
            String war = tfwar.getText();
            String doct = tfdoct.getText();
            String registration = tfrdate.getText();
            String age = tfage.getText();
             String bed = tfbno.getText();
           
              
                 
                try {
               String query = "update information set fullname = '" + fullname + "',room = '" + room + "',bed ='" + bed + "', dname ='" + disease + "', phone = '" + phone + "', gen = '" + gen + "', con ='" + con + "', doct = '" + doct + "', war = '" + war + "',bgroup ='" + bloodg + "',rdate ='" + registration + "',age ='" + age + "' where patient ='"+patient+"'";
               Conn c = new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, " Patient Information Updated Successfully");
               
               setVisible(false);
           }catch  (Exception e) {
               e.printStackTrace();
           }

            }
        } else {
            setVisible(false);

        }
    }

    public static void main(String args[]) {
        new PatientInfo("013");

}
}
