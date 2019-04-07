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

		/*
		 * Referenced Material :
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html
		 */

		Vector<String> questions = new Vector<String>();
		questions.add("How would you rate the following concerning the food dish?");
		questions.add("Please rate the following regarding the service.");
		questions.add("Please rate the following regarding the ambiance of our restaurant");
		questions.add("Would you revisit our restaurant in the future?");
		questions.add("Comments & recomendations.");
		return questions;
	}

	public boolean loginConfirmation(String username, String password) throws RemoteException {

		/*
		 * Admin Login Confirmation
		 */

		boolean stat = false;
		if (username.equals("admin")) {
			if (password.equals("admin")) {
				stat = true;
			}
		}
		return stat;
	}

	public boolean invoiceValidation(int number) throws RemoteException {

		/*
		 * Invoice number validation
		 */

		Connection con = connect.getConnection();
		String que = "select orderNo from ordertab where orderNo = " + number + " ";
		int result = 0;
		boolean stat = false;

		try {
			Statement st = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(que);
			if (rs.next()) {
				result = rs.getInt("orderNo");
			}

			if (result == number) {
				stat = true;
			}

			st.close();
			rs.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stat;

	}

	public void userInput(int orderno, int taste, int plating, int portion, int servetime, int waitingstaff,
			int cleanliness, int lighting, int comfort, String opinion, String message, String date)
			throws RemoteException {

		Connection con = connect.getConnection();

		/*
		 * Referenced Material : https://dev.mysql.com/doc/refman/8.0/en/json.html
		 * 
		 * Inserting values into MySQL database
		 */

		String que = "INSERT INTO reviewTab(message, opinion, date, review)VALUES('" + message + "', '" + opinion
				+ "', '" + date + "', '{\"OrderNo\": " + orderno + ", \"Food\": {\"Taste\": " + taste
				+ ", \"Plating\": " + plating + ", \"Portion\": " + portion + "}, \"Service\": {\"ServeTime\": "
				+ servetime + ", \"WaitingStaff\": " + waitingstaff + "}, \"Ambiance\": {\"Cleanliness\": "
				+ cleanliness + "," + " \"Lighting\": " + lighting + ", \"Comfort\": " + comfort + "}}')";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			int exec = ((java.sql.Statement) st).executeUpdate(que);
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

		/*
		 * Referenced Material : https://dev.mysql.com/doc/refman/8.0/en/json.html
		 * 
		 * Get the total number of review values from the database
		 */

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
		Connection con = connect.getConnection();

		/*
		 * Referenced Material : https://dev.mysql.com/doc/refman/8.0/en/json.html
		 * 
		 * Get average values of different user inputs
		 */

		String que = "select AVG(review->>\"$." + name + "." + attribute + "\") Avg from reviewtab;";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);

			if (rs.next()) {
				sum = rs.getInt("Avg");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;

	}

	public Vector<String> getComments(int number) throws RemoteException {

		/*
		 * Referenced Material :
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html
		 * 
		 * Get limited number of user feedback comments from database
		 */

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

	public int getValueOfFood(String attribute, String foodname) throws RemoteException {
		Connection con = connect.getConnection();
		int no = 0;

		/*
		 * Referenced Material : https://dev.mysql.com/doc/refman/8.0/en/json.html
		 * 
		 * Get the average values for overall individual food rating
		 */

		String que = "select AVG(review->>\"$.Food." + attribute
				+ "\") Avg from reviewtab where review->>\"$.OrderNo\" in (select orderNo from orderlist where foodItem = '"
				+ foodname + "')";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);

			if (rs.next()) {
				no = rs.getInt("Avg");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;

	}

	public int getValueOfOpinion(String opinion) throws RemoteException {

		/*
		 * Get user opinions of future visitation
		 */

		int tot = 0;
		Connection con = connect.getConnection();
		String que = "select COUNT(opinion) op from reviewtab where opinion = '" + opinion + "'";

		try {
			Statement st;
			st = (Statement) con.createStatement();
			ResultSet rs = st.executeQuery(que);

			if (rs.next()) {
				tot = rs.getInt("op");
			}

			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tot;
	}

}
