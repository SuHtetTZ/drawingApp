
package graphic.pkgpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;


public class UserRegister extends JFrame implements ActionListener
{
    public JLabel lblreg;
    public JLabel lblRUN;
    public JLabel lblRPass;
    public JLabel lblAge;
    public JLabel lblGen;
    public JLabel lblmale;
    public JLabel lblfemale;
    public JTextField txtRUN;
    public JPasswordField txtRPass;
    public JTextField txtAge;
    public JRadioButton rdofemale;
    public JRadioButton rdomale;
    public JButton btnreg;
    public JButton btnclose;
    public JButton btnreturn;
    public JButton btnhelp;
    ButtonGroup bg=new ButtonGroup();
    
    public UserRegister()
    {
        
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 250);
        this.setContentPane(new JLabel(new ImageIcon("image1.JPG")));
        this.setLayout(null);
        
        Font f=new Font("Lucida Handwriting", WIDTH, 24);
        Font title=new Font("Arial", Font.BOLD, 30);
        
        lblreg=new JLabel("User Registeration");
        lblreg.setBounds(240, 30, 300, 50);
        lblreg.setFont(title);
        this.add(lblreg);
        
        lblRUN=new JLabel("UserName : ");
        lblRUN.setBounds(50, 100, 180, 40);
        lblRUN.setFont(f);
        this.add(lblRUN);
        
        lblRPass=new JLabel("Password : ");
        lblRPass.setBounds(50, 180, 180, 40);
        lblRPass.setFont(f);
        this.add(lblRPass);
        
        lblAge=new JLabel("Age : ");
        lblAge.setBounds(50, 260, 90, 40);
        lblAge.setFont(f);
        this.add(lblAge);
        
        lblGen=new JLabel("Gender :  ");
        lblGen.setBounds(50, 340, 180, 40);
        lblGen.setFont(f);
        this.add(lblGen);
        
        lblmale=new JLabel("Male");
        lblmale.setBounds(340, 350, 100, 40);
        lblmale.setFont(f);
        this.add(lblmale);
        
        lblfemale=new JLabel("Female");
        lblfemale.setBounds(520, 350, 150, 40);
        lblfemale.setFont(f);
        this.add(lblfemale);
        
        txtRUN=new JTextField();
        txtRUN.setBounds(260, 100, 300, 40);
        txtRUN.setFont(f);
        this.add(txtRUN);
        
        txtRPass=new JPasswordField();
        txtRPass.setBounds(260, 180, 300, 40);
        txtRPass.setFont(f);
        this.add(txtRPass);
        
        txtAge=new JTextField();
        txtAge.setBounds(260, 260, 300, 40);
        txtAge.setFont(f);
        this.add(txtAge);
        
        rdomale=new JRadioButton();
        rdomale.setBounds(260, 360, 20, 20);
        this.add(rdomale);
        
        rdofemale=new JRadioButton();
        rdofemale.setBounds(440, 360, 20, 20);
        this.add(rdofemale);
        
        bg.add(rdomale);
        bg.add(rdofemale);
        
        btnreg=new JButton("Register");
        btnreg.setBounds(250, 420, 200, 40);
        btnreg.addActionListener(this);
        btnreg.setFont(f);
        this.add(btnreg);
        
        btnclose=new JButton("X");
        btnclose.setBounds(550, 450, 60, 60);
        btnclose.addActionListener(this);
        btnclose.setFont(title);
        btnclose.setForeground(Color.red);
        this.add(btnclose);
        
        btnhelp=new JButton("?");
        btnhelp.setBounds(480, 450, 60, 60);
        btnhelp.setFont(title);
        btnhelp.addActionListener(this);
        this.add(btnhelp);
        
        btnreturn=new JButton("Return");
        btnreturn.setBounds(50, 450, 150, 40);
        btnreturn.setFont(f);
        btnreturn.addActionListener(this);
        this.add(btnreturn);
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnreturn) 
        {
            FirstPage FP=new FirstPage();
            this.setVisible(false);
        }
        //-------------------------------------        
        if (e.getSource ()==btnreg ) 
        {
            File Fi=new File("C:\\"+ txtRUN.getText());  //search file
            if (Fi.exists()) 
            {
            String RUN = txtRUN.getText();
            String RPass=txtRPass.getText();
            String Age=txtAge.getText();
            String Gen="";
            if (rdomale.isSelected()) 
            {
                Gen="Male";
            }
            else if (rdofemale.isSelected())
            {
                Gen="Female";
            }
           
        
            if (RUN.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } 
            else if(RPass.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            else if(Age.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter your age");
            }
            else if(Gen.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Choose A Gender");      
            }
            else
            {    
    
        try 
        {
        BufferedWriter bw=new BufferedWriter(new FileWriter ("Registeration.txt",true));
        bw.write(RUN);
        bw.newLine();
        bw.write(RPass);
        bw.newLine();
        bw.write(Age);
        bw.newLine();
        bw.write(Gen);
        bw.newLine();
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Registration Completed");
        }
        catch (IOException ioe) 
        {
            
        }
        txtRUN.setText("");
        txtRPass.setText("");
        txtAge.setText(""); 
        }
                
            } 
            else 
            {
                Fi.mkdir();
                String RUN = txtRUN.getText();
            String RPass=txtRPass.getText();
            String Age=txtAge.getText();
            String Gen="";
            if (rdomale.isSelected()) 
            {
                Gen="Male";
            }
            else if (rdofemale.isSelected())
            {
                Gen="Female";
            }
           
        
            if (RUN.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter your name");
            } 
            else if(RPass.equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Please enter password");
            }
            else if(Age.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter your age");
            }
            else if(Gen.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Choose A Gender");      
            }
            else
            {    
    
        try 
        {
        BufferedWriter bw=new BufferedWriter(new FileWriter ("Registration.txt",true));
        bw.write(RUN);
        bw.newLine();
        bw.write(RPass);
        bw.newLine();
        bw.write(Age);
        bw.newLine();
        bw.write(Gen);
        bw.newLine();
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Registeration Completed");
        UserLogin UL=new UserLogin();
        this.dispose();
        }
        catch (IOException ioe) 
        {
            
        }
        txtRUN.setText("");
        txtRPass.setText("");
        txtAge.setText(""); 
        }
            }
            
        }
        
        //----------------------------------------
        if ((e.getSource()==btnclose)) 
        {
            System.exit(0);
        }
        if ((e.getSource()==btnhelp))
        {
            JOptionPane.showMessageDialog(null, "To use this program you need to have an account."
                                                + "\n" 
                                                + "Fill in the form and then press the register button to register into the program.");
        }
    }    
    
   

}
