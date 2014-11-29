import java.awt.Frame;
public class PopUp {
	public PopUp() {
		Frame frame = new Frame("My Window");
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	public static void main (String args[]) {	
		new PopUp();
	}
}
