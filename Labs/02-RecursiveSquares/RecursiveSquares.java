<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

/*
 *  COSC 112, Fall 2020, Lab 02: R
 *  Name: Claire Jensen
 *
 *  Description: This lab demonstrates how recursion can be employed
 *  in graphics to create fractal patterns. It produces four figures
 *  consisting of overlapping squares in different positions.
 */


public class RecursiveSquares extends JPanel {
    
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;
    public static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    public static final Color SPRING_LEAF_LIGHT = new Color(147, 210, 143);

    public static final double SQUARE_RATIO = 2.2;
    public static final int DEFAULT_DEPTH = 6;

    private int depth;

    
    public RecursiveSquares(int depth){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
	this.depth = depth;
    }

    // you add drawing methods here

    public void square1(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square1(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square1(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square1(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square
        square1(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square
        
        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

    }

    public void square2(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        int nSize = (int) (size / 2.2); // defines new size for variables

        square2(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square2(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square2(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square
        square2(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square

    }

    public void square3(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square3(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square3(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        square3(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square3(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square

    }

    public void square4(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square4(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square4(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        square4(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square4(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square
        
    }
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

	// make the background
        g.setColor(MAMMOTH_PURPLE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

    // call your drawing method(s) here
    square1(g, depth, 100, 100, 200); // top left
    square2(g, depth, 500, 100, 200); // top right
    square3(g, depth, 500, 500, 200); // bottom right
    square4(g, depth, 100, 500, 200); // bottom left

    }
    
    public static void main(String args[]){
	// set default recursion depth
	int depth = DEFAULT_DEPTH;
	
	// if an argument is passed, use that value as recursion depth
	if (args.length > 0) {
	    depth = Integer.parseInt(args[0]);
	}
	
        JFrame frame = new JFrame("Recursive Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RecursiveSquares(depth));
        frame.pack();
        frame.setVisible(true);
    }
}
=======
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

/*
 *  COSC 112, Fall 2020, Lab 02: R
 *  Name: Claire Jensen
 *
 *  Description: This lab demonstrates how recursion can be employed
 *  in graphics to create fractal patterns. It produces four figures
 *  consisting of overlapping squares in different positions.
 */


public class RecursiveSquares extends JPanel {
    
    public static final int BOX_WIDTH = 1024;
    public static final int BOX_HEIGHT = 768;
    public static final Color MAMMOTH_PURPLE = new Color(63, 31, 105);
    public static final Color SPRING_LEAF_LIGHT = new Color(147, 210, 143);

    public static final double SQUARE_RATIO = 2.2;
    public static final int DEFAULT_DEPTH = 6;

    private int depth;

    
    public RecursiveSquares(int depth){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
	this.depth = depth;
    }

    // you add drawing methods here

    public void square1(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square1(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square1(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square1(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square
        square1(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square
        
        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

    }

    public void square2(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        int nSize = (int) (size / 2.2); // defines new size for variables

        square2(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square2(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square2(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square
        square2(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square

    }

    public void square3(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square3(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square3(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        square3(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square3(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square

    }

    public void square4(Graphics g, int depth, int xPos, int yPos, int size) {

        if(depth == 0) {
            g.fillRect(xPos, yPos, size, size);
            return;
        } // base case: if depth == 0, draw a square

        int nSize = (int) (size / 2.2); // defines new size for variables

        square4(g, (depth - 1), (xPos - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom left square
        square4(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos + size - (nSize / 2)), nSize); // bottom right square

        g.setColor(Color.orange); // fill squares in orange
        g.fillRect(xPos, yPos, size, size);

        g.setColor(Color.black); // outline the squares
        g.drawRect(xPos, yPos, size, size);

        square4(g, (depth - 1), (xPos - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top left square
        square4(g, (depth - 1), (xPos + size - (nSize / 2)), (yPos - (nSize / 2)), nSize); // top right square
        
    }
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

	// make the background
        g.setColor(MAMMOTH_PURPLE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

    // call your drawing method(s) here
    square1(g, depth, 100, 100, 200); // top left
    square2(g, depth, 500, 100, 200); // top right
    square3(g, depth, 500, 500, 200); // bottom right
    square4(g, depth, 100, 500, 200); // bottom left

    }
    
    public static void main(String args[]){
	// set default recursion depth
	int depth = DEFAULT_DEPTH;
	
	// if an argument is passed, use that value as recursion depth
	if (args.length > 0) {
	    depth = Integer.parseInt(args[0]);
	}
	
        JFrame frame = new JFrame("Recursive Squares");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RecursiveSquares(depth));
        frame.pack();
        frame.setVisible(true);
    }
}
>>>>>>> d64aae04f5f6455e52738f4a7b9be49df14750f0
