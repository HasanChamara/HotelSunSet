package MemberManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MemberManagement.bean.Member;



public class MemberDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/hotel?useSSL=false"; //127.0.0.1
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_MEMBERS_SQL = "INSERT INTO members" + "  (name,cid,type,sdate,edate) VALUES "
			+ " (?, ?, ?, ?, ?)";

	private static final String SELECT_MEMBER_BY_NO = "select no,name,cid,type,sdate,edate from members where no =?";
	private static final String SELECT_ALL_MEMBERS = "select * from members";
	private static final String DELETE_MEMBERS_SQL = "delete from members where no = ?;";
	private static final String UPDATE_MEMBERS_SQL = "update members set name = ?, cid = ?, type =?, sdate =?, edate =?  where no = ?";

	
	public MemberDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
	
	
	//create or insert a member to the table

		public void insertMember(Member member) throws SQLException {
			System.out.println(INSERT_MEMBERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (
					Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBERS_SQL)) {
				preparedStatement.setString(1, member.getName());
				preparedStatement.setInt(2, member.getCid());
				preparedStatement.setString(3, member.getType());
				preparedStatement.setString(4, member.getSdate());
				preparedStatement.setString(5, member.getEdate());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		//list member by Individual ID
		
		public Member selectMember(int no) {
			Member member = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEMBER_BY_NO);) {
				preparedStatement.setInt(1, no);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String name = rs.getString("name");
					int cid = rs.getInt("cid");
					String type = rs.getString("type");				
					String sdate = rs.getString("sdate");
					String edate = rs.getString("edate");
					member = new Member(no,name,cid,type,sdate,edate);
					
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return member;
		}

		
		//list All member
		
		public List<Member> selectAllMembers() {

			// using try-with-resources to avoid closing resources
			List<Member> members = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEMBERS);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery(); 

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					int cid = rs.getInt("cid");
					String type = rs.getString("type");				
					String sdate = rs.getString("sdate");
					String edate = rs.getString("edate");
					members.add(new Member(no,name,cid,type,sdate,edate));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return members;
		}
		
		//delete member
		
		public boolean deleteMember(int no) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_MEMBERS_SQL);) {
				statement.setInt(1, no);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
		//update member
		
		public boolean updateMember(Member member) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBERS_SQL);) {
				
				statement.setString(1, member.getName());
				statement.setInt(2, member.getCid());
				statement.setString(3, member.getType());
				statement.setString(4, member.getSdate());
				statement.setString(5, member.getEdate());
				statement.setInt(6, member.getNo());
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
