// Sloth Critter:
// movement: hold still for 2 moves, and then move south for one move, then start over
// eats: always
// Color : green
// fight: always SCRATCH
// toString: @

// Note that this object is slightly simpler than what we wrote in the B
// lecture -- this critter doesn't ever move west.

import java.awt.*;
public class Sloth extends Critter {
   // field keeping track of what move the simulation is on
   private int moveCounter;

   // This constructor is what java gives us by default:
   // public Sloth() {
   //     moveCounter = 0;
   // }
   public Direction getMove() {
      // every time the simulator calls get move, add one
      // to our counter
      moveCounter++;
      
      if (moveCounter % 3 == 0) {
         return Direction.SOUTH;
      } else {
         return Direction.CENTER;
      }
   }
   
   public boolean eat() {
      return true;
   }  
   
   public Attack fight(String opponent) {
      return Attack.SCRATCH;
   }
   
   public String toString() {
      return "@";
   }
   
   public Color getColor() {
      return Color.GREEN;
   }

}
