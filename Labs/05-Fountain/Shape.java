import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Shape {
    protected Pair position;      // position of the center
    protected Pair velocity;      
    protected Pair acceleration;

    protected int width;
    protected int height;
    
    protected World world;
    
    public Shape(World world, int width, int height, Pair position, Pair velocity, Pair acceleration) {
	this.world = world;
	this.width = width;
	this.height = height;
	this.position = position;
	this.velocity = velocity;
	this.acceleration = acceleration;
    }

    public Pair getPosition() { return position; }

    public void update (double time){
        position = position.add(velocity.times(time));
	    velocity = velocity.add(acceleration.times(time));
    }

    public boolean isVisible () {
	return ((position.x >= - width)
		&& (position.x <= world.getWidth() + width)
		&& (position.y >= - height)
		&& (position.y <= world.getHeight() + height));
    }
    
    public abstract void draw(Graphics g);
}
