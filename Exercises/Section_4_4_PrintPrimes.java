// An example of a fencepost loop. countFactors is a good example of a 
//  cumulative algorithm to count the number of factors that a given
//  number has.
public class Section_4_4_PrintPrimes {
   public static void main(String[] args) {
      // testing code: 
      // countFactors(2);
      // countFactors(24);
      
      printPrimes(1);
      printPrimes(2);
      printPrimes(51);
   }
   
   public static void printPrimes(int number) {
      // start a counter at 1, increment it until it reaches number
      //     check if the current number i'm looking at is 
      //     prime
      //   if it is, 
      //     print it out
      if (number >= 2) {
         System.out.print(2);
         for (int i = 3; i <= number; i++) {
            if ( countFactors(i) == 2 ) {
               System.out.print(", " + i);
            }
         }
         System.out.println();
      }
   }
   
   public static int countFactors(int number) {
      // start a counter at 1 and increment until 'number',
      // divide the number by i, if it's an integer
      int factors = 0;
      for (int i = 1; i <= number; i++) {
         if (number % i == 0) {
            factors++;
         }
      }      
      return factors;
   }
}