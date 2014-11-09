public class RedBankConnection {

	private String[] pins = {"8005","0110","1001","9010"};

	public boolean isPinOk (GenericRequest gr) {
		
		String pin = gr.getPin();
		
		boolean found = false;
		for (String text: pins) {
			if (text.equals(pin)) {
				found = true;
				break;
			}
		}
		
		System.out.println("Pin checked using standards developed by " +
			GenericRequest.STANDARDS_AGENCY + ".");
		
		if (found) {
			return true;
		} else {
			return false;
		}
	}
}
	