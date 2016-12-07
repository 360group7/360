package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import model.StudentInternship;


/**
 * Test Cases for StudentInternship Class.
 * 
 * @author Louis Yang (jeho1994@uw.edu)
 * @version 1.0
 */
public class StudentInternshipTest {
    
    /** Date format */
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/** A java.sql.Date startDate for the internship. */
	private Date mySqlStartDate;
	/** A java.sql.Date endDate for the internship. */
	private Date mySqlEndDate;
	/** Student internship. */
	StudentInternship myInternship;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		long date = dateFormat.parse("2017-12-06").getTime();
		mySqlStartDate = new Date(date);
		long date2 = dateFormat.parse("2018-12-06").getTime();
		mySqlEndDate = new Date(date2);
		myInternship = new StudentInternship(mySqlStartDate, mySqlEndDate,
				"Software Engineer Intern", "jeho1994", "Microsoft");
	}
	
	
	@Test
	public void testStudentInternship() throws ParseException {
		long date = dateFormat.parse("2017-12-06").getTime();
		Date startDate = new Date(date);
		long date2 = dateFormat.parse("2018-12-06").getTime();
		Date endDate = new Date(date2);
		StudentInternship internship = new StudentInternship(startDate, endDate,
				"Software Engineer Intern", "jeho1994", "Microsoft");
		assertNotNull("Unable to create a Degree", internship);
	}

	@Test
	public void testGetStartDate() {
		assertEquals("2017-12-06", String.valueOf(myInternship.getStartDate()));
	}

	@Test
	public void testSetStartDate() throws ParseException {
		long date = dateFormat.parse("2017-01-06").getTime();
		Date startDate = new Date(date);
		myInternship.setStartDate(startDate);
		assertEquals("2017-01-06", String.valueOf(myInternship.getStartDate()));
	}

	@Test
	public void testGetEndDate() {
		assertEquals("2018-12-06", String.valueOf(myInternship.getEndDate()));
	}

	@Test
	public void testSetEndDate() throws ParseException {
		long date = dateFormat.parse("2018-01-06").getTime();
		Date endDate = new Date(date);
		myInternship.setEndDate(endDate);
		assertEquals("2018-01-06", String.valueOf(myInternship.getEndDate()));
	}

	@Test
	public void testGetPosition() {
		assertEquals("Software Engineer Intern", myInternship.getPosition());
	}

	@Test
	public void testSetPosition() {
		myInternship.setPosition("Bum");
		assertEquals("Bum", myInternship.getPosition());
	}

	@Test
	public void testGetUWId() {
		assertEquals("jeho1994", myInternship.getUWId());
	}

	@Test
	public void testSetUWId() {
		myInternship.setUWId("bum1994");
		assertEquals("bum1994", myInternship.getUWId());
	}

	@Test
	public void testGetEmployer() {
		assertEquals("Microsoft", myInternship.getEmployer());
	}

	@Test
	public void testSetEmployer() {
		myInternship.setEmployer("BumSchool");
		assertEquals("BumSchool", myInternship.getEmployer());
	}

	@Test
	public void testSetId() {
		myInternship.setId("1225");
		assertEquals("1225", myInternship.getId());
	}

}
