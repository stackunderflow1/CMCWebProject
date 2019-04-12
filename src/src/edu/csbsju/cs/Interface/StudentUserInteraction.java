/*packages
*/
package edu.csbsju.cs.Interface;
/*imports
*/
import edu.csbsju.cs.Controllers.*;
import edu.csbsju.cs.Entity.*;
import java.util.*;

import javax.naming.NameNotFoundException;

/**
* StudentInteraction Class
*@author DeAndre Bethell, Ryan Graham, Noah Lefebvre, Anton Andrews, Nathan Drees
*@version March 2019
*/

public class StudentUserInteraction {

/**
	* Displays a university in the database
	*@param 
	*@returns the a university in the database
	*/
	private StudentFunctionalityController sfc = new StudentFunctionalityController();
  public University viewUniversity(University uni) throws NameNotFoundException
  {
    return sfc.viewSchoolDetails(uni.getName());
  }
  /**
	* Displays all the saved schools that the user saved in the database
	*@param 
	*@returns the saved schools in the database
	*/
  public ArrayList<SavedSchools> viewAllSavedUniversitys(Users u) 
  { 
    return sfc.getSavedSchools(u);
  }
  /**
	* Displays the acceptance probability rate of the student 
	*@param 
	*@returns the user's acceptance probability rate
	*/
 /* public String acceptanceProbability() 
  {
    return 
  }*/
  /**
	* Displays all recommended universities to the user
	*@param 
	*@returns the recommended universities to the user
	*/
  public void viewRecommendedUniversities(String n) 
  {
    sfc.viewRecommendedUniversities(n);
  }
  /**
	* Saves a university to the database
	*@param String uName, school
 * @return 
	*@returns the saved university in the database
	*/
  public void saveUniversity(University school, Users uName) 
  { 
    sfc.saveSchool(school, uName);
  }
  
  /**
	*Deletes a saved school from the database
	*@param University school
	*@returns University list without the school that was deleted
	*/
  public void removeSavedSchool(Users user, String school)
  {
     sfc.removeSavedSchool(user, school);
  }
  
  public University viewSchoolDetails(String universityName) throws NameNotFoundException 
  {
	   return sfc.viewSchoolDetails(universityName);
  }
  

  public void editProfile(String uName, String fName, String lName, String pWord) {
	  sfc.editProfile(uName, fName, lName, pWord);
  }
  
  public Users getProfile(Users u)
  {
	  return sfc.getProfile(u);
  }
 
  
}
