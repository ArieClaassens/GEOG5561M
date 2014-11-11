public class Homer {

	public static void main (String args[]) {
		Bart bart = new Bart();
		
		try {
			bart.getMeABeerSon();
		} catch (BeerException eek) {
			eek.print();
		}

		try {
			try {
				int i = 2 / 0;
			} catch (Exception e) {
				System.out.println("Doh! 1");
				e.printStackTrace();
				System.out.println("Doh! 2");
			} 

		// Note that the next catch is never reached, because the 
		// developer has erroneously put a more general class of 
		// exception closer to the statement generating the 
		// runtime exception.
		} catch (RuntimeException rte) {
			System.out.println("Doh! Doh!");
			rte.printStackTrace();
		}
		throw new RuntimeException();		
	}
}
