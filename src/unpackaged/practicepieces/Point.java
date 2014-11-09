/*
* Class:	Point
* Version:	1.1
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/

public class Point {
	public int x = 0;
	public int y = 0;
	public String name = "myName";
	
	//Mutator method to change x value
	public void setX (int newx) {
		x = newx;
	}
	
	//Accessor method to return x value
	public int getX() {
		return x;
	}

	//Mutator method to change y value
	public void setY (int newy) {
		y = newy;
	}
	
	//Accessor method to return y value
	public int getY() {
		return y;
	}
	
	//Mutator method to change name value
	public void setName (String newname) {
		name = newname;
	}
	
	//Accessor method to return name value
	public String getName() {
		return name;
	}
}
