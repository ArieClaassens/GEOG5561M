/*
 * Copyright (C) 2014 Arie Claassens <arieclaassens@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 *
 * @author Arie Claassens <arieclaassens@gmail.com>
 */

public class Analyst {
	
	public Analyst () {
		/*
                 * Instantiate new Storage object called store
                 */
		Storage store = new Storage();
		
		/*
                 * Populate the Storage object (array) with random data
                 */
		store.setRandomData();
		
		/*
                 * Print out the Storage object (array) contents
                 */
		store.printArray();
		
		//spacer between the array print out and the tests below
		System.out.println("");
			
		/*
                 * Calculate the maximum value in the array
                 */
		double max = store.getMaximum();
		
		//Print out the maximum value in the array
		System.out.println("Maximum is: " + max);
		
		/*
                 * Calculate the maximum value in the array and print it out
                 */
		double min = store.getMinimum();
		
		//Print out the minimum value in the array
		System.out.println("Minimum is: " + min);
		
		//Extra practical work
		/*
		 *  Once you have all four methods working, you're done for this practical. 
		 *  If you want some extra coding practice, write set and get methods for the data array 
		 *  and positions within the data array. You could [use] the set and get methods by passing in 
		 *  and getting back a new 2D double array, created in Analyst thus:
		 *  double[][] newArray = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{10.0,11.0,12.0}};
		 *  
		 *  Remember, when passing in an array, you use the array name ("newArray"), 
		 *  rather than a position within the array ("newArray[1][2]"). 
		 */
		
		//Print out heading for extra section
		System.out.println(" ");
		System.out.println("---------------------------------------------------------------");
		System.out.println("Extra practical work:");
		
		/*
                 * Define new array's data
                 */
		double[][] newArray = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{10.0,11.0,12.0}};
		
		/*
                 * Instantiate new storage object named store2
                 */
		Storage store2 = new Storage();
		
		/*
                 * Use mutator method to populate store2 object
                 */
		store2.setData(newArray);
		
		/* 
                 * Use accessor method to retrieve store2 object values
                 */
		//double[][] getData(int startRow, int startCol, int endRow, int endCol)
		double[][] myArray = store2.getData(0,0,2,2);
		
		//Test - Print out the array we obtained above
		//outer loop for rows
		//for (int i = 0; i < myArray.length; i++) {
			//inner loop for columns
		//	for (int j = 0; j < myArray[i].length; j++) {
		//		System.out.print(myArray[i][j] + " ");
		//	}
		//	System.out.println(" ");
		//}
		//System.out.println(" ");
		
		//Use an additional accessor method to print store2 object values for specific cells or cell ranges
		//printData(int startRow, int startCol, int endRow, int endCol);
		store2.printData(0, 0, 2, 2);
		
		//Print a blank line to separate the output blocks
		System.out.println(" ");
				
		//Print out contents of store2
		store2.printArray();
		
		System.out.println("---------------------------------------------------------------");
		
		//Part4 practical
		//create new Storage object called store
		Storage mystore2 = new Storage();
			
		//Populate the array with random data
		mystore2.setRandomData();
		
		//Rerange the array with the new method
		//Get the results back in a new (temp) array
		double[][] resultsArray = mystore2.getRerangedData(0,255);
		
		//Print out the resultsArray contents
		//outer loop for rows
		for (int i = 0; i < resultsArray.length; i++) {
		    //inner loop for columns
		    for (int j = 0; j < resultsArray[i].length; j++) {
                        //Print out array elements by row, with newline at the end of each inner loop
                        
			System.out.print(resultsArray[i][j] + " ");
			}
		    System.out.println(" ");
		}
		System.out.println(" ");
		
		
		//Test the 1D Array conversion function
                //System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//double [] resultsArray1D = mystore2.get1DArray();
		//Print out the resultsArray contents
		//for (int i = 0; i < resultsArray1D.length; i++) {
		//	System.out.println("resultsArray1D item " + i + " is: " + resultsArray1D[i] + " ");
		//}
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//End Test functionality
		
	}

	public static void main (String args[]) {
		new Analyst ();
	}
}
