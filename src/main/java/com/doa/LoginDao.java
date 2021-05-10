package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.UserData;

import utility.JDBCconnection;

public class LoginDao {
	int postid=0;
	Connection connection=null;
	public boolean validate(UserData loginBean) throws ClassNotFoundException {
		boolean status = false;
		
try {
				connection=JDBCconnection.getConnection();
			
				PreparedStatement preparedStatement = connection
						.prepareStatement("select username,password,postid from userdetails where username = ? and password = ? "); 
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
								

			//System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
		

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}
	public int getPost(UserData loginBean) throws ClassNotFoundException {
		connection=JDBCconnection.getConnection();
		int postid=0;
		try {
		PreparedStatement ps=connection.prepareStatement("select postid from userdetails where username = ? and password = ? ");
		ps.setString(1, loginBean.getUsername());
		ps.setString(2, loginBean.getPassword());
		ResultSet rs =ps.executeQuery();
		rs.next();
		postid=rs.getInt("postid");
		System.out.println(postid);
		
		}
		catch (SQLException e) {
			// TODO: handle exception
			printSQLException(e);
		}
		return postid;
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
