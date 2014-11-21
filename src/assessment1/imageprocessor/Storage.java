/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 *
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Storage
 * This class provides the storage-related methods required for the GIS
 * application.
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Storage {

    double data[][] = new double[300][300];

    /**
     * Mutator method to populate array with data.
     * Returns nothing because we are modifying the object and not a reference to it.
     * @param newData The data object used to populate the data[][] array
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
}
