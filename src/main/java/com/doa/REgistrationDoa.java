package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.entity.DummyUser;
import com.entity.UserData;

import utility.JDBCconnection;

public class REgistrationDoa {
	static Connection connection = null;

	public void registerUser(UserData udata) throws ClassNotFoundException, SQLException {
		connection = JDBCconnection.getConnection();
		PreparedStatement ps = connection.prepareStatement("select postid from userdetails where username = ?");
		ps.setString(1, udata.getUsername());
		ResultSet rs = ps.executeQuery();

		int ct = 0;
		while (rs.next()) {
			ct++;
		}
		if (ct > 0) {
			throw new SQLException("Duplicate info<br>Chemical Name " + udata.getUsername());
		} else {

			Calendar calendar = Calendar.getInstance();
			java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());

			String INSERT_USERS_SQL = "INSERT INTO userdetails"
					+ "  (name,city,mobile,address,email,username,password,pincode,postid,Date) VALUES "
					+ " (?,?,?,?,?,?,?,?,?,?);";

			int result = 0;

			connection = JDBCconnection.getConnection();

			try {

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
				preparedStatement.setString(1, udata.getName());
				preparedStatement.setString(2, udata.getCity());
				preparedStatement.setString(3, udata.getPhonenum());
				preparedStatement.setString(4, udata.getAddress());
				preparedStatement.setString(5, udata.getEmail());
				preparedStatement.setString(6, udata.getUsername());
				preparedStatement.setString(7, udata.getPassword());
				preparedStatement.setString(8, udata.getPincode());
				preparedStatement.setInt(9, udata.getPostid());
				preparedStatement.setDate(10, ourJavaDateObject);

				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				result = preparedStatement.executeUpdate();

			} catch (SQLException e) {

				printSQLException(e);
			}
			System.out.println(result);
		}
	}

//	public UserData selectUser(String id) throws ClassNotFoundException {
//		UserData user = null;
//		String getrecord = "select * from userdetails  where postid=?";
//		// Step 1: Establishing a Connection
//		try {
//			connection = JDBCconnection.getConnection();
//
//			// Step 2:Create a statement using connection object
//			PreparedStatement preparedStatement = connection.prepareStatement(getrecord);
//			preparedStatement.setString(1, id);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				String name = rs.getString("name");
//				String email = rs.getString("email");
//				String city = rs.getString("city");
//				String address = rs.getString("address");
//				String mobile = rs.getString("mobile");
//				String username = rs.getString("username");
//				String password = rs.getString("password");
//				String pincode = rs.getString("pincode");
//				int postid = rs.getInt("postid");
//
//				user = new UserData(name, email, city, address, username, password, mobile, pincode, postid);
//			}
//		} catch (SQLException e) {
//			printSQLException(e);
//		}
//		return user;
//	}
		
 public List<DummyUser> selectAllUsers() throws ClassNotFoundException {
		DummyUser udata=new DummyUser();
		String selectusers ="select * from nuser";
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DummyUser> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {

			connection = JDBCconnection.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(selectusers);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userid=rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				//String postname=rs.getString("postname");
				
				
//				udata.setId(userid);
//				udata.setName(name);
//				udata.setEmail(email);
//				udata.setCountry(country);
//			//	udata.setPostname(postname);
				udata=new DummyUser(userid,name,email,country);
			
				users.add(udata);
			}
		} catch (SQLException e) {
			
		}
		return users;
	}

	public static boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
		boolean rowDeleted;
		String DELETE_USERS_SQL="delete from userdetails where postid=?";
		
			  connection=JDBCconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		
		return rowDeleted;
	}
	
	public static boolean updateUser(UserData user) throws SQLException, ClassNotFoundException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL="update userdetails set name=?,city=?,mobile=?,address=?,email=?,username=?,password=?,pincode=?";
			connection=JDBCconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, user.getName());
			statement.setString(2, user.getCity());
			statement.setString(3, user.getPhonenum());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getUsername());
			statement.setString(7, user.getPassword());
			statement.setString(8, user.getPincode());

			rowUpdated = statement.executeUpdate() > 0;
		
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
