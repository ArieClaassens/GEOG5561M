import java.applet.*;
import java.awt.*;

public class HelloWorld extends Applet {

   public void init () {
      setSize(200,200);
      setBackground(Color.LIGHT_GRAY);
      repaint();
   }

   public void paint (Graphics g) {
      g.drawString("Hello World", 50, 50);
   }

} 
