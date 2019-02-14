// The ball will bounce off the right wall, but we don't have logic
// in here yet to make it bounce off of the other walls.
import java.awt.*;
import java.util.*;

public class Section_3_3_2_Ball {
   public static final int SIZE = 30;
   public static final int HALF = SIZE / 2;

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("Please type in a double for displacement: ");
      double displacement = console.nextDouble();
   
      System.out.print("Please type in a double for the angle: ");
      double angle = console.nextDouble();

      DrawingPanel panel = new DrawingPanel(1000, 1000);
      panel.setBackground(Color.CYAN);
      Graphics pen = panel.getGraphics();
      
      // draw the initial ball:
      pen.fillOval(500 - HALF, 500 - HALF, SIZE, SIZE);
      
      double radians = Math.toRadians(angle);
      double xDisplacement = displacement * Math.cos(radians); // px
      double yDisplacement = -1 * displacement * Math.sin(radians);  // px
      
      double x = 500.0;
      double y = 500.0;
      
      for (int i = 1; i <= 100; i++) {
         // erase the old ball by drawing over it with the 
         // background color.
         pen.setColor(Color.CYAN);
         pen.fillOval((int) x - HALF, (int) y - HALF, SIZE, SIZE);
         pen.setColor(Color.BLACK);
         
         // change the x location of the ball
         // change the y location of the ball
         x = x + xDisplacement;
         y = y + yDisplacement;
         
         // TODO -- check for x <= 0, y <= 0, y >= 1000
         if (x >= 1000) {
            // the ball has travelled too far in the x direction: reverse course
            xDisplacement = xDisplacement * -1;
         } else if(x <= 0){
            xDisplacement = xDisplacement * -1;
         }
                 
         // draw the ball again at new location
         pen.setColor(Color.BLACK);
         pen.fillOval((int) x - HALF, (int) y - HALF, SIZE, SIZE);

         // pause for 100 milliseconds
         panel.sleep(100);
      }      
   }
}