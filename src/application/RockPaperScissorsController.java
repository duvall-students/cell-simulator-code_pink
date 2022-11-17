package application;

import java.awt.Point;

/*
 * @author Milli kearse
 */

public class RockPaperScissorsController {
	
	//setting up grid
	private final int INITIAL_NUM_ROWS = 18; 
	private final int INITIAL_NUM_COLUMNS = 18;
	
	
	
	private RockPaperScissors rockPaperScissors;
	private RockPaperScissorsDisplay rockPaperScissorsDisplay;
	
	public RockPaperScissorsController(RockPaperScissorsDisplay view) {
		int numRows = INITIAL_NUM_ROWS;
		int numColumns = INITIAL_NUM_COLUMNS;
		rockPaperScissors = new RockPaperScissors(numRows, numColumns);
		rockPaperScissorsDisplay = view;
	}
	
	public Point getGridDimensions() {
		return new Point(INITIAL_NUM_ROWS, INITIAL_NUM_COLUMNS);
	}

	public int getNumRows() {
		return INITIAL_NUM_ROWS;
	}
	
	public int getNumCols() {
		return INITIAL_NUM_COLUMNS;
	}
	
	//Re-create the grid from scratch.
	public void newModel() {
		rockPaperScissors.createModel(rockPaperScissors.getNumRows(), rockPaperScissors.getNumCols());
		rockPaperScissorsDisplay.redraw();
	}
	public int getCellState(Point position) {
		return rockPaperScissors.get(position);
	}
	
	
}
