/*
* Class:	Storage
* Version:	 1.2
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/

public class Storage {
	//define a 300 x 300 array of type double (300 rows by 300 columns)
	double data[][] = new double[300][300];
	
	//Mutator method to populate array with data. 
	//Returns nothing because we are modifying the object and not a reference to it.
	void setData(double[][] newData) {
		//outer loop for rows
		for (int i = 0; i < newData.length; i++) {
			//inner loop for columns
			for (int j = 0; j < newData[i].length; j++) {
				data[i][j] = newData[i][j];
			}
		}
	}
	
	//Accessor method to return storage object
	double[][] getData(int startRow, int startCol, int endRow, int endCol){
		//calculate dimensions of the array to return
		int myrows = endRow - startRow +1;
		int mycolumns = endCol - startCol + 1;
		double[][] myArray = new double [myrows] [mycolumns];
		//use arraycopy to populate newArray with the requried values
		//System.arraycopy(this, "[startRow][startCol]", myArray,"[endRow][endCol]");
		//Only works with 1D arrays, so adapt the method below to populate the array
		/*
		 * See http://stackoverflow.com/questions/2068370/efficient-system-arraycopy-on-multidimensional-arrays
		 * for a possible alternative:
		 * for (int i = 0; i < src.length; i++) {
    		System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
			}
		 */
		//outer loop for rows
		for (int i = startRow; i <= endRow; i++) {
			//inner loop for columns
			for (int j = startCol; j <= endCol; j++) {
				myArray[i][j] = data[i][j];
			}
		}
		return myArray;
	}
	
	//Additional Accessor method to obtain data from array elements. 
	//Returns nothing as we print out the value to console from this method.
	void printData(int startRow, int startCol, int endRow, int endCol) {
		//print out array (to verify cell contents)
		//outer loop for rows
		for (int i = startRow; i <= endRow; i++) {
			//inner loop for columns
			for (int j = startCol; j <= endCol; j++) {
				//print the columnar data on one line
				System.out.print(data[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	//method to populate array with random data. Returns nothing
	//prepend public/private and static?
	void setRandomData() {
		//outer loop for rows
		//System.out.println(store.data.length);
		for (int i = 0; i < data.length; i++) {
			//inner loop for columns
			//System.out.println("Row: " +i);
			for (int j = 0; j < data[i].length; j++) {
				//System.out.print(" Column" + j + " ");
				data[i][j] = Math.random()*1000;
			}
		}
	}
	
	//method to print out the array contents
	void printArray () {
		//print out array (to verify cell contents)
		//outer loop for rows
		for (int i = 0; i < data.length; i++) {
			//inner loop for columns
			//print the row number
			//System.out.print("Row: " + i + ": ");
			for (int j = 0; j < data[i].length; j++) {
				//print the columnar data on one line
				System.out.print(data[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	//method to calculate and return the maximum value contained in the array
	//returns a double
	double getMaximum() {
		//calculate the maximum value contained by the array
		//Set the maximum to a negative value in order to ensure that it does not exceed the potentially largest positive value produced by Math.random()
		double maximum = -1.0;
		
		//outer loop for rows
		for (int i = 0; i < data.length; i++) {
			//inner loop for columns
			//print the row number
			//System.out.print("Row: " + i + ": ");
			for (int j = 0; j < data[i].length; j++) {
				//print the columnar data on one line
				//System.out.print(store.data[i][j] + " ");
				if (data[i][j] > maximum) {
					maximum = data[i][j];
					}
			}
		}
		return maximum;
	}
	
	//method to calculate and return the minimum value in array
	//returns a double
	double getMinimum() {
		//calculate the minimum value contained by the array
		//Set the minimum to use the first cell in the array as the initial value. 
		//See http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part3/Analyst.java
		double minimum = data[0][0];

		//outer loop for rows
		for (int i = 0; i < data.length; i++) {
			//inner loop for columns
			//print the row number
			//System.out.print("Row: " + i + ": ");
			for (int j = 0; j < data[i].length; j++) {
				//print the columnar data on one line
				//System.out.print(store.data[i][j] + " ");
				if (data[i][j] < minimum) {
					minimum = data[i][j];
					}
			}
		}
		return minimum;
	}
	
	
	
}
