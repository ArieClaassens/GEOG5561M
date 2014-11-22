/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
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
 *
 * Please view readme.txt for copyright and app details
 */
package imageprocessor;

/**
 * Class: Storage.<br>
 * This class provides the storage-related methods required for the GIS
 * application.
 *
 * @author Student 200825599
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Storage {

    double data[][] = new double[300][300];

    /**
     * Mutator method to populate array with data.
     *
     * @param newData The data object used to populate the array
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
     * Accessor method to return a storage object's contents
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

    /**
     * Accessor method used to print the contents of a data object
     */
    void printArray() {
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                //print the columnar data on one line
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Mutator method to convert 2D array to 1D. The width of one row is
     * srcArray2D[0].length, and the number of rows you've completely processed
     * is i. Remember, you don't want to add on the width of the current row as
     * you're only part-way across it. The cells processed in previous rows is
     * thus: srcArray2D[0].length * i. If you're not convinced (perhaps because
     * you think i is the current row count, rather than the rows that have been
     * processed), consider the situation where i == 1. When this is the case,
     * srcArray2D[0].length * i represents the values in the first "zero" row,
     * which is the row that has been completed, and none of the current row.
     * This is one of those nice examples that works because array indices start
     * at zero, not one.
     *
     * The distance across the current row is j. Again, because indices start at
     * zero, although j is counting the values looped through, it also gives the
     * correct position for the next value.
     *
     * @param srcArray2D 2D Array that must be converted to 1D array
     * @return tempArray 1D array after conversion
     */
    static double[] get1DArray(double[][] srcArray2D) {

        //Convert 2D array into 1D array:
        // Make a double tempArray [reranged.length * reranged[0].length]
        int arraySize = srcArray2D.length * srcArray2D[0].length;
        double[] tempArray = new double[arraySize];

        // Open loop with index i down reranged rows
        for (int i = 0; i < srcArray2D.length; i++) {

            // Open loop with index j across a row, using a constant dimension for the columns
            //We would need a different algorithm for varying columnar dimensions.
            //Images are square or rectangular, most of the time....
            for (int j = 0; j < srcArray2D[0].length; j++) {
                tempArray[(srcArray2D[0].length * i) + j] = srcArray2D[i][j];
            }
        }
        // return tempArray 
        return tempArray;

    }
}
