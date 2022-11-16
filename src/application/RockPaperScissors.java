package application;

import java.awt.Point;
import java.util.HashMap; 

public class RockPaperScissors {
	
	// Possible states of squares that make up a maze
	public static final int BORDER = 0;	
	public static final int ROCK = 0;
	public static final int PAPER = 0;	
	public static final int SCISSORS = 0;
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
	
	// resets the maze to its original state
	public void createModel(int rows, int cols){
		assert(rows > 0 && cols > 0);
		rockPaperScissors = new int[rows][cols];
		int i,j;
		// iterate through columns
		for(i = 0; i< rockPaperScissors[i].length; i++){
			// iterate through rows
			for(j =0; j < rockPaperScissors.length/2; j++){
				rockPaperScissors[i][i] = ROCK;
			}
			for(j = rockPaperScissors.length/2; j < rockPaperScissors.length; j++){
				rockPaperScissors[j][i] = SCISSORS;
			}
		}
		// now that the grid is half rock/ half scissors, we can add in the paper	
		int stopLeft = rockPaperScissors.length/2 - 2;
		int stopRight = rockPaperScissors.length - 1;
		for(i = rockPaperScissors[i].length; i< rockPaperScissors[i].length/2; i--){
			// iterate through rows
			if (i < rockPaperScissors[i].length/4) {
				for(j = 0; j < rockPaperScissors.length/2 ; j++){
					rockPaperScissors[i][j] = PAPER;
					
				}	
				for(j = rockPaperScissors.length/2; j < rockPaperScissors.length; j++) {
					rockPaperScissors[i][j] = PAPER;
				}
			}
			else {
				for(j = rockPaperScissors.length/2; j > stopLeft; j--){
					rockPaperScissors[i][j] = PAPER;
					stopLeft -= 2;
				}
				for(j = rockPaperScissors.length/2; j < stopRight; j++){
					rockPaperScissors[i][j] = PAPER;
					stopRight -= 2;
				}	
			}
		}
	}
	
	// converts type if winning neighbors are over threshold
	public void convertType(Point square) {
		assert(validPoint(square));
		HashMap<String, Integer> neighbors = (getNeighbors(square));
		// if (neighbors.get(enemiesMap.get(rockPaperScissors[square.x][square.y])) >= threshold)
		if (rockPaperScissors[square.x][square.y] == ROCK && neighbors.get(enemiesMap.get("ROCK")) >= threshold) {
			markPathAsRock(square);
		}	
		else if (rockPaperScissors[square.x][square.y] == PAPER && neighbors.get(enemiesMap.get("PAPER")) >= threshold) {
			markPathAsPaper(square);
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
		for (int j = square.x-1; j < square.x+1; j++) {
			for ( int i = square.y-1; i<square.y+1; i++) {
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
		
		neighbors.put("Papers", paperNeighbors);
		neighbors.put("Rocks", rockNeighbors);
		neighbors.put("Scissors", scissorsNeighbors);	
		
		return neighbors;
	}
}
