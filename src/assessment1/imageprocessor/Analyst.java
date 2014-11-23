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
 * The median values of the source image cells, calculated using diagonal neighbors 
 * with a user-supplied radius, are used to generate a new image. The radius maximum 
 * may be adjusted by modifying the maxRadius value in the Processing class.
 *
 * @author Student 200825599 
 * <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * @version 1.0
 */

public class Analyst {

    public Analyst() {
        /**
         * Instantiate two Storage objects, used to store the images, and a 
         * DataReader object through which to obtain image data. 
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
         * Display the pre-processing image in a predefined position
         */
        Display a = new Display("Original Image", store.getData(0, 0, myArray.length-1, myArray.length-1), 200, 250);
        
        /**
         * Image processing
         */
       
        //Instantiate new array to store the median values
        double[][] medianArray = new double[myArray.length-1][];
        
        /**
         * Populate the median array, specifying the source array, radius and 
         * median algorithm selection, i.e Conservative or Mean.
         */
        medianArray = Processing.getMedianArray(myArray,-2,"Mean");
        
        //copy values from data to store
        store2.setData(medianArray);
      
        /**
         * Display the post-processing image in a predefined position to verify 
         * the processing code
         */
        Display b = new Display("Processed Image", store2.getData(0, 0, medianArray.length-1, medianArray.length-1), 600, 250);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Analyst();
    }
}
