import java.util.*;

public class Section6_1_2TokenBasedSum {
   public static void main(String[] args) {
      Scanner input1 = new Scanner("38  4 19 -27 -15 -3 4 19 38");
      Scanner input2 = new Scanner("14 7 -10 9 -18 -8 17 42 98");
      checkNegativeSum(input1);
      System.out.println();
      checkNegativeSum(input2);
   }
   
   public static void checkNegativeSum(Scanner input) {
      int sum = 0, count = 0;
      boolean found = false;
      while (input.hasNextInt() && !found) {
         int next = input.nextInt();
         sum += next;
         count++;
         if (sum < 0){
            found = true;
         }
      }
      if (found) {
         System.out.println("Negative sum after " + count + " steps");
      } else {
         System.out.println("No negative sum found");
      }
      System.out.println("Sum = " + sum);
   } 
}