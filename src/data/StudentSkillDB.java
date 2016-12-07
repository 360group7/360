package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StudentSkill;

/**
 * This class contains methods to access StudentSKill table data.
 * The system allows to list, search, and add a StudentSKill.
 * 
 * @author Jieun Lee (jieun212@uw.edu)
 * @version 12-06-2016
 */
public class StudentSkillDB {

	/** A DB Connection */
	private static Connection myConnection;
	
	/** A List of StudentSKill */
	private static List<StudentSkill> myStudentSkillList;
	
	/**
	 * Get a list of StudentSKill.
	 * 
	 * @return A list of Student Skill.
	 * @throws SQLException
	 */
	public static List<StudentSkill> getStudentSkills() throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentSkill;";

		myStudentSkillList = new ArrayList<StudentSkill>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentSkillId");
				String uwId = rs.getString("uwnetId");
				String skillId = rs.getString("skillId");

				StudentSkill studentSkill = new StudentSkill(uwId, skillId);
				studentSkill.setId(id);

				myStudentSkillList.add(studentSkill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return myStudentSkillList;
	}
	
	
	/**
	 * Get a StudentSkill which has givne StudentSKill id.
	 * @param theId StudentSKill id
	 * @return A StudentSKill
	 * @throws SQLException
	 */
	public static StudentSkill getStudentSkills(final String theId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentSkill WHERE studentSkillId = '" + theId + "'";

		myStudentSkillList = new ArrayList<StudentSkill>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentSkillId");
				String uwId = rs.getString("uwnetId");
				String skillId = rs.getString("skillId");


				StudentSkill studentSkill = new StudentSkill(uwId, skillId);
				studentSkill.setId(id);

				return studentSkill;
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
	 * Get a list of StudentSKill of given uw net id.
	 * @param theUwnetId UW net id
	 * @return A list of StudentSKill of given Uwnetid.
	 * @throws SQLException
	 */
	public static List<StudentSkill> getStudentSKillsOfUWNetID(final String theUwnetId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentSkill WHERE uwnetId = '" + theUwnetId + "'";

		List<StudentSkill> filteredList = new ArrayList<StudentSkill>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentSkillId");
				String uwId = rs.getString("uwnetId");
				String skillId = rs.getString("skillId");

				StudentSkill studentSkill = new StudentSkill(uwId, skillId);
				studentSkill.setId(id);
				
				filteredList.add(studentSkill);
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
	 * Add a StudentSKill into the StudentSKill table
	 * 
	 * @param theSkill A StudentSKill
	 * @return True if StudentSKill is added succssfully.
	 */
	public static boolean addStudentSkill(StudentSkill theSkill) {
		String sql = "insert into StudentSkill(uwnetId, skillId) values "
				+ "(?, ?); ";

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
			preparedStatement.setString(1, theSkill.getUwnetId());
			preparedStatement.setString(2, theSkill.getSkillId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
