// An example of String processing -- uses charAt and substring()
//  to pull a given name apart to change the text, and add in more text.
import java.util.*; // for Scanner

public class Section_3_3_Strings {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("Type in your name, playa: ");
      String name = console.nextLine();
      System.out.print("(M)ale or (F)emale? ");
      String gender = console.nextLine();
      
      String gangstaName = gangstaName(name, gender);
      
      System.out.println("Gangsta name = " + gangstaName);
   }

   // (last digits of) character indexes for my name:
   // 01234567890123
   // Whitaker Brand
   public static String gangstaName(String name, String gender) {
      // make all the various pieces of the String that we are trying
      // to construct...
      String initial = name.charAt(0) + "."; // W.
      String firstName = name.substring(0, name.indexOf(" ")); // Whitaker
      String lastName = name.substring(name.indexOf(" ") + 1).toUpperCase(); // BRAND
   
      // assumes the user will either type in M or m or F or f
      String addIn;
      if (gender.equalsIgnoreCase("m")) {
         addIn = "Daddy";         
      } else { // (gender.equalsIgnoreCase("f")) {
         addIn = "Goddess";
      }
      
      // ... and then put it all together, and return it!
      return initial + " " + lastName + " " + addIn + " " + firstName + "-izzle";
   }
}