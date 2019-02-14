public class Section7_3_1_arrayPara{
   public static void main(String[] args) {
      int[] iq = {126, 84, 149, 167, 95};
      double avg = average(iq);
      System.out.println("Average = " + avg);
   }
   public static double average(int[] array) {
      int sum = 0;
      for (int i = 0; i < array.length; i++) {
      sum += array[i];
      }
      return (double) sum / array.length;
   }
}