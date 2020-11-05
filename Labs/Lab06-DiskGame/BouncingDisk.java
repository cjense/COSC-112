import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BouncingDisk {
    
    private Pair position;      // position of the center
    private Pair velocity;      
    private Pair acceleration;
    private double radius;
    private Color color;
    private Game game;        // the game to which the disk belongs

    public BouncingDisk(Game game, double radius, Color color, Pair position) {
	this.game = game;
	this.radius = radius;
	this.color = color;
	this.position = position;
	this.velocity = new Pair(0, 0);
	this.acceleration = new Pair(0, 0);
    }

    public BouncingDisk(Game game, double radius, Color color) {
	
	this.game = game;
	this.radius = radius;
	this.color = color;
	this.velocity = new Pair(0, 0);
	this.acceleration = new Pair(0, 0);

	Random rand = new Random();

	int xMin = (int) radius;
	int xMax = (int) (game.getWidth() - radius);
	int yMin = (int) radius;
	int yMax = (int) (game.getHeight() - radius);
	
        this.position = new Pair((double) (xMin + rand.nextInt(xMax - xMin)),
			    (double) (yMin + rand.nextInt(yMax - yMin)));

    }

    public void update(Game w, double time){
        position = position.add(velocity.times(time));
        velocity = velocity.add(acceleration.times(time));
        bounce();
    }
    
    public void setPosition(Pair p){ position = p; }
    public void setVelocity(Pair v){ velocity = v; }
    public void setAcceleration(Pair a){ acceleration = a; }
    public void setRadius (double r) { radius = r;}

    public Pair getPosition () { return position; }
    public Pair getVelocity () { return velocity; }
    public Pair getAcceleration () { return acceleration; }
    public double getRadius () { return radius; }

    public void draw(Graphics g) {
	g.setColor(color);
	g.fillOval( (int) (position.x - radius),
		    (int) (position.y - radius),
		    (int) (2 * radius), (int) (2 * radius));

    }

    private void bounce(){
	
        if (position.x - radius <= 0){
            velocity.flipX();
            position.x = radius;
        }
	else if (position.x + radius >= game.getWidth()){
            velocity.flipX();
            position.x = game.getWidth() - radius;
        }
	
        if (position.y - radius <= 0){
            velocity.flipY();
            position.y = radius;
        } else if(position.y + radius >=  game.getHeight()){
            velocity.flipY();
            position.y = game.getHeight() - radius;
        }
    }

    /*
     * Method: boolean overlaps (BouncingDisk bd)
     * 
     * Returns true if and only if this disk overlaps with bd. Note
     * that two circles overlap when the distance between their
     * centers is at most the sum of their radii.
     */
    public boolean overlaps (BouncingDisk bd) {

	return (position.distanceFrom(bd.position) <= radius + bd.radius);
	
    }

}
