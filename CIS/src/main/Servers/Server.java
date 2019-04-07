package main.Servers;

/*
 * Author : Mohamed Abshan
 */

import java.rmi.*;

public class Server {
	public static void main(String[] argv) {
		try {

			Naming.rebind("rmi://localhost/test", new functions());

			System.out.println("Server is ready");

		} catch (Exception e) {
			System.out.println("Server has failed : " + e);
		}
	}
}
