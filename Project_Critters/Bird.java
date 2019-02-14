// CSE142 Section: B
// 12/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #9(Bird)
//
/* Bird Critter:
   color : blue
   eats: never eat
   fight: ROAR if the opponent is an Ant ("%"), otherwise POUNCE
   movement: goes north, east, south, west 3 times, then repeats      
   toString: "^" if the bird's last move was north or it has not moved;
             ">" if the bird's last move was east; 
             "V" if the bird's last move was south; 
             "<" if the bird's last move was west  */

import java.awt.*; // for color

public class Bird extends Critter {
   int move; // field keeping track of what move the simulation is on
   
   public Bird() {     
      move = 0;
   }
   
   // set color to red
   public Color getColor() {
      return Color.BLUE;
   }
   
   // always eat
   public boolean eat() {
      return false;
   }
   
   // ROAR if the opponent is an Ant ("%"), otherwise POUNCE
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
         return Attack.ROAR;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // goes north, east, south, west 3 times, then repeats
   public Direction getMove() {
      // every time the simulator calls get move, add one to the counter
      move++;
      if (move % 12 >= 10 || move % 12 == 0) {
         return Direction.WEST;
      } else if (move % 12 <= 3) {
         return Direction.NORTH;
      } else if (move % 12 <= 6) {
         return Direction.EAST;
      } else {
         return Direction.SOUTH;
      }
   }
   
   // "^" if the bird's last move was north or it has not moved;
   // ">" if the bird's last move was east; 
   // "V" if the bird's last move was south; 
   // "<" if the bird's last move was west 
   public String toString() {     
      if ((move % 12 >= 10 || move % 12 == 0) && move > 0) {
         return "<";
      } else if (move % 12 <= 3) {
         return "^";
      } else if (move % 12 <= 6) {
         return ">";
      } else {
         return "V";
      }
   }  
}