// CSE142 Section: B
// 10/21/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #4(Gradanator)
//
/* This program compute a student's overall course grade based
   on the score of midterm exam, final exams and homwork*/

import java.util.*;

public class Gradanator {
   // the capped section number added to the homework category
   public static final int SECTION_NUMBER = 6; 
   public static void main(String[] args) {
      intro(); 
      Scanner console = new Scanner(System.in); 
      double weighted1 = exam(console, "Midterm:"); //WeightedMidtermScore
      double weighted2 = exam(console, "Final:"); //WeightedFinalExamScore  
      double weighted3 = homework(console); //WeightedHomeworkScore 
      comments(weighted1, weighted2, weighted3); 
   } 
   
   // Prints out an introduction to the program.
   public static void intro() {
      System.out.println("This program reads exam/homework scores");
      System.out.println("and reports your overall course grade.");
      System.out.println();
   }
   
   // Accepts a user-input scanner, prompting the user for
   // the exam information and return weighted score. 
   // <test> = <the name of a test>
   public static double exam(Scanner console, String test) {
      System.out.println(test);
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Score earned? ");
      int score = console.nextInt();
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int logic = console.nextInt();
      
      // whether exam scores were shifted 
      int shift = 0; 
      if (logic == 1) {
         System.out.print("Shift amount? ");
         shift = console.nextInt();
      }
      
      // Total points
      int total = shift + score;
      total = Math.min(total, 100);
  
      // Weighted exam score
      double weighted = total * weight / 100.0;
      double roundWeighted = roundTo(weighted, 1);
      
      System.out.println("Total points = " + total +" / 100");
      System.out.println("Weighted score = " + roundWeighted +
                         " / " + weight);
      System.out.println();
      return weighted;
   }   
   
   // Accepts a user-input scanner, prompting the user for
   // homework information and return weighted score.
   public static double homework(Scanner console) {
      System.out.println("Homework:");
      System.out.print("Weight (0-100)? ");
      int weight = console.nextInt();
      System.out.print("Number of assignments? ");
      int number = console.nextInt();
     
      int sum1 = 0; // sum of student's assignment score
      int sum2 = 0; // total sum of assignment score
      for (int i = 1; i <= number; i++) {
         System.out.print("Assignment " + i +" score and max? ");
         int score = console.nextInt();
         int max = console.nextInt();
         sum1 += score;
         sum2 += max;
      }
      
      //sections
      System.out.print("How many sections did you attend? ");
      int section = console.nextInt();
      section = Math.min(section, SECTION_NUMBER);
      int tsection = section * 5; //total section score
      
      sum1 += tsection; // sum of student's homework score
      sum2 += SECTION_NUMBER * 5; //total sum of homework score
      sum1 = Math.min(sum1, sum2);      
  
      // weighted homework score                   
      double weighted = sum1 * weight * 1.0 / sum2;
      double roundWeighted = roundTo(weighted, 1);
      
      System.out.println("Section points = " + tsection +
                         " / " + SECTION_NUMBER * 5);
      System.out.println("Total points = " + sum1 + " / " + sum2);

      System.out.println("Weighted score = " + roundWeighted +
                         " / " + weight);
      System.out.println();
      return weighted;   
   }  
   
   // Prints out the grade range and custom grade message.
   // parameters needed:
   // <w1> = <Weighted Midterm Score>
   // <w2> = <Weighted Final Exam Score >
   // <w3> = <Weighted Homework Score>
   public static void comments(double w1, double w2, double w3) {
      double weighted = w1 + w2 +w3;
      double roundWeighted = roundTo(weighted, 1);
      
      System.out.println("Overall percentage = " + roundWeighted);               
      System.out.print("Your grade will be at least: ");
      if (weighted >= 85) {
         System.out.println("3.0");
         System.out.println("Perfect!");
      } else if (weighted >= 75) {
         System.out.println("2.0");
         System.out.println("Good job!");
      } else if (weighted >= 60) {
         System.out.println("0.7");
         System.out.println("Not bad!");
      } else { // weighted < 60
         System.out.println("0.0");
         System.out.println("You should study harder!");
      }
   }
   
   // rounds the given double to the given number of decimal places
   public static double roundTo(double d, int digits) {
      return Math.round(d * Math.pow(10, digits)) 
                        / Math.pow(10, digits);
   }
}