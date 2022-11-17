package application;

import java.awt.Point;

public class RockPaperScissorsController {
	private final int INITIAL_NUM_OF_ROWS = 18; // initial number of rows
	private final int INITIAL_NUM_OF_COLS = 18; // initial number of rows
	

	private final int NUM_ROWS = 18; 
	private final int NUM_COLUMNS = 18;

	int numRows;
	int numColumns;

	
	private RockPaperScissors rps;
	
	public RockPaperScissorsController(RockPaperScissorsDisplay rpsDisplay){
		numRows = INITIAL_NUM_OF_ROWS;
		numColumns = INITIAL_NUM_OF_COLS;
		rps = new RockPaperScissors(numRows, numColumns);
	}
	
	public int getRows(){
		return numRows;
	}
	
	public int getColumns(){
		return numColumns;
	}
	
	public Point getMazeDimensions() {
		return new Point(numRows, numColumns);
	}
	public void newModel() {
		rockPaperScissors.createModel(rockPaperScissors.getNumRows(), rockPaperScissors.getNumCols());
	}
	public int getCellState(Point position) {
		return rockPaperScissors.get(position);
	}
	
	public void newModel() {
		rps.createModel(rps.getNumRows(),rps.getNumCols());
	}
	
	public int getCellState(Point position) {
		return rps.get(position);
	}
}