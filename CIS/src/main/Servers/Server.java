package main.Servers;

/*
 * Author : Mohamed Abshan
 */

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] argv) {
		try {
			
			LocateRegistry.createRegistry(1102);
			Naming.rebind("rmi://192.168.43.123:1102/test", new functions());

			System.out.println("Server is ready");

		} catch (Exception e) {
			System.out.println("Server has failed : " + e);
		}
	}
}
