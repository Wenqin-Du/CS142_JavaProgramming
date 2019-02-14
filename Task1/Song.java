// CSE142 Section: B
// 10/3/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #1
//
/* This program will produce a cumulative song in which successive verses 
   build on previous verses. To reduce redundancy, I split the song into 
   seven parts and create static methods in which some successive methods 
   build on previous methods.*/
   
   
public class Song{
   public static void main(String[] args){
      firstVerse();
      secondVerse();
      thirdVerse();
      fourthVerse();
      fifthVerse();
      sixthVerse();
      seventhVerse();
   }
  
  
   // Excuting the following method will get the first verse.     
   public static void firstVerse(){
      System.out.println("There was an old woman who swallowed a fly.");
      repeatSixTimes();
   }
   // Excuting the following method will get the second verse.        
   public static void secondVerse(){
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      repeatFiveTimes();
   }
   // Excuting the following method will get the third verse.           
   public static void thirdVerse(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      repeatFourTimes();
   }
   // Excuting the following method will get the fourth verse.           
   public static void fourthVerse(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      repeatThreeTimes();
   }
   // Excuting the following method will get the fifth verse.           
   public static void fifthVerse(){
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      repeatTwoTimes();
   }
   // Excuting the following method will get the sixth verse.             
   public static void sixthVerse(){
      System.out.println("There was an old woman who swallowed a crab,");
      System.out.println("Quite superb to swallow a crab.");
      repeatOneTime();
   }
   // Excuting the following method will get the seventh verse.                
   public static void seventhVerse(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }


   // Excuting the following method will get the last two lines of the first verse and a blank line.
   public static void repeatSixTimes(){
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   // Excuting the following method will get the last three lines of the second verse and a blank line.           
   public static void repeatFiveTimes(){
      System.out.println("She swallowed the spider to catch the fly,");
      repeatSixTimes();
   }
   // Excuting the following method will get the last four lines of the third verse and a blank line.           
   public static void repeatFourTimes(){
      System.out.println("She swallowed the bird to catch the spider,");
      repeatFiveTimes();
   }
   // Excuting the following method will get the last five lines of the fourth verse and a blank line.           
   public static void repeatThreeTimes(){
      System.out.println("She swallowed the cat to catch the bird,");
      repeatFourTimes();
   }
   // Excuting the following method will get the last six lines of the fifth verse and a blank line.           
   public static void repeatTwoTimes(){
      System.out.println("She swallowed the dog to catch the cat,");
      repeatThreeTimes();
   }
   // Excuting the following method will get the last seven lines of the sixth verse and a blank line.             
   public static void repeatOneTime(){
      System.out.println("She swallowed the crab to catch the dog,");
      repeatTwoTimes();
   }
}
        