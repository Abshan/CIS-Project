package main.Servers;

import java.awt.List;
import java.beans.Statement;
import java.io.FileWriter;
import java.nio.file.Files;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.*;

import netscape.javascript.JSObject;

public class functions extends UnicastRemoteObject implements serverInterface {

	private static final long serialVersionUID = 1L;

	DBConnect connect = new DBConnect();

	public functions() throws RemoteException {
		super();
	}

	public Vector<String> questions() throws RemoteException {
		Vector<String> questions = new Vector<String>();
		questions.add("How would you rate the following concerning the food dish?");
		questions.add("Please rate the following regarding the service.");
		questions.add("Please rate the following regarding the ambiance of our restaurant");
		questions.add("Would you revisit our restaurant in the future?");
		questions.add("Comments & recomendations.");
		return questions;
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

		if (result == number) {
			return true;
		} else {
			return false;
		}

	}

	public void userInput(int orderno, int taste, int plating, int portion, int servetime, int waitingstaff,
			int cleanliness, int lighting, int comfort, String opinion, String message, String date)
			throws RemoteException {

		JSONObject inputs = new JSONObject();
		JSONArray food = new JSONArray();
		JSONArray service = new JSONArray();
		JSONArray ambiance = new JSONArray();

		try {
			
			inputs.put("OrderNo", orderno);

			food.put(new JSONObject().put("Taste", taste).put("Plating", plating).put("Portion", portion));
			service.put(new JSONObject().put("Serve Time", servetime).put("", waitingstaff));
			ambiance.put(
					new JSONObject().put("Cleanliness", cleanliness).put("Lighting", lighting).put("Comfort", comfort));

			inputs.put("Food", food);
			inputs.put("Service", service);
			inputs.put("Ambiance", ambiance);

			inputs.put("Opinion", opinion);
			inputs.put("Message", message);
			inputs.put("Date", date);

			FileWriter file = new FileWriter("C:\\GitHub\\CIS-Project\\Test.json", true);
			file.write(inputs.toString() + '\n');
			file.flush();

			JOptionPane.showMessageDialog(null, "Succesful");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
