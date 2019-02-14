// CSE142 Section: B
// 11/12/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #6(Mad Libs)
//
/* This program play a game in which the user provide various words to make 
   a story and the user can read the story and play the game as many times 
   as he/she wants.*/
import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      intro(); 
      Scanner console = new Scanner(System.in); 
      String answer = choice(console);
      
      while (!answer.equalsIgnoreCase("q")) {
         if (answer.equalsIgnoreCase("c")) {
            String fileName = findFile(console);
            Scanner input1 = new Scanner (new File (fileName));
            System.out.print("Output file name: ");
            String name = console.nextLine();
            PrintStream out1 = new PrintStream (new File (name));
            createStory(console, input1, out1);
         } else {
            String fileName = findFile(console);
            Scanner input2 = new Scanner (new File (fileName));
            viewStory(input2);
         }
         answer = choice(console);
      }
   } 
   
   // Prints out an introduction to the program.
   public static void intro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Accepts a user-input scanner and see if the user want to 
   // play again, view or quit. Return the user's answer.
   public static String choice(Scanner console) {
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
      String answer = console.nextLine();
      while (!answer.equalsIgnoreCase("c") && !answer.equalsIgnoreCase("q") &&
             !answer.equalsIgnoreCase("v")) {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         answer = console.nextLine();     
      }
      return answer;
   }
   
   // Accepts a user-input scanner to put something into the placeholder.
   // Accepts a input1 scanner to read the input text.
   // Accepts a out1 PrintStream to write a text.
   public static void createStory(Scanner console, Scanner input1, PrintStream out1) {
      System.out.println();
      while (input1.hasNextLine()) {
         String line = input1.nextLine();
         Scanner lineScan = new Scanner (line);
         while (lineScan.hasNext()) {
            String word = lineScan.next();
            String indefiniteArticle = " a ";
            // see if there is a placeholder?
            if (word.startsWith("<") && word.endsWith(">")) {
               word = word.substring(1, word.length() - 1);
               word = word.replace("-", " ");
               if (vowel(word.substring(0))) {
                  indefiniteArticle = " an ";
               } 
               System.out.print("Please type" + indefiniteArticle + word + ": ");
               word = console.nextLine();
            } 
            out1.print(word + " "); 
         }
         out1.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   // Accepts a input2 scanner to read the input text.
   public static void viewStory(Scanner input2) {
      System.out.println();
      while (input2.hasNextLine()) {
         String line = input2.nextLine();
         System.out.println(line);
      }
      System.out.println();
   }
   
   // parameters needed:
   // <s> = <the word of a placeholder>
   // to see if a word begins with a vowel. Return a boolean.
   public static boolean vowel(String s) {
      if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' ||
          s.charAt(0) == 'o' || s.charAt(0) == 'u' || s.charAt(0) == 'A' ||
          s.charAt(0) == 'E' || s.charAt(0) == 'I' || s.charAt(0) == 'O' ||
          s.charAt(0) == 'U') {
         return true;
      } else {
         return false;
      }
   }
      
   // Accepts a user-input scanner to write in the file name and find it.
   // Prompt the user for numbers until the user types in a exist file name.
   // Return the file name
   public static String findFile(Scanner console) {
      System.out.print("Input file name: ");
      String fileName = console.nextLine();
      File file = new File(fileName);
      while (!file.exists()) {
         System.out.print("File not found. Try again: ");
         fileName = console.nextLine();
         file = new File(fileName);     
      }
      return fileName;
   }
} 