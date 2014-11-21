/*
 * Copyright (C) 2014 Student 200825599: <a href="mailto:gy13awc@leeds.ac.uk">gy13awc@leeds.ac.uk</a>
 * University of Leeds, Leeds, West Yorkshire, UK. LS2 9JT
 * All rights reserved.
 *
 * Please view readme.txt
 */
package imageprocessor;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.MemoryImageSource;

/**
 * Class: Display This class provides a visual display method for the GIS image
 * processing application. It is used to generate a visual representation of the
 * array data supplied to the Display class.
 *
 * @author Arie Claassens:
 * <a href="http://www.arie.co.za/">http://www.arie.co.za/</a>
 * @version 1.0
 */
// The following code was altered from that at http://www.geog.leeds.ac.uk/courses/other/programming/odl-core/assessment1/Display.java
// Code formatting changes were applied to reduce the file size and improve readability in NetBeans
public class Display extends Frame {

    Image image = null;

    public Display(String title, double[][] dataIn) {

        double[][] temp2DArray = rerangeArray(0, 255, dataIn);
        double[] temp1DArray = get1DArray(temp2DArray);
        int[] temp1DIntArray = get1DIntArray(temp1DArray);
        image = getImage(temp1DIntArray, dataIn[0].length, dataIn.length);
        this.setSize(dataIn[0].length, dataIn.length);
        this.setTitle(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ((Frame) e.getSource()).dispose();
            }
        });
        this.setVisible(true);

    }

    public void paint(Graphics gc) {
        gc.drawImage(image, 0, 0, this);
    }

    double[][] rerangeArray(double newMinimum, double newMaximum, double[][] dataIn) {
        double currentMaximum = getMaximum(dataIn);
        double currentMinimum = getMinimum(dataIn);
        double[][] tempArray = new double[dataIn.length][dataIn[0].length];

        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                tempArray[i][j] = dataIn[i][j];
                tempArray[i][j] = tempArray[i][j] - currentMinimum;
                if (tempArray[i][j] != 0) {
                    tempArray[i][j] = tempArray[i][j] / (currentMaximum - currentMinimum);
                }
                tempArray[i][j] = tempArray[i][j] * (newMaximum - newMinimum);
                tempArray[i][j] = tempArray[i][j] + newMinimum;
            }
        }
        return tempArray;

    }

    double[] get1DArray(double[][] dataIn) {
        double[] tempArray = new double[dataIn.length * dataIn[0].length];

        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                tempArray[(i * dataIn[0].length) + j] = dataIn[i][j];
            }
        }
        return tempArray;
    }

    int[] get1DIntArray(double[] dataIn) {
        int[] tempArray = new int[dataIn.length];
        for (int i = 0; i < dataIn.length; i++) {
            tempArray[i] = (new Double(dataIn[i])).intValue();
        }
        return tempArray;

    }

    Image getImage(int[] uncompressed, int width, int height) {
        int[] compressed = new int[uncompressed.length];
        for (int i = 0; i < uncompressed.length; i++) {
            compressed[i] = (new Color(uncompressed[i], uncompressed[i], uncompressed[i])).getRGB();
        }
        MemoryImageSource mis = new MemoryImageSource(width, height, compressed, 0, width);
        return this.createImage(mis);
    }

    double getMaximum(double[][] dataIn) {
        double maximum = -1.0;
        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                if (dataIn[i][j] > maximum) {
                    maximum = dataIn[i][j];
                }
            }
        }
        return maximum;
    }

    double getMinimum(double[][] dataIn) {
        double minimum = getMaximum(dataIn);
        for (int i = 0; i < dataIn.length; i++) {
            for (int j = 0; j < dataIn[i].length; j++) {
                if (dataIn[i][j] < minimum) {
                    minimum = dataIn[i][j];
                }
            }
        }
        return minimum;
    }
}
