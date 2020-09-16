// =============================================================================
/**
 * A <code>Cell</code> keeps track of its own liveness.  It also can determine
 * its own evolution by examining its neighbors and applying its survival rules.
 **/
// =============================================================================



// =============================================================================
public class Cell {
// =============================================================================

    

    // =========================================================================
    /**
     * The specialized constructor.  Create a new, initially-dead cell.
     *
     * @param grid The <code>Grid</code> that contains this cell.
     * @param row The row coordinate of this cell within its <code>Grid</code>.
     * @param column The column coordinate of this cell within its
     *               <code>Grid</code>.
     **/
    public Cell (Grid grid, int row, int column) {

	// Set the initial state to be dead.
	_isAlive = false;

	// Store the grid and the coorindates within that grid.
	_grid = grid;
	_row = row;
	_column = column;

    } // Cell()
    // =========================================================================



    // =========================================================================
    /**
     * Indicate whether this cell is currently dead or alive.
     *
     * @return <code>true</code> if the cell is alive; <code>false</code> if it
     *         is dead.
     **/
    public boolean isAlive () {

	return _isAlive;

    } // isAlive()
    // =========================================================================



    // =========================================================================
    /**
     * Set the cell to be alive.
     **/
    public void makeAlive () {

	_isAlive = true;
	
    } // makeAlive ()
    // =========================================================================



    // =========================================================================
    /**
     * Set the cell to be dead.
     **/
    public void makeDead () {

	_isAlive = false;
	
    } // makeDead ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the row coordinate of this cell in its <code>Grid</code>.
     *
     * @return The row coordinate of this cell.
     **/
    public int getRow () {

	return _row;

    } // getRow ()
    // =========================================================================




    // =========================================================================
    /**
     * Provide the column coordinate of this cell in its <code>Grid</code>.
     *
     * @return The column coordinate of this cell.
     **/
    public int getColumn () {

	return _column;

    } // getColumn ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide a textual representation of the cell's state.
     *
     * @return One particular character to represent liveness, another to
     *         represent deadness.  The characters chosen depend on the type of
     *         cell, and thus are determined by the subclasses.
     **/
    public String toString () {

	if (_isAlive) {
	    return "+";
	} else {
	    return "-";
	}
	
    }
    // =========================================================================



    // =========================================================================
    /**
     * Traverse the standard neighborhood (the surrounding 8 <code>Cell</code>s
     * in the <code>Grid</code>) and count the number of neighbors that are
     * alive.
     *
     * @return The number of live neighbors in the standard neighborhood.
     **/
    private int countLiveNeighbors () {
        int liveNeighbors = 0;

        for(int i = -1; i <= 1; i++) {
            for(int k = -1; k <= 1; k++) {
                Cell currentCell = _grid.getCell((_row + i), (_column + k));
                if(currentCell != null && currentCell != _grid.getCell(_row, _column)){
                    if(currentCell.isAlive() == true){
                        liveNeighbors++;
                    }
                } else {
                    liveNeighbors += 0;
            }
        }
    }
        System.out.println(liveNeighbors);
        return liveNeighbors;

    }
    // =========================================================================



    // =========================================================================
    /**
     * Based on its neighbors' states, evolve this cell by calculating and
     * adopting its state for next generation.  Here, the Conway rules are that
     * <i>a live cell with 2 or 3 live neighbors remains alive, a dead cell with
     * 3 live neighbors becomes alive, and all other cells will die</i>.
     **/
    public void evolve () {
        int currentNeighbors = this.countLiveNeighbors();

        if(this.isAlive() && currentNeighbors < 2){
            _willBeAlive = false; // if there are less than 2 live neighbors, cell is marked dead
        } else if(this.isAlive() && (currentNeighbors == 2 || currentNeighbors == 3)){
            _willBeAlive = true; // if there are 2 or 3 live neighbors, cell is marked alive
        } else if(this.isAlive() && (currentNeighbors > 4 || currentNeighbors == 4)){
            _willBeAlive = false; // if there are 4 or more live neighbors, cell is marked dead
        } else if(this.isAlive() == false && currentNeighbors == 3){
            _willBeAlive = true; // if there are exactly 3 live neighbors next to a dead cell, it is marked alive
        }

    } // evolve ()
    // =========================================================================



    // =========================================================================
    /**
     * Advance to the next generation.
     **/
    public void advance () {

        if(_willBeAlive == true){ // if a cell is marked alive for next round, make it alive
            this.makeAlive();
        } else {
            this.makeDead();
        }
	
    }
    // =========================================================================



    // =========================================================================
    // DATA MEMBERS

    /**
     * The current liveness.
     **/
    boolean _isAlive;

    /**
     * The liveness in the next generation.
     **/
    boolean _willBeAlive;

    /**
     * The <code>Grid</code> that contains this cell.
     **/
    Grid _grid;

    /**
     * The cell's row coordinate within its <code>Grid</code>.
     **/
    int _row;

    /**
     * The cell's column coordinate within its <code>Grid</code>.
     **/
    int _column;

    /**
     * Whether to provide debugging information.
     **/
    final static boolean _debug = false;
    // =========================================================================



// =============================================================================
} // class Cell
// =============================================================================
