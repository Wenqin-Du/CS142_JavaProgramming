// CSE142 Section: B
// 11/27/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #8(PlaceInformation)
//
/* This class stores information about a place, including name, address, tag
   and location. Locations are specified using latitude and longitude.  The 
   class includes methods to manipulate the information and calculate the 
   distance between the place and other spots.*/

public class PlaceInformation {
      
   private String name;
   private String address;
   private String tag;
   private GeoLocation place;
    
   // constructs PlaceInformation object with name, address, tag and location
   public PlaceInformation(String name, String address, String tag,
                        double latitude, double longitude) {
      this.name = name;
      this.address = address;
      this.tag = tag;
      this.place = new GeoLocation(latitude, longitude);
   }

   // returns a reference to the GeoLocation object above
   public GeoLocation getLocation() {
      return place;
   }  
   
   // returns a string representation of the location of the place
   public String toString() {
       return name + " (latitude: " + place.getLatitude() + ", longitude: " + 
              place.getLongitude() +")";
   }
   
   // returns a string representation of the name of the place
   public String getName() {
      return name;
   }
   
   // returns a string representation of the address of the place
   public String getAddress() {
      return address;
   }
   
   // returns a string representation of the address of the place
   public String getTag() {
      return tag;
   }

   // returns the distance between the place and other spots
   public double distanceFrom(GeoLocation spot) {
      return place.distanceFrom(spot);
   }
}
