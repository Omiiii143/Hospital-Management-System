package hospitalmanagementsystem;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuItem pd,upd,vpd,dpd,cpd,bpd,vh,bh,d,p,c,n,a,vp,vbh,dr,vd,dl,pl,rl,vpi,vpil,pil,di;
    JLabel header;
    JMenu pr,pk,h,o,s;
    String username;
    Dashboard(String username)
    {
        this.username = username;
    
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    
    JMenuBar mb = new JMenuBar();
    mb.setBackground(Color.white);
    mb.setBounds(0, 0, 1600, 30);
    mb.setLayout(null);
    setJMenuBar(mb);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
    Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(5,0, 70, 70);
     mb.add(image);
    
       pr = new JMenu("Patient    ");
       pr.setForeground(Color.black);
       pr.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(pr);
       
    ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/doctor.png"));
    Image i8 = i7.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i9 = new ImageIcon(i8);
    JLabel image2 = new JLabel(i9);
    image2.setBounds(5,0, 70, 70);
    mb.add(image2);
       
       pk = new JMenu("   Doctor     ");
       pk.setForeground(Color.black);
       pk.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(pk);
       
        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/checklist.png"));
    Image i17 = i16.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i18 = new ImageIcon(i17);
    JLabel image6 = new JLabel(i18);
    image6.setBounds(5,0, 70, 70);
    mb.add(image6);
       
       o = new JMenu("   List     ");
       o.setForeground(Color.black);
       o.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(o);
       
    ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/menu.png"));
    Image i11 = i10.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i12 = new ImageIcon(i11);
    JLabel image3 = new JLabel(i12);
    image3.setBounds(5,0, 70, 70);
    mb.add(image3);
       
       h = new JMenu("   Others     ");
       h.setForeground(Color.black);
       h.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(h);
    
       
    ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
    Image i14 = i13.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
    ImageIcon i15 = new ImageIcon(i14);
    JLabel image5 = new JLabel(i15);
    image5.setBounds(5,0, 70, 70);
     mb.add(image5);
     image5.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 new  DeleteDetails("");   
            }});
     
      s = new JMenu("        ");
       s.setForeground(Color.black);
       s.setFont(new Font("Tahona",Font.BOLD, 30));
       mb.add(s);
       
      ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
      Image i20 = i19.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
      ImageIcon i21 = new ImageIcon(i20);
      JLabel image7 = new JLabel(i21);
      image7.setBounds(5,0, 70, 70);
      mb.add(image7);
      image7.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseClicked(MouseEvent e)
            {
                 setVisible(false);                 
            }});
     
        dl = new  JMenuItem ("Doctor List");
        dl.setBounds(0, 40, 300, 50);
        dl.addActionListener(this);
        dl.setForeground(Color.white);
        dl.setBackground(new Color(0, 0, 102));
        dl.setBorder(new LineBorder(new Color(133, 193, 233)));
        dl.setFont(new Font("Tahoma",Font.PLAIN, 20));
        dl.setMargin(new Insets(0, 0, 0, 0));
        o.add(dl);
        
        pl = new  JMenuItem ("Patient  List");
        pl.setBounds(0, 40, 300, 50);
        pl.addActionListener(this);
        pl.setForeground(Color.white);
        pl.setBackground(new Color(0, 0, 102));
        pl.setBorder(new LineBorder(new Color(133, 193, 233)));
        pl.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pl.setMargin(new Insets(0, 0, 0, 0));
        o.add(pl);
        
        rl = new  JMenuItem ("Registration  List");
        rl.setBounds(0, 40, 300, 50);
        rl.addActionListener(this);
        rl.setForeground(Color.white);
        rl.setBackground(new Color(0, 0, 102));
        rl.setBorder(new LineBorder(new Color(133, 193, 233)));
        rl.setFont(new Font("Tahoma",Font.PLAIN, 20));
        rl.setMargin(new Insets(0, 0, 0, 0));
        o.add(rl);
        
        pil = new  JMenuItem ("Patient Info List");
        pil.setBounds(0, 40, 300, 50);
        pil.addActionListener(this);
        pil.setForeground(Color.white);
        pil.setBackground(new Color(0, 0, 102));
        pil.setBorder(new LineBorder(new Color(133, 193, 233)));
        pil.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pil.setMargin(new Insets(0, 0, 0, 0));
        o.add(pil);
        
        pd = new  JMenuItem ("Add Patient Details");
        pd.setBounds(0, 40, 300, 50);
        pd.addActionListener(this);
        pd.setForeground(Color.white);
        pd.setBackground(new Color(0, 0, 102));
        pd.setBorder(new LineBorder(new Color(133, 193, 233)));
        pd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        pd.setMargin(new Insets(0, 0, 0, 0));
        pr.add(pd);
        
        
        upd = new  JMenuItem ("Update Patient Details");
        upd.setBounds(0, 80, 300, 50);
        upd.addActionListener(this);
        upd.setForeground(Color.white);
        upd.setBackground(new Color(0, 0, 102));
        upd.setBorder(new LineBorder(new Color(133, 193, 233)));
        upd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        upd.setMargin(new Insets(0, 0, 0, 0));
        pr.add(upd);
        
        
        vpi = new  JMenuItem ("PatientInfo");
        vpi.setBounds(0, 120, 300, 50);
        vpi.addActionListener(this);
        vpi.setForeground(Color.white);
        vpi.setBackground(new Color(0, 0, 102));
        vpi.setBorder(new LineBorder(new Color(133, 193, 233)));
        vpi.setFont(new Font("Tahoma",Font.PLAIN, 20));
        vpi.setMargin(new Insets(0, 0, 0, 0));
        h.add(vpi);
        
        vpil = new  JMenuItem ("PatientInformation");
        vpil.setBounds(0, 120, 300, 50);
        vpil.addActionListener(this);
        vpil.setForeground(Color.white);
        vpil.setBackground(new Color(0, 0, 102));
        vpil.setBorder(new LineBorder(new Color(133, 193, 233)));
        vpil.setFont(new Font("Tahoma",Font.PLAIN, 20));
        vpil.setMargin(new Insets(0, 0, 0, 0));
        h.add(vpil);
      
   
        
        bpd = new  JMenuItem ("Patient Registration");
        bpd.setBounds(0, 240, 300, 50);
        bpd.addActionListener(this);
        bpd.setForeground(Color.white);
        bpd.setBackground(new Color(0, 0, 102));
        bpd.setBorder(new LineBorder(new Color(133, 193, 233)));
        bpd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        bpd.setMargin(new Insets(0, 0, 0, 0));
        pr.add(bpd);
        
        d = new  JMenuItem ("Discharge");
        d.setBounds(0, 280, 300, 50);
        d.addActionListener(this);
        d.setForeground(Color.white);
        d.setBackground(new Color(0, 0, 102));
        d.setBorder(new LineBorder(new Color(133, 193, 233)));
        d.setFont(new Font("Tahoma",Font.PLAIN, 20));
        d.setMargin(new Insets(0, 0, 0, 0));
        h.add(d);
        
        di = new  JMenuItem ("Discharge List");
        di.setBounds(0, 40, 300, 50);
        di.addActionListener(this);
        di.setForeground(Color.white);
        di.setBackground(new Color(0, 0, 102));
        di.setBorder(new LineBorder(new Color(133, 193, 233)));
        di.setFont(new Font("Tahoma",Font.PLAIN, 20));
        di.setMargin(new Insets(0, 0, 0, 0));
        o.add(di);
        
        bh = new  JMenuItem ("Book Appointment");
        bh.setBounds(0, 0, 300, 50);
        bh.addActionListener(this);
        bh.setForeground(Color.white);
        bh.setBackground(new Color(0, 0, 102));
        bh.setBorder(new LineBorder(new Color(133, 193, 233)));
        bh.setFont(new Font("Tahoma",Font.PLAIN, 20));
        bh.setMargin(new Insets(0, 0, 0, 0));
        pk.add(bh); 
        
        dr = new  JMenuItem ("Add Doctor");
        dr.setBounds(0, 320, 300, 50);
        dr.addActionListener(this);
        dr.setForeground(Color.white);
        dr.setBackground(new Color(0, 0, 102));
        dr.setBorder(new LineBorder(new Color(133, 193, 233)));
        dr.setFont(new Font("Tahoma",Font.PLAIN, 20));
        dr.setMargin(new Insets(0, 0, 0, 0));
        pk.add(dr);
        
        vd = new  JMenuItem ("View Doctor");
        vd.setBounds(0, 360, 300, 50);
        vd.addActionListener(this);
        vd.setForeground(Color.white);
        vd.setBackground(new Color(0, 0, 102));
        vd.setBorder(new LineBorder(new Color(133, 193, 233)));
        vd.setFont(new Font("Tahoma",Font.PLAIN, 20));
        vd.setMargin(new Insets(0, 0, 0, 0));
        pk.add(vd);
     
         vbh= new  JMenuItem ("Delete Doctor");
        vbh.setBounds(0, 400, 300, 50);
        vbh.addActionListener(this);
        vbh.setForeground(Color.white);
        vbh.setBackground(new Color(0, 0, 102));
        vbh.setBorder(new LineBorder(new Color(133, 193, 233)));
        vbh.setFont(new Font("Tahoma",Font.PLAIN, 20));
        vbh.setMargin(new Insets(0, 0, 0, 60));
        pk.add(vbh);  
        
    
        
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Hospital.jpg"));
    Image i5 = i4.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel image4 = new JLabel(i6);
    image4.setBounds(0,0, 1400, 800);
    add(image4);
    
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ac)
    {
        if(ac.getSource()==pd)
        {
            new AddPatient(username);
        }
         else if(ac.getSource()==vpi)
        {
        new PatientInfo(username);
        }
          else if(ac.getSource()==vpil)
        {
        new PatientInformation(username);
        }
        else if(ac.getSource()==upd)
        {
           new UpdatePatient(username);
        }
        
         else if(ac.getSource()==bpd)
        { 
           new PatientRegistration(username);
           }
         else if(ac.getSource()==d)
        { 
           new Discharge(username);
        }
         else if(ac.getSource()==di)
        { 
            new DischargeList();
        }
          else if(ac.getSource()==dl)
        { 
            new DoctorList();
        }
            else if(ac.getSource()==pl)
        { 
              new PatientList();
        }
              else if(ac.getSource()==pil)
        { 
             new PatientInfoList();
        }
            else if(ac.getSource()==rl)
        { 
              new RegistrationList();
        }
          else if(ac.getSource()==dr)
        {
            new AddDoctor(username);
        }
          else if(ac.getSource()==vd)
        {
            new ViewDoctor(username);
        }
         else if(ac.getSource()==bh)
        {
            new  BookAppointment(username);
        }
        else if(ac.getSource()==vbh)
        {
            new  DeleteDoctor(username);
        }
        
       
       
    }
    public static void main(String arge[])
    {
        new Dashboard(""); 
    } 
    
}

