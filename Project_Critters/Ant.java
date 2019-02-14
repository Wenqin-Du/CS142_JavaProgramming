// CSE142 Section: B
// 12/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #9(Ant)
//
/* Ant Critter:
   color : red
   eats: always eat
   fight: always SCRATCH
   movement: move south and east alternately or move north and east alternately     
   toString: %  */

import java.awt.*; // for color

public class Ant extends Critter {
   private boolean walkSouth; // field deciding the moving direction
   private int move; // field keeping track of what move the simulation is on
   
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
      move = 0;
   }
   
   // set color to red
   public Color getColor() {
      return Color.RED;
   }
   
   // always eat
   public boolean eat() {
      return true;
   }
   
   // always SCRATCH
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   // if walkSouth equals true, move south and east alternately
   // if walkSouth equals false, move north and east alternately
   public Direction getMove() {
      // every time the simulator calls get move, add one to the counter
      move++;
      if (move % 2 == 1 && walkSouth) {
         return Direction.SOUTH;
      } else if (move % 2 == 1) {
         return Direction.NORTH;
      } else {
         return Direction.EAST;
      }
   }
   
   // set toString to be "%"
   public String toString() {
      return "%";
   }  
}
