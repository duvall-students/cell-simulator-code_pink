package application;

import java.awt.Point;
import java.util.HashMap; 

// @author Maggie Bickerstaffe ////
public class RockPaperScissors {
	
	// Possible states of squares that make up a maze
	public static final int BORDER = 0;	
	public static final int ROCK = 1;
	public static final int PAPER = 2;	
	public static final int SCISSORS = 3;
	public int threshold = 3; 
	
	// squares that make up the maze
	private int[][] rockPaperScissors;
	
	private HashMap<String, String> enemiesMap = new HashMap<String, String>() {{
	    put("ROCK", "PAPER");
	    put("PAPER", "SCISSORS");
	    put("SCISSORS", "ROCK");
	}};
	
	//private RockPaperScissorsController rpcController;
	
	// constructor method 
	public RockPaperScissors(int rows, int columns){
		assert(rows > 0 && columns > 0);
		createModel(rows, columns);
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
	
	public void iterateThroughModel(int start, int end, int state, int i) {
		for (int j = start; j < end; j++) {
			rockPaperScissors[j][i] = state;
		}
	}
	
	// resets the maze to its original state
	public void createModel(int rows, int cols){
		assert(rows > 0 && cols > 0);
		rockPaperScissors = new int[rows][cols];
		int i,j;
		// iterate through columns
		for(i = 1; i < rockPaperScissors.length/2; i++){
			iterateThroughModel(1, rockPaperScissors[i].length-1, ROCK, i);
		}
		for(i = rockPaperScissors.length/2; i< rockPaperScissors.length-1; i++){
			iterateThroughModel(1, rockPaperScissors[i].length-1, SCISSORS, i);
		}

		// now that the grid is half rock/ half scissors, we can add in the paper	
		int height = rockPaperScissors[1].length;
		
		int startLeft = rockPaperScissors.length/2 - 1;
		int startRight = rockPaperScissors.length/2 + 1;
		

		for(i = 1; i < height-1; i++){
			if (i > height*3/4) {
				for(j = 1; j<rockPaperScissors.length-1; j++) {
					rockPaperScissors[i][j] = PAPER;
				}
			}
			if (i < height*3/4 + 1 && i > height/2) {
				for(j = startLeft; j<rockPaperScissors.length/2; j++) {
					rockPaperScissors[i][j] = PAPER;
				}
				startLeft -= 2;
				
				for(j = rockPaperScissors.length/2; j<startRight; j++) {
					rockPaperScissors[i][j] = PAPER;
				}
				startRight += 2;
			}
		}

	}
	
	// converts type if winning neighbors are over threshold
	public void convertType(Point square) {
		assert(validPoint(square));
		HashMap<String, Integer> neighbors = (getNeighbors(square));
		
		// if (neighbors.get(enemiesMap.get(rockPaperScissors[square.x][square.y])) >= threshold)
		if (rockPaperScissors[square.x][square.y] == ROCK && neighbors.get(enemiesMap.get("ROCK")) >= threshold) {
			markPathAsPaper(square);
		}	
		else if (rockPaperScissors[square.x][square.y] == PAPER && neighbors.get(enemiesMap.get("PAPER")) >= threshold) {
			markPathAsScissors(square);
		}
		else if (rockPaperScissors[square.x][square.y] == SCISSORS && neighbors.get(enemiesMap.get("SCISSORS")) >= threshold) {
			markPathAsRock(square);
		}
	}
	
	
	// returns a map with the count of each neighbor type  
	public HashMap<String, Integer> getNeighbors(Point square) {
		HashMap<String, Integer> neighbors = new HashMap<String, Integer>();
		int paperNeighbors = 0;
		int rockNeighbors = 0; 
		int scissorsNeighbors = 0;
		assert(validPoint(square));
		for (int j = square.x-1; j <= square.x+1; j++) {
			for ( int i = square.y-1; i<=square.y+1; i++) {
				if (rockPaperScissors[j][i] == PAPER) {
					paperNeighbors += 1;
				}
				else if (rockPaperScissors[j][i] == ROCK) {
					rockNeighbors += 1;
				}
				else if (rockPaperScissors[j][i] == SCISSORS) {
					scissorsNeighbors += 1;
				}
			}
		}
		
		neighbors.put("PAPER", paperNeighbors);
		neighbors.put("ROCK", rockNeighbors);
		neighbors.put("SCISSORS", scissorsNeighbors);	
		
		return neighbors;
	}
}