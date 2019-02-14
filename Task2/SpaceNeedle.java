// CSE142 Section: B
// 9/10/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #2(Space Neddle)
//
/* This program will produce the Space Neddle. I split it into 6 parts and 
   only need to write down 4 parts of them to compile the hole picture by
   using nested for loops. */
   

public class SpaceNeedle {
   public static final int SCALE = 4;
   
   public static void main(String[] args) {
   drawPole();
   drawTopHalf();
   drawBottomHalf();
   drawPole();
   drawMidsection();
   drawTopHalf();
   } 
   
   // produce the top pole of Space Needle
   public static void drawPole() {
      for (int i = 1; i <= SCALE; i++) {
         for (int j = 1; j <= 3 * SCALE; j++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }
   } 
   
   //produce the top half hall or the foundation of Space Needle
   public static void drawTopHalf() {
      for (int i = 1; i <= SCALE; i++) {
         for (int j = 1; j <= 3 * SCALE - 3 * i; j++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         for (int j = 1; j <= 3 * i - 3; j++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int j = 1; j <= 3 * i - 3; j++) {
            System.out.print(":"); 
         }
         System.out.println("\\__");
      }
      
      System.out.print("|");
      for (int i = 1; i <= 6 * SCALE; i++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
   //produce the bottom half hall of Space Needle
   public static void drawBottomHalf(){
      for (int i = 1; i <= SCALE; i++){
         for (int j = 1; j <= 2 * i - 2; j++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int j = 1; j <= 3 * SCALE + 1 - 2 * i; j++) {
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }
   
   //produce the midsection of Space Needle
   public static void drawMidsection() {
      for (int i = 1; i <= SCALE * SCALE; i++) {
         for (int j = 1; j <= 2 * SCALE + 1; j++) {
         System.out.print(" ");
         }
         System.out.print("|");
         for (int j = 1; j <= SCALE - 2; j++) {
            System.out.print("%");
         }
         System.out.print("||");
         for (int j = 1; j <= SCALE - 2; j++) {
            System.out.print("%");
         }
         System.out.println("|");
      }
   }
}