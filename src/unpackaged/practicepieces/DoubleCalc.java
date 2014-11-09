/*
* Class:	DoubleCalc
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/

public class DoubleCalc {
	//instantiate class variables
	double myx = 0.0;
	double myy = 0.0;
	
	//Mutator method: set myx value, returns nothing
	void setX(double x) {
		myx = x;
	}
	
	//Mutator method: set myy value, returns nothing
	void setY(double y) {
		myy = y;
	}

	//Accessor method: returns myx value
	double getX(double x) {
		return myx;
	}
	
	//Accessor method: returns myy value
	double getY(double y) {
		return myy;
	}	
	
	//Additional Mutator methods to perform mathematical operations on the supplied doubleegers
	
	double getSum(double x, double y) {
		double sum = x + y;		
		return sum;
	}
	
	double getProduct(double x, double y) {
		double product = x * y;		
		return product;
	}
	
	double getDifference(double x, double y) {
		double difference = x - y;
		//convert result to a positive number if it is negative
		if (difference < 0) {
			difference = difference * -1;
		}
		return difference;
	}
	
}
