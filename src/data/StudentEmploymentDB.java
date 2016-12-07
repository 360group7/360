package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StudentEmployment;

/**
 * This class contains methods to access StudentEmployment table data.
 * The system allows to list, search, and add a StudentEmployment.
 * 
 * @author Jieun Lee (jieun212@uw.edu)
 * @version 12-06-2016
 */
public class StudentEmploymentDB {
	
	/** A DB Connection */
	private static Connection myConnection;
	
	/** A List of StudentSKill */
	private static List<StudentEmployment> myStudentEmploymentList;
	
	/**
	 * Get a list of StudentSKill.
	 * 
	 * @return A list of Student Skill.
	 * @throws SQLException
	 */
	public static List<StudentEmployment> getStudentEmployments() throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentEmployment;";

		myStudentEmploymentList = new ArrayList<StudentEmployment>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentEmployId");
				String uwnetId = rs.getString("uwnetid");
				String employer = rs.getString("employer");
				String position = rs.getString("position");
				double salary = rs.getDouble("salary");
				Date date = rs.getDate("dateFrom");
				String comment = rs.getString("comment");

				StudentEmployment studentEmployment = new StudentEmployment(uwnetId, employer,  position, salary, date, comment);

				studentEmployment.setId(id);
				myStudentEmploymentList.add(studentEmployment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return myStudentEmploymentList;
	}
	
	/**
	 * Return a list of StudentEmployment which is under given uwnetid
	 * 
	 * @param theUwnetId 
	 * @returnA list of StudentEmployment which is under given uwnetid
	 * @throws SQLException
	 */
	public static List<StudentEmployment> getStudentEmploymentsOfUWNetID(final String theUwnetId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentEmployment WHERE uwnetId = '" + theUwnetId + "'";
		List<StudentEmployment> filteredList = new ArrayList<StudentEmployment>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentEmployId");
				String uwnetId = rs.getString("uwnetid");
				String employer = rs.getString("employer");
				String position = rs.getString("position");
				double salary = rs.getDouble("salary");
				Date date = rs.getDate("dateFrom");
				String comment = rs.getString("comment");

				StudentEmployment studentEmployment = new StudentEmployment(uwnetId, employer, position, salary, date,
						comment);

				studentEmployment.setId(id);
				filteredList.add(studentEmployment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return filteredList;
	}
	
	
	/**
	 *  Get a StudentEmployment which has givne StudentSKill id.
	 * 
	 * @param theId StudentEmployment id
	 * @return A StudentEmployment which has givne StudentSKill id.
	 * @throws SQLException
	 */
	public static StudentEmployment getStudentEmployment(String theId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentEmployment WHERE studentEmploymentId = " + theId + ";";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentEmployId");
				String uwnetId = rs.getString("uwnetid");
				String employer = rs.getString("employer");
				String position = rs.getString("position");
				double salary = rs.getDouble("salary");
				Date date = rs.getDate("dateFrom");
				String comment = rs.getString("comment");

				StudentEmployment studentEmployment = new StudentEmployment(uwnetId, employer, position, salary, date,
						comment);

				studentEmployment.setId(id);
				return studentEmployment;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return null;
	}
	
	
	
	/**
	 * Add givne StudentEmployment into StudentEmployment table
	 * 
	 * @param theEmployemnt
	 *            StudentEmployment
	 * @return True if StudentEmployment is added succssfully.
	 */
	public static boolean add(StudentEmployment theEmployemnt) {
		String sql = "insert into StudentEmployment(uwnetid, employer, position, salary, dateFrom, comment) values "
				+ "(?, ?, ?, ?, ?, ?); ";

		if (myConnection == null) {
			try {
				myConnection = DataConnection.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = myConnection.prepareStatement(sql);
			preparedStatement.setString(1, theEmployemnt.getUwnetId());
			preparedStatement.setString(2, theEmployemnt.getEmployer());
			preparedStatement.setString(3, theEmployemnt.getPosition());
			preparedStatement.setDouble(4, theEmployemnt.getSalary());
			preparedStatement.setDate(5, theEmployemnt.getStartDate());
			preparedStatement.setString(6, theEmployemnt.getComment());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}