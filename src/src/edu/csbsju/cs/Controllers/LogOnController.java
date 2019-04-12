/*
*packages
*/
package edu.csbsju.cs.Controllers;

/*
*imports
*/
import edu.csbsju.cs.Entity.*;
import java.util.*;

/**
 * This class is the LogOn controller that allows a user to access the database.
 * 
 * @StackUnderflow
 * @author DeAndre Bethell, Nathan Drees, Anton Andrews, Ryan Graham, Noah
 *         Lefebvre
 * @version March 2019
 */
public class LogOnController {
	/**
	 * private instance variables
	 */

	private DataBaseController dbc;
	private ArrayList<Users> allU;
	//private boolean isSLoggedOn = false;
	private boolean isLoggedOn = false;
	private boolean isAdminLoggedOn = false;
	/*
	 * LogOn Constructor
	 */
	public LogOnController() {
		this.dbc = new DataBaseController();
		this.allU = new ArrayList<Users>();
	}

	/**
	 * Enables the user to log into the database
	 * 
	 * @param String
	 *            username, password
	 * @returns the result of the logOn by stating whether a user or admin is loggin
	 *          onto the database. If neither it returns a fail message or a
	 *          deactivated user
	 */
	public void logOn(String username, String password) {
		// NEED NEW ONE
		boolean iUser = false;
		boolean iPass = false;
		boolean iAcc = false;
		allU = dbc.getAllUsers();
		for (int i = 0; i < allU.size(); i++) {
			if (username.equals(allU.get(i).getUsername())) {
				iUser = true;
				if (password.equals(allU.get(i).getPassword())) {
					iPass = true;
					if (allU.get(i).getType() == 'Y') {
						iAcc = true;
						if (allU.get(i).getStatus() == 'u')
						{
							this.isLoggedOn = true;
						}
						else if (allU.get(i).getStatus() == 'a' ) {
							this.isAdminLoggedOn = true;
						}
					}
					
				}
				
				
			}
			
		}
		if(iUser == false)
		{
			this.isLoggedOn = false;
			this.isAdminLoggedOn = false;
		}
		else if(iPass == false)
		{
			this.isLoggedOn = false;
			this.isAdminLoggedOn = false;
		}
		
		else if(iAcc == false)
		{
			this.isLoggedOn = false;
			this.isAdminLoggedOn = false;
		}
		}
		


	/**
	 * Allows the user to logout of the database
	 * 
	 * @param String
	 *            username, password
	 * @returns successfully logged out or fail if the user fails to log out
	 */
	public void logOut() {
		this.isLoggedOn = false;
}
	public void adminLogOut() {
		this.isAdminLoggedOn = false;
}
	public boolean isLoggedOn()
	{
		return isLoggedOn;
	}
	
	public boolean isAdminLoggedOn()
	{
		return isAdminLoggedOn;
	}
}
