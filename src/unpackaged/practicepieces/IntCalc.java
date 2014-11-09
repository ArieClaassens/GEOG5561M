/*
* Class:	IntCalc
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/

//Extra exercise:
//2) Change IntCalc so it has static methods, 
//and call them straight from the class definition 
//(within the main class; as we would if we used Math.random()).

public class IntCalc {
	//instantiate class variables
	static int myx = 0;
	static int myy = 0;
	
	//Mutator method: set myx value, returns nothing
	static void setX(int x) {
		final int myx = x;
	}
	
	//Mutator method: set myy value, returns nothing
	static void setY(int y) {
		final int myy = y;
	}

	//Accessor method: returns myx value
	static int getX(int x) {
		return myx;
	}
	
	//Accessor method: returns myy value
	static int getY(int y) {
		return myy;
	}	
	
	//Additional Mutator methods to perform mathematical operations on the supplied integers
	
	static int getSum(int x, int y) {
		final int sum = x + y;		
		return sum;
	}
	
	static int getProduct(int x, int y) {
		final int product = x * y;		
		return product;
	}
	
	static int getDifference(int x, int y) {
		//convert result to a positive number if it is negative
		final int difference = Math.abs(x - y);
		return difference;
	}
	
}
