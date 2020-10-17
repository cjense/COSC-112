import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Disk extends Shape {
    private Color color;
    
    public Disk(World w, int diameter, Pair position, Pair velocity, Pair acceleration, Color color) {
	super(w, diameter, diameter, position, velocity, acceleration);
	this.color = color;
    }
    
    public void draw(Graphics g) {
	g.setColor(color);
	g.fillOval( (int) (position.x - width / 2),
		    (int) (position.y - height / 2),
		    width, height);

    }
}