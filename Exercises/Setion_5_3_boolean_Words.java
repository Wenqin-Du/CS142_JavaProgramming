import java.util.*;

public class Setion_5_3_boolean_Words {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("Type two words: ");
      String word1 = console.next();
      String word2 = console.next();
      System.out.println("word1 and word2 are alliterative? " + alliterative(word1, word2));
   }
   public static boolean alliterative(String word1, String word2) {
      return word2.substring(0, 1).equalsIgnoreCase(word1.substring(0, 1));
   }
}