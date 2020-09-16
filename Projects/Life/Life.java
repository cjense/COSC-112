// =============================================================================
/**
 * The <code>Life</code> class.  This class is the entry point -- that is, it is
 * the class that is invoked on the command line to begin the creation of
 * objects used to play the game.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edu
 */
// =============================================================================



// =============================================================================
public class Life {
// =============================================================================


    
    // =========================================================================
    /**
     * The program's entry point.
     *
     * @param args Command line arguments containing the pathname to the initial
     *             state of the universe and the number of generations to
     *             compute.
     */
    public static void main (String[] args) {

	// If the wrong number of arguments were passed, show the usage and
	// exit.
	if (args.length != 3) {
	    showUsageAndExit();
	}

	// Assign names to the command line arguments.
	String initialStatePathname = args[0];
	int generations = 0;
	try {
	    generations = Integer.parseInt(args[1]);
	} catch (NumberFormatException e) {
	    showUsageAndExit();
	}
	String interfaceType = args[2];
	    
	// Create the game; then create the interface to control the game.
	Game game = new Game(initialStatePathname);
	UserInterface ui = null;
	if (interfaceType.equals("Text")) {
	    ui = new TextInterface(game);
	} else if (interfaceType.equals("Graphic")) {
	    ui = new GraphicInterface(game);
	} else {
	    showUsageAndExit();
	}
	
	// Play the game, evolving one generation at a time.
	game.play(generations, ui);

    } // main ()
    // =========================================================================



    // =========================================================================
    /**
     * Print the correct command-line usage and then exit.
     **/
    protected static void showUsageAndExit () {

	Support.abort("USAGE: java Life <initial state pathname>\n" +
		      "                 <number of generations to compute>\n" +
		      "                 <interface type [Text | Graphic]>");
	
    }
    // =========================================================================



// =============================================================================
} // class Life
// =============================================================================
