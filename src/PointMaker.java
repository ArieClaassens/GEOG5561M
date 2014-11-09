public class PointMaker {

   // Why do you think these variables need to be static?
   private static double minX = 0.0;
   private static double maxX = 1000.0;
   private static double minY = 0.0;
   private static double maxY = 1000.0;

   private PointMaker() {}

   public static Point makePointWithin(double left, double bottom, double right, double top) {

      double x = (Math.random() * (maxX - minX)) + minX;
      double y = (Math.random() * (maxY - minY)) + minY;

      if (((x > left) && (x < right)) &&
       ((y > bottom) && (y < top))) {

         return new Point(x, y);

      } else {
          return null;
    	  //make point anyway, to test point generation  
    	  //return new Point(x, y);
      		}

   }
}