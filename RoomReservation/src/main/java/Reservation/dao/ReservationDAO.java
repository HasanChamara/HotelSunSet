package Reservation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Reservation.bean.Reservation;
import Reservation.bean.Room;

public class ReservationDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/hotel?useSSL=false"; //127.0.0.1
	private String jdbcUsername = "root";
	private String jdbcPassword = "Hasan.2000";
	
	private static final String INSERT_RESERVATIONS_SQL = "INSERT INTO reservations" + "  (customerid, checkindate, checkoutdate, paymentMethod) VALUES "
			+ " (?, ?, ?, ?);";
	
	private static final String SELECT_AVAILABLE_ROOMS = "select * from rooms";
	private static final String SELECT_ALL_RESERVATIONS = "select * from reservations WHERE id =(SELECT max(id) FROM reservations)";
	private static final String SELECT_INDIVIDUAL_ROOM = "select * from rooms where id = ?;";
	
	public ReservationDAO () {
		
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
	
	
	public void insertReservaton(Reservation roomreservation) throws SQLException {
		System.out.println(INSERT_RESERVATIONS_SQL);
		// try-with-resource statement will auto close the connection.
		try (
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATIONS_SQL)) {
			preparedStatement.setInt(1, roomreservation.getCustomerid());
			preparedStatement.setString(2, roomreservation.getCheckindate());
			preparedStatement.setString(3, roomreservation.getCheckoutdate());
			preparedStatement.setString(4, roomreservation.getPaymentMethod());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	
	public List<Room> selectAvailableRooms() {

		// using try-with-resources to avoid closing resources
		List<Room> rooms = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AVAILABLE_ROOMS);) {
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
	
	
	public List<Reservation> selectAllReservations() {

		// using try-with-resources to avoid closing resources
		List<Reservation> reservations = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RESERVATIONS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(); 

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				int customerid = rs.getInt("customerid");
				String checkindate = rs.getString("checkindate");
				String checkoutdate = rs.getString("checkoutdate");				
				String paymentMethod =rs.getString("paymentMethod");
				reservations.add(new Reservation(id,customerid, checkindate, checkoutdate, paymentMethod));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return reservations;
	}
	
	
	// Select Room By Individual ID
		public List<Room> selectIndividualRoom(int id) {

			// using try-with-resources to avoid closing resources
			List<Room> rooms = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INDIVIDUAL_ROOM);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery(); 

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					//int id = rs.getInt("id");
					String number = rs.getString("number");
					String type = rs.getString("type");
					int noOfBeds = rs.getInt("noOfBeds");				
					String wifi =rs.getString("wifi");
					String phoneService = rs.getString("phoneService");
					rooms.add(new Room(id,number,type, noOfBeds,wifi,phoneService));
				}
			} catch (SQLException e) {
				//printSQLException(e);
			}
			return rooms;
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
