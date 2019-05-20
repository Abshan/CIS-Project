package main.Servers;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Mohamed Abshan
 *
 */
public class DBConnect {
	/** MySql Database connection code
	 * @return : Connection or null
	 */
	public Connection getConnection() {
		
		/*
		 * Referenced Material: https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html
		 */
		
		String username = "root";
		String password = "root";

		String jdbcURL = "jdbc:mysql://localhost:3306/restaurant";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcURL, username, password);
			return con;
		} catch (Exception e) {
			System.out.println("Database Connection Failed!" + e);
			return null;
		}

	}

}
