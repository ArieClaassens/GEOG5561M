/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 *
 * Please view readme.txt
 */
package imageprocessor;

/**
 * Class: Analyst
 * This class provides a basic GIS image processing application. 
 * A source image is manipulated to produce an image generated from the median
 * values of each cell, using diagonal neighbors with a radius of 1.
 *
 * @author Student 200825599:
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */

public class Analyst {

    public Analyst() {
        /**
         * Instantiate new Storage object called store
         */
        Storage store = new Storage();
        Storage store2 = new Storage();
        DataReader data = new DataReader();

        /**
         * Populate the Storage object (array) with image data
         */
        double[][] myArray = data.getData();

        //copy values from data to store
        store.setData(myArray);
       
        /**
         * Display the pre-processing image
         */
        //CHANGE THIS TO DYNAMIC RANGE, DEFINED AUTOMATICALLY BY ARRAY DIMENSIONS!!!!!
        Display a = new Display("Original Image", store.getData(0, 0, 299, 299));
        
        /**
         * Image processing
         */
       
        //Instantiate new array to store median values and define number of rows
        double[][] medianArray = new double[myArray.length-1][];
        
        //Call method to generate median processing and cast array to int
        medianArray = Processing.getMedianArray(myArray,1,"Conservative");
        //copy values from data to store
        store2.setData(medianArray);
      
        
        /**
         * Display the post-processing image to visually check on impact of 
         * image processing tasks
         */
        //CHANGE THIS TO DYNAMIC RANGE, DEFINED AUTOMATICALLY BY ARRAY DIMENSIONS!!!!!
        //Display b = new Display("Processed Image", store2.getData(0, 0, medianArray.length, medianArray.length));
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
