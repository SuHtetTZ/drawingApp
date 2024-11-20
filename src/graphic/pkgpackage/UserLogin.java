
package graphic.pkgpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class UserLogin extends JFrame implements ActionListener
{
    
    
    public JLabel lblSignIn;
    public JLabel lblNm;
    public JLabel lblPass;
    public JTextField txtNm;
    public JPasswordField txtPass;
    public JButton btnLog;
    public JButton btnreturn;
    public JButton btnClose;
    public JButton btnhelp;
    public static String UN;    //for keeping text from UNname called by Drawing class
    
    public UserLogin()
    {
        this.setTitle("Sign In");
        this.setSize(700, 600);
        this.setLocation(300, 250);
        this.setContentPane(new JLabel(new ImageIcon("image1.JPG")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        Font f=new Font("Lucida Handwriting", WIDTH, 24);
        Font F=new Font("Arial", WIDTH, 35);
        Font title=new Font("Arial", Font.BOLD, 35);
        
        lblSignIn=new JLabel("SIGN IN!");
        lblSignIn.setBounds(260, 40, 250, 60);
        lblSignIn.setFont(title);
        this.add(lblSignIn);
        
        lblNm=new JLabel("UserName :");
        lblNm.setBounds(70, 150, 200, 40);
        lblNm.setFont(f);
        this.add(lblNm);
        
        lblPass=new JLabel("Password :");
        lblPass.setBounds(70, 240, 200, 40);
        lblPass.setFont(f);
        this.add(lblPass);
        
        txtNm=new JTextField();
        txtNm.setBounds(300, 150, 300, 40);
        txtNm.setFont(f);
        this.add(txtNm);
        
        txtPass=new JPasswordField();
        txtPass.setBounds(300, 240, 300, 40);
        txtPass.setFont(f);
        this.add(txtPass);
        
        btnLog=new JButton("Login");
        btnLog.setBounds(280, 350, 150, 50);
        btnLog.addActionListener(this);
        btnLog.setFont(f);
        this.add(btnLog);
        
        btnreturn=new JButton("Return");
        btnreturn.setBounds(70, 450, 150, 50);
        btnreturn.setFont(f);
        btnreturn.addActionListener(this);
        this.add(btnreturn);
        
        btnhelp=new JButton("?");
        btnhelp.setBounds(470, 450, 60, 60);
        btnhelp.setFont(F);
        btnhelp.addActionListener(this);
        this.add(btnhelp);
        
        btnClose=new JButton("X");
        btnClose.setBounds(550, 450, 60, 60);
        btnClose.addActionListener(this);
        btnClose.setFont(F);
        btnClose.setForeground(Color.red);
        this.add(btnClose);
        
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnreturn) 
        {
            FirstPage FP=new FirstPage();
            this.dispose();
        }
        
        if (e.getSource()==btnLog) 
        {
            ArrayList aldata=new ArrayList();
            try 
            {
                BufferedReader br=new BufferedReader(new FileReader("Registeration.txt"));
                String line;
                while ((line=br.readLine())!=null) 
                {                    
                    aldata.add(line);
                }
                br.close();
            } 
            catch (IOException ioe) 
            {
            }
            
            String Nm=txtNm.getText();
            String Pass=txtPass.getText();
            if (Nm.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter your name.");
            } 
            else if(Pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            else
            {
            int check=0;
            for (int i = 0; i < aldata.size(); i+=4) 
            {
                if (Nm.equals(aldata.get(i)) && Pass.equals(aldata.get(i+=1))) 
                {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    UN=txtNm.getText();
                    Drawing D=new Drawing();
                    D.show();
                    this.dispose();
                    check=1;break;
                }
            }
            if (check==0)
            {
                JOptionPane.showMessageDialog(null, "Try Again");
            }
            
            
            
            txtNm.setText("");
            txtPass.setText("");
        }
        }
        
        if ((e.getSource()==btnClose)) 
        {
            System.exit(0);
        }
        if (e.getSource()==btnhelp) 
        {
            JOptionPane.showMessageDialog(null, "Please enter your username and password to enter the program.");
        }
    }
    
}
