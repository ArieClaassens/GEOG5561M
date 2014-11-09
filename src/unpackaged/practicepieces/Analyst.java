/*
 * Class:	Analyst
 * Version:	1.2
 * Author: 	Arie Claassens
 * Date:		GEOG5561M Oct-Dec 2014 (22 Oct 2014)
 * Copyright notice
 */
public class Analyst {

	public static void main(String[] args) {
		//create new storage variable
		Storage store = new Storage();

		//populate storage with point data
		store.data[0][0] = new Land();
		store.data[0][0].setX(0); //doesn't work. figure out later why. Scope. made all public and it worked. Now reduce scope
		//store.data[0][0].x = 0;
		store.data[0][0].setY(0);
		store.data[0][0].setName("Point Zero");
		store.data[0][0].setOwner("Arie");

		store.data[1][0] = new Land();
		store.data[1][0].setX(1);
		store.data[1][0].setY(1);
		store.data[1][0].setName("Point One");
		store.data[1][0].setOwner("Arie Willem");

		store.data[2][0] = new Land();
		store.data[2][0].setX(2);
		store.data[2][0].setY(2);
		store.data[2][0].setName("Point Two");
		store.data[2][0].setOwner("Arie Willem Claassens");

		System.out.println(store.data[2][0].name + " location -> x: " + store.data[2][0].x + " y: " + store.data[2][0].y + " is owned by " + store.data[2][0].owner);
	}

}
