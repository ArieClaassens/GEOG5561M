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
 * Class: Analyst.java <br>
 * Version: 1.6 <br>
 * Date: 26 Nov 2014<br>
 * Overview:The Analyst class provides the framework for a basic GIS application
 * utilized in the GEOG5561M course<br>
 *
 * @author Arie Claassens
 * <a href="mailto:arieclaassens@gmail.com">arieclaassens@gmail.com</a>
 * @version 1.6 - 24 Nov 2014
 */
public class Analyst {

    public Analyst() {
        Storage store = new Storage();
        // Our Analyst code this practical will go here.
        //Instantiate new IO object
        IO io = new IO();
        //Populate store object with data from io object
        store.setData(io.readData());
        
        //Output data from store object via io writeData method
        io.writeData(store.data);
        
        /*
         Once you've got that done, test it works and you're done.

        You might like to replace the hardwired file locations with FileDialogs,
        one with its constructor's mode set to FileDialog.LOAD and the other 
        FileDialog.SAVE. Again, the code is in the lecture slides; you'll need 
        to import java.awt.* to use FileDialogs.

        You might also want to see if you can mess around with the data before 
        you write it to the file, for example, using the rerangeArray code. 
        When you're happy with your code, you're done.

        */
        
    }

    public static void main(String args[]) {
        new Analyst();
    }

}
