// CSE142 Section: B
// 10/29/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #5(GuessingGame)
//
/* This program allows the user to play a guessing game with the
   computer. The user can play as many time as he wants and finally
   the computer gives out overall statistics for his game(s).*/

import java.util.*;

public class GuessingGame {
   // the maximum number used in the games
   public static final int MAX = 100; 
   public static void main(String[] args) {
      intro();
      playGames();
   }
   
   // Prints out an introduction to the program
   public static void intro() {
      System.out.println("It's a guessing game");
      System.out.println("Play many times as you like");
      System.out.println("Get stat in the end");
      System.out.println();
   }
   
   // Complet the whole guessing game
   public static void playGames() {
      Scanner console = new Scanner(System.in);
      Random rand = new Random(28);
      
      int best = playOneGame(rand); // best game
      int totalGuesses = best;
      int totalGames = 1;
      String playAgain = again(console);
           
      while (playAgain.substring(0,1).equalsIgnoreCase("y")) {
         int guessTimes = playOneGame(rand);
         best = Math.min(guessTimes, best);
         totalGames++;
         totalGuesses += guessTimes;
         playAgain = again(console);
      }   
      overallStat(totalGames, totalGuesses, best);  
   }
    
   // Accepts a user-input scanner and see if the user want to 
   // play again. 
   public static String again(Scanner console) {
      System.out.print("Do you want to play again? ");
      String playAgain = console.next();
      System.out.println();
      return playAgain;
   }
     
   // Accepts a user-input scanner, prompting the user for
   // guessing numbers when the user plays one game and return
   // the guessing times. 
   public static int playOneGame(Random rand) {
      Scanner console = new Scanner(System.in);
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      int answer = rand.nextInt(MAX) + 1;
      int guessTimes = 0;
      int guess;
      
      // body of a guessing game
      do {
         System.out.print("Your guess? ");
         guess = console.nextInt();
         if (guess < answer) {
            System.out.println("It's higher.");
         } else if (guess > answer) {
            System.out.println("It's lower.");
         }
         guessTimes++;
      } while (answer != guess);
      
      if (guessTimes == 1) {
         System.out.println("You got it right in 1 guess!");
      } else {
         System.out.println("You got it right in " + guessTimes + " guesses!");
      }
      return guessTimes;
   }
   
   // Print the statistics of the whole game.
   // parameters needed:
   // <i> = <Total games>
   // <j> = <Total guesses>
   // <k> = <Best game>
   public static void overallStat(int i, int j, int k) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + i);
      System.out.println("Total guesses = " + j );
      System.out.printf("Guesses/game  = %.1f\n", j * 1.0 / i);
      System.out.println("Best game     = " + k );
   }
}