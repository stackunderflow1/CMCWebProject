

/**
*packages
*/
package edu.csbsju.cs.Entity;
/**
*imports
*/

import java.util.*;
/**
 *stackUnderflow1
 *@author Anton Andrews, Ryan Graham, Nathan Drees, Noah Lefebvre, DeAndre Bethell
 *@version March 2019
 */

/**
 * University Entity that stores all the information pertaining to a university.
 */
public class University {
/**
*instance variables
*/
private String name, state, location, control;
private int numStudents, numApplicants, academicScale, socialScale, qOLScale;
private double enrolled, SATV, SATM, expenses, financialAid,  admitted, females;
private ArrayList<String> emphases;

	/**
	* Lists information on a specific University
	* @param String name, state, location,control 
	* @param Double females, SATV, SATM, expenses, financialAid, admitted, enrolled
	*@param Int numStudents, numApplicants, acedemicScale, socialScale, q0LScale
	*@param ArrayList<String> emphasess
	 */
	public University(String name, String state, String location, String control, int numStudents, 
			 double females, double SATV, double SATM, double expenses, double financialAid, 
			 int numApplicants, double admitted, double enrolled, int academicScale, int socialScale, 
			 int qOLScale, ArrayList<String> emphasess) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.females = females;
		this.SATV = SATV;
		this.SATM = SATM;
		this.expenses = expenses;
		this.financialAid = financialAid;
		this.numApplicants = numApplicants;
		this.admitted = admitted;
		this.enrolled = enrolled;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qOLScale = qOLScale;
		this.emphases = emphasess; //School emphases
	}
	
	/*while i < 
		University u = universites.get(i)
		if param == u.getname
		u.getname();*/
	

	/**
	 * gets the Name of the University
	 *@param 
	 * @return the state/ this.name
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String name){
		this.name = name.toUpperCase();
	}
	/**
	 * gets the state of the University
	 *@param 
	 * @return the state/ this.state
	 */
	public String getState() {
		return this.state;
	}
	
	public void setState(String state){
		this.state = state.toUpperCase();
	}

	/**
	 * gets the location of the University
	 *@param 
	 * @return the location/ this.location
	 */
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location){
		this.location = location.toUpperCase();
	}


	/**
	 * gets the control of the university
	 *@param 
	 * @return the control of the university/ this.control
	 */
	public String getControl() {
		return this.control;
	}

	public void setControl(String control){
		this.control = control.toUpperCase();
	}


	/**
	 * gets the getNumStudents
	 *@param 
	 * @return the number of students/ this.numStudents
	 */
	public int getNumStudents() {
		return this.numStudents;
	}
	
	public void setNumStudents(int numStudents){
		this.numStudents = numStudents;
	}



	/**
	 * gets the number of applicants to a specific University
	 *@param 
	 * @return the number of applicants/ this.numApplicants
	 */
	public int getNumApplicants() {
		return this.numApplicants;
	}

	public void setNumApplicants(int numApplicants){
		this.numApplicants = numApplicants;
	}


	/**
	 * gets the application scale of the University
	 *@param 
	 * @return the academic scale/ this.academicScale
	 */
	public int getAcademicScale() {
		return this.academicScale;
	}
	
	public void setAcademicScale(int academicScale){
		this.academicScale = academicScale;
	}



	/**
	 * gets the social scale of the University
	 *@param 
	 * @return the social scale/ this.socialScale
	 */
	public int getSocialScale() {
		return this.socialScale;
	}
	
	public void setSocialScale(int socialScale){
		this.socialScale = socialScale;
	}



	/**
	 * gets the q0L scale of the University
	 *@param 
	 * @return the q0L scale/ this.q0LScale
	 */
	public int getqOLScale() {
		return this.qOLScale;
	}
	
	public void setqOLScale(int qOLScale){
		this.qOLScale = qOLScale;
	}




	/**
	 * gets the number of students enrolled at the University
	 *@param 
	 * @return the number of students enrolled at the university/ this.enrolled
	 */
	public double getEnrolled() {
		return this.enrolled;
	}
	
	public void setEnrolled(double enrolled){
		this.enrolled = enrolled;
	}




	/**
	 * gets the sATV score of a university
	 *@param
	 * @return the sATV score of a university/ this.SATV
	 */
	public double getSATV() {
		return this.SATV;
	}
	
	public void setSATV(double SATV){
		this.SATV = SATV;
	}




	/**
	 * gets the sATM score of a university
	 *@param
	 * @return the sATM score of a university/ this.SATM
	 */
	public double getSATM() {
		return this.SATM;
	}
	
	public void setSATM(double SATM){
		this.SATM = SATM;
	}


	/**
	 * gets the expenses of a university
	 *@param
	 * @return the expenses of a university/ this.expenses
	 */
	public double getExpenses() {
		return this.expenses;
	}
	
	public void setExpenses(double expenses){
		this.expenses = expenses;
	}

	/**
	 * gets the financial aid of a university
	 *@param
	 * @return the financial aid of a university/ this.financialAid
	 */
	public double getFinancialAid() {
		return this.financialAid;
	}

	public void setFinancialAid(double financialAid){
		this.financialAid = financialAid;
	}
	/**
	 * gets the number of students admitted to a university
	 *@param
	 * @return the number of students admitted to a university/ this.admitted
	 */
	public double getAdmitted() {
		return this.admitted;
	}
	
	public void setAdmitted(double admitted){
		this.admitted = admitted;
	}



	/**
	 * gets the number of female students admitted to a university
	 *@param
	 * @return the number of female students admitted to a university/ this.females
	 */
	public double getFemales() {
		return this.females;
	}
	
	public void setFemales(double females){
		this.females = females;
	}
	
	
	/**
	 * gets the emphases of a university
	 *@param
	 * @return the emphases of a university/ this.emphases
	 */
	public ArrayList<String> getEmphases(){
		return this.emphases;
	}
	/**
	 * prints all of the information aforementioned
	 *@param
	 * @return s
	 */
	public String print()
	{
		String s = this.name + " " + this.state + " " + this.location + " " + 
	this.control + " " + Integer.toString(this.numStudents) + " " + Double.toString(this.females) + 
	" " + Double.toString(this.SATV) + " " + Double.toString(this.SATM) + " " + Double.toString(this.expenses) + 
	" " + Double.toString(this.financialAid) + " " + Integer.toString(this.numApplicants) + " " + 
	Double.toString(this.admitted) + " " + Double.toString(this.enrolled) + " " + Integer.toString(this.academicScale) + 
	" " + Integer.toString(this.socialScale) + " " + Integer.toString(this.qOLScale);
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
