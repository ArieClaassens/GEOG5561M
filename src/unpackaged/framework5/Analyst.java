/*
 * Copyright (C) 2014 Arie Claassens <arieclaassens@gmail.com>
 * Johannesburg, South Africa
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
 * Class:   Analyst.java <br>
 * Version: 1.5 <br>
 * Date:    17 Nov 2014<br>
 * Overview:The Analyst class provides the framework for a basic GIS application utilized in the GEOG5561M course<br>
 * 
 * @author Arie Claassens <a href="mailto:arieclaassens@gmail.com">arieclaassens@gmail.com</a>
 * @version 1.5 - 17 Nov 2014
 */

public class Analyst {
	
    /**
     *
     */
    public Analyst () {
		/*
                 * Instantiate new Storage object called store
                 */
		Storage store = new Storage();
		
		/*
                 * Populate the Storage object (array) with random data
                 */
		store.setRandomData();
		
		/*
                 * Print out the Storage object (array) contents
                 */
		store.printArray();
		
		//spacer between the array print out and the tests below
		System.out.println("");
			
		/*
                 * Calculate the maximum value in the array
                 */
		double max = store.getMaximum();
		
		//Print out the maximum value in the array
		System.out.println("Maximum is: " + max);
		
		/*
                 * Calculate the maximum value in the array and print it out
                 */
		double min = store.getMinimum();
		
		//Print out the minimum value in the array
		System.out.println("Minimum is: " + min);
	}

    /**
     *
     * @param args the command line arguments
     */
    public static void main (String args[]) {
		new Analyst ();
	}
}
