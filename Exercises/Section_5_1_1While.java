// Emulates a game of roulette, with simplified betting
// and payout rules.
// Uses a British roulette wheel (no 00, which is only present
// in the American version)

import java.util.*; // for both Scanner and Random

public class Section_5_1_1_While {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      int money = 1000;
      
      while (money > 0) {
         System.out.print("You have $" + money + ". Place your bet: " );
         int bet = console.nextInt();
      }
         
      // this is slightly different that what we wrote in class
      // this RE-prompts the user if the bet was too high.
      while (bet > money) {
         System.out.println("You bet too much: $" + bet);
         System.out.print("You have $" + money + ". Place your bet: " );
         int bet = console.nextInt();            
      }
      
      money -= bet;
      // money = money - bet;    (synonym of the above line)

      // prompt the user for a number guess         
      System.out.print("Pick a number between 0 and 10: ");
      int guess = console.nextInt();         

      // "spin the wheel"
      int answer = rand.nextInt(11);
      System.out.println(answer + "!!!");
      
      // payout the user if they guessed correctly
      if (guess == answer) {
         money += bet * 35;
      }
   }
}
