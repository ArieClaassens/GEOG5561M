import java.net.*;
import java.io.*;
import java.util.*;

public class Server {


	public Server() {
	
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9999);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		Socket s = null;
		try {
			s = ss.accept();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(s.getInputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try {
			int c = 0;
			while ((c = in.read()) > -1) {
				System.out.print((char)c);
			}
			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		new Server();
	}
	
}