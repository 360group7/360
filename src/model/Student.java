package model;

import java.util.List;

/**
 * The Student class represents a unique University of Washington Tacoma
 * Institute of Technology student.
 * 
 * @author Thomas Van Riper November 19, 2016
 */
public class Student {
	private List<StudentDegree> myDegree;
	private List<StudentEmployment> myEmployment;
	private List<StudentInternship> myInternship;
	private List<StudentSkill> mySkills;
	
	private String myEmail;
	private String myFirstName;
	private String myMiddleName;
	private String myLastName;
	private String myUWNetID;

	/**
	 * Constructs a new student with first name, last name, and a UW NetID.
	 * @param theFirstName
	 * @param theLastName
	 * @param theUWNetID
	 */
	public Student(String theFirstName, String theLastName, String theUWNetID)
	{
		if (theFirstName == null || theLastName == null || theUWNetID == null)
		{
			throw new NullPointerException("Value cannot be null.");
		}
		
		setFirstName(theFirstName);
		setLastName(theLastName);
		myUWNetID = theUWNetID;
	}
	
	/**
	 * Constructs a new student with first name, middle name, last name, and
	 * a UW Net ID.
	 * 
	 * @param myFirstName
	 * @param myMiddleName
	 * @param myLastName
	 * @param myUWNetID
	 */
	public Student(String theFirstName, String theMiddleName, String theLastName, String theUWNetID) 
	{
		this(theFirstName, theLastName, theUWNetID);
		setMiddleName(theMiddleName);
	}

	/**
	 * Returns the student's degree.
	 * @return myDegree
	 */
	public List<StudentDegree> getDegree()
	{
		return myDegree;
	}
	
	/**
	 * Sets the student's degree.
	 * @param theDegree
	 */
	public void setDegree(List<StudentDegree> theDegree)
	{
		myDegree = theDegree;
	}
	
	/**
	 * Returns the student's employment.
	 * @return myEmployment
	 */
	public List<StudentEmployment> getEmployment()
	{
		return myEmployment;
	}
	
	/**
	 * Sets the student's employment.
	 * @param theEmployment
	 */
	public void setEmployment(List<StudentEmployment> theEmployment)
	{
		myEmployment = theEmployment;
	}
	
	/**
	 * Returns the student's internship.
	 * @return myInternship
	 */
	public List<StudentInternship> getInternship()
	{
		return myInternship;
	}
	
	/**
	 * Sets the student's internship.
	 * @param theInternship
	 */
	public void setInternship(List<StudentInternship> theInternship)
	{
		myInternship = theInternship;
	}
	
	/**
	 * Returns the student's skills.
	 * @return mySkills
	 */
	public List<StudentSkill> getSkills()
	{
		return mySkills;
	}
	
	/**
	 * Sets the student's skills.
	 * @param theSkills
	 */
	public void setSkills(List<StudentSkill> theSkills)
	{
		mySkills = theSkills;
	}
	
	/**
	 * Returns student's email.
	 * 
	 * @return email
	 */
	public String getEmail() 
	{
		return myEmail;
	}

	/**
	 * Sets the student's e-mail.
	 * 
	 * @param theEmail
	 */
	public void setEmail(String theEmail) 
	{
		if (!theEmail.contains("@") || !theEmail.contains(".")) 
		{
			throw new IllegalArgumentException("Invalid e-mail address.");
		}

		this.myEmail = theEmail.trim();
	}

	/**
	 * Returns student's first name.
	 * 
	 * @return myFirstName
	 */
	public String getFirstName() 
	{
		return myFirstName;
	}

	/**
	 * Sets the student's first name.
	 * 
	 * @param theFirstName
	 */
	public void setFirstName(String theFirstName) 
	{
		theFirstName = theFirstName.trim();
		validateParameters(theFirstName);
		this.myFirstName = theFirstName;
	}
	
	/**
	 * Returns student's middle name.
	 * @return myMiddleName
	 */
	public String getMiddleName()
	{
		return myMiddleName;
	}
	
	/**
	 * Sets the student's middle name.
	 * @param theMiddleName
	 */
	public void setMiddleName(String theMiddleName)
	{
		if (theMiddleName == null || theMiddleName.length() < 1) 
		{
			throw new IllegalArgumentException();
		}
		
		this.myMiddleName = theMiddleName;
	}

	/**
	 * Returns student's last name.
	 * 
	 * @return myLastName
	 */
	public String getLastName() 
	{
		return myLastName;
	}

	/**
	 * Sets the student's last name.
	 * 
	 * @param theLastName
	 */
	public void setLastName(String theLastName) 
	{
		theLastName = theLastName.trim();
		validateParameters(theLastName);
		this.myLastName = theLastName;
	}

	/**
	 * Returns student's UW Net ID.
	 * 
	 * @return myUWNetID
	 */
	public String getUWNetID() 
	{
		return myUWNetID;
	}

	/**
	 * Sets the student's UW Net ID.
	 * 
	 * @param theUWNetID
	 */
	public void setUWNetID(String theUWNetID) 
	{
		theUWNetID = theUWNetID.trim();
		validateParameters(theUWNetID);
		this.myUWNetID = theUWNetID;
	}
	
	/**
	 * Checks if parameter values are less than two characters long.
	 * @param theParameter
	 */
	private void validateParameters(String theParameter)
	{
		if (theParameter.length() < 2)
		{
			throw new IllegalArgumentException("Invalid value.");
		}
	}
}
