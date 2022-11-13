package application;

import java.awt.Point;

public class RockPaperScissors {
	
	// Possible states of squares that make up a maze
	public static final int BORDER = 0;	
	public static final int ROCK = 0;
	public static final int PAPER = 0;	
	public static final int SCISSORS = 0;	
	
	// squares that make up the maze
	private int[][] rockPaperScissors;
	
	private RockPaperScissorsController rpcController;
	
	// constructor method 
	public RockPaperScissors(int rows, int columns){
		assert(rows > 0 && columns > 0);
		//createRockPaperScissors(rows, columns);
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
	
	// make sure the maze stays in bounds and not in the "non active" outer border
	public boolean inBounds(Point p){
		assert(rockPaperScissors!=null);
		return (p!= null && p.x < rockPaperScissors.length-1 && p.x > 0 && p.y < rockPaperScissors[0].length-1 && p.y >0);
	}
	
	
	public void createrRockPaperScissors(int rows, int cols) {
		assert(rows > 0 && cols > 0);
		rockPaperScissors = new int[rows][cols];
	}
	
	// make sure the point isn't out of bounds
	public boolean validPoint(Point p){
		assert(rockPaperScissors!=null);
		return (p!=null && p.x < rockPaperScissors.length && p.x >= 0 && p.y < rockPaperScissors[0].length && p.y >= 0);
	}
	
	// get - returns a square state at the given position.
	public int get(Point square){
		assert(validPoint(square));
		return rockPaperScissors[square.x][square.y];
	}
	
	// turns a square into a rock 
	public void markPathAsRock(Point square){
		assert(validPoint(square));
		rockPaperScissors[square.x][square.y] = ROCK;
	}
	
	// turns a square into a paper 
	public void markPathAsPaper(Point square){
		assert(validPoint(square));
		rockPaperScissors[square.x][square.y] = PAPER;
	}
	
	// turns a square into a scissors 
	public void markPathAsScissors(Point square){
		assert(validPoint(square));
		rockPaperScissors[square.x][square.y] = SCISSORS;
	}
	
	// resets the maze to its original state
	public void reColorMaze(){
		assert(rockPaperScissors != null);
		// iterate through columns
		for(int i = 0; i< rockPaperScissors[i].length; i++){
			// iterate through rows
			for(int j =0; j < rockPaperScissors.length/2; j++){
				rockPaperScissors[j][i] = ROCK;
			}
			for(int j = rockPaperScissors.length/2; j < rockPaperScissors.length; j++){
				rockPaperScissors[j][i] = SCISSORS;
			}
		}
		// now that the grid is half rock/ half scissors, we can add in the paper	
		int i = 0;
		for(i = rockPaperScissors[i].length/2; i< rockPaperScissors[i].length; i++){
			// iterate through rows
			int pyramid = 2;
			for(int j = rockPaperScissors.length/2; j > 0; j--){
		//		if 
				
			}
		}
	}
}
