public class Pair {
    private int x;
    private int y;
    
    public Pair (int xVal, int yVal) {
      x = xVal;
      y = yVal;
    }

    public Pair (Pair p) {
        x = p.getX();
        y = p.getY();
    }
  
    public int getX () { return x; }
    public int getY () { return y; }
    public void setX (int newX) { x = newX; }
    public void setY (int newY) { y = newY; }
    public String getString () {return "(" + x + ", " + y + ")";}
  
    public Pair plus (Pair p) {
      Pair sum = new Pair(x + p.x, y + p.y);
      return sum;
    }
  }