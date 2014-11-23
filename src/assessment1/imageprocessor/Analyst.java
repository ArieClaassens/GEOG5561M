/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 * 
 * Please view readme.txt for full copyright and app details
 */
package imageprocessor;

/**
 * Class: Analyst.<br>
 * This class provides a basic GIS image processing application. 
 * A source image is manipulated to produce an image generated from the median
 * values of each cell, using diagonal neighbors with a radius ranging from 1 to 
 * a predefined maximum. The maximum limit may be adjusted in the Processing 
 * class file by increasing or decreasing the maxRadius value.
 *
 * @author Student 200825599 
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */

public class Analyst {

    public Analyst() {
        /**
         * Instantiate two Storage objects, used to store the original and final
         * images, and a DataReader object through which to obtain image data.
         * 
         */
        Storage store = new Storage();
        Storage store2 = new Storage();
        DataReader data = new DataReader();

        /**
         * Instantiate and populate myArray with the image data.
         */
        double[][] myArray = data.getData();

        //copy values from data to store
        store.setData(myArray);
       
        /**
         * Display the pre-processing image
         */
        //CHANGE THIS TO DYNAMIC RANGE, DEFINED AUTOMATICALLY BY ARRAY DIMENSIONS!!!!!
        Display a = new Display("Original Image", store.getData(0, 0, 299, 299), 200, 250);
        
        /**
         * Image processing
         */
       
        //Instantiate new array to store median values and define number of rows
        double[][] medianArray = new double[myArray.length-1][];
        
        //Call method to generate median processing and cast array to int
        medianArray = Processing.getMedianArray(myArray,-10,"Mean");
        //copy values from data to store
        store2.setData(medianArray);
      
        
        /**
         * Display the post-processing image to visually check on impact of 
         * image processing tasks
         */
        //CHANGE THIS TO DYNAMIC RANGE, DEFINED AUTOMATICALLY BY ARRAY DIMENSIONS!!!!!
        //Display b = new Display("Processed Image", store2.getData(0, 0, medianArray.length, medianArray.length));
        Display b = new Display("Processed Image", store2.getData(0, 0, medianArray.length, medianArray.length), 600, 250);
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Analyst();
    }
}
