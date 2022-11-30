package application;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;

//@author: Milli Kearse
public class ControllerTestCase {
	//Using this class to test my work in the RockPaperScissorsController class
	
	RockPaperScissors rps = new RockPaperScissors(18, 18);
	RockPaperScissorsDisplay rpsd = new RockPaperScissorsDisplay();
	RockPaperScissorsController rpsc = new RockPaperScissorsController(rps.getNumRows(), rps.getNumCols(), rpsd);
	
	@Test
	public void testGetGridDimensions() {
		Point p = new Point (18,18);
		//assertTrue(rpsc.getGridDimensions(p));
		assertEquals(rpsc.getGridDimensions(), p);
	}
	
	@Test
	public void testGetNumRows() {
		int actual = rpsc.getNumRows();
		assertEquals(18, actual);
	}
	
	@Test
	public void testGetNumCols() {
		int actual = rpsc.getNumCols();
		assertEquals(18, actual);
	}
	
	@Test
	public void testNewModel() {
		
	}
	
	@Test
	public void testGetCellState() {
		Point p = new Point(1,1);
		assertEquals(1, rps.get(p));
	}
	
	@Test
	public void testDoOneStep() {
		
	}
}
