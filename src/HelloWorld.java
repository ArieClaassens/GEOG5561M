/*
* Class:	HelloWorld
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/

public class HelloWorld {

	public static void main(String[] args) {
		String hw = "Hello World";
		int x = (int) (Math.random()*20000);
		PrintIt printstuff = new PrintIt();
		//Step 1: Writing and running a method that prints "Hello World"
		printstuff.doIt(1, hw, x);
		//with the returned value:
		System.out.println(printstuff.doIt(1, hw, x));
		x++;
		
		//Step 2: Writing and running a method that takes in a String and prints it.
		System.out.println(" ");
		printstuff.doIt(2, hw, x);
		x++;
		printstuff.doIt(2, hw, x);
		x++;
		printstuff.doIt(2, hw, x);
		x++;
		System.out.println(printstuff.doIt(2, hw, x)); //why is the value of x not incrementing here?
		
		//Step 3: Writing and running a method that returns a String for you to print.
		System.out.println(" ");
		System.out.println("Step 3: Print the returned data, including the counter object that was modified by the external method");
		System.out.println(printstuff.doIt(3, hw, x));
	}

}
