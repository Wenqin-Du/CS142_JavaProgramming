// CSE142 Section: B
// 12/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #9(Hippo)
//
/* Hippo Critter:
   color : gray if the hippo is still hungry; otherwise white 
   eats: not eat until have eaten the max number times
   fight: if Hippo is hungry then SCRATCH; else POUNCE    
   movement: moves 5 steps in a random direction
             then chooses a new random direction and repeats      
   toString: the number of pieces of food this Hippo still wants to eat  */

import java.awt.*; // for color

public class Hippo extends Critter {
   private int hungerTime; // field deciding the max number the Hippo will eat
   private int eatTime; // field deciding if the Hippo still want to eat
   private int move; // field keeping track of what move the simulation is on
   private int num; //field to store the random number to decide movement
   
   public Hippo(int hunger) {
      eatTime = 0;
      hungerTime = hunger;
      move = 0;
      num = 0;
   }
   
   // set color to gray if the hippo is still hungry; otherwise white
   public Color getColor() {
      if (eatTime < hungerTime) {
         return Color.GRAY;
      } else {
         return Color.WHITE;
      }
   }
   
   // not eat until have eaten the max number times
   public boolean eat() {
      if (eatTime < hungerTime) {
         eatTime++;
         return true;
      } else {
         return false;
      }
   }
   
   // if Hippo is hungry then SCRATCH; else POUNCE
   public Attack fight(String opponent) {
      if (eatTime < hungerTime) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }
   
   // moves 5 steps in a random direction
   // then chooses a new random direction and repeats
   public Direction getMove() {
      // every time the simulator calls get move, add one to the counter
      move++;
      if (move % 5 == 1) {
         num = (int)(Math.random() * (4));;
      } 
      
      if (num == 0) {
         return Direction.NORTH;
      } else if (num == 1) {
         return Direction.EAST;
      } else if (num == 2) {
         return Direction.SOUTH;
      } else {
         return Direction.WEST;
      }
   }
   
   // the number of pieces of food this Hippo still wants to eat
   public String toString() {
      return "" + (hungerTime - eatTime);
   }  
}