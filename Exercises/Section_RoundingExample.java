// An example of rounding doubles after the decimal place
public class Section_RoundingExample {
   public static void main(String[] args) {
      double d = 12.34567;
      // goal: round to 12.3
      // trick: 
      //   - multiply by 10.0,
      //   - round off everything after the decimal, 
      //   - divide by 10.0 to get back where we started, without the extra
      // round(12.34567 * 10.0) / 10 ::> 123 / 10.0 ::> 12.3
      System.out.println("d = " + d); 
      d = Math.round(d * 100.0) / 100.0;
      System.out.println("d = " + d);
      
      System.out.println(roundTo(5.668732, 3));
   }

   // NOTE: you may include either of the following methods
   //       in your a4 Gradanator assignment. They are helpful
   //       to format some of the output. You may alternatively
   //       use printf()
   
   // rounds the given double to the given number of decimal places
   public static double roundTo(double d, int digits) {
      return Math.round(d * Math.pow(10, digits)) 
                /   Math.pow(10, digits);
   }

   // rounds the given double to 1 decimal place
   public static double round(double d) {
      return Math.round(d * 10.0) / 10.0;
   }
}