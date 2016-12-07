package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.StudentDegree;

/**
 * This class contains methods to access StudentDegree table data.
 * The system allows to list, search, and add a StudentDegree.
 * 
 * @author Jieun Lee (jieun212@uw.edu)
 * @version 12-06-2016
 */
public class StudentDegreeDB {
	
	/** A DB Connection */
	private static Connection myConnection;
	
	/** A List of StudentDegree */
	private static List<StudentDegree> myStudentDegreeList;
	
	/**
	 * Get a list of StudentDegree
	 * 
	 * @return A list of StudentDegree
	 * @throws SQLException
	 */
	public static List<StudentDegree> getStudentDegrees() throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentDegree;";

		myStudentDegreeList = new ArrayList<StudentDegree>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentDegreeId");
				String uwId = rs.getString("uwnetId");
				String degreeId = rs.getString("degreeId");
				String term = rs.getString("graduation_term");
				String year = rs.getString("graduation_year");
				double gpa = rs.getDouble("gpa");
				String transfer = rs.getString("transferCollege");

				StudentDegree studentDegree = new StudentDegree(uwId, degreeId, term, year, gpa, transfer);
				studentDegree.setId(id);
				myStudentDegreeList.add(studentDegree);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return myStudentDegreeList;
	}
	
	
	/**
	 * Get a StudentDegree which has the givne StudentDegree id
	 * 
	 * @param theId
	 *            StudentDegree id
	 * @returnStudentDegree which has the givne StudentDegree id
	 * @throws SQLException
	 */
	public static StudentDegree getStudentDegree(String theId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentDegree WHERE studentDegreeId '" + theId + "'";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentDegreeId");
				String uwId = rs.getString("uwnetId");
				String degreeId = rs.getString("degreeId");
				String term = rs.getString("graduation_term");
				String year = rs.getString("graduation_year");
				double gpa = rs.getDouble("gpa");
				String transfer = rs.getString("transferCollege");

				StudentDegree studentDegree = new StudentDegree(uwId, degreeId, term, year, gpa, transfer);
				studentDegree.setId(id);
				return studentDegree;
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
	 * Get a StudentDegree contains the given uwnet id and Degree id
	 * 
	 * @param theUwnetid 
	 * @param theDegreeId
	 * @return StudentDegree contains the given uwnet id and Degree id
	 * @throws SQLException
	 */
	public static StudentDegree getStudentDegreeID(String theUwnetid, String theDegreeId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentDegree WHERE uwnetId = '" + theUwnetid + "' "
				+ "AND degreeId = '" + theDegreeId + "'";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentDegreeId");
				String uwId = rs.getString("uwnetId");
				String degreeId = rs.getString("degreeId");
				String term = rs.getString("graduation_term");
				String year = rs.getString("graduation_year");
				double gpa = rs.getDouble("gpa");
				String transfer = rs.getString("transferCollege");

				StudentDegree studentDegree = new StudentDegree(uwId, degreeId, term, year, gpa, transfer);
				studentDegree.setId(id);
				return studentDegree;
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
	 * Get a list of StudentDegree of given uw net id
	 * 
	 * @param theUwnetId
	 * @return A list of StudentDegree of given uw net id
	 * @throws SQLException
	 */
	public static List<StudentDegree> getStudentDegreeOfUWNetID(String theUwnetId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT * " + "FROM StudentDegree WHERE uwnetid = '" + theUwnetId + "'";

		List<StudentDegree> filteredList = new ArrayList<StudentDegree>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentDegreeId");
				String uwId = rs.getString("uwnetId");
				String degreeId = rs.getString("degreeId");
				String term = rs.getString("graduation_term");
				String year = rs.getString("graduation_year");
				double gpa = rs.getDouble("gpa");
				String transfer = rs.getString("transferCollege");
				
				StudentDegree studentDegree = new StudentDegree(uwId, degreeId, term, year, gpa, transfer);
				studentDegree.setId(id);
				filteredList.add(studentDegree);
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
	 * Add StudentDegree into StudentDegree table
	 * 
	 * @param theDegree StudentDegree
	 * @return True if StudentDegree is added succssfully.
	 * @throws SQLException
	 */
	public static boolean addStudentDegree(StudentDegree theDegree) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		String sql = "insert into StudentDegree(uwnetId, degreeId, graduation_term, graduation_year, gpa, transferCollege) values "
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
			preparedStatement.setString(1, theDegree.getUwnetId());
			preparedStatement.setString(2, theDegree.getDegreeId());
			preparedStatement.setString(3, theDegree.getGraduationTerm());
			preparedStatement.setString(4, theDegree.getGraduationYear());
			preparedStatement.setDouble(5, theDegree.getGPA());
			preparedStatement.setString(6, theDegree.getTransferCollege());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * Update the given StudentDegree where the column name is the given columnName to the data
	 * 
	 * @param theDegree
	 * @param columnName
	 * @param data New data of the given columnName
	 * @return True if StudentDegree is updated succssfully.
	 * @throws SQLException
	 */
	public static boolean updateStudentDegree(StudentDegree theDegree, String columnName, Object data) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		String id = theDegree.getId();
		String sql = "UPDATE StudentDegree SET `" + columnName
				+ "` = ?  WHERE studentDegreeId = ? ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = myConnection.prepareStatement(sql);
			if (data instanceof String) {
				preparedStatement.setString(1, (String) data);
			} else if (data instanceof Double) {
				preparedStatement.setDouble(1, (Double) data);
			} else {
				System.out.println(data.getClass().getName() + "");
			}
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		return true;
	
	}
	
	/**
	 * Get a list of StudentDegree by given year and quarter
	 * 
	 * @param annual
	 * @param quarter
	 * @return a list of StudentDegree by given year and quarter
	 * @throws SQLException
	 */
	public static List<StudentDegree> getStudentDegreeByYear(int annual, String quarter) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query;
		if (quarter == null) {
			query = "SELECT * " + "FROM StudentDegree WHERE graduation_year = " + annual + ";";
		} else  {
			query = "SELECT * " + "FROM StudentDegree WHERE graduation_year = " 
					+ annual + " AND graduation_term = " + quarter + ";";
		}
		myStudentDegreeList = new ArrayList<StudentDegree>();
		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString("studentDegreeId");
				String uwId = rs.getString("uwnetId");
				String degreeId = rs.getString("degreeId");
				String term = rs.getString("graduation_term");
				String year = rs.getString("graduation_year");
				double gpa = rs.getDouble("gpa");
				String transfer = rs.getString("transferCollege");

				StudentDegree studentDegree = new StudentDegree(uwId, degreeId, term, year, gpa, transfer);
				studentDegree.setId(id);
				myStudentDegreeList.add(studentDegree);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return myStudentDegreeList;
	}
	
	/**
	 * Get a list of StudentDegree by given year
	 * 
	 * @param annual
	 * @return a list of StudentDegree by given year
	 * @throws SQLException
	 */
	public static List<StudentDegree> getStudentDegreeByYear(int annual) throws SQLException {
		return getStudentDegreeByYear(annual, null);
	}
	
	public static boolean hasTransferred(final String theUWnetId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT COUNT(studentDegreeId) AS transferred" 
				+ " FROM StudentDegree WHERE uwnetId = '" + theUWnetId + "' "
				+ "AND transferCollege IS NULL";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String result_str = rs.getString("transferred");
				int result = Integer.parseInt(result_str);
				if (result > 0) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return false;
	}
	
	/**
	 * Return true if the given student is in the rogram
	 * 
	 * @param theUWnetId
	 * @param theDegreeId
	 * @return
	 * @throws SQLException
	 */
	public static boolean isInProgram(final String theUWnetId, final String theDegreeId) throws SQLException {
		if (myConnection == null) {
			myConnection = DataConnection.getConnection();
		}
		Statement stmt = null;
		String query = "SELECT COUNT(studentDegreeId) AS inProgram" 
				+ " FROM StudentDegree WHERE uwnetId = '" + theUWnetId + "' "
				+ "AND degreeId = '" + theDegreeId + "'";

		try {
			stmt = myConnection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String result_str = rs.getString("inProgram");
				int result = Integer.parseInt(result_str);
				if (result > 0) {
					return true;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return false;
	}

}
