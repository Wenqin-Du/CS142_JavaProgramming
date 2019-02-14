// Compares an inputted user first and last name against mine
// to see whether either their first or last is the same.
// Illustrates methods that return booleans, and some boolean expressions

import java.util.*;

public class Setion_5_3_2boolean_NameComparison {
   public static void main(String[] args) {
      String firstName = "Wenqin";
      String lastName = "Du";
      
      Scanner console = new Scanner(System.in);
      System.out.print("Please enter your name (First Last): ");
      String userFirstName = console.next();
      String userLastName = console.next();
      
      //(firstName == userFirstName) no == on Strings, BAD!
      // firstName.equals(userFirstName) TREMENDOUS! Much improved
      
      if ( sameName(firstName, lastName, userFirstName, userLastName) ) {
         System.out.println("Hey, we have the same name!");
      } else {
         System.out.println("Our names are different.");      
      }
   }
   
   // Takes four Strings as parameters and returns whether either 
   // the two first names or last names are the same, ignoring case
   public static boolean sameName(String first1, String last1, String first2, String last2) {
      return first1.equalsIgnoreCase(first2) || last1.equalsIgnoreCase(last2);
   }
   
}