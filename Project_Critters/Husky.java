// CSE142 Section: B
// 12/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #9(Husky)
//
// code for Husky do not need to be commented

import java.awt.*; // for color

public class Husky extends Critter {
   private int eatTime; 
   private int move; 
   private int num;
   
   public Husky() {
      eatTime = 0;
      move = 0;
      num = 0;
   }

   public Color getColor() {
      if (eatTime <= 2) {
         return Color.BLUE;
      } else if (eatTime <= 4) {
         return Color.YELLOW;
      } else if (eatTime < 6) {
         return Color.RED;
      } else if (move % 2 == 0) {
         return Color.BLACK;
      } else {
         return Color.WHITE;
      }
   }
   
   public boolean eat() {
      if (eatTime < 6) {
         eatTime++;
         return true;
      } else {
         return false;
      }
   }
   
   public Attack fight(String opponent) {
      if (num == 0 || getNeighbor(Direction.WEST).equals("%") ||
          getNeighbor(Direction.EAST).equals("%") || 
          getNeighbor(Direction.NORTH).equals("%")||
          getNeighbor(Direction.SOUTH).equals("%")) {
         return Attack.ROAR;
      } else if (num == 1) {
         return Attack.SCRATCH;
      } else {
         return Attack.POUNCE;
      }
   }
   
   public Direction getMove() {
      move++;
      
      if (move % 4 == 1) {
         num = (int)(Math.random() * (3));;
      } 
      
      if (getX() > 25 && getX() < 33 && getY() > 25 && getY() < 33) {
         return Direction.SOUTH;
      } else if (num == 0) {
         return Direction.NORTH;
      } else if (num == 1) {
         return Direction.EAST;
      } else {
         return Direction.WEST;
      }
   }
   
   public String toString() {
      if (eatTime <= 2) {
         return "n";
      } else if (eatTime <= 4) {
         return "h";
      } else if (eatTime < 6) {
         return "H";
      }else if (move % 2 == 0) {
         return "\\";
      } else {
         return "/";
      }
   }  
}