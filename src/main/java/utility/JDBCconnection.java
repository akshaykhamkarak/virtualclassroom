package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection {
	private static	String URL = "jdbc:mysql://localhost:3307/virtualclassroom";
	private static	String USER_NAME = "root";
	private static	String PASSWORD = "Trishali@1999";
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;

		try {
	  	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
