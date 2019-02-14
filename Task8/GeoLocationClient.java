// CSE142 Section: B
// 11/27/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #8(GeoLocationClient)
//
/* This client program prints out the locations of different places and the
   distance from each other.*/

public class GeoLocationClient {
   public static void main(String[] args) {
      
      GeoLocation g1 = new GeoLocation(34.988889, -106.614444);
      System.out.println("the stash is at " + g1);    
      
      GeoLocation g2 = new GeoLocation(34.989978, -106.614357);
      System.out.println("ABQ studio is at " + g2);     

      GeoLocation g3 = new GeoLocation(35.131281, -106.61263);
      System.out.println("FBI building is at " + g3);     

      System.out.println("distance in miles between:");
      
      System.out.println("    stash/studio = " + g1.distanceFrom(g2));      
      System.out.println("    stash/fbi    = " + g1.distanceFrom(g3)); 
   }
}