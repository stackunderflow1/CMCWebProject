/**
 * packages
 */
package edu.csbsju.cs.Controllers;
/**
 * imports
 */
import java.util.ArrayList;
import edu.csbsju.cs.Entity.University;

/**
 * This class is the University controller that allows a user to access the database.
 * @StackUnderflow
 * @author DeAndre Bethell, Nathan Drees, Anton Andrews, Ryan Graham, Noah Lefebvre
 * @version March 2019
 */
public class UniversityController {
	private DataBaseController dbc = new DataBaseController();
	ArrayList<University> schools = dbc.getAllSchoolDetails();

	/**
	 * Constructor
	 */
	//University university;
	public UniversityController() {
		// TODO Auto-generated constructor stub
		
	}
	/** 
  	*displays the information of all the schools inside of the database
	*throws NumberFormatException
	*@param String name, state, location, control, numStudents, females, SATV, SATM,expenses, financialAid, numApplicants, admitted, enrolled, academicScale, socialScale, qOlScale 
	*
	*@returns a clone out of the university arrayList
	*/
	public ArrayList<University> searchAllSchools(String name, String state, String location, String control, String numStudents, String females, String SATV, String SATM, String expenses, String financialAid, String numApplicants, String admitted, String enrolled, String academicScale, String socialScale, String qOLScale) throws NumberFormatException
	{
		
		
		
		ArrayList<University> schools2 = (ArrayList<University>) schools.clone();

		for(int i =0; i<schools.size(); i++)
		{
			if(!name.equals(null) && !name.equals("-1") && !name.equals("")) {
			if(schools.get(i).getName().toLowerCase().indexOf(name.toLowerCase())< 0)
					{
				schools2.remove(schools.get(i));
					}
			}
			if(!state.equals(null) && !state.equals("-1") && !state.equals("")) {
			if(schools.get(i).getState().toLowerCase().indexOf(state.toLowerCase())<0 )
			{
				schools2.remove(schools.get(i));
			}
			}
			if(!location.equals(null) && !location.equals("-1") && !location.equals("")) {
			if(schools.get(i).getLocation().toLowerCase().indexOf(location.toLowerCase())< 0 )
			{
				schools2.remove(schools.get(i));
			}
			}
			if(!control.equals(null) && !control.equals("-1") && !control.equals("")) {
			if(schools.get(i).getControl().toLowerCase().indexOf(control.toLowerCase())<0 )
			{
				schools2.remove(schools.get(i));
			}
			}
			if(!numStudents.equals(null) && !numStudents.equals("-1") && !numStudents.equals("")) {
			if(!(-1 < schools.get(i).getNumStudents() && schools.get(i).getNumStudents() <= (Integer.parseInt(numStudents))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!females.equals(null) && !females.equals("-1") && !females.equals("")) {
			if(!(-1.0 < schools.get(i).getFemales() && schools.get(i).getFemales() <= (Double.parseDouble(females))))
			{
				schools2.remove(schools.get(i));
			}}
			
			if(!SATV.equals(null) && !SATV.equals("-1") && !SATV.equals("")) {
				if(!(-1.0 < schools.get(i).getSATV() && schools.get(i).getSATV() <= (Double.parseDouble(SATV))))
			{
					schools2.remove(schools.get(i));
			}
			}
			if(SATM != (null) && !SATM.equals("-1") && !SATM.equals("")) {
			if(!(-1.0 < schools.get(i).getSATM() && schools.get(i).getSATM() <= (Double.parseDouble(SATM))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!expenses.equals(null) && !expenses.equals("-1") && !expenses.equals("")) {
			if(!(-1.0 < schools.get(i).getExpenses() && schools.get(i).getExpenses() <= (Double.parseDouble(expenses))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!financialAid.equals(null) && !financialAid.equals("-1") && !financialAid.equals("")) {
			if(!(-1.0 < schools.get(i).getFinancialAid() && schools.get(i).getFinancialAid() <= (Double.parseDouble(financialAid))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!numApplicants.equals(null) && !numApplicants.equals("-1") && !numApplicants.equals("")) {
			if(!(-1 < schools.get(i).getNumApplicants() && schools.get(i).getNumApplicants() <= (Integer.parseInt(numApplicants))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!admitted.equals(null) && !admitted.equals("-1") && !admitted.equals("")) {
			if(!(-1.0 < schools.get(i).getAdmitted() && schools.get(i).getAdmitted() <= (Double.parseDouble(admitted))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!enrolled.equals(null) && !enrolled.equals("-1")&& !enrolled.equals("")) {
			if(!(-1.0 < schools.get(i).getEnrolled() && schools.get(i).getEnrolled() <= (Double.parseDouble(enrolled))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!academicScale.equals(null)&& !academicScale.equals("-1") && !academicScale.equals("")) {
			if(!(-1 < schools.get(i).getAcademicScale() && schools.get(i).getAcademicScale() <= (Integer.parseInt(academicScale))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!socialScale.equals(null) && !socialScale.equals("-1") && !socialScale.equals("")) {
			if(!(-1 < schools.get(i).getSocialScale() && schools.get(i).getSocialScale() <= (Integer.parseInt(socialScale))))
			{
				schools2.remove(schools.get(i));
			}}
			if(!qOLScale.equals(null) && !qOLScale.equals("-1") && !qOLScale.equals("")) {
			if(!(-1 < schools.get(i).getqOLScale() && schools.get(i).getqOLScale() <= (Integer.parseInt(qOLScale))))
			{
				schools2.remove(schools.get(i));
			}}
				
					}
		return schools2;
		}
	/** 
  	*gets all the school details out of the database
	*@param 
	*@returns
	*/
	
	/** 
  	*displays the topReccommended schools
	*@param String n
	*@returns
	*/
	public void topRecommended(String n) {
		// TODO Auto-generated constructor stub
		University u = null;
		for(int i = 0; i<schools.size(); i++)
		{
			if(schools.get(i).getName().equals(n))
			{
				 u = schools.get(i);
			}
		}
		
		
		double [] distances = new double[schools.size()];
		String [] sc = new String[schools.size()];
		double d = 0;
		int i = 0;
		
		for(University univ : schools)
		{
			d = dist(u, univ);
			distances[i] = d;
			sc[i] = univ.getName();
			i++;
		}
		System.out.println("Top Recommended for school '" + n + "':");
		topRecommendedSort(distances, sc);
			}
			
	
	
	/** 
  	*This method calculates the distance between two schools by comparing the values of each parameter
	*
	*@param University u1,u2
	*
	*@returns all the necessary information needed to produce the distance between the two schools
	*/
	public static double dist(University u1, University u2) {
		//variables to be compared
		String u1Control,u1State, u1Location;
		int u1NumStudents;
		String u2Control,u2State, u2Location;
		int u2NumStudents;
		
		//Each comparison return a number. Therefore, these are the variables to hold those numbers
		double controlNumber,totalNumStudents, stateNumber, locationNumber, totalFemales, totalSATV, totalSATM, totalExpenses;
		double totalFinAid, totalNumApplicants, totalAdmitted, totalEnrolled, totalAcademicScale, totalSocialScale, totalQOLScale;
		
		//Assigning value to the variables
		u1Control = u1.getControl();
		u1State = u1.getState();
		u1NumStudents = u1.getNumStudents();
		u2Control = u2.getControl();
		u2State = u2.getState();
		u2NumStudents = u2.getNumStudents();
		u1Location = u1.getLocation();
		u2Location = u2.getLocation();
		
		
		
		if (u1Control.equals(u2Control)) {
			//control match
			controlNumber = 0.0;
		} else {
			controlNumber = 1.0;
		}
		if (u1Location.equals(u2Location)) {
			//control match
			locationNumber = 0.0;
		} else {
			locationNumber = 1.0;
		}
		if (u1State.equals(u2State)) {
			//states match
			stateNumber = 0.0;
		}else {
			stateNumber = 1.0;
		}
		
		totalFemales = Math.abs((u1.getFemales() - u2.getFemales())/ 99.0);
		totalSATV = Math.abs((u1.getSATV() - u2.getSATV()) /500.0);
		totalNumStudents = Math.abs((u1NumStudents - u2NumStudents)/ 30000.0);
		totalSATM = Math.abs((u1.getSATM() - u2.getSATM())/ 530.0);
		totalExpenses = Math.abs((u1.getExpenses()-u2.getExpenses())/52477.0);
		totalFinAid = Math.abs((u1.getFinancialAid()-u2.getFinancialAid())/95.0);
		totalNumApplicants = Math.abs((u1.getNumApplicants()-u2.getNumApplicants())/13000.0);
		totalAdmitted = Math.abs((u1.getAdmitted()-u2.getAdmitted())/95.0);
		totalEnrolled = Math.abs((u1.getEnrolled()-u2.getEnrolled())/90.0);
		totalAcademicScale = Math.abs((u1.getAcademicScale()-u2.getAcademicScale())/4.0);
		totalSocialScale = Math.abs((u1.getSocialScale()-u2.getSocialScale())/4.0);
		totalQOLScale = Math.abs((u1.getqOLScale()-u2.getqOLScale())/4.0);
		
		double d = (controlNumber + stateNumber + totalNumStudents + locationNumber + totalFemales + totalSATV + totalSATM + totalExpenses + totalFinAid + totalNumApplicants + totalAdmitted + totalEnrolled + totalAcademicScale + totalSocialScale + totalQOLScale);
		
		return d;
}
	/** 
  	*sorts the topReccommended schools
	*@param double [] a1, String [] a2
	*@returns
	*/
	public static void topRecommendedSort(double a1[], String a2[])
	{
		int n = a1.length;
		for (int i = 0; i< n-1; i++)
		{
			for (int j=0; j<n-i-1; j++)
			{
				if(a1[j] > a1[j+1]) {
					double temp = a1[j];
					a1[j] = a1[j+1];
					a1[j+1] = temp;
					
					String temp2 = a2[j];
					a2[j] = a2[j+1];
					a2[j+1] = temp2;
				}
			}
		}
		System.out.println("\n" + a2[1] + "\n" + a2[2] + "\n" +a2[3] + "\n" + a2[4] + "\n" + a2[5]);
		System.out.println("\n\nwith distances of: \n" + a2[1] + ": " + a1[1] + "\n" + a2[2] + ": " + a1[2] + "\n" +a2[3] + ": " +a1[3] + "\n" + a2[4] + ": " + a1[4] + "\n" + a2[5] + ": " + a1[5]);
	}
	
	//@param double SATV, double SATM
	//@param University university
	public double acceptanceProbability(double SATV, double SATM, University university)
	  {
		double hello = university.getSATV() - SATV;
		double world = university.getSATM() - SATM;
		  
		if((university.getSATV() == -1.0)|| (university.getSATM()==-1.0))
		{
			return -1;
		}
		if (SATV > 800 || SATV < 0 || SATM > 800 || SATV < 0)
		{
			return -1;
		}
		else if (hello <= 0 && world <= 0) {
			  return 100.0;
		  }
		  else if(hello < 20 && world < 20 )
		  {
			  return 90.0;
		  }
		  else if(hello < 50 && world < 50)
		  {
			  return 70.0;
		  }
		  else if(hello < 75 && world < 75)
		  {
			  return 55.0;
		  }
		  else if(hello < 100 && world < 100)
		  {
			  return 40.0;
		  }
		  else if(hello < 150 && world < 150)
		  {
			  return 10.0;
		  }
		  else if(SATV == 800 || SATM == 800)
		  {
			  return 100;
		  }
		
	  return 0.0;
	  }
}
