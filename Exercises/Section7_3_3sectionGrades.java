import java.util.*; // for Scanner
import java.io.*;   // for File

public class Section7_3_3sectionGrades {
   public static final int STUDENTS = 5;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("sections.txt"));
      
      while (input.hasNextLine()) {
         String line = input.nextLine();
         
         int[] counts = new int[STUDENTS];
         getCounts(line, counts);
         System.out.println("Sections attended: " + Arrays.toString(counts));         
         
         int[] scores = getScores(counts);
         System.out.println("Section points earned: " + Arrays.toString(scores)); 
         
         double[] percentages = getPercentages(scores);
         System.out.println("Section percentages: " + Arrays.toString(percentages));
         System.out.println();
      }
   }

      // Given a data line from the sections.txt file, computes
      // count of attendance for each of the students, and returns
      // the count in a new array 
      public static int[] getCounts(String line, int[] counts) {
         // int[] counts = new int[STUDENTS];
         // { 9, 4, 5, 8, 3 } 
         for (int i = 0; i < line.length(); i++) {
            char attended = line.charAt(i);
            int studentNumber = i % STUDENTS;
            if (attended == '1') {
               counts[studentNumber]++;
            }            
         }      
         return counts;
      }
      
      // Given an array of section attendance counts, computes
      // score for attendance for each given count, and returns
      // them in a new array, corresponding values stored
      // at the same index
      public static int[] getScores(int[] counts) {
         int[] scores = new int[STUDENTS];
         // { 20, 18, 20, 12, 9 }
         for (int i = 0; i < STUDENTS; i++) {
            scores[i] = Math.min(20, 3 * counts[i]);
         }
         return scores;
      }
      
      // Given an array of scores, computes percentage of
      // maximum points awarded for each score, and returns
      // it in a new array, corresponding values stored
      // at the same index
      public static double[] getPercentages(int[] scores)  {
         double[] percentages = new double[STUDENTS];
         // { 100.0, 90.0, 100.0, 60.0, 45.0 } 
         for (int i = 0; i < STUDENTS; i++) {
            percentages[i] = 100.0 * scores[i] / 20;
         }        
         return percentages;   
      }
  }