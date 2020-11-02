import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.*;



public class DiskGame extends JPanel implements KeyListener {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private static final int FPS = 60;
    private static final int NUM_DISKS = 50;

    private static final int KEY_UP = 38;
    private static final int KEY_DOWN = 40;
    private static final int KEY_LEFT = 37;
    private static final int KEY_RIGHT = 39;
    private static final int KEY_Q = 81;

    private static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    
    Game game;

    public DiskGame(){
        game = new Game(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	this.addKeyListener(this);
	this.setFocusable(true);
    }

    
    public void keyTyped(KeyEvent e) {
	    
    }

    /* 
     * Method: void keyPressed(KeyEvent e) 
     * 
     * The code to be executed when a key is pressed. Specifically,
     * when the "up" arrow is pressed, the Game's ship should
     * accelerate upwards, when "down" is pressed, the ship should
     * accelerate downwards, etc.
     */
    public void keyPressed(KeyEvent e) {
	int code = e.getKeyCode();

	// complete method

	if (code == KEY_Q) {
	    System.out.println("Goodbye!");
	    System.exit(0);
	}

    }

    /* 
     * Method: void keyReleased(KeyEvent e) 
     * 
     * The code to be executed when a key is released. Specifically,
     * when the "up" arrow is released, the Game's ship should
     * stop accelerating upwards, etc.
     */
    public void keyReleased(KeyEvent e) {
	
	// complete method
	
    }

    
    public void run()
    {
        while(true){
            game.update(1.0 / (double)FPS);
            repaint();
            try{
                Thread.sleep(1000/FPS);
            }
            catch(InterruptedException e){}
        }

    }

    
    public static void main(String[] args){
        JFrame frame = new JFrame("Disk Game");
	System.out.println("Press 'q' to quit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DiskGame mainInstance = new DiskGame();
        frame.setContentPane(mainInstance);
        frame.pack();
        frame.setVisible(true);
        mainInstance.run();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);            
        g.setColor(MAMMOTH_PURPLE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        game.drawShapes(g);
    }
}
