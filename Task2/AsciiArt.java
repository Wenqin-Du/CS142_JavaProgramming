// CSE142 Section: B
// 9/10/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #2(text art)
//
/* This program will produce a figure of a girl. It contains a head, body 
   and legs. I draw it using nested for loops. */
   

public class AsciiArt {
   public static void main(String[] args) {
   drawHead();
   drawBody();
   drawLegs();
   }
   
   // produce the head of the girl   
   public static void drawHead() {
      for (int i = 1; i <= 3; i++) {
         for (int j = 1; j <= 3; j++) { 
            System.out.print(" ");
         }
         for (int j = 1; j <= 3; j++) { 
            System.out.print("*");
         }
         System.out.println();
      }
   }
   
   // produce the body of the girl  
   public static void drawBody() {
      for (int i = 5; i >= 1; i--){
         for (int j = 1; j <= i-1; j++){
            System.out.print(" ");
         }
         for (int j = 1; j <= 11 - 2*i; j++){
            System.out.print("*");
         }
         System.out.println();
      }

   }

   // produce the legs of the girl 
   public static void drawLegs() {
      for (int i = 1; i <= 5; i++){
         System.out.println("   * *");
      }
   }
}