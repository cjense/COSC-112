
public class Rectangle {
  private int x; // the x-coordinate of the upper left corner of the rectangle
  private int y; // the y-coordinate of the upper left corner of the rectangle
  private int width;
  private int height;

  public Rectangle (int x, int y, int width, int height) {
    // complete this code!
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public boolean Overlap(Rectangle r) {
    int area = this.width * this.height;
    if(r.x <= this.width && this.y <= this.height) {
      System.out.println("true");
        return true;
    }
    System.out.println("false");
    return false;
  }
  
  public int getX () { return x; }
  public int getY () { return y; }
  public int getWidth () { return width; }
  public int getHeight () { return height; }

  public static void main(String args[]) {
    
  }
}