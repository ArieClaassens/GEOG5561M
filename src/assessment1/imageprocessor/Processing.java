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
 * This class provides the image processing methods required by the GIS
 * application.<br>
 * The processing method applies median filtering with a specific radius,
 * applying a bubble sort to the cell values array prior to identification of
 * the median. Online references:
 * <ul>
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html" target="_blank">Median
 * filtering</a></li>
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html" target="_blank">Conservative</a>
 * and
 * <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html" target="_blank">Mean</a>
 * median calculation algorithms</li>
 * <li><a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html" target="_blank">Diagonal
 * neighbor method</a>.</li>
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
     * by 2 x radius for both the rows and columns to account for the boundary
     * issue.
     *
     * @param srcArray array of integer values representing the image band
     * @param radius integer stipulating the median filter processing radius
     * @param calcMethod string stipulating the calculation option, i.e.
     * Conservative or Mean
     * @return medianArray array of integer values representing the calculated
     * median values.
     */
    static double[][] getMedianArray(double srcArray[][], int myRadius, String calcMethod) {

        /**
         * @todo Add input validation to check user input when expanding the
         * application to accept user input via GUI. GUI must also limit input
         * to predefined options in order to limit the possibility for malicious
         * input.
         */
        //Define the maximum value for the radius to control user input
        int maxRadius = 10;

        //Convert radius to an absolute value to cater for negative values submitted 
        //by users.
        int radius = Math.abs(myRadius);

        /**
         * Check radius size to constrain user input to useful ranges.
         */
        if ((radius > maxRadius) || (radius < 1)) {
            System.out.println("Your RADIUS is too large or too small!");
            System.out.println("Try an integer value larger than 0 and smaller than " + maxRadius + "% of the image width");
            System.exit(1);
        }

        //Instantiate our new array of median values, reducing it by the amount 
        //of rows we're losing due to the boundary issue
        //This assumes that we are dealing with a square array.
        //Additional functionality to test the existence and contents of each 
        // cell will mitigate the risk of running into uncaught exceptions
        double medianArray[][] = new double[srcArray.length - (radius * 2)][srcArray.length - (radius * 2)];

        //outer loop for rows
        //Instead of looping from 0 to srcArray.length-1, we loop from radius to 
        //medianArray.length to ensure that we start within the boundaries
        //Start at radius because radius+1 provides the first valid point to 
        //process, but the array index starts at 0, thus radius+1-1 = radius
        //for (int i = radius; i < srcArray.length - (radius + 1); i++) {
        for (int i = radius; i < medianArray.length; i++) {
            //inner loop for columns; also from the 2nd column (1) to the arr[i].length-radius column
            // for (int j = radius; j < srcArray[i].length - (radius + 1); j++) {
            for (int j = radius; j < medianArray[i].length - (radius + 1); j++) {

                //Loop for each cell to process.
                //Repeat the loop radius times, e.g. r = 3, repeat 3 times
                /**
                 * Instantiate the neighbors array to store the values of
                 * neighbors. Exclude the focus cell value if conservative
                 * algorithm or an invalid option was specified, otherwise the
                 * if/else if/else ladder lets us include the focus cell value
                 * if the mean algorithm was specified
                 */
                //2D array to store the rows and columns of neighbour data before
                //we turn it into a 1D array and bubble sort it.
                double[][] neighbors = new double[radius][4];

                //Instantiate label for this cell's value
                double thiscell = 0;
                thiscell = srcArray[i][j];

                for (int k = 1; k <= radius; k++) {

                    //instantiate method variables that will store diagonal neighbour 
                    //and target cell values.
                    //Ensures that these method variables are cleaned up in each iteration
                    double leftup = 0;
                    double rightup = 0;
                    double leftdown = 0;
                    double rightdown = 0;

                    //Populate the variables with the relevant cell data
                    leftup = srcArray[i - k][j - k];        //k row up and k column left. Both negative values, relative to current position
                    rightup = srcArray[i - k][j + k];       //k row up and k column right. Negative row value and positive column value, relative to current position
                    leftdown = srcArray[i + k][j - k];      //k row down and k column left. Positive row value and negatoive column value, relative to current position
                    rightdown = srcArray[i + k][j + k];     //k row down and k column right. Both positive values, relative to current position

                    //Add the cell values to the array
                    neighbors[k - 1][0] = leftup;
                    neighbors[k - 1][1] = rightup;
                    neighbors[k - 1][2] = leftdown;
                    neighbors[k - 1][3] = rightdown;

                }
                //End per cell radius-based loop

                //Convert the 2D array into a 1D array so that we can bubble sort
                //it and calculate the median of the cell values
                double[] neighbors1D = new double[radius * 4];
                neighbors1D = Storage.get1DArray(neighbors);

                //Expand neighbors1D array if we're using the mean algorithm
                if (calcMethod.equalsIgnoreCase("mean")) {
                    //expand the array by 1 to cater for the focus cell's value
                    double[] resizeArray = new double[neighbors1D.length + 1];
                    System.arraycopy(neighbors1D, 0, resizeArray, 0, neighbors1D.length);
                    //change neighbors array to the upsized newArray's dimensions and data
                    neighbors1D = resizeArray;
                    //Add the focus cell's value to the array
                    neighbors1D[neighbors1D.length - 1] = thiscell;
                }

                //Instantiate variable to hold median value.
                double tmpMedian = 0.0;

                //Calculate the median value using the calculateMedian method
                tmpMedian = calculateMedian(neighbors1D);
                //System.out.println("tmpMedian --> " + tmpMedian);

                //End of per cell processing loop
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
