import java.util.*;

public class Section_3_3_1ScannerExample {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      int sum = 0;
      for (int i = 1; i <= 3; i++) {
         System.out.print("Please type an int: ");
         int x = console.nextInt();
         sum += x;
         // get a number from the user
         // add it to the current value of "sum"
      }
      System.out.println("The sum of those three numbers is: " + sum);
   }
}