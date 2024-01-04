

import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.*;

// we need "JFrame" to make frame 
// "Jframe" class comes from swing package so we need to import "swing" package
// Actionlistener interface is used to define behaviour of action when clicking on button

public class Server extends JFrame implements ActionListener
{
    // class ka object banate hi mereko frame dikhna start ho jaye to uske liye mereko yahape constructor banana padega
    // meri frame ki jo bhi coding hogi vo mere constructor ke andar hogi
    // jese mai class ko run karu vaise muze frame dikhna start ho jaye

    JTextField text;
    JPanel a1;
    Box vertical = Box.createVerticalBox();

    Server()
    {
        setLayout(null);

        // frame head or header panel

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));   // setting backgrond color green
        // setting panel on our frame (x,y are x axis and y axis according to frame) (width and height of panel)
        p1.setBounds(0,0,450,70); 
        p1.setLayout(null); 
        add(p1);
        
        // taking image from system for back button(->) and set over the JPanel using JLabel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));   // taking image from system
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // scaling image
        ImageIcon i3 = new ImageIcon(i2);   // put this scaled image into normal image 
        JLabel back = new JLabel(i3);       // pass this normal image to label
        back.setBounds(5, 20,25,25);  // locate where to set this Image label on panel 
        p1.add(back);                        // add Image label on panel

        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent ae)
            {
                System.exit(0);
            }
        });

        // taking image from system for user photo and set over the JPanel using JLabel

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));  
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
        ImageIcon i6 = new ImageIcon(i5);   
        JLabel profile = new JLabel(i6);       
        profile.setBounds(40, 10,50,50);   
        p1.add(profile);

        // taking image from system for video call symbol image image and set over the JPanel using JLabel

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));  
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
        ImageIcon i9 = new ImageIcon(i8);   
        JLabel video = new JLabel(i9);       
        video.setBounds(300, 20,30,30); 
        p1.add(video); 

        // taking image from system for audio call symbol image and set over the JPanel using JLabel

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));  
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
        ImageIcon i12 = new ImageIcon(i11);   
        JLabel phone = new JLabel(i12);       
        phone.setBounds(360, 20,30,30); 
        p1.add(phone); 


        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));  
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT); 
        ImageIcon i15 = new ImageIcon(i14);   
        JLabel morevert = new JLabel(i15);       
        morevert.setBounds(410, 20,10,25); 
        p1.add(morevert); 

        JLabel name = new JLabel("Adarsh");
        name.setBounds(120, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF" , Font.BOLD ,18 ));
        p1.add(name);


        JLabel status = new JLabel("ACTIVE NOW");
        status.setBounds(120, 40, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF" , Font.BOLD ,10 ));
        p1.add(status);
        
        
        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        add(a1);

        // Taking user Input
        text = new JTextField();
        text.setBounds(5,655,310, 40);
        text.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        add(text);

        // SEND BUTTON

        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84)); 
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF" , Font.PLAIN , 16));
        add(send);
 

        setSize(450,700);  //setting size of frame
        setLocation(200, 50);       // changing location of frame
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);  // chaning background color of frame

        setVisible(true);             // By Default frame ki visibility by default hidden hoti hai to hame usko visible karna hoga
    }

    public void actionPerformed(ActionEvent ae)
    {
        String out = text.getText();

        JPanel p2 = formatLabel(out);
        
        a1.setLayout(new BorderLayout());

        // messages written by you will be right side aligned
        JPanel right = new JPanel(new BorderLayout());
        right.add( p2 , BorderLayout.LINE_END );

        // messages written by you will be right side aligned
        vertical.add(right);

        vertical.add(Box.createVerticalStrut(15));

        a1.add(vertical,BorderLayout.PAGE_START);

        text.setText("");
        
        repaint();
        invalidate();
        validate();

    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(255, 255, 0));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }

    public static void main(String[] args) 
    {
        new Server();

        try 
        {
            ServerSocket skt = new ServerSocket(6001);
            while(true)
            {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}