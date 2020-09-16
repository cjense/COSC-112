// =============================================================================
/**
 * A graphically-based user-interface for the <i>Game of Life</i>.  A
 * <code>GraphicInterface</code> controls the progression from one generation to
 * the next, displaying the state at each generation.
 **/
// =============================================================================



// =============================================================================
// IMPORT

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
// =============================================================================



// =============================================================================
public class GraphicInterface extends JPanel implements UserInterface {
// =============================================================================



    // =========================================================================
    /**
     * The constructor.  Hold onto a pointer to the <code>Game</code> for which
     * this <code>GraphicInterface</code> is providing interaction.
     *
     * @param game The <code>Game</code> whose state to draw.
     */
    public GraphicInterface (Game game) {

	_game   = game;
	_width  = game.getRows()    * _boxSize;
	_height = game.getColumns() * _boxSize;
	
	setPreferredSize(new Dimension(_width, _height));
	JFrame frame = new JFrame("Life");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);

    } // GraphicInterface ()
    // =========================================================================



    // =========================================================================
    public void display (Graphics g) {

	// Draw the background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, _width, _height);

        // Iterate over all cells
        for (int row = 0; row < _game.getRows(); row += 1) {
            for (int column = 0; column < _game.getColumns(); column += 1) {

		// The coordinates of this cell.
		int initx = column * _boxSize;
		int inity = row    * _boxSize;

		// Fill a cell with color depending on its state
		Cell  cell = _game.getCell(row, column);
		Color color = (cell.isAlive() ? Color.RED : Color.BLACK);
		g.setColor(color);
		g.fillRect(initx, inity, _boxSize, _boxSize);

		// Draw a boundary to around the cell.
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(initx, inity, _boxSize, _boxSize);

	    }
        }
	
    } // display ()
    // =========================================================================



    // =========================================================================
    /**
     * Display the state of the <code>Cell</code>s in the <code>Grid</code>.
     */
    public void display () {

	// Provide generation and population counts.
	System.out.println("Generation = " + _game.getGeneration() +
			   ", Population = " + _game.getPopulation());

	repaint();

    } // display ()
    // =========================================================================



    // =========================================================================
    public void paintComponent (Graphics g) {
	
        super.paintComponent(g);
        display(g);
	
    } // paintComponent ()
    // =========================================================================



    // =========================================================================
    /**
     * Keep control of the program until it is time to advance the state of the
     * <code>Game</code>.
     */
    public void triggerMove () {

	// Pause for a fixed interval.
	try {
	    Thread.sleep(_wait);
	} catch(InterruptedException e) {}
	
    } // triggerMove ()
    // =========================================================================



    // =========================================================================
    // DATA MEMBERS

    /** The window width. */
    private int _width;

    /** The default window height. */
    private int _height;

    /** The size of the boxes for each cell. */
    private final static int _boxSize = 20;

    /** The delay between generations, in ms. */
    private final static int _wait   = 500;
    
    /** The <code>Game</code> that this interface is controlling. */
    private Game _game;
    // =========================================================================



// =============================================================================
} // class GraphicInterface
// =============================================================================
