package Attendance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Attendance.bean.Attendance;

public class AttendanceDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/attendance?useSSL=false"; //127.0.0.1
	private String jdbcUsername = "root";
	private String jdbcPassword = "isuru12345";
	
	private static final String INSERT_ATTENDANCES_SQL = "INSERT INTO attendances" + "  (name,typeOfWork,date,inTime,outTime) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_ATTENDANCE_BY_ID = "select id,name,typeOfWork,date,inTime,outTime from attendances where id =?";
	private static final String SELECT_ALL_ATTENDANCES = "select * from attendances";
	private static final String DELETE_ATTENDANCES_SQL = "delete from attendances where id = ?;";
	private static final String UPDATE_ATTENDANCES_SQL = "update attendances set name = ?,typeOfWork= ? , date = ?, inTime = ?, outTime =? where id = ?;";
	
	
	public AttendanceDAO() {
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//create or insert a attendance to the table
	
	public void insertAttendance(Attendance attendance) throws SQLException {
		System.out.println(INSERT_ATTENDANCES_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ATTENDANCES_SQL)) {
			preparedStatement.setString(1, attendance.getName());
			preparedStatement.setString(2, attendance.getTypeOfWork());
			preparedStatement.setString(3, attendance.getDate());
			preparedStatement.setString(4, attendance.getInTime());
			preparedStatement.setString(5, attendance.getOutTime());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//list by Individual ID
	
	public Attendance selectAttendance(int id) {
		Attendance attendance = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTENDANCE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
	
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String typeOfWork = rs.getString("typeOfWork");				
				String date =rs.getString("date");
				String inTime = rs.getString("inTime");
				String outTime = rs.getString("outTime");
				attendance = new Attendance(id,name,typeOfWork, date,inTime,outTime);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return attendance;
	}
	
	//list All Attendances
	
	public List<Attendance> selectAllAttendance() {
	
		// using try-with-resources to avoid closing resources
		List<Attendance> attendances = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
	
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTENDANCES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(); 
	
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String typeOfWork = rs.getString("typeOfWork");				
				String date =rs.getString("date");
				String inTime = rs.getString("inTime");
				String outTime = rs.getString("outTime");
				attendances.add(new Attendance(id,name,typeOfWork,date,inTime,outTime));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return attendances;
	}
	
	//delete Attendance
	
	public boolean deleteAttendance(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ATTENDANCES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//update attendance
	
	public boolean updateAttendance(Attendance attendance) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ATTENDANCES_SQL);) {
			
			statement.setString(1, attendance.getName());
			statement.setString(2, attendance.getTypeOfWork());
			statement.setString(3, attendance.getDate());
			statement.setString(4, attendance.getInTime());
			statement.setString(5, attendance.getOutTime());
			statement.setInt(6, attendance.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
			}
		}
	}
}

}
