/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
 * All rights reserved.
 * 
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Storage.<br>
 * This class provides the storage-related methods required for the application.
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
        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData[i].length; j++) {
                data[i][j] = newData[i][j];
            }
        }
    }

    /*
     * Accessor method to return the object contents
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
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                myArray[i][j] = data[i][j];
            }
        }
        return myArray;
    }

    /**
     * Accessor method used to print object contents
     */
    void printArray() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Mutator method to convert 2D array to 1D. Adapted from
     * http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part4/answer.html
     *
     * @param srcArray2D 2D Array that must be converted to 1D array
     * @return tempArray 1D array after conversion
     */
    static double[] get1DArray(double[][] srcArray2D) {
        //find the maximum dimensions of the 2D array, assuming constant width
        int arraySize = srcArray2D.length * srcArray2D[0].length;
        double[] tempArray = new double[arraySize];
        for (int i = 0; i < srcArray2D.length; i++) {
            for (int j = 0; j < srcArray2D[0].length; j++) {
                tempArray[(srcArray2D[0].length * i) + j] = srcArray2D[i][j];
            }
        }
        return tempArray;
    }
}
