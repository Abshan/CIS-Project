package main.Servers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public Connection getConnection() {
		String username = "";
		String password = "";

		String jdbcURL = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(jdbcURL, username, password);
			return con;
		} catch (Exception e) {
			System.out.println("Connection to the internet has been terminated!" + e);
			return null;
		}

	}

}
