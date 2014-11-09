public class RedBank {

	private RedBank() {};

	public static RedBankConnection getRedBankConnection() {
		return new RedBankConnection();
	}
	
}