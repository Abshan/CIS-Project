package main.Servers;

/*
 * Author : Mohamed Abshan
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
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
