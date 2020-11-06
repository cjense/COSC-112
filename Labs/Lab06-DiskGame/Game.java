import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

class Game {
    private static final int SHIP_RADIUS = 20;
    private static final int HAZARD_RADIUS = 10;
    private static final int GOAL_RADIUS = 5;

    private static final Color SHIP_COLOR = Color.WHITE;
    private static final Color HAZARD_COLOR = Color.RED;
    private static final Color GOAL_COLOR = Color.GREEN;

    private static final int NUM_HAZARDS = 5;
    private static final int NUM_GOALS = 5;

    private static final double ACCEL_FACTOR = 50.0;
    
    private int width;
    private int height;

    private int goalcount = 0;
    private int lives = 2;

    private ArrayList<BouncingDisk> hazards = new ArrayList<BouncingDisk>();
    private ArrayList<BouncingDisk> goals = new ArrayList<BouncingDisk>();
    private BouncingDisk ship;

    public Game(int width, int height){
        this.width = width;
        this.height = height;

	ship = new BouncingDisk(this, SHIP_RADIUS, SHIP_COLOR, new Pair(width / 2, height / 2));

	reset();

    }

    /*
     * Method: reset()
     *
     * Removes all hazards and goals (if any), then repopulates the
     * game with new hazards and goals in new locations. The number of
     * goals should be NUM_GOALS, while the number of hazards should
     * be NUM_HAZARDS.
     */
    private void reset () {
	
        for(int i = 0; i < hazards.size(); i++) {
            hazards.remove(i);
        }

        for(int i = 0; i < goals.size(); i++) {
            goals.remove(i);
        }

        for(int i = 0; i < NUM_GOALS; i++) {
            BouncingDisk goal = new BouncingDisk(this, GOAL_RADIUS, GOAL_COLOR);
            goals.add(goal);
        }

        for(int i = 0; i < NUM_HAZARDS; i++) {
            BouncingDisk hazard = new BouncingDisk(this, HAZARD_RADIUS, HAZARD_COLOR);
            hazards.add(hazard);
        }
	
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    /*
     * Method: drawShapes(Graphics g)
     *
     * This method draws all of the shapes on the screen: the ship,
     * all hazards, and goals.
     */
    public void drawShapes(Graphics g){

        for(int i = 0; i < hazards.size(); i++) {
            (hazards.get(i)).draw(g);
        }

        for(int i = 0; i < goals.size(); i++) {
            (goals.get(i)).draw(g);
        }
        
        ship.draw(g);
    
    }

    /*
     * Method setShipVertAccel (int amount)
     *
     * Sets the vertical (y) component of the ship's acceleration. The
     * ship's acceleration should always be an integer multiple of
     * ACCEL_FACTOR.
     */
    public void setShipVertAccel (int amount) {

        ship.setAcceleration(new Pair(0, (ACCEL_FACTOR * amount)));
	
    }

    /*
     * Method setShipHorAccel (int amount)
     *
     * Sets the horizontal (x) component of the ship's
     * acceleration. The ship's acceleration should always be an
     * integer multiple of ACCEL_FACTOR.
     */
    public void setShipHorAccel (int amount) {

        ship.setAcceleration(new Pair((ACCEL_FACTOR * amount), 0));

    }


    public void update(double time){

	ship.update(this, time);
	checkGoalCollision();
	checkHazardCollision();
	
    }

    /*
     * Method: checkGoalCollision ()
     *
     * Checks for a collision (overlap) between ship and a goal
     * disk. If a collision is detected, the goal disk should be
     * removed from goals. If after removal, goals is empty, the game
     * should be repopulated by calling the reset() method.
     */
    private void checkGoalCollision () {

        for(int i = 0; i < goals.size(); i++) {
            if(ship.overlaps(goals.get(i))) {
                goals.remove(goals.get(i));
                goalcount++;
                System.out.println("Score: " + goalcount);
            }
            if(goals.size() == 0) {
                reset();
            }
        }	
    }

    /*
     * Method: checkHazardCollision ()
     *
     * Checks for a collision (overlap) between ship and a hazard
     * disk. If a collision is detected, the method should print a
     * message to the console saying that a hazard collision occurred,
     * then exit the game (or some other behavior).
     */
    private void checkHazardCollision () {

        for(int i = 0; i < hazards.size(); i++) {
            if(ship.overlaps(hazards.get(i)) && lives > 0) {
                System.out.println("Lives: " + lives);
                lives -= 1;
                hazards.remove(hazards.get(i));
            } else if(ship.overlaps(hazards.get(i)) && lives == 0) {
                System.out.println("Final Score: " + goalcount);
                System.exit(0);
            }
        }	
	
    }
}
