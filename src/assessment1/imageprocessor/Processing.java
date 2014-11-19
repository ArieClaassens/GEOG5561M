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
 */
package imageprocessor;

/**
 * This class provides the image processing methods required by the GIS
 * application
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
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

        //Instantiate our new array of median values
        double medianArray[][] = new double[srcArray.length-2][];

        //outer loop for rows; to what index?
        for (int i = 1; i < srcArray.length-1; i++) {
            //inner loop for columns; to what index?
            for (int j = 1; j < srcArray[i].length-1; j++) {
                //medianArray[i-1][j-1] = srcArray[i][j];
                //instantiate method variables that will store diagonal neighbour and target cell values
                double leftup = 0;
                double rightup = 0;
                double thiscell = 0;
                double leftdown = 0;
                double rightdown = 0;
                
                thiscell = srcArray[i][j];
                leftup = srcArray[i-1][j-1];        //One row up and one column left. Both negative values, relative to current position
                rightup = srcArray[i-1][j+1];       //One row up and one column right. Negative row value and positive column value, relative to current position
                leftdown = srcArray[i+1][j-1];      //One row down and one column left. Positive row value and negatoive column value, relative to current position
                rightdown = srcArray[i+1][j+1];     //One row down and one column right. Both positive values, relative to current position
                
                //Instantiate array with cell values for median processing and hardwire with 
                //values obtained in this inner loop
                double[] cellArray = {leftup,rightup,thiscell,leftdown,rightdown};
                //Test
                System.out.println(cellArray);
                //Test the output
                //System.out.print(" | i:" + i + " j:" + j + " -> value " + thiscell + " ");
            }
            System.out.println(" ");
        }

    //Implement  Median Filtering with a Diagonal Neighbourhood, using a Bubble Sort
        // Median filtering
        //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/median.html
    //Diagonal Neighbourhood with radius 1
        //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/neighbourhoods.html
    //Conservative Median Filter - central cell is excluded from calculations
        //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/conservative.html
        //Conservative filtering is an image processing methodology for removing high frequency noise from images.
    //Mean Median Filter - central cell is usually included in calculations
        //http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/mean.html
        //Mean filtering is an image processing methodology for removing high frequency noise from images.
        /*
         Pseudo-code:
         generate a new array of the same(?) dimension as the source array. 
         How are we to handle boundaries? Lose 1 cell in each direction (top, bottom, left & right) 
         and know that we're working with valid data. See chapter 2, Looping through arrays.
         ONLY process cells that can have complete processing (Suitable for image processing), p20 of my notes.
    
         This means that we will need to start our processing offset by the radius distance from the start, so if radius is 1,
         we need to start 1 row down and 1 column right from [0][0]. The radius needs to be parameterised in this processing method 
         so that we can pass radii of varying sizes to analyze the impact on the image. For higher marks too.
         Input validation: is this an int and is it less than say 25% of image size? 
         If not an int, but can be cast as an int, e.g. byte/double/long/etc. convert it.
         If a string, set it to a default of 1 and raise an error, or just catch the error and stop processing?
    
         We also need to parameterise the value calculations, providing either a Conservative or Mean calculation option. 
         This will also allow us to analyze the impact on the image. For higher marks too.
         Use a switch to provide options or if/else ladder? Only two options available, so if/else will be OK and 
         we can put in a default choice. 50% chance of choosing our default one.
    
         Set up an array loop that processes the supplied array:
         //
         Instantiate a new array with method scope, of the dimension: tmpArray[srcArray.length-2][]
         Start looping from srcArray[1][1] to srcArray[srcArray.length-1][srcArray.length[srcArray.length-1]-1]
         This will see us process cell data one row and one column away from the boundaries across the whole process.

         Inside this loop, create a new loop/storage object that will collect the cell values from the following 
         relative positions:
         for position srcArray[i][j]:
         srcArray[i-1][j-1] Up and Left
         srcArray[i-1][j+1] Up and Right
         srcArray[i+1][j-1] Down and Left
         srcArray[i+1][j+1] Down and Right

         Calculate the MEDIAN value, depending on the calculation option selected:
    
         //See http://pages.cs.wisc.edu/~cs302-5/resources/examples/MeanMedianMode_Methods.java
         //calculates the median wrong
         Median value is the middle number in a sorted list, so for
    
         //Convert string to lowercase to simplify validation
         if (calcMethod.toLowerCase() == "conservative") {
         //Use conservative median calc
    
         } else if (calcMethod.toLowerCase() == "mean"){
         //Use mean median calc
    
         } else {
         //Use conservative median calc
    
         }
    
         Conservative:
         Bubble sort the 4 values, take the middle two, add them and divide by two to find their middle value
         Use the Math.Round() function to produce more accurate values.
         Take note that Java 6 has an issue with Math.Round(), implementing it as a floor and not ceiling calculation.
         See http://stackoverflow.com/questions/9902968/why-does-math-round0-49999999999999994-return-1?lq=1
         position of median element => [((newArray.length)/2)] + [((newArray.length)/2)+1] (Middle of 4 is 2 & 3)
    
         Mean:
         Bubble sort the 5 values and take the middle one
         position of median element => ((newArray.length-1)/2)+1 (Array length -1, divided by 2, plus 1) 
         //
    
         Assign the new, median, value to our tempArray and repeat the process untill we reach the last row and column available 
         for processing.
         */
        //return the array with median values
        return medianArray;

    }

}
