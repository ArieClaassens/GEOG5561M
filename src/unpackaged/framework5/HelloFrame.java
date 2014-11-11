import javax.swing.JFrame;
import java.awt.Label;

public class HelloFrame extends JFrame {

   public HelloFrame () {
      super("HelloWorld!");
      setSize(300,300);
      setLocation(300,300);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(new Label("Hello World, I am here!"));
      setVisible(true);
   }

   public static void main (String args[]) {
      new HelloFrame();
   }
}