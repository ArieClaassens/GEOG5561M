/*
* Class:	Analyst
* Version:	 1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/

/*In this practical we're going to build a main class, and give it an object variable in which it can store a 2D array of data. 
* This is going to be our data store for later versions of the software. Here's the algorithms for the two classes we'll build: 

* Analyst class:
* In the main block:
* 1) Make a Storage class object.
* 2) Put values in the object's 'data' array.
* 3) Test that the values have been set up. 

* Storage class:
* In the class block:
*  Make a 'data' array. 
*/

public class Analyst {
	public static void main (String args[]) {
		//create new Storage object called store
		Storage store = new Storage();
		//create new Storage object called store and hardwire data for 12 cells
		store.data[0][0] = 0.0;
		store.data[0][1] = 1.0;
		store.data[0][2] = 2.0;
		store.data[0][3] = 3.0;
		store.data[1][0] = 4.0;
		store.data[1][1] = 5.0;
		store.data[1][2] = 6.0;
		store.data[1][3] = 7.0;
		store.data[2][0] = 8.0;
		store.data[2][1] = 9.0;
		store.data[2][2] = 10.0;
		store.data[2][3] = 11.0;

		System.out.println("store.data[0][0] must equal 10.0. Current value => " + store.data[0][0]);
		System.out.println("Number at [0][0] = " + store.data[0][0]);
		System.out.println("Number at [1][1] = " + store.data[1][1]);
		//System.out.println("Number at [3][2] = " + store.data[3][2]); - wrong, refers non-existent array element. fixed below
		System.out.println("Number at [2][2] = " + store.data[2][2]);
		
		/* Loop framework
		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				System.out.println("i -> " + i + " j -> " + j);
			}
		}
		*/
	}
}
