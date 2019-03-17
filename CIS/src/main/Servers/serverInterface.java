package main.Servers;

import java.rmi.*;

public interface serverInterface extends Remote {
	public String question1() throws RemoteException;
	public String question2() throws RemoteException;
	public String question3() throws RemoteException;
}
