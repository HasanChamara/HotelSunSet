package RoomManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import RoomManagement.bean.Room;




public class RoomDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/sunset?useSSL=false"; //127.0.0.1
	private String jdbcUsername = "root";
	private String jdbcPassword = "IT20157296";

	private static final String INSERT_ROOMS_SQL = "INSERT INTO rooms" + "  (number,type, noOfBeds,wifi,phoneService) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_ROOM_BY_ID = "select id,number,type, noOfBeds,wifi,phoneService from rooms where id =?";
	private static final String SELECT_ALL_ROOMS = "select * from rooms";
	private static final String DELETE_ROOMS_SQL = "delete from rooms where id = ?;";
	private static final String UPDATE_ROOMS_SQL = "update rooms set number = ?, type = ?, noOfBeds =?, wifi =?,phoneService=? where id = ?;";

	
	public RoomDAO() {
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
	
	//create or insert a room to the table

	public void insertRoom(Room room) throws SQLException {
		System.out.println(INSERT_ROOMS_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOMS_SQL)) {
			preparedStatement.setString(1, room.getNumber());
			preparedStatement.setString(2, room.getType());
			preparedStatement.setInt(3, room.getNoOfBeds());
			preparedStatement.setString(4, room.getWifi());
			preparedStatement.setString(5, room.getPhoneService());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	//list room by Individual ID
	
	public Room selectRoom(int id) {
		Room room = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String number = rs.getString("number");
				String type = rs.getString("type");
				int noOfBeds = rs.getInt("noOfBeds");				
				String wifi =rs.getString("wifi");
				String phoneService = rs.getString("phoneService");
				room = new Room(id,number,type, noOfBeds,wifi,phoneService);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return room;
	}

	//list All rooms
	
	public List<Room> selectAllRooms() {

		// using try-with-resources to avoid closing resources
		List<Room> rooms = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(); 

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String number = rs.getString("number");
				String type = rs.getString("type");
				int noOfBeds = rs.getInt("noOfBeds");				
				String wifi =rs.getString("wifi");
				String phoneService = rs.getString("phoneService");
				rooms.add(new Room(id,number,type, noOfBeds,wifi,phoneService));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return rooms;
	}

	//delete room
	
	public boolean deleteRoom(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ROOMS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update room
	
	public boolean updateRoom(Room room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ROOMS_SQL);) {
			
			statement.setString(1, room.getNumber());
			statement.setString(2, room.getType());
			statement.setInt(3, room.getNoOfBeds());
			statement.setString(4, room.getWifi());
			statement.setString(5, room.getPhoneService());
			statement.setInt(7, room.getId());
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
