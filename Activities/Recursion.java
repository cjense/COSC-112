import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;

/*
 *  This program uses recursion to draw a figure consisting of nested
 *  boxes with text.
 */


public class Recursion extends JPanel {
    
    public static final int BOX_WIDTH = 512;
    public static final int BOX_HEIGHT = 768;

    // relative size of recursive image
    public static final double RATIO = 3.0 / 4;

    // ratio of text size to box height
    public static final double TEXT_RATIO = 1.0 / 16;

    // ratio of text margins to box width
    public static final double TEXT_MARGIN_RATIO = 1.0 / 16;

    // message to be printed
    public static final String MESSAGE = "RECURSION!";

    private int depth;

    
    public Recursion(int depth){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
	this.depth = depth;
    }

    
    /* 
     *  method drawTextBox(Graphics g, int x, int y, int width, int
     *  height) draws a rectangle with text at the bottom. x and y are
     *  the coordinates of the upper left corner of the rectangle;
     *  width and height specify the width and height of the box.
     */
    private void drawTextBox(Graphics g, int x, int y, int width, int height) {

	// draw a rectangle
	g.setColor(Color.BLACK);
	g.drawRect(x, y, width, height);

	// determine the text size
	int textSize = (int) (height * TEXT_RATIO);

	// determine the text margins
	int textMargin = (int) (width * TEXT_MARGIN_RATIO);

	// coordinates to print message
	int xCoord = x + textMargin;
	int yCoord = y + height - textMargin;

	// set up the font
	g.setColor(Color.BLACK);
	g.setFont(new Font("Times New Roman", Font.BOLD, textSize));

	// print the text
	g.drawString(MESSAGE, xCoord, yCoord);
    }

    // draws recursive squares
    private void drawFigure(Graphics g, int x, int y, int width, int height, int curDepth) {
	
	drawTextBox(g, x, y, width, height);

	// draw a smaller figure if the new figure will have width at
	// least 1 pixel. How would you modify this to stop
	if (width * RATIO >= 1) {
	    int xMargin = (int) (width * (1 - RATIO) / 2);
	    int yMargin = (int) (height * (1 - RATIO) / 2);
	    int newWidth = (int) (width * RATIO);
	    int newHeight = (int) (height * RATIO);

		
	    drawFigure(g, x + xMargin, y + yMargin, newWidth, newHeight, curDepth + 1);
	}
    }
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

	// draw the figure!
	drawFigure(g, 0, 0, BOX_WIDTH, BOX_HEIGHT, 0);
    }
    
    public static void main(String args[]){
	// set default recursion depth
	int depth = 10;
	
	// if an argument is passed, use that value as recursion depth
	if (args.length > 0) {
	    depth = Integer.parseInt(args[0]);
	}
	
        JFrame frame = new JFrame("Recursion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Recursion(depth));
        frame.pack();
        frame.setVisible(true);
    }
}
