import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;



public class Bouncing extends JPanel{
    public static final int WIDTH = 1024;    // width of the world
    public static final int HEIGHT = 768;    // height of the world
    public static final int FPS = 60;        // frames per second for animation
    public static final int NUM_DISKS = 50;
    
    private World world;

    public Bouncing(){
        world = new World(WIDTH, HEIGHT, NUM_DISKS);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void run()
    {
        while(true){
            world.update(1.0 / (double) FPS);
            this.repaint();
            try{
                Thread.sleep(1000/FPS);
            }
            catch(InterruptedException e){}
        }

    }

    
    public static void main (String[] args){
        JFrame frame = new JFrame("Bouncing Disks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Bouncing mainInstance = new Bouncing();
        frame.setContentPane(mainInstance);
        frame.pack();
        frame.setVisible(true);
        mainInstance.run();
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);            
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        world.drawDisks(g);
    }
}
