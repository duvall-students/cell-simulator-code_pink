package application;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @author Milli kearse
 */

public class RockPaperScissorsController {
	
	//setting up initial grid
	private final int INITIAL_NUM_ROWS = 18; 
	private final int INITIAL_NUM_COLUMNS = 18;
	
	private RockPaperScissors rockPaperScissors;
	private RockPaperScissorsDisplay rockPaperScissorsDisplay;
	
	//where to look
	private Point start;
	
	public RockPaperScissorsController(int rows, int cols, RockPaperScissorsDisplay view) {
		//int numRows = INITIAL_NUM_ROWS;
		//int numColumns = INITIAL_NUM_COLUMNS;
		int numRows = rows;
		int numColumns = cols;
		start = new Point(rows/2,cols/2);
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
	public void newModel(int rows, int cols) {
		rockPaperScissors.createModel(rows, cols);
		rockPaperScissorsDisplay.redraw();
	}
	
	public int getCellState(Point position) {
		return rockPaperScissors.get(position);
	}
	
	// Does a step regardless of pause status
	public void doOneStep(double elapsedTime){
		if (rockPaperScissors != null) {
			step();
		}
		rockPaperScissorsDisplay.redraw();
	}
	
	public void step() {
		HashMap<String, Integer> neighbors = rockPaperScissors.getNeighbors(start);
		rockPaperScissors.createModel(getNumRows(), getNumRows());
		rockPaperScissors.convertType(start);
		/*for (Map.Entry<String, Integer> mapElement: neighbors.entrySet()) {
			String key = mapElement.getKey();
			int value = mapElement.getValue();
			rockPaperScissors.convertType(start);
			
			System.out.println(key+" : "+value);
		}*/
		
	}
	
	public void startSimulation() {
		step();
	}
}
