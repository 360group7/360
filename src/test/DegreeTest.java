package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Degree;

/**
 * Test Cases for Degree Class.
 * 
 * @author Louis Yang (jeho1994@uw.edu)
 * @version 1.0
 */
public class DegreeTest {
	
	/** Degree used for setup. */
	Degree myDegree;
	
	@Before
	public void setUp() throws Exception {
		myDegree = new Degree("Computer Science and Systems", "BA");
	}
	
	@Test
	public void testConstructor() {
		Degree degree = new Degree("Computer Science and Systems", "BA");
		assertNotNull("Unable to create a Degree", degree);
	}

	@Test
	public void testGetProgram() {
		assertEquals("Computer Science and Systems", myDegree.getProgram());
	}

	@Test
	public void testSetProgram() {
		myDegree.setProgram("Computer Science and Nerds");
		assertEquals("Computer Science and Nerds", myDegree.getProgram());
	}

	@Test
	public void testGetLevel() {
		assertEquals("BA", myDegree.getLevel());
	}

	@Test
	public void testSetLevel() {
		myDegree.setLevel("BS");
		assertEquals("BS", myDegree.getLevel());
	}

	@Test
	public void testSetId() {
		myDegree.setId("1225");
		assertEquals("1225", myDegree.getId());
	}
	
	@Test
	public void testToString() {
		assertEquals("Computer Science and Systems, BA", myDegree.toString());
	}

}
