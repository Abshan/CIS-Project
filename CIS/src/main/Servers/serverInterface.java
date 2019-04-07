package main.Servers;

import java.rmi.*;
import java.util.Vector;

public interface serverInterface extends Remote {

	public Vector<String> questions() throws RemoteException;                                                     //@author - Mohamed Abshan

	public boolean loginConfirmation(String username, String password) throws RemoteException;                    //@author - Kowshigan Senthilrajah

	public boolean invoiceValidation(int number) throws RemoteException;                                          //@author - Kowshigan Senthilrajah

	public void userInput(int orderno, int taste, int plating, int portion, int servetime, int waitingstaff,      //@author - Mohamed Abshan
			int cleanliness, int lighting, int comfort, String opinion, String message, String date)
			throws RemoteException;

	public int getValueOf(String name, String attribute) throws RemoteException;                                   //@author - Illyas Nairoos

	public int getAvgValueOf(String name, String attribute) throws RemoteException;                                //@author - Illyas Nairoos

	public Vector<String> getComments(int number) throws RemoteException;                                          //@author - Illyas Nairoos

	public int getValueOfFood(String attribute, String foodname) throws RemoteException;                           //@author - Illyas Nairoos
	
	public int getValueOfOpinion(String opinion) throws RemoteException;                                           //@author - Illyas Nairoos
}
