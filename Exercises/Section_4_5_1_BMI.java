// This program finds the body mass index (BMI) for two 
// individuals. 

import java.util.*;

public class Section_4_5_1_BMI {
   public static void main(String[] args) {
       // better structure here: 
      intro();
      Scanner console = new Scanner(System.in);
      
      double bmi1 = userInput(console);
      double bmi2 = userInput(console);
      
      index(1, bmi1);
      index(2, bmi2);
   }

   // prints out an introduction to the program
   public static void intro() {
      System.out.println("This program reads in data for two people");
      System.out.println("and computes their body mass index (BMI)");
      System.out.println("and weight status.");
      System.out.println();
   }

   // Accepts a user-input scanner, prompting the user for height/weight
   // information and returns the BMI for the given input
   public static double userInput(Scanner console) {
      System.out.println("Enter next person's information:");
      System.out.print("height (in inches)? ");
      double height = console.nextDouble();
      System.out.print("weight (in pounds)? ");
      double weight = console.nextDouble();
      // TODO factor this calculation into a method:
      double bmi = weight / (height * height) * 703;
      System.out.println();
      return bmi;
   }
   
   // <i> = <the ith person>
   public static void index(int i, double bmi) {
      System.out.println("Person #" + i + 
                         " body mass index = " + 
                         Math.round(bmi * 10.0) / 10.0);
      if (bmi < 18.5) {
         System.out.println("underweight");
      } else if (bmi < 25) {
         System.out.println("normal");
      } else if (bmi < 30) {
         System.out.println("overweight");
      } else { // bmi >= 30
         System.out.println("obese");
      }
   }
}