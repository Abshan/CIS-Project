package main.Servers;

import java.rmi.*;
import java.util.Vector;

public interface serverInterface extends Remote {

	public Vector<String> questions() throws RemoteException;

	public boolean loginConfirmation(String username, String password) throws RemoteException;

	public boolean invoiceValidation(int number) throws RemoteException;
	
	public void userInput(int orderno, int taste, int plating, int portion, int servetime, int waitingstaff, int cleanliness, int lighting,
			int comfort, String opinion, String message) throws RemoteException;
}
