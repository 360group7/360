package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Skill;

/**
 * Test Cases for Skill Class.
 * 
 * @author Louis Yang (jeho1994@uw.edu)
 * @version 1.0
 */
public class SkillTest {
	
	/** Skill that will be used for testing.*/
	private Skill mySkill;
	
	@Before
	public void setUp() throws Exception {
		mySkill = new Skill("HTML");
	}
	
	@Test
	public void testSkill() {
		Skill skill = new Skill("HTML");
		assertNotNull("Unable to create a Skill", skill);
	}

	@Test
	public void testGetSkillName() {
		assertEquals("HTML", mySkill.getSkillName());
	}

	@Test
	public void testSetSkillName() {
		mySkill.setSkillName("CSS");
		assertEquals("CSS", mySkill.getSkillName());
	}

	@Test
	public void testSetId() {
		mySkill.setId("1225");
		assertEquals("1225", mySkill.getId());
	}
	
	@Test
	public void testToString() {
		assertEquals("HTML", mySkill.toString());
	}
}
