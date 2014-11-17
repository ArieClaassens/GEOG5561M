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

    double[][] getData(int startRow, int startCol, int endRow, int endCol) {
        //calculate dimensions of the array to return
        int myrows = endRow - startRow + 1;
        int mycolumns = endCol - startCol + 1;
        double[][] myArray = new double[myrows][mycolumns];
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
                data[i][j] = Math.random() * 1000;
            }
        }
    }

    //method to print out the array contents
    void printArray() {
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

    /*
     * Images are based on arrays containing values between 0 and 255. 
     * To convert our data into an image, we need to re-range it between these two values. 
     * We need a method that will take the data in our array, and stretch or compress the 
     * numbers across a given range, that is, the minimum value matches a new minimum, 
     * the maximum a new maximum, and the rest of the data is spread between them, 
     * proportional to the values in the original dataset. 
     */
    double[][] getRerangedData(double newMinimum, double newMaximum) {
        // Set up double variables containing currentMaximum and currentMinimum (where could we get these from...?)
        double currentMinimum = this.getMinimum();
        double currentMaximum = this.getMaximum();

        // Make a double[][] array called tempArray, and size [data.length][data[0].length]
        double[][] tempArray = new double[data.length][data[0].length];

        // Open loop with index i down data rows
        for (int i = 0; i < data.length; i++) {
            // Open loop with index j across a row
            for (int j = 0; j < data[i].length; j++) {
                // tempArray[i][j] = data[i][j]
                tempArray[i][j] = data[i][j];
                // tempArray[i][j] = tempArray[i][j] - currentMinimum (so values between 0 and currentMaximum - currentMinimum)
                tempArray[i][j] = tempArray[i][j] - currentMinimum;

                // tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum) (so values between 0 and 1)
                tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum);
                // tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum) (so values between 0 and newMaximum - newMinimum)
                tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum);

                // tempArray[i][j] = tempArray[i][j] + newMinimum (so values between newMinimum and newMaximum)
                tempArray[i][j] = tempArray[i][j] + newMinimum;

                // End loop across row
            }
            // End loop down rows
        }

        // return tempArray 
        return tempArray;
    }

    //Next, the method to save our data into a 1D array.
    //Images, strangely, are stored in 1D arrays. This is because 1D arrays are slightly more efficient to process. 
    //The data inside an image array is actually stored in quite a complicated format, as we'll see in 
    //our lecture on images. However, for now, let's just copy the data out of our 2D array and into a 1D array 
    //of the same, double, type.
    double[] get1DArray() {
        //create a reranged array
        //Note that here we're calling another method in our Storage class from within another method. 
        //This means that we don't need to call store.getRerangedData(0.0,255.0) 
        //-- we are *inside* the store object; we can just call the method directly. 
        double[][] reranged = getRerangedData(0.0, 255.0);

        //Convert 2D array into 1D array:
        // Make a double tempArray [reranged.length * reranged[0].length]
        int arraySize = reranged.length * reranged[0].length;
        double[] tempArray = new double[arraySize];

        // Open loop with index i down reranged rows
        for (int i = 0; i < reranged.length; i++) {

            // Open loop with index j across a row, using a constant dimension for the columns
            //We would need a different algorithm for varying columnar dimensions.
            //Images are square or rectangular, most of the time....
            for (int j = 0; j < reranged[0].length; j++) {
		    // tempArray[????] = reranged[i][j]
		    /*
                 * int counter = i * j;
                 * tempArray[counter] = reranged[i][j];
                 * Won't work because array counters start at zero and 0 x any number is zero
                 */
                //(reranged[0].length * i) = number of columns processed times the current row counter, e.g. 10 columns x row 2 = 20
                //j = current column
                tempArray[(reranged[0].length * i) + j] = reranged[i][j];
                /*
                 *  the width of one row is reranged[0].length, and the number of rows you've completely processed is i. 
                 *  Remember, you don't want to add on the width of the current row as you're only part-way across it. 
                 *  The cells processed in previous rows is thus: reranged[0].length * i. 
                 *  If you're not convinced (perhaps because you think i is the current row count, rather than the 
                 *  rows that have been processed), consider the situation where i == 1. When this is the case, 
                 *  reranged[0].length * i represents the values in the first "zero" row, which is the row that 
                 *  has been completed, and none of the current row. This is one of those nice examples that works 
                 *  because array indices start at zero, not one. 
                 *  
                 *  The distance across the current row is j. Again, because indices start at zero, 
                 *  although j is counting the values looped through, it also gives the correct position for the next value. 
                 */

                // End loop across row
            }
            // End loop across
        }
        // return tempArray 
        return tempArray;

    }
}
