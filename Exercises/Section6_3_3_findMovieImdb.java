import java.util.*;
import java.io.*;

// This program prompts the user to type in a search phrase, 
// then looks through a data file of the top 250 movies
// and prints out what movies matched, if any.
public class Section6_3_3_findMovieImdb {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter some text to search for: ");      
      String searchText = console.nextLine();
      
      Scanner input = new Scanner(new File("imdb.txt"));
      String line = findMovie(input, searchText);
      if (line.length() > 0) {
         System.out.println("Rank\tVotes\tRating\tTitle");
         while (line.length() > 0) {
            display(line);
            line = findMovie(input, searchText);         
         }
      } else {
         System.out.println("Movie not found");
      }
   }
   
   // returns the next line from the input that contains the given searchText,
   // or "" if no matching line was found
   public static String findMovie(Scanner input, String searchText) {
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (line.toLowerCase().contains(searchText.toLowerCase())) {
            return line;   
         }
      }
      return "";
   }

    // outputs a line from the Imdb file, separating the columns by tabs.   
   public static void display(String line) {
      Scanner lineScan = new Scanner(line);
      int rank = lineScan.nextInt();
      int votes = lineScan.nextInt();
      double rating = lineScan.nextDouble();
      String title = lineScan.next();
      while (lineScan.hasNext()) {
         title += " " + lineScan.next();
      }
      System.out.println(rank + "\t" + votes + "\t" + rating + "\t" + title);
   }
}