/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
 * All rights reserved.
 * 
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Processing.<br>
 * This class provides the image processing methods used by the application.<br>
 *
 * @author Student 200825599
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
public class Processing {

    /**
     * This mutator method implements median filtering with diagonal neighbors
     * within a user-supplied radius. The returned array is smaller than the source
     * by radius x 2 in both dimensions to account for the boundary
     * issue, as only cells that can be fully processed are analysed.
     *
     * @param srcArray Array with image data
     * @param myRadius Integer limiting the processing radius
     * @param calcMethod String stipulating the calculation algorithm, i.e.
     * Conservative or Mean
     * @return medianArray Array of median values.
     */
    static double[][] getMedianArray(double srcArray[][], int myRadius, String calcMethod) {

        //User input sanitation:
        //Define the maximum radius value
        int maxRadius = 10;

        //Obtain absolute value of radius
        int radius = Math.abs(myRadius);

        // Validate radius size
        if ((radius > maxRadius) || (radius < 1)) {
            System.out.println("Your RADIUS value (" + radius + ") is invalid!");
            System.out.println("Try an integer value, where 0 < radius <= " + maxRadius);
            System.exit(1);
        }

        //Instantiate median values array, accommodating the boundary issue and
        //assuming a square array.
        double medianArray[][] = new double[srcArray.length - (radius * 2)][srcArray.length - (radius * 2)];

        //Start at radius because radius+1 provides the first valid point to 
        //process, but array index starts at 0, thus radius+1-1 = radius
        for (int i = radius; i < medianArray.length; i++) {
            for (int j = radius; j < medianArray[i].length - (radius + 1); j++) {

                //2D array to store neighbour data
                double[][] neighbors = new double[radius][4];

                double thiscell = 0;
                thiscell = srcArray[i][j];

                //Loop to process neighbours
                for (int k = 1; k <= radius; k++) {

                    double leftup = 0;
                    double rightup = 0;
                    double leftdown = 0;
                    double rightdown = 0;

                    leftup = srcArray[i - k][j - k];        //k row up and k column left.
                    rightup = srcArray[i - k][j + k];       //k row up and k column right.
                    leftdown = srcArray[i + k][j - k];      //k row down and k column left.
                    rightdown = srcArray[i + k][j + k];     //k row down and k column right.

                    neighbors[k - 1][0] = leftup;
                    neighbors[k - 1][1] = rightup;
                    neighbors[k - 1][2] = leftdown;
                    neighbors[k - 1][3] = rightdown;
                }

                //Create a 1D array from the 2D array
                double[] neighbors1D = Storage.get1DArray(neighbors);

                //Expand neighbors1D array if using the mean algorithm to
                //include the source cell value
                if (calcMethod.equalsIgnoreCase("mean")) {
                    double[] resizeArray = new double[neighbors1D.length + 1];
                    System.arraycopy(neighbors1D, 0, resizeArray, 0, neighbors1D.length);
                    neighbors1D = resizeArray;
                    neighbors1D[neighbors1D.length - 1] = thiscell;
                }

                //Instantiate and calculate Median value variable
                double tmpMedian = 0.0;
                tmpMedian = calculateMedian(neighbors1D);

                //Assign median value to correct position in target array
                medianArray[i - 1][j - 1] = tmpMedian;
            }
        }
        return medianArray;
    }

    /**
     * Method to compute median of the array values.<br>
     * Adapted from
     * <a href="http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java" target="_blank">
     * http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java</a>
     * to use doubles and less variables.
     *
     * @param arr Array of doubles
     * @return median Median of the array
     */
    static double calculateMedian(double[] arr) {
        // Sort array
        Sorting.bubbleSort(arr);

        double median = 0.0;

        // If array length is even, we need to find the average of the two 
        //centered values
        if (arr.length % 2 == 0) {
            int indexA = (arr.length - 1) / 2;
            int indexB = arr.length / 2;
            median = ((arr[indexA] + arr[indexB])) / 2;
        } // Else simply find value at the center index
        else {
            int index = (arr.length - 1) / 2;
            median = arr[index];
        }
        return median;
    }
}
