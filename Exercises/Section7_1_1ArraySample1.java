// This class contains several small examples of array manipulation.  

import java.util.*;

public class Section7_1_1ArraySample1 {
   public static void main(String[] args) {
      // below are two examples of an array initializer
      //              0  1  2  3  4    5   6   7   8
      int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
      
      //                  0        1       2      3         4       5
      String[] words = {"four", "score", "and", "seven", "years", "ago", "100"};
      // {"ago", "years", "seven", "and", "score", "four"};

      System.out.println("before reverse, words contains : " + Arrays.toString(words));
      reverse(words);
      System.out.println("after reverse, words contains : " + Arrays.toString(words));
         
      int sum = sum(primes);
      System.out.println("sum = " + sum);

      System.out.println("before modify, primes contains: " + Arrays.toString(primes)); 
      modify(primes);
      System.out.println("after modify, primes contains: " + Arrays.toString(primes)); 
   
      mystery();  
   }

   // changes some values inside the array. Note that in this situation, we don't have 
   // to return the modified array: the underlying array changed both here, and in main()
   public static void modify(int[] values) {
      values[4] = 1337;
      values[6] = 1001;
   } 
      
   public static int sum(int[] values) {
      int sum = 0;
      for (int i = 0; i < values.length; i++) {  // Strings : s.length()
         sum += values[i];
      }
      return sum;
   }
   
   // reverses the order of the elements in the given array
   public static void reverse(String[] values) {
      // swap 0 with 5
      // swap 1 with 4
      // swap 2 with 3
      for (int i = 0; i < values.length / 2; i++) {
         // set words[i] to words[words.length - i - 1]
         // set words[words.length - i -1 ] to be words[i]
         String temp = values[i];
         values[i] = values[values.length - i - 1];
         values[values.length - i - 1] = temp;       
      }
   }
   
   // an example of an array mystery problem -- there will a problem
   // like this on the final
   public static void mystery() {
      int[] a = {1, 7, 5, 6, 4, 14, 11};
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] > a[i + 1]) {
            a[i + 1] = a[i + 1] * 2;
         }
      }
      System.out.println("mystery array = " + Arrays.toString(a));
   }
}