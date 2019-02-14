import java.util.*;
public class Section7_3_2_arrayPara{
   public static void main(String[] args) {
      int[] iq = {126, 167, 95};
      doubleAll(iq);
      //at this time, the value of iq has been changed!
      System.out.println(Arrays.toString(iq));
   }
   public static void doubleAll(int[] a) {
      for (int i = 0; i < a.length; i++) {
         a[i] = a[i] * 2;
      }
   }
}