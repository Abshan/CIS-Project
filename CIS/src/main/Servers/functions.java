package main.Servers;

import java.beans.Statement;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;

public class functions extends UnicastRemoteObject implements serverInterface {

	private static final long serialVersionUID = 1L;

	DBConnect connect = new DBConnect();

	public functions() throws RemoteException {
		super();
	}

	public String question1() throws RemoteException {
		return "Rate the service based on the following criteria.";
	}

	public String question2() throws RemoteException {
		return "Rate the ambience in the restaurent.";
	}

	public String question3() throws RemoteException {
		return "Would you revisit our restaurant in the future?";
	}

	public boolean loginConfirmation(String username, String password) throws RemoteException {

		if (username == "Admin" && password == "password") {
			return true;
		} else {
			return false;
		}
	}

	public boolean invoiceValidation(int number) throws RemoteException {

		String query = "";
		int result = 0;

		try {
			Connection con = connect.getConnection();
			Statement st = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
			if (rs.next()) {
				result = rs.getInt("invoiceNo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == number) {
			return true;
		}else {
			return false;
		}

	
	}

}
