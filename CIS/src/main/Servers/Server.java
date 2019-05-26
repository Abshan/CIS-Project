package main.Servers;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/**
 * @author Mohamed Abshan
 *
 */
public class Server {
	@SuppressWarnings("deprecation")
	public static void main(String[] argv) {
		
		if(System.getSecurityManager() == null) {
	         System.setSecurityManager(new RMISecurityManager());
	      }
		
		try {
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://0.0.0.0:1099/test", new functions());

			System.out.println("Server is ready");

		} catch (Exception e) {
			System.out.println("Server has failed : " + e);
		}
	}
}
