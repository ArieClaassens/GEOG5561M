public class GIS {
   public static void main (String args[]) {

      Point[] points = new Point[100];
      //add my own counter to keep track of number of pointmaker attempts
      int j = 1;
      for (int i = 0; i < points.length; i++) {

    	  //run the pointmaker code untill the Math.random() dependent code generates values large enough
    	  //to pass the limitation checks
    	  
         do {
            //System.out.println("Trying...");
        	 System.out.println("Trying... " + j + " times to use makePointWithin() to create a 100 valid points");
        	 j++;
            points[i] = PointMaker.makePointWithin(100,100,300,300);
         } while (points[i] == null);

         System.out.println("Point " + i + " made, x = " + points[i].getX() + " y = " + points[i].getY());
      }

   }
}




