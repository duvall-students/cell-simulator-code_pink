package application;

import java.awt.Point;

/*
 * @author Milli kearse
 */

public class RockPaperScissorsController {
	
	private final int NUM_ROWS = 18; 
	private final int NUM_COLUMNS = 18;
	
	//setting up grid
	private RockPaperScissors rockPaperScissors;
	private RockPaperScissorsDisplay rockPaperScissorsDisplay;
	
	public RockPaperScissorsController(RockPaperScissorsDisplay view) {
		int numRows = NUM_ROWS;
		int numColumns = NUM_COLUMNS;
		rockPaperScissors = new RockPaperScissors(numRows, numColumns);
		rockPaperScissorsDisplay = view;
	}
	
	public Point getGridDimensions() {
		return new Point(NUM_ROWS, NUM_COLUMNS);
	}

	public int getNumRows() {
		return NUM_ROWS;
	}
	
	public int getNumCols() {
		return NUM_COLUMNS;
	}
	public void newModel() {
		rockPaperScissors.createModel(rockPaperScissors.getNumRows(), rockPaperScissors.getNumCols());
	}
	public int getCellState(Point position) {
		return rockPaperScissors.get(position);
	}
	
}
