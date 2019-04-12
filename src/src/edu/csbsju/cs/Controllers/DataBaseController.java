/* packages
*/
package edu.csbsju.cs.Controllers;

/* imports
*/
import java.io.*;
import dblibrary.project.csci230.UniversityDBLibrary;
import edu.csbsju.cs.Entity.SavedSchools;
import edu.csbsju.cs.Entity.University;
import edu.csbsju.cs.Entity.Users;

import java.util.*;


/**
 * This class is the Database controller that allows a user to access the
 * database.
 * 
 * @StackUnderflow
 * @author DeAndre Bethell, Nathan Drees, Anton Andrews, Ryan Graham, Noah
 *         Lefebvre
 * @version March 2019
 */
public class DataBaseController {
	/**
	 * private instance variables
	 */
	private UniversityDBLibrary univDBlib;

	/**
	 * @param String
	 *            username, String password
	 * @return
	 */
	public DataBaseController() {
		univDBlib = new UniversityDBLibrary("stackund", "csci230");
	}

	/*
	 * @param
	 * 
	 * @returns UniversityDBLibrary univDBlib
	 */
	public UniversityDBLibrary getUnivDBlib() {
		return univDBlib;
	}

	/**
	 * displays the information inside of the table
	 *
	 * @param String
	 *            [][]table, PrintWriter pw, Int topx
	 *
	 * @returns
	 */
	public void display(String[][] table, PrintWriter pw, int topx) {

		if (table != null) {
			if (topx == -1 || topx > table.length)
				topx = table.length;
			for (int row = 0; row < topx; row++) {
				for (int col = 0; col < table[0].length; col++) {
					pw.print(table[row][col] + ",");
				}
				pw.println();
			}
		} else {
			pw.println("Nothing to display");
		}
	}

	/**
	 * Allows the user to get all the school details from the database
	 * 
	 * @param
	 * 
	 * @return newSchoolList /an entity with the information of the university
	 */
	public ArrayList<University> getAllSchoolDetails() {

		String[][] allSchools = univDBlib.university_getUniversities();
		String[][] schoolEmp = univDBlib.university_getNamesWithEmphases();
		ArrayList<University> newSchoolList = new ArrayList<University>();

		int i = 0;
		while (i < allSchools.length) {
			int a = 0;
			ArrayList<String> emp = new ArrayList<String>();
			while (a < schoolEmp.length) {
				if (schoolEmp[a][0].equals(allSchools[i][0])) {
					emp.add(schoolEmp[a][1]);
					a++;
				} else {
					a++;
				}
			}
			University school = new University(allSchools[i][0], allSchools[i][1], allSchools[i][2], allSchools[i][3],
					Integer.parseInt(allSchools[i][4]), Double.parseDouble(allSchools[i][5]),
					Double.parseDouble(allSchools[i][6]), Double.parseDouble(allSchools[i][7]),
					Double.parseDouble(allSchools[i][8]), Double.parseDouble(allSchools[i][9]),
					Integer.parseInt(allSchools[i][10]), Double.parseDouble(allSchools[i][11]),
					Double.parseDouble(allSchools[i][12]), Integer.parseInt(allSchools[i][13]),
					Integer.parseInt(allSchools[i][14]), Integer.parseInt(allSchools[i][15]), emp);

			newSchoolList.add(school);
			i++;

		}

		return newSchoolList;
	}

	/**
	 * Allows the user to get all the users in the database
	 * 
	 * @param
	 * 
	 * @return newUserList / an entity with the information on the users
	 */
	public ArrayList<Users> getAllUsers() {

		String[][] allUsers = univDBlib.user_getUsers();
		ArrayList<Users> newUserList = new ArrayList<Users>();

		int i = 0;
		while (i < allUsers.length) {
			Users user = new Users(allUsers[i][0], allUsers[i][1], allUsers[i][2], allUsers[i][3],
					allUsers[i][4].charAt(0), allUsers[i][5].charAt(0));

			newUserList.add(user);
			i++;
		}
		return newUserList;
	}

	/**
	 * Allows the users to add a university to the database
	 * 
	 * @param University
	 *            uni/ university to be added in the database
	 * @returns schoolAdded
	 *
	 */
	public boolean addUniversity(University uni) {
		boolean isNowThere = false;
		if (!this.checkSchoolName(uni.getName())) {
			univDBlib.university_addUniversity(uni.getName(), uni.getState(), uni.getLocation(), uni.getControl(),
					uni.getNumStudents(), uni.getFemales(), uni.getSATV(), uni.getSATM(), uni.getExpenses(),
					uni.getFinancialAid(), uni.getNumApplicants(), uni.getAdmitted(), uni.getEnrolled(),
					uni.getAcademicScale(), uni.getSocialScale(), uni.getqOLScale());
			isNowThere = true;
			ArrayList<String> emp = uni.getEmphases();
			int i = 0;
			while (i < emp.size()) {
				univDBlib.university_addUniversityEmphasis(uni.getName(), emp.get(i));
			}
		} else {
			isNowThere = false;
		}

		return isNowThere;
	}

	public boolean checkSchoolName(String name) {
		boolean there = false;
		ArrayList<University> checkSchool = this.getAllSchoolDetails();
		for (University u : checkSchool) {
			if (u.getName().equals(name)) {
				there = true;
			}
		}
		return there;
	}

	public boolean checkUserName(String name) {
		boolean there = false;
		ArrayList<Users> checkUsers = this.getAllUsers();
		for (Users u : checkUsers) {
			if (u.getUsername().equals(name)) {
				there = true;
			}
		}
		return there;
	}

	/**
	 * Allows the users to add a user to the database
	 * 
	 * @param Users
	 *            use/ user to be added in the database
	 * @returns addSuccess
	 *
	 */
	public int addUser(Users use) {
		
		int i = univDBlib.user_addUser(use.getFirstName(), use.getLastName(), use.getUsername(), use.getPassword(),
				use.getType());
		
		return i;
	}

	/**
	 * Allows the users to delete a university from the database
	 * 
	 * @param University
	 *            uni/ school to be deleted in the database
	 * @returns success
	 *
	 */
	public void deleteSchool(University uni) {
		boolean success = false;

		ArrayList<University> uniE = this.getAllSchoolDetails();
		for (University u : uniE) {
			if (u.getName().equals(uni.getName())) {
				for (String i : uni.getEmphases()) {
					univDBlib.university_removeUniversityEmphasis(u.getName(), i);
				}
				univDBlib.university_deleteUniversity(uni.getName());
				success = true;
			}
		}
		if (success == true)
		
			System.out.println("University Successfully Deleted");
		
		
		else if (success == false)
			System.out.println("University Unsuccessfully Deleted");
			
	}

	/**
	 * Allows the users to edit a university in the database
	 * 
	 * @param University
	 *            uni0, University uni to be edited in the database
	 * @returns success
	 *
	 */
	public void editSchool(University uni) {
		
		univDBlib.university_editUniversity(uni.getName(), uni.getState(), uni.getLocation(), uni.getControl(),
				uni.getNumStudents(), uni.getFemales(), uni.getSATV(), uni.getSATM(), uni.getExpenses(),
				uni.getFinancialAid(), uni.getNumApplicants(), uni.getAdmitted(), uni.getEnrolled(),
				uni.getAcademicScale(), uni.getSocialScale(), uni.getqOLScale());
		
	}

	/**
	 * Allows the users to delete a user from the database
	 * 
	 * @param Users
	 *            u/ user that is to be deleted in the database
	 * @returns success
	 *
	 */
	public void deleteUser(Users u) {
		univDBlib.user_deleteUser(u.getUsername());

	}

	/**
	 * Allows the users to edit a user in the database
	 * 
	 * @param Users
	 *            u/ user to be edited in the database
	 * @returns success
	 *
	 */
	public void editUser(Users u) {
		boolean oof = checkUserName(u.getUsername());
		
		if(oof == true)
		{
		univDBlib.user_editUser(u.getUsername(), u.getFirstName(), u.getLastName(), u.getPassword(), u.getType(),
				u.getStatus());
		}
		
		else {
			throw new IllegalArgumentException("User Not Found");
		}
	}

	/**
	* Allows the users to get saved schools in the database
	*@param Users u
	*@returns savedSchools
	*
	*/
	public ArrayList<SavedSchools> getSavedSchools(Users u){
		String [][] allSavedSchools = univDBlib.user_getUsernamesWithSavedSchools();
		ArrayList<SavedSchools> saveList = new ArrayList<SavedSchools>();
		ArrayList<University> allSchools = new ArrayList<University>();
		
		for (int i = 0; i < allSavedSchools.length; i++) {
			
			if (allSavedSchools[i][0].equals(u.getUsername())) {
				 allSchools = this.getAllSchoolDetails();
				
				 for (int x = 0; x < allSchools.size(); x++){
					 if(allSavedSchools[i][1].equals(allSchools.get(x).getName())) {
						 ArrayList<String> empList = new ArrayList<String>();
						String[][] emp = univDBlib.university_getNamesWithEmphases();
						for(int j = 0; j < emp.length; j ++) {
							
	                  if (emp[j][0].equals(allSchools.get(x).getName()))
	                  {
	                    empList.add(emp[j][1]);
	                  }
	                }
	                University uni = new University(allSchools.get(x).getName(), allSchools.get(x).getState(), allSchools.get(x).getLocation(), allSchools.get(x).getControl(),
	                		allSchools.get(x).getNumStudents(), allSchools.get(x).getFemales(), allSchools.get(x).getSATV(), allSchools.get(x).getSATM(), allSchools.get(x).getExpenses(),
	                		allSchools.get(x).getFinancialAid(), allSchools.get(x).getNumApplicants(), allSchools.get(x).getAdmitted(), allSchools.get(x).getEnrolled(),
	                		allSchools.get(x).getAcademicScale(), allSchools.get(x).getSocialScale(), allSchools.get(x).getqOLScale(), empList);
	                SavedSchools savedSchool = new SavedSchools(uni, allSavedSchools[i][2]);
	                saveList.add(savedSchool);
	              }
	            }          
	      }
	}
		return saveList;
	}

	

	/**
	 * Allows the users to remove saved schools from the database
	 * 
	 * @param SavedSchools
	 *            school
	 * @returns success
	 *
	 */
	public void removeSavedSchool(Users uName, String school) {

		univDBlib.user_removeSchool(uName.getUsername(), school);

	}
	public University viewSchoolDetails(String universityName) {
		
	boolean found = false;
	String[][] allSchools1 = univDBlib.university_getUniversities();
	ArrayList<University> allSchools2 =  new ArrayList<University>();
	String[][] schoolEmp = univDBlib.university_getNamesWithEmphases();
	int i = 0;
			int a = 0;
			ArrayList<String> emp = new ArrayList<String>();
			while (a < schoolEmp.length) {
				if (schoolEmp[a][0].equals(allSchools1[i][0])) {
					emp.add(schoolEmp[a][1]);
					a++;
				} else {
					a++;
				}
			}
			University school = new University(allSchools1[i][0], allSchools1[i][1], allSchools1[i][2], allSchools1[i][3],
					Integer.parseInt(allSchools1[i][4]), Double.parseDouble(allSchools1[i][5]),
					Double.parseDouble(allSchools1[i][6]), Double.parseDouble(allSchools1[i][7]),
					Double.parseDouble(allSchools1[i][8]), Double.parseDouble(allSchools1[i][9]),
					Integer.parseInt(allSchools1[i][10]), Double.parseDouble(allSchools1[i][11]),
					Double.parseDouble(allSchools1[i][12]), Integer.parseInt(allSchools1[i][13]),
					Integer.parseInt(allSchools1[i][14]), Integer.parseInt(allSchools1[i][15]), emp);

			allSchools2.add(school);
			for (int x = 0; x<allSchools2.size(); x++)
			
			{
			if(allSchools1[x][0].equals(universityName))
			{
			System.out.println(allSchools1[x][0] + " " + allSchools1[x][1]+ " " + allSchools1[x][2]+ " " +allSchools1[x][3]+ " " +
					Integer.parseInt(allSchools1[x][4])+ " " + Double.parseDouble(allSchools1[x][5])+ " " +
					Double.parseDouble(allSchools1[x][6])+ " " + Double.parseDouble(allSchools1[x][7])+ " " +
					Double.parseDouble(allSchools1[x][8])+ " " + Double.parseDouble(allSchools1[x][9])+ " " +
					Integer.parseInt(allSchools1[x][10])+ " " + Double.parseDouble(allSchools1[x][11])+ " " +
					Double.parseDouble(allSchools1[x][12])+ " " + Integer.parseInt(allSchools1[x][13])+ " " +
					Integer.parseInt(allSchools1[x][14])+ " " + Integer.parseInt(allSchools1[x][15]));
			 University uni = allSchools2.get(x);
			 found = true;
			 return uni;
		}
		i++;
	}
			if(found == false)
			{
				throw new IllegalArgumentException("School not found");
			}
	return null;
		/*ArrayList<University> list = getAllSchoolDetails();
		boolean found = false;
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).equals(universityName))
			{
				list.get(i).print();
				found = true;
				return list.get(i);
			}
		}
		if(found == false)
		throw new IllegalArgumentException("University: '" + universityName + "' was not found");
		
		return null;*/
	}

	/**
	 * Allows the users to save schools in the database
	 * 
	 * @param String
	 *            uName, String school
	 * @return 
	 * @returns success
	 *
	 */
	public int saveSchool(Users uName, University school) {

		return univDBlib.user_saveSchool(uName.getUsername(), school.getName());

	}
	
	public Users getUser(String uName) {
		ArrayList<Users> users = getAllUsers();
		Users u = null;
		for(int i = 0; i<users.size(); i++)
		{
			if(users.get(i).getUsername().equals(uName)) {
		 u = users.get(i);
		}
		}
	
		return u;
	}
	
}
