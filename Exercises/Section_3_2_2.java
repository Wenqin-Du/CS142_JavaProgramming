import java.awt.*;

public class Section_3_2_2 {
   public static final int SIZE = 30;
   public static final int HALF = SIZE / 2;

   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(1000, 1000);
      panel.setBackground(Color.CYAN);
      Graphics pen = panel.getGraphics();
      
      // draw the initial ball:
      pen.fillOval(500 - HALF, 500 - HALF, SIZE, SIZE);
      
      double xVelocity = 20.0; // px/sec
      double yVelocity = 5.0;  // px/sec
      
      // <implementation detail :: This is good information, but bad code commenting.>
      // Store x and y as doubles because their position can be a real nubmber.
      // When we draw it, we do have to round to the nearest pixel, which is the reason
      // for the cast to (int).
      
      double x = 500.0;
      double y = 500.0;
      
      for (int i = 1; i <= 100; i++) {
         // change the x location of the ball
         // change the y location of the ball
         x = x + xVelocity;
         y = y + yVelocity;
         
         // draw the ball again at new location
         // <implementation detail :: This is good information, but bad code commenting.>
         //   use casting to force java to treat the double 'x - HALF' as an int. This
         //   truncates the double into an int, effectively discarding anything after
         //   the decimal sign: (int) 12.88 evaluates to 12 
         // </implementation detail>
         pen.fillOval((int) x - HALF, (int) y - HALF, SIZE, SIZE);

         // pause for 1 second (velocity is px/second)
         panel.sleep(1500);
         
         // pause for 1 millisecond (velocity would be px/millisecond)
         // panel.sleep(1);
         
         // pause for 1 minute (velocity would be px/minute)
         // panel.sleep(1000 * 60);
      }      
   }
}

// <implementation detail :: This is good information, but bad code commenting.>
//   Note that the units of the x/yVelocity variables is DEFINED by the length of
//   time that we are sleeping. That is to say, the sleep time changes how often 
//   we draw the draw, and therefore, how often we are doing the math to move it
//   to a new location.
// 
//   The units of velocity are actually px/??, where the ?? gets filled in when
//   we pick a sleep time. sleep(1000) -> px/second
// </implementation detail>