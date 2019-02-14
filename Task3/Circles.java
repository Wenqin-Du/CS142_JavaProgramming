// CSE142 Section: B
// 17/10/17
// Instructor: Whitaker Brand
// TA: Robert Minneker
// Student: Wenqin Du
// Assignment #3(Circles)
//
/* This program draws different size of yellow concentric circles
   and grids in different places in a cyan background.*/

import java.awt.*;

public class Circles { 
   public static void main(String[] args) {
      DrawingPanel m = new DrawingPanel(500, 350);
      Graphics g = m.getGraphics();

      m.setBackground(Color.CYAN);
      
      drawCircles(g, 0, 0, 100, 10);
      drawCircles(g, 130, 25, 100, 10);
      drawCircles(g, 260, 0, 60, 6);
      drawCircles(g, 360, 50, 80, 4);
      drawGrid(g, 10, 170, 48, 3, 4);
      drawGrid(g, 180, 200, 24, 5, 2);
      drawGrid(g, 330, 170, 72, 2, 9);
   }
   
   // draw different size and positions of concentric circles
   // parameters needed:
   // <x,y> = <position of concentric circles's top left corner>
   // <l> = <the dia of the largest circle in concentric circles>
   // <z> = <the number of circles per subfigure>
   public static void drawCircles(Graphics g, int x, 
                                  int y, int l, int z) {
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, l, l);
      
      g.setColor(Color.BLACK);
      for (int i = 0; i < z; i++) {
         int r = i * l / (2 * z); //r is the radius of each circle
         g.drawOval(x + r, y + r,l - 2 * r, l - 2 * r);
      }
   }
   
   // draw different size and positions of grids
   // parameters needed:
   // <x,y> = <position of the top left corner of grids>
   // <l> = <the dia of the largest circle in concentric circles>
   // <n> = <rows/cols of grids>
   // <z> = <the number of circles per subfigure>
   public static void drawGrid(Graphics g, int x, int y,
                               int l, int n, int z) {
      g.setColor(Color.GREEN);
      g.fillRect(x, y, l * n, l * n);
      
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            drawCircles(g, x + j * l, y + i * l, l, z);
         }
      }
       
      g.setColor(Color.BLACK);
      g.drawRect(x, y, l * n, l * n);
      g.drawLine(x, y, x + l * n, y + l * n);
      g.drawLine(x + l * n, y, x, y + l * n);
   }
}