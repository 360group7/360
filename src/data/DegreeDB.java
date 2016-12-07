package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Degree;
/**
 * DegreeDB represents the database of Degree.
 * @author Louis Yang.

 */
public class DegreeDB {
	
	private static Connection myConnection;
	private static List<Degree> myDegreeList;
	
	// get all student-employments
	public static List<Degree> getDegrees() throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM Degree;";

		myDegreeList = new ArrayList<Degree>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("degreeId");
				String programName = rs.getString("programName");
				String level = rs.getString("level");
				Degree degree = new Degree(programName, level);
				degree.setId(Integer.toString(id));
				myDegreeList.add(degree);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return myDegreeList;
	}
	
	public static Degree getDegree(String theId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM Degree WHERE degreeId = " + theId + ";";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("degreeId");
				String programName = rs.getString("programName");
				String level = rs.getString("level");
				Degree degree = new Degree(programName, level);
				degree.setId(Integer.toString(id));
				return degree;
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
	
	
	
	
	// add
	public static String addDegree(Degree degree) {
		String stmt = "insert into Degree(programName, level) values "
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
			preparedStatement = myConnection.prepareStatement(stmt);
			preparedStatement.setString(1, degree.getProgram());
			preparedStatement.setString(2, degree.getLevel());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error adding Degree: " + e.getMessage();
		}
		return "Added Degree Successfully";
	}
	
	// edit
	public static String updateStudentEmployment(Degree theEmployment, String columnName, Object data) {
		
		String id = theEmployment.getId();
		String sql = "UPDATE Degree SET `" + columnName
				+ "` = ?  WHERE degreeId = ? ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = myConnection.prepareStatement(sql);
			preparedStatement.setString(1, (String) data); 
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return "Error updating Degree: " + e.getMessage();
		}
		return "Updated Degree Successfully";
	
	}
	

}
