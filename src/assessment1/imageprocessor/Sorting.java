/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
 * All rights reserved.
 * 
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Sorting.<br>
 * This class provides the sorting methods required by the GIS application.
 *
 *  @author Student 200825599 
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Sorting {

    /**
     * Bubblesort Method.<br>
     * Adapted from <a href="http://www.fredosaurus.com/notes-java/algorithms/sorting/sort-bubble.html" target="_blank">
     * http://www.fredosaurus.com/notes-java/algorithms/sorting/sort-bubble.html</a>
     * to accept array of doubles, instead of integers.
     *
     * @param x Integer array of values to sort
     */

    public static void bubbleSort(double[] x) {
        boolean doMore = true;
        while (doMore) {
            doMore = false;
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    double temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    doMore = true;
                }
            }
        }
    }
}
