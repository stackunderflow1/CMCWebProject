/**
 * packages
 */

package edu.csbsju.cs.Controllers;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import edu.csbsju.cs.Entity.*;


/**
 * This class is the Admin Functionality controller that allows an admin to access the database.
 * @StackUnderflow
 * @author DeAndre Bethell, Nathan Drees, Anton Andrews, Ryan Graham, Noah Lefebvre
 * @version March 2019
 */
public class AdminFunctionalityController {

	private DataBaseController dbc;
	/**
	 * Constructor 
	 */
	public AdminFunctionalityController() {
		this.dbc  = new DataBaseController();
	}

	/*
	* Allows the admin to add a user to the database
	*@param String firstname, lastName, userName, password, type
	*@return the new user in the database; x
	*/
	public void addUser(Users newUser)
	{
		int i = dbc.addUser(newUser);
		if(i == -1)
		{
			System.out.print("Similar username is already there");
			//throw new IllegalArgumentException("Similar username is already there");
		}
	}
	/*
	* Allows the admin to delete a user from the database
	*@param User users
	*@return the user that was deleted from the database; x
	*/
	public void deleteUser(Users user)
	{
	dbc.deleteUser(user);
	}
	/*
	* Allows the admin to edit a user in the database
	*@param Users user
	*@return the updated user in the database; x
	*/

public void editUser(String uName, String fName, String lName, String pWord, char type, char status) {

if(!(type == 'u' || type == 'a'))
	  throw new IllegalArgumentException("The type entered is invalid");
else if(!(status == 'Y' || status == 'N'))
	  throw new IllegalArgumentException("The status entered is invalid");

	Users u = getUser(uName);
	if(u == null) 
		  throw new IllegalArgumentException("The username entered was not found");
	
	
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setPassword(pWord);
		u.setStatus(status);
		u.setType(type);
		dbc.editUser(u);

	}

	/*
	* Allows the admin to add an university to the database
	*@param String name, state, location, control
	*Int numStudents, numApplicants, academicScale, socialScale, qOLScale
	*double females, SATV, SATM, expenses, financialAid, admitted, enrolled
	*ArrayList<String> emphasess
	*
	*@return the new university in the database; x
	*/
	public void addUniversity(University uni)
	{
		boolean check = dbc.addUniversity(uni);
		if (check == false)
		{
			System.out.println("Similar university name is already there");
			//throw new IllegalArgumentException("Similar university name is already there");
		}
		
	}
	/*
	* Allows the admin to get all the users in the database
	*@param 
	*@return all the users in the database
	*/
	public ArrayList<Users> getAllUsers()
	{
		ArrayList<Users> stuList = dbc.getAllUsers();
		return stuList;
		
	}
	/*
	* Allows the admin to get the users in the database
	*@param String userName 
	*@return a user in the database
	*/
	public Users getUser(String userName)
	{
		Users user = dbc.getUser(userName);
		return user;
	}
	/*
	* Allows the admin to delete an university from the database
	*@param University uni
	*@return the  university deleted from the database; x
	*/
	public void deleteSchool(University uni)
	{
		dbc.deleteSchool(uni);
	}
	/*
	* Allows the admin to edit an university in the database
	*@param University uni0, uni1
	*@return the  university edited in the database; x
	*/
	public void editSchool(String old, String name, String state, String location, String control, int numStudents, 
			 double females, double SATV, double SATM, double expenses, double financialAid, 
			 int numApplicants, double admitted, double enrolled, int academicScale, int socialScale, 
			 int qOLScale, ArrayList<String> emp) throws NameNotFoundException
	{
		ArrayList<University> univ = dbc.getAllSchoolDetails();
		for (University x : univ)
		{
			if(x.getName().equals(old))
			{
				University u = dbc.viewSchoolDetails(x.getName());
				u.setName(name);
				u.setState(state);
				u.setLocation(location);
				u.setControl(control);
				u.setNumStudents(numStudents);
				u.setFemales(females);
				u.setSATV(SATV);
				u.setSATM(SATM);
				u.setExpenses(expenses);
				u.setFinancialAid(financialAid);
				u.setNumApplicants(numApplicants);
				u.setAdmitted(admitted);
				u.setEnrolled(enrolled);
				u.setAcademicScale(academicScale);
				u.setSocialScale(socialScale);
				u.setqOLScale(qOLScale);
		//University uni = new University(name, state, location, control, numStudents, females, SATV, SATM, expenses, financialAid, numApplicants, admitted, enrolled, academicScale, socialScale, qOLScale, emp);
	
		 dbc.editSchool(u);
			}
	}
	}
	/*
	* Allows the admin to deactivate a university in the database
	*@param Users user
	*@return the  university deactivated in the database; x
	*/
	public void changeStatus(String uName)
	{
		boolean found = false;
		Users user = getUser(uName);
		if(user == null) 
			  throw new IllegalArgumentException("The username entered was not found");
		if(user.getStatus() == 'Y') {
			//System.out.print(user.getStatus());
			user.setStatus('N');
			//System.out.print(user.getStatus());
			dbc.editUser(user);
			found = true;
		}
		else if(user.getStatus() == 'N')
		{
			user.setStatus('Y');
			dbc.editUser(user);
			found = true;
		}
		if(found == false)
		{
			//System.out.println("User's status was not found");
			throw new IllegalArgumentException("User's status was not found");
		}
	}
	
	
public University viewSchoolDetails(String universityName) throws NameNotFoundException {
		
		return dbc.viewSchoolDetails(universityName);
		

	}
	/*
	* Allows the admin to print user information in the database
	*@param Users user 
	*@return a user in the database
	*/
	
}
