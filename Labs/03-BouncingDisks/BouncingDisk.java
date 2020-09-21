import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BouncingDisk {
    public static final int DEFAULT_RADIUS = 25;
    
    private Pair position;      // position of the center
    private Pair velocity;      
    private Pair acceleration;
    
    private double radius = DEFAULT_RADIUS;
    private Color color;

    private World world;
    
    public BouncingDisk(World world) {
	this.world = world;
	
        Random rand = new Random();

	int xMin = (int) radius;
	int xMax = (int) (world.getWidth() - radius);
	int yMin = (int) radius;
	int yMax = (int) (world.getWidth() - radius);

	
        position = new Pair((double) (xMin + rand.nextInt(xMax - xMin)),
			    (double) (yMin + rand.nextInt(yMax - yMin)));
	
        velocity = new Pair((double) (rand.nextInt(200) - 100),
			    (double) (rand.nextInt(200) - 100));
	
        acceleration = new Pair(0.0, 0.0);
	
        color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
    }

    public void update(World w, double time){
        position = position.add(velocity.times(time));
        velocity = velocity.add(acceleration.times(time));
        bounce();
    }
    
    public void setPosition(Pair p){
        position = p;
    }

    public void setVelocity(Pair v){
        velocity = v;
    }

    public void setAcceleration(Pair a){
        acceleration = a;
    } 

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
	else if (position.x + radius >= world.getWidth()){
            velocity.flipX();
            position.x = world.getWidth() - radius;
        }
	
        if (position.y - radius <= 0){
            velocity.flipY();
            position.y = radius;
        } else if(position.y + radius >=  world.getHeight()){
            velocity.flipY();
            position.y = world.getHeight() - radius;
        }
    }
}
