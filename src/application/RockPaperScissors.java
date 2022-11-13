package application;

public class RockPaperScissors {
	
	private int[][] rockPaperScissors;
	//numRows
	//numCols
	//inBounds
	//coloring
	//createGrid
	//
	
	// constructor method 
	public RockPaperScissors(int rows, int columns){
		assert(rows > 0 && columns > 0);
		createRockPaperScissors(rows, columns);
	}

	// get the number of rows from the user
	public int getNumRows(){
		assert(rockPaperScissors!=null);
		return rockPaperScissors.length;
	}

	// get the number of columns from the user
	public int getNumCols(){
		assert(rockPaperScissors!=null);
		return rockPaperScissors[0].length;
	}
	
	
	public void createrRockPaperScissors(int rows, int cols) {
		assert(rows > 0 && cols > 0);
		rockPaperScissors = new int[rows][cols];
	}
}
