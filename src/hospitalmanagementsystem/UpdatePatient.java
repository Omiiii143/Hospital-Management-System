package hospitalmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdatePatient extends JFrame implements ActionListener {

    JLabel lname;
    JButton cancel, update, search;
    JTextField tc, idno, tad, te, tp, ge, id2, uid;

    UpdatePatient(String patient) {
        setSize(900, 600);
        setLocation(230, 100);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Update 1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 600);
        add(image);

        JLabel text = new JLabel("UPDATE PATIENT DETAILS");
        text.setBounds(100, 20, 300, 25);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        image.add(text);

        JLabel luser = new JLabel("Patient ID");
        luser.setBounds(50, 60, 150, 25);
        luser.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(luser);

        uid = new JTextField();
        uid.setBounds(240, 60, 200, 25);
        uid.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(uid);

        JLabel id = new JLabel("Card");
        id.setBounds(50, 100, 150, 25);
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(id);

        id2 = new JTextField();
        id2.setBounds(240, 100, 200, 25);
        image.add(id2);

        JLabel idn = new JLabel("ID Number");
        idn.setBounds(50, 140, 150, 25);
        idn.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(idn);

        idno = new JTextField();
        idno.setBounds(240, 140, 200, 25);
        image.add(idno);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 180, 150, 25);
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(name);

        lname = new JLabel();
        lname.setBounds(240, 180, 200, 25);
        lname.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lname);

        JLabel g = new JLabel("Gender");
        g.setBounds(50, 220, 150, 25);
        g.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(g);

        ge = new JTextField();
        ge.setBounds(240, 220, 200, 25);
        image.add(ge);

        JLabel c = new JLabel("Country");
        c.setBounds(50, 260, 150, 25);
        c.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(c);

        tc = new JTextField();
        tc.setBounds(240, 260, 200, 25);
        image.add(tc);

        JLabel ad = new JLabel("Address");
        ad.setBounds(50, 300, 150, 25);
        ad.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(ad);

        tad = new JTextField();
        tad.setBounds(240, 300, 200, 25);
        image.add(tad);

        JLabel e = new JLabel("Email ID");
        e.setBounds(50, 340, 150, 25);
        e.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(e);

        te = new JTextField();
        te.setBounds(240, 340, 200, 25);
        image.add(te);

        JLabel p = new JLabel("Phone No.");
        p.setBounds(50, 380, 150, 25);
        p.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(p);

        tp = new JTextField();
        tp.setBounds(240, 380, 200, 25);
        image.add(tp);

        update = new JButton("Update");
        update.setBounds(400, 480, 100, 30);
        //update.setBackground(Color.LIGHT_GRAY);
        update.setForeground(Color.black);
        update.addActionListener(this);
        update.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(550, 480, 100, 30);
        //cancel.setBackground(Color.LIGHT_GRAY);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(cancel);

        search = new JButton("Search");
        search.setBounds(500, 60, 100, 30);
        //search.setBackground(Color.LIGHT_GRAY);
        search.setForeground(Color.black);
        search.addActionListener(this);
        search.setFont(new Font("Monospaced", Font.BOLD, 15));
        add(search);


        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource() == search){
           
           try {
                String query = "select * from patient where patient= '"+uid.getText()+"'";
                Conn c = new Conn();
                
                 ResultSet rs = c.s.executeQuery(query);
                 while(rs.next()){
                uid.setText(rs.getString("patient"));
                lname.setText(rs.getString("name"));
                id2.setText(rs.getString("card"));
                idno.setText(rs.getString("number"));
                ge.setText(rs.getString("gender"));
                te.setText(rs.getString("email"));
                tp.setText(rs.getString("phone"));
                tad.setText(rs.getString("address"));
                tc.setText(rs.getString("country"));
                 }
            } catch(Exception e){
                e.printStackTrace();
            }
       
        
        } else if (ae.getSource() == update) {
            { 
            String patient = uid.getText();
            String card = id2.getText();
            String number = idno.getText();
            String name = lname.getText();
            String gender = ge.getText();
            String country = tc.getText();
            String address = tad.getText();
            String phone = tp.getText();
            String email = te.getText();

           
              
                 
                try {
               Conn co = new Conn();
                String query = "update patient set card = '" + card + "', number ='" + number + "', name = '" + name + "', gender = '" + gender + "', country ='" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' where patient = '" + patient +"'";
                co.s.executeUpdate(query);
               
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
        new UpdatePatient("013");

}
}

