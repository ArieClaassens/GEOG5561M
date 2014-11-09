public class BlueBankATM{

	private BlueBankATM(String args[]) {
	
		BlueBankRequest b1 = new BlueBankRequest();
		//b1.setPin(args[0]);
		System.out.println("PIN is: "+ b1.getPin());
		b1.setPin("9010");
		RedBankConnection redBankConnection = RedBank.getRedBankConnection();
		boolean pinOk = redBankConnection.isPinOk(b1);
		if (pinOk) {
			System.out.println("Here your monies! Haz a cheezburger!");
		} else {
			System.out.println("You haz a sad. Yes you do.");
		}
		
	}
	
	public static void main (String args[]) {
	    //Supply PIN through main class?
	    //String mypin = "9010";
	    new BlueBankATM(args);

    }
 }
	