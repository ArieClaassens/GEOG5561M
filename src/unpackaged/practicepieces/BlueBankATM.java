public class BlueBankATM{
	public BlueBankATM(){};
	protected BlueBankATM(String args[]) {
		
		BlueBankRequest b1 = new BlueBankRequest();
		b1.setPin(args[0]);
		//b1.setPin("9010");
		RedBankConnection redBankConnection = RedBank.getRedBankConnection();
		boolean pinOk = redBankConnection.isPinOk(b1);
		if (pinOk) {
			System.out.println("Here your monies! Haz a cheezburger! Your PIN was " + args[0]);
		} else {
			System.out.println("You haz a sad. Yes you do. Your PIN was " + args[0]);
		}
		
	}
	
	public static void main (String args[]) {
      new BlueBankATM(args);

    }
 }
	