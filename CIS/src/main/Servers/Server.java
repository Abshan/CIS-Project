package main.Servers;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 * @author Mohamed Abshan
 *
 */
public class Server {
	public static void main(String[] argv) {
		try {
			
			LocateRegistry.createRegistry(8041);
			Naming.rebind("rmi://192.168.8.100:8041/test", new functions());

			System.out.println("Server is ready");

		} catch (Exception e) {
			System.out.println("Server has failed : " + e);
		}
	}
}
