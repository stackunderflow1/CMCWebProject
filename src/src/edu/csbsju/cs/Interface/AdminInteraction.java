/**
 * packages
 */
package edu.csbsju.cs.Interface;
/**
 * imports
 */
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import edu.csbsju.cs.Entity.*;
import edu.csbsju.cs.Controllers.*;

/**
* Admin Interaction Class
*@author DeAndre Bethell, Ryan Graham, Noah Lefebvre, Anton Andrews, Nathan Drees
*@version March 2019
*/
public class AdminInteraction {
	private AdminFunctionalityController afc = new AdminFunctionalityController();

	/**
	 * Constructor
	 */
	public AdminInteraction() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	* Adds a new user to the database
	*@param String, firstName, lastName, userName, password, type
	*@returns the new user that was added to the database
	*/
	public void addUser(String firstName, String lastName, String userName, String password, char type, char status)

	{
		Users newUser = new Users(firstName, lastName, userName, password, type, status);
		afc.addUser(newUser);
	}
	
	/**
	* Deletes a user out of the database
	*@param Users user
	*@returns the user that was deleted from the database
	*/
	public void deleteUser(Users user)
	{
	afc.deleteUser(user);
	}
	/**
	* Edits a user inside of the database
	*@param Users user
	*@returns the updated user
	*/

	public void editUser(String uName, String fName, String lName, String pWord, char type, char status) 
	{
	afc.editUser(uName, fName, lName, pWord, type, status);
	}
	/**
	* Adds a new university to the database
	*@param String name, state, locaiton, control, numStudents
	*double females, SATV,SATM,expenses, financialAid, addmitted, enrolled
	*int numApplicants, academicScale, socialScale,q0lScale
	*ArrayList<String> emphasess
	*@returns the new university that was added to the database
	*/
	public void addUniversity(String name, String state, String location, String control, int numStudents, 
			 double females, double SATV, double SATM, double expenses, double financialAid, 
			 int numApplicants, double admitted, double enrolled, int academicScale, int socialScale, 
			 int qOLScale, ArrayList<String> emphasess)
	{
		University uni = new University( name,  state, location,  control,  numStudents, 
				  females,  SATV,  SATM,  expenses,  financialAid, 
				  numApplicants,  admitted, enrolled, academicScale, socialScale, 
				  qOLScale, emphasess);
		afc.addUniversity(uni);
	}

	/**
	* gets all the users in the database
	*@param
	*@returns all the users in the database
	*/
	public ArrayList<Users> getAllUsers()

	{
		return afc.getAllUsers();

	}
	/**
	*Deletes a school from the database
	*@param University uni
	*@returns University list without the school that was deleted
	*/
	public void deleteSchool(University uni)
	{
		afc.deleteSchool(uni);
	}
	/**
	* Edits a university in the database
	 * @param university 
	*@param University uni0, uni1
	 * @throws NameNotFoundException 
	*@returns the updated school list with the edited school
	*/
	public void editSchool(String old, String name, String state, String location, String control, int numStudents, 
			 double females, double SATV, double SATM, double expenses, double financialAid, 
			 int numApplicants, double admitted, double enrolled, int academicScale, int socialScale, 
			 int qOLScale, ArrayList<String> emp) throws NameNotFoundException
	{
		afc.editSchool(old, name, state, location, control, numStudents, females, SATV, SATM, expenses, financialAid, numApplicants, admitted, enrolled, academicScale, socialScale, qOLScale, emp);
	}
	/**
	* Deactivates a user
	*@param Users user
	*@returns the list of users without the deactivated user
	*/
	public void changeStatus(String user)
	{
		afc.changeStatus(user);

	}
	
	
	 public University viewSchoolDetails(String universityName) throws NameNotFoundException 
	  {
		   return afc.viewSchoolDetails(universityName);
	  }
	/**
	* Gets a user inside of the database
	*@param Users user
	*@returns the user in the database
	*/
	public Users getUser(String user)
	{
		return afc.getUser(user);
		
	}
	
	

}
