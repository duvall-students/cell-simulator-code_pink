package application;

import java.awt.Point;

public class RockPaperScissorsController {
	private final int NUM_ROWS =30; 
	private final int NUM_COLUMNS = 30;
	
	private RockPaperScissors rps;
	
	public RockPaperScissorsController(RockPaperScissorsDisplay rpsDisplay){
		int numRows = NUM_ROWS;
		int numColumns = NUM_COLUMNS;
		rps = new RockPaperScissors(numRows, numColumns);
	}
	
	public int getRows(){
		return NUM_ROWS;
	}
	
	public int getColumns(){
		return NUM_COLUMNS;
	}
	
	public Point getMazeDimensions() {
		return new Point(NUM_ROWS, NUM_COLUMNS);
	}
	
	public void newModel() {
		rps.createModel(rps.getNumRows(),rps.getNumCols());
	}
	
	public int getCellState(Point position) {
		return rps.get(position);
	}

}
