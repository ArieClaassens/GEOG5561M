/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK.
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
/**
 * Class: Storage.java<br>
 * Version: 1.5 - 17 Nov 2014<br>
 * Overview: The Storage class provides the storage object and its methods that
 * are required for a basic GIS application utilized in the GEOG5561M course
 *
 * @author Arie Claassens
 * <a href="mailto:arieclaassens@gmail.com">arieclaassens@gmail.com</a>
 * @version 1.5 - 17 Nov 2014
 */
public class Storage {

    //define a 300 x 300 array of type double (300 rows by 300 columns)
    double data[][] = new double[300][300];

    /*
     * Mutator method to populate array with data.
     * Returns nothing because we are modifying the object and not a reference to it.
     * @param newData   The placeholder variable used to modify the data[][] array
     */
    /*
     public void setData(double[][] newData) {
     //outer loop for rows
     for (int i = 0; i < newData.length; i++) {
     //inner loop for columns
     for (int j = 0; j < newData[i].length; j++) {
     data[i][j] = newData[i][j];
     }
     }
     }
     */
    //from practical notes - > http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part5/2.html
    public void setData(double[][] dataIn) {
        data = dataIn;
    }

    /*
     * Accessor method to return storage object contents
     * Returns a 2D array of double primitive type
     * Accepts integers to define the startRow, startCol*umn), endRow and endCol(umn) parameters of the method
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     * @return myArray  2D array consisting of double primitive type data
     */
    /*
     public double[][] getData(int startRow, int startCol, int endRow, int endCol) {
     //calculate dimensions of the array to return
     int myrows = endRow - startRow + 1;
     int mycolumns = endCol - startCol + 1;
     double[][] myArray = new double[myrows][mycolumns];
     //outer loop for rows
     for (int i = startRow; i <= endRow; i++) {
     //inner loop for columns
     for (int j = startCol; j <= endCol; j++) {
     myArray[i][j] = data[i][j];
     }
     }
     return myArray;
     }
     */
    //From Practical -> http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part5/2.html
    public double[][] getData() {
        return data;
    }

    /*
     * Additional Accessor method to obtain data from array elements.
     * Returns nothing as we print out the value to console from this method.
     * @param startRow  integer specifying the start row for the method
     * @param startCol  integer specifying the start column for the method
     * @param endRow    integer specifying the end row for the method
     * @param endCol    integer specifying the end column for the method
     */
    public void printData(int startRow, int startCol, int endRow, int endCol) {
        //print out array (to verify cell contents)
        //outer loop for rows
        for (int i = startRow; i <= endRow; i++) {
            //inner loop for columns
            for (int j = startCol; j <= endCol; j++) {
                //print the columnar data on one line
                System.out.print(data[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /*
     * Mutator method to populate array with random data.
     * Accepts and returns nothing
     */
    public void setRandomData() {
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = Math.random() * 1000;
            }
        }
    }

    /*
     * Method to print out the object (array) contents
     * Accepts and returns nothing
     */
    public void printArray() {
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                //print the columnar data on one line
                System.out.print(data[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /*
     * Method to calculate and return the maximum value contained in the array
     * @return A double containing the maximum value found in the array
     */
    public double getMaximum() {
        //calculate the maximum value contained by the array
        //Set the maximum to a negative value in order to ensure that it does 
        //not exceed the potentially largest positive value produced by Math.random()
        double maximum = -1.0;
        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > maximum) {
                    maximum = data[i][j];
                }
            }
        }
        return maximum;
    }
    /*
     * Method to calculate and return the minimum value in array
     * @return A double containing the minimum value found in the array
     */

    public double getMinimum() {
        //calculate the minimum value contained by the array
        //Set the minimum to use the first cell in the array as the initial value. 
        //See http://www.geog.leeds.ac.uk/courses/other/programming/practicals/raster-framework/part3/Analyst.java
        double minimum = data[0][0];

        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //inner loop for columns
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < minimum) {
                    minimum = data[i][j];
                }
            }
        }
        return minimum;
    }

    /*
     * Method to re-range array values to a new minimum and maximum value
     * @param newMinimum A double defining the new minimum value limit
     * @param newMaximum A double defining the new maximum value limit
     * @return 2D double array with the re-ranged values
     */
    // Images are based on arrays containing values between 0 and 255. 
    // To convert our data into an image, we need to re-range it between these two values. 
    // We need a method that will take the data in our array, and stretch or compress the 
    // numbers across a given range, that is, the minimum value matches a new minimum, 
    // the maximum a new maximum, and the rest of the data is spread between them, 
    // proportional to the values in the original dataset. 
    public double[][] getRerangedData(double newMinimum, double newMaximum) {
        // Set up double variables containing currentMaximum and currentMinimum
        double currentMinimum = this.getMinimum();
        double currentMaximum = this.getMaximum();

        // Instantiate a double[][] array called tempArray, and size [data.length][data[0].length]
        double[][] tempArray = new double[data.length][data[0].length];

        //outer loop for rows
        for (int i = 0; i < data.length; i++) {
            //outer loop for columns
            for (int j = 0; j < data[i].length; j++) {
                // tempArray[i][j] = data[i][j]
                tempArray[i][j] = data[i][j];

                // tempArray[i][j] = tempArray[i][j] - currentMinimum (so values between 0 and currentMaximum - currentMinimum)
                tempArray[i][j] = tempArray[i][j] - currentMinimum;

                // tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum) (so values between 0 and 1)
                tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum);

                // tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum) (so values between 0 and newMaximum - newMinimum)
                tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum);

                // tempArray[i][j] = tempArray[i][j] + newMinimum (so values between newMinimum and newMaximum)
                tempArray[i][j] = tempArray[i][j] + newMinimum;
            }
        }
        // return double [][] tempArray 
        return tempArray;
    }

    /*
     * Mutator method to save our object (2D array) data into a 1D array.
     * Accepts a 2D array of type double and retuns a 1D array of the same type
     * @param 2D array of type double
     * @return 1D array of type double
     */
    public double[] get1DArray() {
        //create a reranged array
        double[][] reranged = getRerangedData(0.0, 255.0);

        //Convert 2D array into 1D array:
        int arraySize = reranged.length * reranged[0].length;
        double[] tempArray = new double[arraySize];

        // Outer loop for rows
        for (int i = 0; i < reranged.length; i++) {

            // Inner loop for the columns
            // We would need a different algorithm for varying columnar dimensions.
            // Images are square or rectangular, most of the time, so we will use the following:
            for (int j = 0; j < reranged[0].length; j++) {
                // tempArray[counter] = reranged[i][j];
                // Won't work because array counters start at zero and 0 x any number is zero
                //(reranged[0].length * i) = number of columns processed times the current row counter, e.g. 10 columns x row 2 = 20
                //j = current column
                tempArray[(reranged[0].length * i) + j] = reranged[i][j];
            }
        }
        // return double[] tempArray 
        return tempArray;

    }
}
