
package graphic.pkgpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FirstPage extends JFrame implements ActionListener
{
    public JButton btnregister;
    public JButton btnlogin;
    public JButton btnclose;
    public JButton btnhelp;
    public JLabel lblreg;
    public JLabel lbllog;
    
public FirstPage()
{
    this.setSize(700, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(300, 250);
    this.setLayout(new BorderLayout());
    this.setContentPane(new JLabel(new ImageIcon("image1.JPG")));
    
    Font f=new Font("Lucida Handwriting", WIDTH, 28);
    Font F=new Font("Arial", WIDTH, 30);
    Font lable= new Font("Arial", Font.BOLD, 28);
    
    lblreg=new JLabel("Create a new account");
    lblreg.setBounds(210, 100, 500, 40);
    lblreg.setFont(lable);
    this.add(lblreg);
       
    btnregister=new JButton("Register");
    btnregister.setBounds(250, 150, 200, 50);
    btnregister.addActionListener(this);
    btnregister.setFont(f);
    this.add(btnregister);
    
    lbllog=new JLabel("Already have an account?");
    lbllog.setBounds(210, 250, 500, 40);
    lbllog.setFont(lable);
    this.add(lbllog);
    
    btnlogin=new JButton("Login");
    btnlogin.setBounds(250, 300, 200, 50);
    btnlogin.addActionListener(this);
    btnlogin.setFont(f);
    this.add(btnlogin);
    
    btnhelp=new JButton("?");
    btnhelp.setBounds(470, 450, 60, 60);
    btnhelp.setFont(F);
    btnhelp.addActionListener(this);
    this.add(btnhelp);
    
    btnclose=new JButton("X");
    btnclose.setBounds(550, 450, 60, 60);
    btnclose.addActionListener(this);
    btnclose.setForeground(Color.red);
    btnclose.setFont(F);
    this.add(btnclose);
    
    this.setVisible(true);
}
    public static void main(String[] args) 
    {
    new FirstPage();    
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnclose) 
        {
            System.exit(0);
        }
        
        if (e.getSource()==btnregister) 
        {
            UserRegister r=new UserRegister();
            this.setVisible(false);
        }
        
        if (e.getSource()==btnlogin) 
        {
            UserLogin l=new UserLogin();
            this.setVisible(false);
        }
        
        if (e.getSource()==btnhelp) 
        {
            JOptionPane.showMessageDialog(null, "If you have an account choose login."+ "\n" +"IF you still don't have one choose register.");
        }
    }
}
