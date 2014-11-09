/*
* Class:	Analyst
* Version:	 1.1
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014
* Copyright notice
*/

public class Analyst {
	public static void main (String args[]) {
		//create new Storage object called store
		Storage store = new Storage();
		//create new Storage object called store and hardwire data for 300x300 cells
		//store.data[0][0] = 0.0;
		
		//outer loop for rows
		//System.out.println(store.data.length);
		for (int i = 0; i < store.data.length; i++) {
			//inner loop for columns
			//System.out.println("Row: " +i);
			for (int j = 0; j < store.data[i].length; j++) {
				//hardwire all the cells with the same value
				//System.out.print(" Column" + j + " ");
				store.data[i][j] = Math.random()*1000;
			}
		}
		
		//print out array to verify cell contents
		//outer loop for rows
		for (int i = 0; i < store.data.length; i++) {
			//inner loop for columns
			//print the row number
			System.out.print("Row: " + i + ": ");
			for (int j = 0; j < store.data[i].length; j++) {
				//print the columnar data on one line
				System.out.print(store.data[i][j] + " ");
			}
			System.out.println("");
		}
		//spacer between the array print out and the tests below
		System.out.println("");
		
		/*
		//Spare loop structure 
		//print out array to verify cell contents
		//outer loop for rows
		for (int i = 0; i < store.data.length; i++) {
			//inner loop for columns
			//print the row number
			System.out.print("Row: " + i + ": ");
			for (int j = 0; j < store.data[i].length; j++) {
				//print the columnar data on one line
				System.out.print(store.data[i][j] + " ");
			}
			System.out.println("");
		}
		 */
		
		//Start array processing code
		
		//calculate the maximum value contained by the array
		//Set the maximum to a negative value in order to ensure that it does not exceed the potentially largest positive value produced by Math.random()
		double maximum = -1.0;
		// Loop through rows with index i.
		// Loop through spaces on row with index j.
		// if yourArrayName[i][j] > maximum, maximum = yourArrayName[i][j]
		// End spaces loop.
		// End rows loop.
		// Print the final maximum to the screen. 
		
		//outer loop for rows
		for (int i = 0; i < store.data.length; i++) {
			//inner loop for columns
			//print the row number
			//System.out.print("Row: " + i + ": ");
			for (int j = 0; j < store.data[i].length; j++) {
				//print the columnar data on one line
				//System.out.print(store.data[i][j] + " ");
				if (store.data[i][j] > maximum) {
					maximum = store.data[i][j];
					}
			}
		}
		System.out.println("Maximum is: " + maximum);
		
		//calculate the minimum value contained by the array
		//Set the minimum to a positive value in order to ensure that it does not exceed the potentially largest negative value produced by Math.random()
		double minimum = 1.0;
		// Loop through rows with index i.
		// Loop through spaces on row with index j.
		// if yourArrayName[i][j] < minimum, minimum = yourArrayName[i][j]
		// End spaces loop.
		// End rows loop.
		// Print the final minimum to the screen. 

		//outer loop for rows
		for (int i = 0; i < store.data.length; i++) {
			//inner loop for columns
			//print the row number
			//System.out.print("Row: " + i + ": ");
			for (int j = 0; j < store.data[i].length; j++) {
				//print the columnar data on one line
				//System.out.print(store.data[i][j] + " ");
				if (store.data[i][j] < minimum) {
					minimum = store.data[i][j];
					}
			}
		}
		System.out.println("Minimum is: " + minimum);
		
		/*
		System.out.println("store.data[0][0] must equal 42.23. Current value => " + store.data[0][0]);
		System.out.println("Number at [0][0] = " + store.data[0][0]);
		System.out.println("Number at [1][1] = " + store.data[1][1]);
		//System.out.println("Number at [3][2] = " + store.data[3][2]); - wrong, refers non-existent array element. fixed below
		System.out.println("Number at [2][2] = " + store.data[2][2]);
		System.out.println("Number at [299][299] = " + store.data[299][299]);
		*/
	}
	
}
