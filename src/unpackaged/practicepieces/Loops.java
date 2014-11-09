/*
* Class:	Loops - practice pieces for loops and branches
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/	
public class Loops {
	public static void main (String args[]) {
	// 1) There are two rabbits. Each pair of rabbits has four young, then dies. 
	// How many rabbits are there in the 20th generation? 
	// Hint: write the code then test it with a calculator for the first three generations. 
	
	int totalbunnies = 0;
	int startbunnies = 2;
	int bunnygenerations = 20;
	
	System.out.println("Total number of bunnies at the start: "+totalbunnies);
	//loop through the number of generations to build up the total number of rabbits.
	for (int i = 0; i <= bunnygenerations; i++) {
		if (i == 0) {
			totalbunnies = startbunnies + 4 - 2;
		} else {
			int newgen = (totalbunnies / 2) * 4 -  (totalbunnies / 2);
			totalbunnies = totalbunnies + newgen;			
		}
		System.out.println("Total rabbits after generation " + i + " is : "+totalbunnies);
	}
	
	//Option from Answer sheet
	System.out.println(" ");
	System.out.println("Answer from course answer sheet");
	int numberOfRabbits = 2;
	System.out.println("In generation 1 there are 2 rabbits.");

	for (int i = 2; i <= 20; i++) {
		numberOfRabbits = numberOfRabbits + (numberOfRabbits * 2) - numberOfRabbits;
		// Which is, of course, just numberOfRabbits * 2.
		System.out.println("In generation " + i + " there are " + numberOfRabbits + " rabbits.");
	
	}
	
	}
}
