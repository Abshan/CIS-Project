package main.Servers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

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

		if (username == "admin" && password == "admin") {
			return true;
		} else {
			return false;
		}
	}

	public boolean invoiceValidation(int number) throws RemoteException {

		Connection con = connect.getConnection();
		String que = "select review->>\"$.OrderNo\" from reviewtab where review->>\"$.OrderNo\" = " + number + " ";
		int result = 0;

		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(que);
			if (rs.next()) {
				result = rs.getInt("OrderNo");
			}
			st.close();
			rs.close();
			con.close();

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

		Connection con = connect.getConnection();

		String que = "INSERT INTO reviewTab(message, opinion, date, review)VALUES('" + message + "', '" + opinion
				+ "', '" + date + "', '{\"OrderNo\": " + orderno + ", \"Food\": {\"Taste\": " + taste
				+ ", \"Plating\": " + plating + ", \"Portion\": " + portion + "}, \"Service\": {\"ServeTime\": "
				+ servetime + ", \"WaitingStaff\": " + waitingstaff + "}, \"Ambiance\": {\"Cleanliness\": "
				+ cleanliness + "," + " \"Lighting\": " + lighting + ", \"Comfort\": " + comfort + "}}')";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			int exec = ((java.sql.Statement) st).executeUpdate(que);
			JOptionPane.showMessageDialog(null, "Succesfully Added!");
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something is wrong!");

		}

	}

	public int getValueOf(String name, String attribute) throws RemoteException {

		int sum = 0;
		Connection con = connect.getConnection();
		String que = "select SUM(review->>\"$." + name + "." + attribute + "\") Sum from reviewtab;";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);

			if (rs.next()) {
				sum = rs.getInt("Sum");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;

	}

	public int getAvgValueOf(String name, String attribute) throws RemoteException {

		int sum = 0;
		int count = 0;
		Connection con = connect.getConnection();
		String que = "select COUNT(review->>\"$." + name + "." + attribute + "\") Count, SUM(review->>\"$." + name + "."
				+ attribute + "\") Sum from reviewtab;";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);

			if (rs.next()) {
				sum = rs.getInt("Sum");
				count = rs.getInt("Count");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum / count;

	}

	public Vector<String> getComments(int number) throws RemoteException {

		Vector<String> comments = new Vector<String>();
		Connection con = connect.getConnection();
		String comment = null;
		String que = "select message from reviewtab LIMIT " + number + " ";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);
			while (rs.next()) {
				comment = rs.getString("message");
				comments.add(comment);
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comments;
	}

}
