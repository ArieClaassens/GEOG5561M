/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 *
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Sorting This class provides the sorting methods required by the GIS
 * application.
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Sorting {

    /**
     * Bubblesort Method
     *
     * @param x : Integer array of values to sort
     *
     * This version of bubble sort continues making passes over the array as
     * long as there were any exchanges. If the array is already sorted, this
     * sort will stop after only one pass.
     */
    //Code adapted from
    // http://www.fredosaurus.com/notes-java/algorithms/sorting/sort-bubble.html
    // Modified to accept array of doubles, instead of integers.

    public static void bubbleSort(double[] x) {
        boolean doMore = true;
        while (doMore) {
            doMore = false;  // assume this is last pass over array
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    // exchange elements
                    double temp = x[i];
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
