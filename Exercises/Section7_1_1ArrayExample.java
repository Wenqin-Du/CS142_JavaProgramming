// Demonstrates usage of an array of ints, used to store ages and print
// out a message about each sibling.
public class Section7_1_1ArrayExample {
   public static void main(String[] args) {
      int[] ages = new int[4];      
      ages[0] = 32;        
      ages[1] = 30;       
      ages[2] = 27;
      ages[3] = 23;
      // index:   0   1   2   3
      // ages: [ 32, 30, 27, 23 ]

      printAges("Brand", ages);
   }
   
   public static void printAges(String familyName, int[] ages) {
      for (int i = 0; i < ages.length; i++) {
         System.out.println(familyName + " child # " + i + " is " + ages[i] + " years old.");
      }
   }
}