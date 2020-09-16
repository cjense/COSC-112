import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
// import java.lang.ref.Cleaner;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class HelloGraphics extends JPanel{
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;
    public static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    public static final Color SPRING_LEAF = new Color(91, 161, 81);
    public static int x = 0;
    public static int y = 0;

    public HelloGraphics(){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }
    
    //Your code here, if you want to define additional methods.
        
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        //Your code here: feel free to remove what is below
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

        for(int i = 0; i < 5; i++) {
            y += 80;
            x = 0;
            for(int j = 0; j < 5; j++) {
                g.setColor(Color.ORANGE);
                g.fillOval(x + 60, y + 70, 60, 70);
    
                g.fillOval(x + 55, y + 120, 20, 25);
                g.fillOval(x + 90, y + 120, 20, 25);
    
                g.setColor(Color.black);
                g.fillOval(x + 60, y + 100, 5, 7);
                g.fillOval(x + 90, y + 100, 5, 7);
    
                g.setColor(Color.MAGENTA);
                g.drawOval(x + 70, y + 125, 15, 10);
                x += 70;
            }
        }
    }
    
    public static void main(String args[]){
        JFrame frame = new JFrame("Hello, Graphics!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HelloGraphics());
        frame.pack();
        frame.setVisible(true);
    }
}
