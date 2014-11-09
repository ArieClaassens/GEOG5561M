/*
* Class:	Calculator
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/

public class Calculator {

	public Calculator() {
		int x = 0;
		int y = 0;
		
		//Calculate the sum of the two numbers
		int result = x + y;
		
		//Print out the value of the result
		System.out.println("The result is " + result);
		
		//Now use IntCalc methods
		//IntCalc mycalc = new IntCalc();
		
		System.out.println("The sum of 2 and 3 is: " + IntCalc.getSum(2, 3));
		System.out.println("The product of 2 and 3 is: " + IntCalc.getProduct(2, 3));
		System.out.println("The difference between 2 and 3 is: " + IntCalc.getDifference(2, 3));
		
		//Repeat the steps with the DoubleCalc class
		DoubleCalc mydbcalc = new DoubleCalc();
		
		System.out.println("The sum of 2.5 and 3.5 is: " + mydbcalc.getSum(2.5, 3.5));
		System.out.println("The product of 2.5 and 3.5 is: " + mydbcalc.getProduct(2.5, 3.5));
		System.out.println("The difference between 2.5 and 3.5 is: " + mydbcalc.getDifference(2.5, 3.5));
	}
	
	public static void main(String[] args) {
		//Instantiate new calculator
		new Calculator();
	}

}
