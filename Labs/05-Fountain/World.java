import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class World {
    public static final int ACCEL = 100;
    public static final int DROPLET_SIZE = 4;
    
    private int width;
    private int height;
    private Random rand;

    private ShapeCollection droplets;

    public World(int width, int height){
        this.width = width;
        this.height = height;

	rand = new Random();
	
	droplets = new ShapeCollection();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }


    
    ////////////////////////////////////////////////////////////
    // method: void drawShapes(Graphics g)
    // 
    // description: Draws all shapes in the World. For the basic
    // program, it will iterate over all shapes in droplets
    // draw each one. If you implement an extension that draws
    // other shapes as well, they should be drawn in this method
    // as well
    ////////////////////////////////////////////////////////////

    public void drawShapes(Graphics g){
        Shape currentDroplet2 = droplets.getFirst();
        currentDroplet2.draw(g);
        Shape currentDroplet3 = droplets.getNext();

        while(currentDroplet3 != null) {
            currentDroplet3.draw(g);
            currentDroplet3 = droplets.getNext();
        }

    }

    ////////////////////////////////////////////////////////////
    // method: void update (double time)
    // 
    // description: Updates the World to the next frame, where
    // time is the amount of time elapsed between consecutive
    // frames. Each update state should do the following:
    //   1. add one or more new shapes using the addDroplet()
    //      method
    //   2. iterate over all shapes in droplets and (a) update
    //      update the droplet's state (using Shape's update
    //      method), and (b) if the shape is no longer visible
    //      it should be removed from droplets.
    ////////////////////////////////////////////////////////////

    public void update (double time){
        addDroplet();
        addDroplet();
        addDroplet();
        addDroplet();
        Shape currentDroplet = droplets.getFirst();
        currentDroplet.update(time);

        Shape currentDroplet4 = droplets.getNext();
        currentDroplet4.update(time);

        while(currentDroplet4 != null) {
            if(currentDroplet4.isVisible() == false) {
                droplets.remove(currentDroplet4);
            }
            currentDroplet4.update(time);
            currentDroplet4 = droplets.getNext();
        }
    }

    ////////////////////////////////////////////////////////////
    // method: void addDroplet ()
    // 
    // description: Creates a new shape--specifically, a Disk--
    // and appends it to the droplets collection. The initial
    // position of the disk should be at the top of the
    // Fountain drawn in the "drawForeground" method in
    // Fountain.java. The initial velocity should be randomized
    // so that not all droplets follow the same trajectory.
    // Reasonable values for the initial velocity are between
    // (approximately) -50 to 50 (pixels per second) in the
    // horizontal direction, and between 100 and 300 in the
    // vertical direction. The acceleration should be set to
    // 0 in the horizontal direction, and ACCEL in the vertical
    // direction.
    ////////////////////////////////////////////////////////////
    
    private void addDroplet () {
        Pair positionPair = new Pair(1024/2, 668);
        Pair velocityPair = new Pair((double) (rand.nextInt(100) - 50), -(double)(rand.nextInt(200) + 100));
        Pair accelerationPair = new Pair(0.0, ACCEL);

        droplets.append(new Disk(this, DROPLET_SIZE, positionPair, velocityPair, accelerationPair, Color.WHITE));
    }

}
