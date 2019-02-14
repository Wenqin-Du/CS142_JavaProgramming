// CSE142 Section: B
// 17/10/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #3(Doodle)
//
/* This program draws a figure composed of cirlces, ovals and 
   rectangles in a pink background.*/


import java.awt.*;

public class Doodle {
   public static void main(String[] args) {
      DrawingPanel m = new DrawingPanel(300, 370);
      Graphics g = m.getGraphics();
      
      m.setBackground(Color.PINK);
      
      g.setColor(new Color(150, 200, 20));
      g.fillRect(10, 10, 105, 105);
      
      g.setColor(Color.YELLOW);
      g.fillOval(150, 10, 120, 120);
      
      g.setColor(Color.BLUE);
      g.drawRect(150, 10, 120, 120);
      
      g.setColor(Color.RED);
      g.drawOval(70, 150, 100, 100);
      
      for (int i = 1; i <= 100; i++) {
         g.fillOval(70 * i - 30, 260, 120, 100);
         m.sleep(500);
      }
   }
}