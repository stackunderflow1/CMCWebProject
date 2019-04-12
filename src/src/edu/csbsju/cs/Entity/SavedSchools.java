
/**
*packages
*/
package edu.csbsju.cs.Entity;
import java.text.SimpleDateFormat;

/**
 * Saved schools entity class
 * 
 * @author DeAndre Bethell, Ryan Graham, Noah Lefebvre, Anton Andrews, Nathan
 *         Drees
 * @version March 2019
 */

public class SavedSchools extends University {
	/**
	 * instance variables
	 */
	private SimpleDateFormat timeStamp;
	private University uni;

	/**
	*constructor method
	*/
	public SavedSchools(University u, String time) {
		super(u.getName(), u.getState(), u.getLocation(), u.getControl(),
                u.getNumStudents(), u.getFemales(), u.getSATV(), u.getSATM(),
                u.getExpenses(), u.getFinancialAid(), u.getNumApplicants(),
                u.getAdmitted(), u.getEnrolled(), u.getAcademicScale(), 
                u.getSocialScale(), u.getqOLScale(), u.getEmphases());
         this.timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
         this.uni = u;
	}
	
	public University getUniversity()
	{
		return uni;
	}

	/**
	 * gets the user name of the user in the school
	 * 
	 * @param
	 * @returns the user name of the user/ this.userName
	 */
	public SimpleDateFormat getTimeStamp() {
		return this.timeStamp;
	}
}
