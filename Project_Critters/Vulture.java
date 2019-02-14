// CSE142 Section: B
// 12/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #9(Vulture)
//
/* Vulture Critter:
   color : black
   eats: eat for one time when first born or after a fight
   fight: ROAR if the opponent is an Ant ("%"), otherwise POUNCE
   movement: goes north, east, south, west 3 times, then repeats      
   toString: "^" if the vulture's last move was north or it has not moved;
             ">" if the vulture's last move was east; 
             "V" if the vulture's last move was south; 
             "<" if the vulture's last move was west  */

import java.awt.*; // for color

public class Vulture extends Bird {
   private boolean fight; // field deciding if the vulture have a fight
   
   public Vulture() {
      move = 0;
      fight = false;
   }
   
   // set color to black
   public Color getColor() {
      return Color.BLACK;
   }
   
   // ROAR if the opponent is an Ant ("%"), otherwise POUNCE
   public Attack fight(String opponent) {
      fight = !fight;
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }    
   }
  
   // 
   public boolean eat() {
      if (move == 0 || fight) {
         return true;
      } else {
         return false;
      }
   }
}