import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class Fountain extends JPanel{
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    public static final int FOUNTAIN_WIDTH = 50;
    public static final int FOUNTAIN_HEIGHT = 100;
    
    public static final int FPS = 60;
    public static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    public static final Color DARK_GREY = new Color(66, 66, 66);

    World world;

    public Fountain(){
        world = new World(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void run()
    {
        while(true){
            world.update(1.0 / (double)FPS);
            repaint();
            try{
                Thread.sleep(1000/FPS);
            }
            catch(InterruptedException e){}
        }

    }

    
    public static void main(String[] args){
        JFrame frame = new JFrame("Fountain");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fountain mainInstance = new Fountain();
        frame.setContentPane(mainInstance);
        frame.pack();
        frame.setVisible(true);
        mainInstance.run();
    }

    public void drawBackground (Graphics g) {
	g.setColor(MAMMOTH_PURPLE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void drawForeground (Graphics g) {
	g.setColor(DARK_GREY);
	g.fillRect((WIDTH - FOUNTAIN_WIDTH) / 2,
		   (HEIGHT - FOUNTAIN_HEIGHT),
		   FOUNTAIN_WIDTH,
		   FOUNTAIN_HEIGHT);
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);            
	drawBackground(g);
        world.drawShapes(g);
	drawForeground(g);
    }
}
