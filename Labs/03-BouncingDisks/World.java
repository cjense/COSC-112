import java.awt.Color;
import java.awt.Graphics;

class World {
    private int width;
    private int height;
    
    int numDisks;
    BouncingDisk[] disks;

    public World(int width, int height, int numDisks){
        this.width = width;
        this.height = height;

        this.numDisks = numDisks;
        disks  = new BouncingDisk[numDisks];
        
        for (int i = 0; i < numDisks; i ++) {
	    disks[i] = new BouncingDisk(this);
	}
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void drawDisks(Graphics g){
        for (int i = 0; i < numDisks; i++){
            disks[i].draw(g);
        }
    }

    public void update(double time){
        for (int i = 0; i < numDisks; i ++) {
	    disks[i].update(this, time);
	}
    }

}
