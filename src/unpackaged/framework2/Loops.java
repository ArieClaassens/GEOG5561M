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
	
	int totalbunnies = 2;
	int bunnygenerations = 20;
	
	System.out.println("Total number of bunnies at the start: "+ totalbunnies);
	//loop through the number of generations to build up the total number of rabbits.
	for (int i = 2; i <= bunnygenerations; i++) {
			//totalbunnies = totalbunnies + (totalbunnies * 2) - totalbunnies;
			totalbunnies = (totalbunnies * 2);
			System.out.println("In generation " + i + " there are " + totalbunnies + " rabbits.");
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
	//spacer line
	System.out.println(" ");
	
	//loop through numbers, efficiently determining whether they are odd or even numbers
	int start = 1;
	int end = 6;
	
	for (int i = start; i <= end; i++) {
		if (i % 2 == 1) {
			System.out.println(i + ". This is odd");
		} else {
			System.out.println(i + ". This is even");
		}
		
	}
	//spacer line
	System.out.println(" ");
	
	//loop through numbers, efficiently determining whether they are odd or even numbers, printing only odd numbers
		int startodd = 1;
		int endodd = 6;
		
		for (int i = startodd; i <= endodd; i++) {
			if (i % 2 == 1) {
				System.out.println(i + ". This is odd");
			} 
			
		}
	
	//spacer line
	System.out.println(" ");
	
	//loop through numbers, efficiently determining whether they are odd or even numbers, printing only odd numbers divisible by 3
		int startodd3 = 1;
		int endodd3 = 6;
		
		for (int i = startodd3; i <= endodd3; i++) {
			if (i % 2 == 1) {
				if (i % 3 == 0) {
					System.out.println(i + ". This is odd AND divisible by 3");
				}
			} 
			
		}
	
	
	
	//End of main
	}
}


