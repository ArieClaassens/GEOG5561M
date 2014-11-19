/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * Johannesburg, South Africa
 * All rights reserved.
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
package imageprocessor;

/**
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
public class Storage {

    //define a 300 x 300 array of type double (300 rows by 300 columns)
    double data[][] = new double[300][300];

    /*
     * Mutator method to populate array with data.
     * Returns nothing because we are modifying the object and not a reference to it.
     * @param newData   The placeholder variable used to modify the data[][] array
     */
    void setData(double[][] newData) {
        //outer loop for rows
        for (int i = 0; i < newData.length; i++) {
            //inner loop for columns
            for (int j = 0; j < newData[i].length; j++) {
                data[i][j] = newData[i][j];
            }
        }
    }

    /*
     * Accessor method to return storage object contents
     * Returns a 2D array of double primitive type
     * Accepts integers to define the startRow, startCol*umn), endRow and endCol(umn) parameters of the method
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     * @return myArray  2D array consisting of double primitive type data
     */
    double[][] getData(int startRow, int startCol, int endRow, int endCol) {
        //calculate dimensions of the array to return
        int myrows = endRow - startRow + 1;
        int mycolumns = endCol - startCol + 1;
        double[][] myArray = new double[myrows][mycolumns];
        //outer loop for rows
        for (int i = startRow; i <= endRow; i++) {
            //inner loop for columns
            for (int j = startCol; j <= endCol; j++) {
                myArray[i][j] = data[i][j];
            }
        }
        return myArray;
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

    /**
     * Bubblesort Method
     *
     * @param x : Integer array of values to sort
     *
     * This version of bubble sort continues making passes over the array as
     * long as there were any exchanges. If the array is already sorted, this
     * sort will stop after only one pass. From
     * http://www.fredosaurus.com/notes-java/algorithms/sorting/sort-bubble.html
     */
    public static void bubbleSort2(int[] x) {
        boolean doMore = true;
        while (doMore) {
            doMore = false;  // assume this is last pass over array
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    // exchange elements
                    int temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    doMore = true;  // after an exchange, must look again 
                }
            }
        }
        //Test the bubble sort. Print out the results
        //for (int i = 0; i < x.length; i++) {
        //    System.out.println(x[i]);
        //}
    }

   
}
