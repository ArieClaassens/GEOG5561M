    /*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 *
 * Please view readme.txt
 */
package imageprocessor;

/**
 * This class provides the image processing methods required by the GIS
 * application
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */
/**
 *
 * //Implement Median Filtering with a Diagonal Neighbourhood, using a Bubble
 * Sort // Median filtering
 * //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html
 * //Diagonal Neighbourhood with radius 1
 * //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html
 * //Conservative Median Filter - central cell is excluded from calculations
 * //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html
 * //Conservative filtering is an image processing methodology for removing high
 * frequency noise from images. //Mean Median Filter - central cell is usually
 * included in calculations
 * //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html
 * //Mean filtering is an image processing methodology for removing high
 * frequency noise from images. Pseudo-code: generate a new array of the same(?)
 * dimension as the source array. How are we to handle boundaries? Lose 1 cell
 * in each direction (top, bottom, left and right) and know that we're working
 * with valid data. See chapter 2, Looping through arrays. ONLY process cells
 * that can have complete processing (Suitable for image processing), p20 of my
 * notes.
 *
 * This means that we will need to start our processing offset by the radius
 * distance from the start, so if radius is 1, we need to start 1 row down and 1
 * column right from [0][0]. The radius needs to be parameterised in this
 * processing method so that we can pass radii of varying sizes to analyze the
 * impact on the image. For higher marks too. Input validation: is this an int
 * and is it less than say 25% of image size? If not an int, but can be cast as
 * an int, e.g. byte/double/long/etc. convert it. If a string, set it to a
 * default of 1 and raise an error, or just catch the error and stop processing?
 *
 * We also need to parameterise the value calculations, providing either a
 * Conservative or Mean calculation option. This will also allow us to analyze
 * the impact on the image. For higher marks too. Use a switch to provide
 * options or if/else ladder? Only two options available, so if/else will be OK
 * and we can put in a default choice. 50% chance of choosing our default one.
 *
 * Set up an array loop that processes the supplied array: // Instantiate a new
 * array with method scope, of the dimension: tmpArray[srcArray.length-2][]
 * Start looping from srcArray[1][1] to
 * srcArray[srcArray.length-1][srcArray.length[srcArray.length-1]-1] This will
 * see us process cell data one row and one column away from the boundaries
 * across the whole process.
 *
 * Inside this loop, create a new loop/storage object that will collect the cell
 * values from the following relative positions: for position srcArray[i][j]:
 * srcArray[i-1][j-1] Up and Left srcArray[i-1][j+1] Up and Right
 * srcArray[i+1][j-1] Down and Left srcArray[i+1][j+1] Down and Right
 *
 * Calculate the MEDIAN value, depending on the calculation option selected:
 *
 * //See
 * http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java
 * //calculates the median wrong Median value is the middle number in a sorted
 * list, so for
 *
 * Conservative: Bubble sort the 4 values, take the middle two, add them and
 * divide by two to find their middle value Use the Math.Round() function to
 * produce more accurate values. Take note that Java 6 has an issue with
 * Math.Round(), implementing it as a floor and not ceiling calculation. See
 * http://stackoverflow.com/questions/9902968/why-does-math-round0-49999999999999994-return-1?lq=1
 * position of median element is [((newArray.length)/2)] +
 * [((newArray.length)/2)+1] (Middle of 4 is 2 and 3)
 *
 * Mean: Bubble sort the 5 values and take the middle one position of median
 * element is ((newArray.length-1)/2)+1 (Array length -1, divided by 2, plus 1)
 * //
 *
 * Assign the new, median, value to our tempArray and repeat the process untill
 * we reach the last row and column available for processing.
 */
        //return the array with median values
public class Processing {

    //Define our mutator method to generate an array of median values
    /**
     * This mutator method implements Median Filtering, with diagonal
     * neighhbours, of the image band supplied. Describe the median filtering
     * process. Include HTML image tag to include image or use HTML table to
     * illustrate. This returned array is smaller than the source array by two
     * rows and two columns.
     *
     * @param srcArray : array of integer values representing the image band
     * @param radius : integer stipulating the median filter processing radius
     * @param calcMethod : string stipulating the calculation option, i.e.
     * Conservative or Mean
     * @return medianArray : array of integer values representing the calculated
     * median values.
     */
    static double[][] getMedianArray(double srcArray[][], int radius, String calcMethod) {

        //Instantiate our new array of median values, reducing it by the amount of rows we're losing due to the boundary issue
        //ASSUMING IT IS A SQUARE ARRAY!!!!!! FIX THIS
        double medianArray[][] = new double[srcArray.length - radius * 2][srcArray.length - radius * 2];
        
        

        //outer loop for rows; to the one before last, so instead of 0 - arr.length-1, we do 1 - arr.length-2
        for (int i = 1; i < srcArray.length - radius; i++) {
            //inner loop for columns; to the one before last
            for (int j = 1; j < srcArray[i].length - radius; j++) {
                //medianArray[i-1][j-1] = srcArray[i][j];
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

                //Instantiate array with cell values for median processing and hardwire with
                //values obtained in this inner loop. Array contents include thiscell if Mean was selected
                //thiscell is excluded if Conservative option was selected.
                //(string1.equalsIgnoreCase(string2))
                double tmpMedian = 0.0;

                //populate the cellArray with the correct values based on the selected method.
                if (calcMethod.equalsIgnoreCase("conservative")) {
                    //Use conservative median calc, excluding thiscell
                    double[] tmpcellArray = {leftup, rightup, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);
                    //Linking objects, not passing the value!
                    //cellArray = tmpcellArray;

                    //Test
                    //System.out.println("conservative, with median: " + tmpMedian);
                } else if (calcMethod.equalsIgnoreCase("mean")) {
                    //Use mean median calc, include thiscell
                    double[] tmpcellArray = {leftup, rightup, thiscell, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);
                    //Test
                    //System.out.println("mean, with median: " + tmpMedian);

                } else {
                    //Use conservative median calc as the default option to cater for invalid choices
                    double[] tmpcellArray = {leftup, rightup, leftdown, rightdown};
                    //Bubble sort the cellArray and calculate the median
                    tmpMedian = calculateMedian(tmpcellArray);
                    //Linking objects, not passing the value!
                    //cellArray = tmpcellArray;
                    //Test
                    //System.out.println("default, with median: " + tmpMedian);
                }
                //Test the output
                //System.out.println(" | i:" + i + " j:" + j + " -> value " + thiscell + " -> tmpMedian: " + tmpMedian + " ");
                //Assign median value to new array
                medianArray[i-1][j-1] = tmpMedian;
            }
            //System.out.println(" ");
            //Stop here for review
           //System.exit(0);
        }

        return medianArray;

    }

    /**
     * This method computes the median of the values in the input array. 
     * See http://www.calculatorsoup.com/calculators/statistics/descriptivestatistics.php
     * Adapted from http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java
     * to use doubles and less variables
     *
     * @param arr - an array of doubles
     * @return median - the median of the input array
     */
    public static double calculateMedian(double[] arr) {
        // Sort our array
        Sorting.bubbleSort(arr);

        double median = 0;

        // If our array's length is even, then we need to find the average of the two centered values
        if (arr.length % 2 == 0) {
            int indexA = (arr.length - 1) / 2;
            int indexB = arr.length / 2;

            median = ((double) (arr[indexA] + arr[indexB])) / 2;
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
