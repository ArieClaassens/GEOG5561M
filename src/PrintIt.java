/*
* Class:	PrintIt
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/

public class PrintIt {
	String doIt(int step, String hw, int x) {
		switch (step) {
		case 1:
			//For Step 1
			System.out.println("Hello World, Step 1");
			String result = hw + " " + x + "; STEP 1!";
			//not needed, but hacked in here to satisfy class requirement for a return string
			return result;
			//break;
			
		case 2:
			//For Step 2
			System.out.println(hw + " " + x + ", Step 2");
			String result2 = hw + " " + x + "; STEP 2!";
			//not needed, but hacked in here to satisfy class requirement for a return string
			return result2;
			//break;
			
		case 3:
			//For Step 3
			//Global scope, so let's update it!!!!
			x = x*109;
			String result3 = hw + " " + x + "; all the friggin way!";
			return result3;
			//break;
			
		default:
			String result4 = "You need to specify a Step ranging from 1 to 3";
			System.out.println("You need to specify a Step ranging from 1 to 3");
			return result4;
			//break;
		}		
	}
}
