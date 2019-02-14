// An example of using our improved Point2 class:
//
// Calls various types of Point2 constructors,
// also leverages the fact that Point2 objects
// override the toString() method, making for
// easy use in println()s and String concatenation
public class PointClient2 {
   public static void main(String[] args) {
      // call no-parameter constructor to start at origin
      Point2 p1 = new Point2();
      // Since Point2 defines a good toString(), simply add
      // our object variable to a String to get a String
      // representation of our Point2 object:
      System.out.println("p1 = " + p1);    
      
      Point2 p2 = new Point2(15, 30);
      System.out.println("p2 = " + p2);    

      // call no-parameter constructor to start at origin
      Point2 p3 = new Point2(); 

      
      double p1Dist = p1.distanceFromOrigin();
      System.out.println("p1 dist = " + p1Dist);      
      System.out.println("p2 dist = " + p2.distanceFromOrigin());
      
      p1.translate(3, 10);
      System.out.println("p1 = " + p1);    
      
   }
}