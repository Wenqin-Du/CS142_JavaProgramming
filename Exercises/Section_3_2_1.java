public class Section_3_2_1 {
   public static void main(String[] args) {
      // Since 00:00:00:000 Jan 1, 1970
      long millis = System.currentTimeMillis();
      
      // call the new method we defined -- ask it to calculate
      // the conversion for us, and when it's done, it brings
      // back the answer, so we go ahead as save that into
      // a variable named days.
      double days = millisToDays(millis);
      
      System.out.println("The current time is : " + millis);
      System.out.println("For humans, that's " + days + " days.");
   }

   // Converts milliseconds to days
   public static double millisToDays(long millis) {
      // no need to save the expression in a variable here like this:
      //double daysForMillis = millis / 1000.0 / 60.0  / 60.0 / 24.0;
      //return daysForMillis; 
      
      // can just return the result of the expression, like this:
      return millis / 1000.0 / 60.0  / 60.0 / 24.0;      
   }
}