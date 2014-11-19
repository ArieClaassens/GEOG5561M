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
 * This class provides a basic GIS image processing application. A source image
 * is manipulated to produce XXXXXXXXXX
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 */
/**
 * We will imagine that we are dealing with a single band of data (details of
 * bands); that is, a single file of data values in a 2D array. As we haven't
 * yet dealt with reading files, We've written you a class that replicates the
 * reading process by passing out a 2D double data array: DataReader.java. To
 * get the data from it, make an object from the class in your Analyst class and
 * call the DataReader's getData() method. You may also be interested in this
 * info on checking your array visually.
 */
public class Analyst {

    public Analyst() {
        /**
         * Instantiate new Storage object called store
         */
        Storage store = new Storage();
        Storage store2 = new Storage();
        DataReader data = new DataReader();

        //Check store object contents
        //store.printArray();
        /**
         * Populate the Storage object (array) with image data
         */
        double[][] myArray = data.getData();
        
        // NEED TO CONVERT DOUBLE ARRAY TO INT ARRAY
        // IMAGES ONLY USE INTEGER VALUES????
        // APPLY CHANGES TO METHODS AS WELL, WHERE NEEDED

        /*
         //Print out the resultsArray contents
         //outer loop for rows
         for (int i = 0; i < myArray.length; i++) {
         //inner loop for columns
         for (int j = 0; j < myArray[i].length; j++) {
         //Print out array elements by row, with newline at the end of each inner loop

         System.out.print(myArray[i][j] + " ");
         }
         System.out.println(" ");
         }
         System.out.println(" ");
         */
        //copy values from data to store
        store.setData(myArray);

        //Bubble sort trail run
        //int[] mynumbers = {5, 188, 14, 171, 56, 9000, 1, 12};
        //Sorting.bubbleSort2(mynumbers);
        
        
        //Check store object contents
        //store.printArray();
        
        /**
         * Display the pre-processing image
         */
        //CHANGE THIS TO DYNAMIC RANGE, DEFINED AUTOMATICALLY BY ARRAY DIMENSIONS
        Display a = new Display("Original Image", store.getData(0, 0, 299, 299));
        
        /**
         * Image processing
         */
        //PROCESSING IS DONE HERE
        //int mya = (int)(200.0 + 203)/2;
        //System.out.println("int mya is now: " + Math.round(mya));
        
        //double mya2 = (200.0 + 203)/2;
        //System.out.println("int mya2 is now: " + Math.round(mya2));
        
        //Instantiate new array to store median values and define number of rows
        double[][] medianArray = new double[myArray.length-1][];
        
        //Call method to generate median processing and cast array to int
        medianArray = Processing.getMedianArray(myArray,1,"Conservative");
        //copy values from data to store
        //store2.setData(medianArray);
        //int medianArray[][] =Processing.getMedianArray(newArray,1,"Conservative");
        
        
        /**
         * Display the post-processing image to visually check on impact of 
         * image processing tasks
         */
        Display b = new Display("Processed Image", store2.getData(0, 0, 298, 298));
        
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Analyst();
    }
}
