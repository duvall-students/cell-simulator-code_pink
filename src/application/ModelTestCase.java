package application;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashMap;

import org.junit.Test;


//@author Maggie Bickerstaffe
public class ModelTestCase {
	
	RockPaperScissors rps = new RockPaperScissors(18, 18);
	RockPaperScissorsDisplay rpsDisplay = new RockPaperScissorsDisplay();
	RockPaperScissorsController rpsController = new RockPaperScissorsController(rpsDisplay);
	
	@Test
	public void testGetRows() {
		int actual = rps.getNumRows();
		assertEquals(18, actual);
	}
	
	@Test
	public void testGetCols() {
		int actual = rps.getNumCols();
		assertEquals(18, actual);
	}
	
	@Test
	public void testinBoundsTrue(){
		Point p = new Point (1,1);
		assertTrue(rps.inBounds(p));
	}
	
	@Test
	public void testinBoundsFalse(){
		Point p = new Point (50,50);
		assertFalse(rps.inBounds(p));
	}
	
	@Test
	public void testValidPointTrue(){
		Point p = new Point (1,1);
		assertTrue(rps.validPoint(p));
	}
	
	@Test
	public void testValidPointFalse(){
		Point p = new Point (50,50);
		assertFalse(rps.validPoint(p));
	}
	
	@Test
	public void testGetForRock(){
		Point square = new Point (1,1);
		assertEquals(1,rps.get(square));
	}
	
	@Test
	public void testGetForBorder(){
		Point square = new Point (0,0);
		assertEquals(0,rps.get(square));
	}
	
	@Test
	public void testGetForPaper(){
		Point square = new Point (15,1);
		assertEquals(2,rps.get(square));
	}
	
	@Test
	public void testGetForScissors(){
		Point square = new Point (9,10);
		assertEquals(3,rps.get(square));
	}
	
	@Test
	public void testMarkPathAsRock(){
		Point square = new Point (1,1);
		rps.markPathAsRock(square);
		int actual = rps.get(square);
		assertEquals(1, actual);
	}
	
	@Test
	public void testMarkPathAsPaper(){
		Point square = new Point (1,1);
		rps.markPathAsPaper(square);
		int actual = rps.get(square);
		assertEquals(2, actual);
	}
	
	@Test
	public void testMarkPathAsScissors(){
		Point square = new Point (1,1);
		rps.markPathAsScissors(square);
		int actual = rps.get(square);
		assertEquals(3, actual);
	}
	
	@Test 
	public void testgetNeighbors() {
		Point p = new Point (13, 1);
		HashMap<String, Integer> neighbors = rps.getNeighbors(p);
		String actual = String.valueOf(neighbors);
		assertEquals("{ROCK=3, PAPER=3, SCISSORS=0}", actual);
	}
	
	@Test
	public void testgetNeighborsMany() {
		Point p = new Point (10, 9);
		HashMap<String, Integer> neighbors = rps.getNeighbors(p);
		String actual = String.valueOf(neighbors);
		assertEquals("{ROCK=1, PAPER=5, SCISSORS=3}", actual);
	}

	@Test
	public void testConvertType(){
		Point square = new Point (10, 9);
		rps.convertType(square);
		int actual = rps.get(square);
		assertEquals(3, actual);
	}
}
