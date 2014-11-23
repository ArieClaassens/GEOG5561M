/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 * 
 * Please view readme.txt for full copyright and app details
 */
package imageprocessor;

/**
 * Class: Processing.<br>
 * This class provides the image processing methods used by the application.<br>
 * The method applies median filtering with a user-supplied radius, bubble
 * sorting the cell values before finding the median. References: <br>
 * <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html" target="_blank">Median
 * filtering</a> <br>
 * <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html" target="_blank">Conservative</a>
 * and
 * <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html" target="_blank">Mean</a>
 * median calculation algorithms <br>
 * <a href="http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html" target="_blank">Diagonal
 * neighbor method</a>.<br>
 *
 * @author Student 200825599
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Processing {

    /**
     * This mutator method implements Median Filtering, with diagonal neighbors
     * at a user-supplied radius. The returned array is smaller than the source
     * array by 2 x radius for both rows and columns to account for the boundary
     * issue, as only cells that can be fully processed are included.
     *
     * @param srcArray array of integer values representing the image band
     * @param radius integer stipulating the median filter processing radius
     * @param calcMethod string stipulating the calculation option, i.e.
     * Conservative or Mean
     * @return medianArray array of integer values representing the calculated
     * median values.
     */
    static double[][] getMedianArray(double srcArray[][], int myRadius, String calcMethod) {

        //User input sanitation:
        //Define the maximum value for the radius
        int maxRadius = 10;

        //Convert radius to an absolute value
        int radius = Math.abs(myRadius);

        // Validate radius size to constrain user input to useful ranges.
        if ((radius > maxRadius) || (radius < 1)) {
            System.out.println("Your RADIUS value (" + radius + ") is invalid!");
            System.out.println("Try an integer value, where 0 < radius <= " + maxRadius);
            System.exit(1);
        }

        //Instantiate array of median values, minus the rows lost to the
        //boundary issue; assuming a square array.
        double medianArray[][] = new double[srcArray.length - (radius * 2)][srcArray.length - (radius * 2)];

        //Start at radius because radius+1 provides the first valid point to 
        //process, but the array index starts at 0, thus radius+1-1 = radius
        for (int i = radius; i < medianArray.length; i++) {
            for (int j = radius; j < medianArray[i].length - (radius + 1); j++) {

                //2D array to store the rows and columns of neighbour data before
                //conversion into a 1D array.
                double[][] neighbors = new double[radius][4];

                //Instantiate label for this cell's value
                double thiscell = 0;
                thiscell = srcArray[i][j];

                //Loop for each cell to process, repeating radius, e.g. 3, times
                for (int k = 1; k <= radius; k++) {

                    //instantiate method variables to store neighbour and target cell values.
                    double leftup = 0;
                    double rightup = 0;
                    double leftdown = 0;
                    double rightdown = 0;

                    //Populate the variables with the relevant cell data
                    leftup = srcArray[i - k][j - k];        //k row up and k column left.
                    rightup = srcArray[i - k][j + k];       //k row up and k column right.
                    leftdown = srcArray[i + k][j - k];      //k row down and k column left.
                    rightdown = srcArray[i + k][j + k];     //k row down and k column right.

                    //Add the cell values to the array
                    neighbors[k - 1][0] = leftup;
                    neighbors[k - 1][1] = rightup;
                    neighbors[k - 1][2] = leftdown;
                    neighbors[k - 1][3] = rightdown;
                }

                //Create a 1D array from the 2D array
                double[] neighbors1D = Storage.get1DArray(neighbors);

                //Expand neighbors1D array if we're using the mean algorithm to
                //include the focus cell's value
                if (calcMethod.equalsIgnoreCase("mean")) {
                    double[] resizeArray = new double[neighbors1D.length + 1];
                    System.arraycopy(neighbors1D, 0, resizeArray, 0, neighbors1D.length);
                    neighbors1D = resizeArray;
                    neighbors1D[neighbors1D.length - 1] = thiscell;
                }

                //Instantiate median value variable
                double tmpMedian = 0.0;

                //Calculate the median value
                tmpMedian = calculateMedian(neighbors1D);

                //Assign median value to new array
                medianArray[i - 1][j - 1] = tmpMedian;
            }
        }
        return medianArray;
    }

    /**
     * Method to compute the median of the array values.<br>
     * Adapted from
     * <a href="http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java" target="_blank">
     * http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java</a>
     * to use doubles and less variables.
     *
     * @param arr Array of doubles
     * @return median Median of the array
     */
    static double calculateMedian(double[] arr) {
        // Sort the array
        Sorting.bubbleSort(arr);

        double median = 0.0;

        // If the array length is even,  we need to find the average of the two 
        //centered values
        if (arr.length % 2 == 0) {
            int indexA = (arr.length - 1) / 2;
            int indexB = arr.length / 2;
            median = ((arr[indexA] + arr[indexB])) / 2;
        } // Else simply find the value at the center index
        else {
            int index = (arr.length - 1) / 2;
            median = arr[index];
        }
        return median;
    }
}
