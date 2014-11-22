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
 * Class: Processing.<br>
 * This class provides the image processing methods required by the GIS application.<br>
 * The processing method applies median filtering with a specific radius, applying a 
 * bubble sort to the cell values array prior to identification of the median. Online references:
 * <ul>
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html" target="_blank">Median filtering</a></li>
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html" target="_blank">Conservative</a> and <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html" target="_blank">Mean</a> median calculation algorithms</li> 
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html" target="_blank">Diagonal neighbor method</a>.</li>
 * </ul>
 *
 *
 * @author Student 200825599 
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Processing {

    /**
     * This mutator method implements Median Filtering, with diagonal neighbors
     * at a radius of 1 cell, of the image band supplied. Describe the median
     * filtering process. This returned array is smaller than the source array
     * by 2 x radius for both the rows and columns to account for the boundary issue.
     * 
     * @param srcArray array of integer values representing the image band
     * @param radius integer stipulating the median filter processing radius
     * @param calcMethod string stipulating the calculation option, i.e.
     * Conservative or Mean
     * @return medianArray array of integer values representing the calculated
     * median values.
     */
    static double[][] getMedianArray(double srcArray[][], int radius, String calcMethod) {

        //Instantiate our new array of median values, reducing it by the amount 
        //of rows we're losing due to the boundary issue
        //This assumes that we are dealing with a square array.
        //Additional functionality to test the existence and contents of each 
        // cell will mitigate the risk of running into uncaught exceptions
        double medianArray[][] = new double[srcArray.length - radius * 2][srcArray.length - radius * 2];

        //outer loop for rows
        //Instead of looping from 0 to arr.length-1, we loop from radius to 
        //arr.length-(1+radius) to ensure that we start within the boundaries
        //Start at radius because radius+1 provides the first valid point to 
        //process, but the array index starts at 0, thus radius+1-1 = radius
        for (int i = radius; i < srcArray.length - (1+radius); i++) {
            //inner loop for columns; also from the 2nd column (1) to the arr[i].length-radius column
            for (int j = radius; j < srcArray[i].length - 1 - radius; j++) {
                
                //Loop for each cell to process.
                //Repeat the loop radius times, e.g. r = 3, repeat 3 times
                

                //instantiate method variables that will store diagonal neighbour 
                //and target cell values. Define as int as images store values in int
                //Ensure that variables are cleaned up in each iteration
                double leftup = 0;
                double rightup = 0;
                double thiscell = 0;
                double leftdown = 0;
                double rightdown = 0;

                //Populate the variables with the relevant cell data
                thiscell = srcArray[i][j];
                leftup = srcArray[i - 1][j - 1];        //One row up and one column left. Both negative values, relative to current position
                rightup = srcArray[i - 1][j + 1];       //One row up and one column right. Negative row value and positive column value, relative to current position
                leftdown = srcArray[i + 1][j - 1];      //One row down and one column left. Positive row value and negatoive column value, relative to current position
                rightdown = srcArray[i + 1][j + 1];     //One row down and one column right. Both positive values, relative to current position

                //Instantiate variable to hold median value.
                double tmpMedian = 0.0;

                //Calculate the median value using the median calculation method
                // selected, i.e. Conservative or Median, with the former excluding
                // the current cell value in the median calculation and the latter
                // including the current cell value from the median calculation

                // Utilise an if/elseif ladder to cater for the limited set of 
                // calculation choices and to enforce a default option in the event
                // of invalid input for the calculation method.
                if (calcMethod.equalsIgnoreCase("conservative")) {
                    //Use conservative median calc, excluding thiscell
                    double[] tmpcellArray = {leftup, rightup, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);

                } else if (calcMethod.equalsIgnoreCase("mean")) {
                    //Use mean median calc, include thiscell
                    double[] tmpcellArray = {leftup, rightup, thiscell, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);

                } else {
                    //Use conservative median calc as the default option to cater for invalid choices
                    double[] tmpcellArray = {leftup, rightup, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);

                }
                //Assign median value to new array
                medianArray[i - 1][j - 1] = tmpMedian;
            }
        }
        //Return the array of median values
        return medianArray;
    }

    /**
     * This method computes the median of the values in the input array.<br> 
     * Adapted from
     * <a href="http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java" target="_blank">
     * http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java</a>
     * to use doubles instead of integers and utilize less variables.
     *
     * @param arr - an array of doubles
     * @return median - the median of the input array
     */
    static double calculateMedian(double[] arr) {
        // Sort our array
        Sorting.bubbleSort(arr);

        double median = 0;

        // If our array's length is even, then we need to find the average of the two centered values
        if (arr.length % 2 == 0) {
            int indexA = (arr.length - 1) / 2;
            int indexB = arr.length / 2;

            median = ((arr[indexA] + arr[indexB])) / 2;
        } // Else if our array's length is odd, then we simply find the value at the center index
        else {
            int index = (arr.length - 1) / 2;
            median = arr[index];
        }

        // Print the values of the sorted array
        //for (double v : arr) {
        //    System.out.println(v);
        //}
        return median;
    }

}
