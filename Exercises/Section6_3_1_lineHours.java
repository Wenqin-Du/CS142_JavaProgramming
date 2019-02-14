// Processes an employee input file and outputs each employee's hours. 
import java.io.*; // for File
import java.util.*; // for Scanner

public class Section6_3_1_lineHours {
   public static void main(String[] args) throws FileNotFoundException {
      String a = "hours.txt";
      Scanner input = new Scanner(new File(a)); 
        
      while (input.hasNextLine()) {
         String line = input.nextLine(); 
         Scanner lineScan = new Scanner(line); 
         int id = lineScan.nextInt();
         String name = lineScan.next();
         double sum = 0.0;
         int count = 0;
         while (lineScan.hasNextDouble()) {
            sum = sum + lineScan.nextDouble();
            count++; 
         }
         double average = sum / count;
         sum  = Math.round(sum * 10.0) / 10.0;
         average  = Math.round(average * 10.0) / 10.0;
         System.out.println(name + " (ID#" + id + ") worked " +
             sum + " hours (" + average + " hours/day)");
      }
   }
} 