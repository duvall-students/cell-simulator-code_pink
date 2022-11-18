package application;

import java.awt.Point;
import java.util.Collection;
import java.util.Stack;

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
	
	// Does a step regardless of pause status
	public void doOneStep(double elapsedTime){
		if (rockPaperScissors != null) {
			step();
		}
		rockPaperScissorsDisplay.redraw();
	}
	
	/*public boolean step(){
		// Don't keep computing after goal is reached or determined impossible.
		if(rockPaperScissors == null){
			return false;
		}
		// Find possible next steps
		//Collection<Point> neighbors = getNeighbors();
		rockPaperScissors.getNeighbors(Point p);
		
		// Choose one to be a part of the path
		Point next = chooseNeighbor(neighbors);
		// mark the next step
		if(next!=null){
			maze.markPath(next);
			recordLink(next);
		}
		// if no next step is found
		else{	
			maze.markVisited(current);
			Stack<Point> stack = (Stack<Point>)data;
			stack.pop();
		}
		resetCurrent();
		checkSearchOver();
		return searchResult;	
	}*/
	
	public boolean step() {
		return false;
	}
	
}
