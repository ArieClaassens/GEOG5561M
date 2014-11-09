/*
* Class:	Land
* Version:	1.0
* Author: 	Arie Claassens
* Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
* Copyright notice
*/
public class Land extends Point{
	//extends the Point Class by adding an owner variable to the method
	public String owner = "Land Owner";
	
	//Mutator method to change owner value
	public void setOwner (String newowner) {
		owner = newowner;
	}
	
	//Accessor method to return owner value
	public String getOwner() {
		return owner;
	}
}
