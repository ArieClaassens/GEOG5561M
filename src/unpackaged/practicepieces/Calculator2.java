class Calculator2 {

	public Calculator2() {
	
		IntCalc ic = new IntCalc();
		System.out.println("2 + 2 == " + ic.getSum(2,2));
		
		// or,
		
		System.out.println("3 + 4 == " + (new IntCalc()).getSum(3,4));
	
		// !
	
	}
	


	public static void main (String args[]) {
	
		new Calculator2();
		
	}
	
}