import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class PopUp extends Frame {
 
  public void paint(Graphics g) {
     Graphics2D ga = (Graphics2D)g;
     ga.setPaint(Color.red);
     ga.drawLine(200,100,200,300);
  }
               
  public static void main(String args[])
  {
      PopUp frame = new PopUp();      
      frame.addWindowListener(
      new WindowAdapter()
      {
         public void windowClosing(WindowEvent we)
         {
            System.exit(0);
         }
      }
      );
            
      frame.setSize(400, 400);
      frame.setVisible(true);
   }
}