package main.Servers;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;

public class functions extends UnicastRemoteObject implements serverInterface {


	private static final long serialVersionUID = 1L;

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

}
