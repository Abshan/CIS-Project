package main.Servers;

import java.rmi.*;
import java.util.Vector;

/**
 * @author Mohamed Abshan
 *
 */
public interface serverInterface extends Remote {

	/** Returns the set of questions for the Customer GUI and Home GUI
	 * @return Questions																						 
	 * @throws RemoteException if questions are not reachable 
	 * @author - Mohamed Abshan
	 */
	public Vector<String> questions() throws RemoteException;                                                     

	/** Confirms login details from Admin for logging into Admin panel
	 * @param username : User name of the Admin
	 * @param password : Password for Admin																		  
	 * @return : Returns true or false by validating info provided
	 * @throws RemoteException if function cannot be executed
	 * @author - Kowshigan Senthilrajah
	 */
	public boolean loginConfirmation(String username, String password) throws RemoteException;                    

	/** Validating invoice number provided by the customer
	 * @param number : Invoice Number
	 * @return : False or true 																					  
	 * @throws RemoteException if invoice validation function is not reachable
	 * @author - Kowshigan Senthilrajah
	 */
	public boolean invoiceValidation(int number) throws RemoteException;                                          

	/** Function to input all the review inputs into  SQL database 
	 * @param orderno : Invoice Number
	 * @param taste : Taste review
	 * @param plating : Plating Review
	 * @param portion : Portion review										
	 * @param servetime : Serve time review																		   
	 * @param waitingstaff : Waiting staff review
	 * @param cleanliness : Cleanliness review
	 * @param lighting : lighting review
	 * @param comfort : Comfort review
	 * @param opinion : Opinion review
	 * @param message : message
	 * @param date : Date of input
	 * @throws RemoteException if user input is failed because of function is not to be found
	 * @author - Mohamed Abshan
	 */
	public void userInput(int orderno, int taste, int plating, int portion, int servetime, int waitingstaff,      
			int cleanliness, int lighting, int comfort, String opinion, String message, String date)
			throws RemoteException;

	/** Function to get Average values of ratings
	 * @param name : Rating Category
	 * @param attribute : Rating attribute 																		   
	 * @return : returns the individual values got from database
	 * @throws RemoteException if function is not reachable 
	 * @author - Illyas Nairoos
	 */                                
	public int getAvgValueOf(String name, String attribute) throws RemoteException;                                

	
	/** Function to get comments from database
	 * @param number : To Limit the returning values
	 * @return : returns comments from database
	 * @throws RemoteException if function is not reachable 
	 * @author - Illyas Nairoos
	 */
	public Vector<String> getComments(int number) throws RemoteException;                                          

	
	/** Get the number of opinions 
	 * @param opinion : type of opinion to get 
	 * @return : returns the number of parsed opinions
	 * @throws RemoteException if function is not reachable 
	 * @author - Illyas Nairoos
	 */
	public int getValueOfOpinion(String opinion) throws RemoteException;                                           
}
