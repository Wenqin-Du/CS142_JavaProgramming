// A better Point class: this one has
// private fields, with getter and setter
// methods. Allows the client to calculate
// the distance from the Point to the origin,
// move the Point, get and set its x and y
// coordinates, and get a String representation
// of itself.
public class Point2 {
   private int x;
   private int y;

   public Point2() {
      // |--It turns out we don't even techinacally need this line, we --|
      // |  could leave the whole method body empty. That's because    --|
      // |  Java has to set x and y to something to initialize the     --|
      // |  object. So, it sets them to 0 if we don't specify          --| 
      this(0, 0);  
      // |------------------------------------------------------------ --|
   }

   // New Point with the given initial x and y
   public Point2(int x, int y) {
       // Note that here, x and y (the params) and x and y (the fields)
       // are both in scope. Use 'this.x' to refer to x, The Field, and
       // simply 'x' to refer to x, The Parameter.
      this.x = x;
      this.y = y;
   }
            
   // returns the distance from 'this' Point to the origin (0,0)
   public double distanceFromOrigin() {
      return Math.sqrt(x * x + y * y);
   }
   
   // move 'this' Point by the given delta-x and delta-y
   public void translate(int dx, int dy) {
      x += dx;
      y += dy;
   }
   
   // returns a String representation of this Point:
   // (x, y)
   public String toString() {
      return "(" + x + ", " + y + ")";
      // default: Point2@someaddy
   }

   // returns the current x-coordinate for this Point
   public int getX() {
      return x;
   }
   
   // returns the current y-coordinate for this Point
   public int getY() {
      return y;
   }
   
   // set the current x-coordinate for this Point.
   // Note that this method probably should be 
   // validating the parameter here, to make sure what
   // the client passed in actually makes sense.
   //
   // But, for Point objects, there isn't much validation
   // to do: the client is allowed to set the Point
   // to be pretty much anywhere they want.
   public void setX(int newX) {
      // in other applications, we would check newX
      //  to make sure it makes sense
      x = newX;
   }
   
   public void setY(int newY) {
      // in other applications, we would check newY
      //  to make sure it makes sense
      y = newY;
   }
}