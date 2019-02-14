// This program demonstrates a couple good usages of if/else,
// and returning values from methods.
import java.util.*;

public class Section_4_1_1 {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("give me an int-> ");
      int n = console.nextInt();
      n = update(n);
      System.out.println("updated n = " + n);
      System.out.println();

      n = update2(n);
      System.out.println("updated n = " + n);
   }

   // This method updates the value of n. 
   public static int update(int n) {
      if (n < 0) {
         n++;
      } else if (n == 0) {
         n = 1000;
      } else { // if (n > 0)
         n--;
      }
      return n;
   }
   
   // This method performs a "special" update that either 
   // adds 42 to n (for negatives) or subtracts 13 from n 
   // (for non-negatives).
   public static int update2(int n) {
      System.out.println("special update in progress");
      int change = 0;   
      if (n < 0) {
         change = 42;
      } else { // if (n >= 0) 
         change = -13;
      }
      n = n + change;
      System.out.println("updated by " + change);
      return n;
   }
}
