// CSE142 Section: B
// 11/21/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #7(DNA)
//
/* This program reads data of DNA and writes a file to give out region name and
   other numeric features of a DNA and to judge whether it is protein.*/

import java.io.*;
import java.util.*;

public class DNA {
   // the minimum number of codons a valid protein must have
   public static final int MIN_NUMBER = 5; 
   // the percentage of mass from C and G in order for a protein to be valid
   public static final int MIN_PERCENTAGE = 30;
   // the number of unique nucleotides 
   public static final int NUCLEOTIDES = 4;
   // the number of nucleotides per codon 
   public static final int NU_PER_CODON = 3;
   
   public static void main(String[] args) throws FileNotFoundException {
      intro(); 
      Scanner console = new Scanner(System.in);
      System.out.print("Input file name? ");
      String name1 = console.nextLine();
      Scanner input = new Scanner (new File (name1));
      System.out.print("Output file name? ");
      String name2 = console.nextLine();
      PrintStream out = new PrintStream (new File (name2));
    
      while (input.hasNextLine()) {
         String region = input.nextLine(); 
         String nucleotides = input.nextLine();
         int dash = countDash(nucleotides);
         String nuclPrint = nucleotides.toUpperCase();
         String list = nuclPrint.replace("-", "");
         int[] counts = countNumbers(list);
         double mass = countMass(dash, counts);
         String[] codonsList = triplet(list);
         boolean protein = isProtein(list, mass, counts);
         create(out, region, nuclPrint, mass, counts, codonsList, protein);
      }
   }
   
   // Prints out an introduction to the program.
   public static void intro() {
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
   }

   // Count the number of dashes in a nucleotide sequence and return the value.
   // <nucleotides> = <a nucleotide sequence>
   public static int countDash(String nucleotides) {
      int num = 0;
      for (int i = 0; i < nucleotides.length(); i++) {
         if (nucleotides.charAt(i) == '-') {
            num++;
         }
      }
      return num;
   }  
 
   // Count the number of AGCT in a nucleotide sequence and return as an array.
   // <list> = <an upper case nucleotide sequence without dash>
   public static int[] countNumbers(String list) {
      int[] numbers = new int[NUCLEOTIDES];
      char[] words = {'A', 'C', 'G', 'T'};
      for (int i = 0; i < list.length(); i++) {
         for (int j = 0; j < NUCLEOTIDES; j++) {
            if (list.charAt(i) == words[j]) {
               numbers[j]++;
            }
         }
      }
      return numbers;
   }  
   
   // Count the total mass.
   // <dash> = <the number of dashes in a nucleotide sequence>
   // <counts> = <the number of AGCT in a nucleotide sequence>
   public static double countMass(int dash, int[] counts) {
      double mass = 100.000 * dash + 135.128 * counts[0] + 111.103 * counts[1] +
                    151.128 * counts[2] + 125.107 * counts[3];
      return mass;
   }  
   
   // Transfer from the original nucleotide sequence string to codon triplets
   // and return it.
   // <list> = <an upper case nucleotide sequence without dash> 
   public static String[] triplet(String list) {
      String[] codonsList = new String[list.length()/NU_PER_CODON];
      for (int i = 0; i < list.length()/NU_PER_CODON; i++) {
         codonsList[i] = list.substring(i * NU_PER_CODON, (i + 1) * NU_PER_CODON);
      }
      return codonsList;
   }
   
   // Judge whether the nucleotides is a protein or not and return a boolean
   // <list> = <an upper case nucleotide sequence without dash> 
   // <counts> = <the number of AGCT in a nucleotide sequence>
   // <mass> = <the total mass of a nucleotides>
   public static boolean isProtein(String list, double mass, int[] counts) {
      if (!list.substring(0, NU_PER_CODON).equals("ATG")) {
         return false;
      }
      if (!list.substring(list.length() - NU_PER_CODON, list.length()).equals("TAA") &&
          !list.substring(list.length() - NU_PER_CODON, list.length()).equals("TAG") &&
          !list.substring(list.length() - NU_PER_CODON, list.length()).equals("TGA")) {
         return false;
      }
      if (list.length() < NU_PER_CODON * MIN_NUMBER) {
         return false;
      }
      if ((111.103 * counts[1] + 151.128 * counts[2]) / mass < MIN_PERCENTAGE / 100.0) {
         return false;
      }
      return true;
   }
   
   // Create the output file.
   // <region> = <region name of the nucleotides>
   // <nuclPrint> = <the upper case of the nucleotides>
   // <mass> = <the total mass of a nucleotides>
   // <counts> = <the number of AGCT in a nucleotide sequence>
   // <codonsList> = <codon triplets of the nucleotides>
   // <protein> = <boolean - if the nucleotides is a protein?>
   public static void create(PrintStream out, String region, String nuclPrint, 
            double mass,int[] counts, String[] codonsList, boolean protein) {
      out.println("Region Name: " + region);
      out.println("Nucleotides: " + nuclPrint);
      out.println("Nuc. Counts: " + Arrays.toString(counts));
      
      double[] masses = new double[NUCLEOTIDES];
      masses[0] = Math.round(100 * 135.128 * counts[0] / mass * 10.0) / 10.0;         
      masses[1] = Math.round(100 * 111.103 * counts[1] / mass * 10.0) / 10.0;
      masses[2] = Math.round(100 * 151.128 * counts[2] / mass * 10.0) / 10.0;
      masses[3] = Math.round(100 * 125.107 * counts[3] / mass * 10.0) / 10.0;
      out.println("Total Mass%: " + Arrays.toString(masses) + " of " + Math.round(mass * 10.0) / 10.0);

      out.println("Codons List: " + Arrays.toString(codonsList));
      out.print("Is Protein?: ");
      if (protein) {
         out.println("YES");
      } else {
         out.println("NO");
      }
      out.println();                     
   }  
}