
package graphic.pkgpackage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

//mouse press method
//mouse dragged method
public class MethodClass extends JComponent //componet don't need to setbound
{
    String shape;
    Graphics2D Gra;
    int x1, x2, y1, y2;
    Mouse M;
    Color ChosenColor=Color.BLACK;
    boolean shapefill=false;
    int penSize=3;
    
    Image image;    //change Jcomponet to image setting vairable
    
    public void setShape(String S)  //tools
    {
        shape=S;
    }
    
    public void setCurrentColor(Color c)
    {
        ChosenColor=c;
    }
    
    public void setshapefill(boolean fill)
    {
        shapefill=fill;
    }
    public void setSize(int PS)
    {
        penSize=PS;
    }
    
    public void clear()
    {
        Gra.setPaint(Color.WHITE);
        Gra.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
    }
    
    public void save()
    {
        BufferedImage bi=new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_3BYTE_BGR);//this=componet
        Graphics gra=bi.createGraphics();   //image to graphic
        paintComponents(gra);
        this.paint(gra);
        gra.dispose();      //close
        
        try 
        {
            String namepic=JOptionPane.showInputDialog(null, "name of pic", "Enter name");
            
            ImageIO.write(bi, "bmp", new File("C:\\"+UserLogin.UN+ "\\"+ namepic.toString()+ "bmp"));
            JOptionPane.showMessageDialog(null, "Save Completed");
            
        } 
        catch (IOException ioe) 
        {
            System.out.println("Clip write help; "+ ioe.getMessage());
        }
    }
    
    public void openpic()
    {
        try 
        {
            DefaultTreeModel model= (DefaultTreeModel) Drawing.tree.getModel();
            TreePath[] paths=Drawing.tree.getSelectionPaths();
        
            for (TreePath path : paths) 
            {
                DefaultMutableTreeNode node=(DefaultMutableTreeNode) path.getLastPathComponent();
                File file=new File("C:\\"+ UserLogin.UN+"\\"+node.toString());
                
                BufferedImage img=ImageIO.read(file);
                image=img;
                repaint();
            }
        } 
        catch (Exception e)
        {
            
        }
    }
    
    //-----------------------------------------------
    public void paintComponent(Graphics G)    //change componet to image
    {
        if (image==null) 
        {
            image=createImage(getSize().width, getSize().height);//set the image to componet size, getSize=to size of componet
            Gra=(Graphics2D) image.getGraphics();
            Gra.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//for the drawing to be smooth
            clear();
        }
        Gra=(Graphics2D) image.getGraphics();
        Gra.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        G.drawImage(image, 0, 0, null);
    }
    
    //---------------(Mouse Action)--------------------
    public class Mouse extends MouseAdapter //mouse methods
    {
        public void mousePressed(MouseEvent e)  //mouse pressing method
        {
            if (shape==null) 
            {    
                //nothing
            }
            if (shape=="Eraser") 
            {
                 x1=e.getX();
                y1=e.getY();
                
                x2=x1;
                y2=y1;
            }
            if (shape=="Pen") 
            {
                x1=e.getX();
                y1=e.getY();
                
                x2=x1;
                y2=y1;
            }
            if (shape=="Line") 
            {
                x1=e.getX();
                y1=e.getY();
                
            }
            if (shape=="Rectangle") 
            {
                x1=e.getX();
                y1=e.getY();
                
            }
            if (shape=="Circle") 
            {
                x1=e.getX();
                y1=e.getY();
                
            }
            if (shape=="Triangle") 
            {
                x1=e.getX();
                y1=e.getY();
                
            }
            if (shape=="RoundRec") 
            {
                x1=e.getX();
                y1=e.getY();
                
            }
            if (shape=="Penta") 
            {
                x1=e.getX();
                y1=e.getY();
            }
            if (shape=="RightTri") 
            {
                x1=e.getX();
                y1=e.getY();
            }
            if (shape=="Star") 
            {
                x1=e.getX();
                y1=e.getY();
            }
            if (shape=="Text") 
            {
                x1=e.getX();
                y1=e.getY();
                
                
                String text=JOptionPane.showInputDialog(null, "Type here", "");
                if (text!=null) 
                {
                    Gra.setColor(ChosenColor);
                    Gra.drawString(text, x1, y1);
                    repaint();  //to be able to draw more than one tool
                }
            }
            
        }
     //--------------(end mouse press)------------   
        public void mouseDragged(MouseEvent e)  //pen use
        {
            if(shape==null)
            {
                //nothing
            }
            if (shape=="Pen")   //draw with Pen
            {
                x1=e.getX();
                y1=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                
                Gra.drawLine(x1, y1, x2, y2);
                repaint();
                
                x2=x1;
                y2=y1;
            }
            if (shape=="Eraser") 
            {
                x1=e.getX();
                y1=e.getY();
                
                Gra.setColor(Color.WHITE);
                Gra.setStroke(new BasicStroke(penSize));
                
                Gra.drawLine(x1, y1, x2, y2);
                repaint();
                x2=x1;
                y2=y1;
            }
            
        }
    //-------------------------------------------------
        public void mouseReleased(MouseEvent e) //for the shape to form at the place the mouse release
        {
            if (shape==null) 
            {
                //nothing
            }
            if (shape=="Line") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                Gra.drawLine(x1, y1, x2, y2);
                repaint();
            }
            if (shape=="Rectangle") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                
                if (shapefill==true) 
                {
                    Gra.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2)); 
                } 
                else 
                {
                   Gra.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2)); 
                }
                repaint();
            }
            if (shape=="Circle") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                
                if (shapefill==true) 
                {
                    Gra.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
                }
                else 
                {
                    Gra.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2));
                }
                repaint();
            }
            if (shape=="RoundRec") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                
                if (shapefill==true) 
                {
                    Gra.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2), 30, 30);
                } 
                else 
                {
                   Gra.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1-x2), Math.abs(y1-y2), 30, 30);
                }
                repaint();
            }
            if (shape=="Triangle") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                if (shapefill==true) 
                {
                    Gra.fillPolygon(new int[]{(x1+x2)/2, x2, x1}, new int[]{y1, y2, y2}, 3);
                }
                else 
                {
                    Gra.drawPolygon(new int[]{(x1+x2)/2, x2, x1}, new int[]{y1, y2, y2}, 3);
                }
                repaint();
            }
            if (shape=="RightTri") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                if (shapefill==true) 
                {
                    Gra.fillPolygon(new int[]{x1,x1,x2}, new int[]{y1,y2,y2}, 3);
                }
                else 
                {
                    Gra.drawPolygon(new int[]{x1,x1,x2}, new int[]{y1,y2,y2}, 3);
                }
                repaint();
            }
            if (shape=="Penta") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                if (shapefill==true) 
                {
                    Gra.fillPolygon(new int[]{((x1+x2)/2-x1)/3+x1, x2-(((x1+x2)/2-x1)/3), x2, (x1+x2)/2, x1}, new int[]{y2, y2, (y1+y2)/2, y1, (y1+y2)/2}, 5);
                }
                else 
                {
                    Gra.drawPolygon(new int[]{((x1+x2)/2-x1)/3+x1, x2-(((x1+x2)/2-x1)/3), x2, (x1+x2)/2, x1}, new int[]{y2, y2, (y1+y2)/2, y1, (y1+y2)/2}, 5);
                }
                repaint();
            }
            if (shape=="Star") 
            {
                x2=e.getX();
                y2=e.getY();
                
                Gra.setColor(ChosenColor);
                Gra.setStroke(new BasicStroke(penSize));
                if (shapefill==true) 
                {
                    Gra.fillPolygon( new int[]{x1, ((x1+x2)/2)-((((x1+x2)/2)-x1)/3), (x1+x2)/2, ((x2-((x1+x2)/2))/3)+((x1+x2)/2), x2, (x2+((x1+x2)/2))/2, (((x2-((x1+x2)/2))/3)+((x1+x2)/2)+(x2-(x1+x2)/2)/3), (x1+x2)/2, x1+(((x1+x2)/2)-x1)/3, (x1+(x1+x2)/2)/2},
                                     new int[]{(y2-y1)/3+y1, (y2-y1)/3+y1, y1, (y2-y1)/3+y1, (y2-y1)/3+y1, y2-((y2-y1)/3), y2, (y2-((y2-y1)/3)+y2)/2, y2, y2-((y2-y1)/3)}, 
                                    10);
                }
                else 
                {
                    Gra.drawPolygon( new int[]{x1, ((x1+x2)/2)-((((x1+x2)/2)-x1)/3), (x1+x2)/2, ((x2-((x1+x2)/2))/3)+((x1+x2)/2), x2, (x2+((x1+x2)/2))/2, (((x2-((x1+x2)/2))/3)+((x1+x2)/2)+(x2-(x1+x2)/2)/3), (x1+x2)/2, x1+(((x1+x2)/2)-x1)/3, (x1+(x1+x2)/2)/2},
                                     new int[]{(y2-y1)/3+y1, (y2-y1)/3+y1, y1, (y2-y1)/3+y1, (y2-y1)/3+y1, y2-((y2-y1)/3), y2, (y2-((y2-y1)/3)+y2)/2, y2, y2-((y2-y1)/3)}, 
                                    10);
                }
                repaint();
            }
          

        }
        
    //-------------------------------------------------------    
        
    }
    
    
    //-------------------------------------------------
    
    
    
public MethodClass()
{
    /*this.setLayout(null);
    this.setBackground(Color.white);
    this.setSize(800, 630);
    this.setLocation(140,20); */
    
    M=new Mouse();
    
    this.addMouseListener(M);
    this.addMouseMotionListener(M);
}
}
