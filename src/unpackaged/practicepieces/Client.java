import java.net.*;
import java.io.*;

public class Client {

	private byte[] addr = {(byte)127,(byte)0,(byte)0,(byte)1}; // 127.0.0.1 is LOCALHOST.

	public Client() {
		InetAddress i = null;
		
		try {
			i = InetAddress.getByAddress(addr);
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		Socket s = null;
		try {
			s = new Socket(i, 9999);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		BufferedOutputStream b = null;
		try {
			b  = new BufferedOutputStream(s.getOutputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		// DOS actually uses a quite complicated character set mapping, so char 170 may not be 
		// the logical negation symbol for you. Given this, see what character is printed by 
		// this line and use that. Alternatively, if it isn't on your keyboard, adjust this 
		// number until you find one that is, and change the 170 throughout.
		System.out.println("To end communications, type " + (char)170 + " and enter.");
		
		try {
			int c = 0;
			while ((c = System.in.read()) != 170) {
				b.write(c);
				b.flush();
			}
			s.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		

	}
	
	public static void main (String args[]) {
		new Client();
	}
	
}