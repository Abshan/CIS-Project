package main.Servers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnection() {
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
