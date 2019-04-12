package edu.csbsju.cs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.csbsju.cs.Entity.University;

public class UniversityTest {
	ArrayList<String> emp = new ArrayList<String>();
	University u = new University("i2", "i", "i", "i", 1, 1.1, 1.2, 1.3, 1.4, 1.5, 2, 2.1, 2.2, 3, 4, 5, emp);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUniversity() {
		ArrayList<String> emp = new ArrayList<String>();
		University result = new University("i2", "i", "i", "i", 1, 1.1, 1.2, 1.3, 1.4, 1.5, 2, 2.1, 2.2, 3, 4, 5, emp);
		University expResult = null;
		assertNotEquals("school" + expResult,expResult, result);
	}

	@Test
	public void testGetName() {
		String expResult = null;
		String result = u.getName();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetName() {
		String expResult = "COOL";
		u.setName(expResult);
		String result = u.getName();
		u.setName("i");
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetState() {
		String expResult = null;
		String result = u.getState();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetState() {
		String expResult = "COOL";
		u.setState(expResult);
		String result = u.getState();
		u.setState("i");
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetLocation() {
		String expResult = null;
		String result = u.getLocation();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetLocation() {
		String expResult = "COOL";
		u.setLocation(expResult);
		String result = u.getLocation();
		u.setLocation("i");
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetControl() {
		String expResult = null;
		String result = u.getControl();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetControl() {
		String expResult = "COOL";
		u.setControl(expResult);
		String result = u.getControl();
		u.setControl("i");
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetNumStudents() {
		int expResult = -5;
		int result = u.getNumStudents();
		assertNotEquals("University" + expResult,expResult, result);;
	}

	@Test
	public void testSetNumStudents() {
		int expResult = 25;
		u.setNumStudents(expResult);
		int result = u.getNumStudents();
		u.setNumStudents(4);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetNumApplicants() {
		int expResult = -5;
		int result = u.getNumApplicants();
		assertNotEquals("University" + expResult,expResult, result);;
	}

	@Test
	public void testSetNumApplicants() {
		int expResult = 25;
		u.setNumApplicants(expResult);
		int result = u.getNumApplicants();
		u.setNumApplicants(4);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetAcademicScale() {
		int expResult = -5;
		int result = u.getAcademicScale();
		assertNotEquals("University" + expResult,expResult, result);;
	}

	@Test
	public void testSetAcademicScale() {
		int expResult = 25;
		u.setAcademicScale(expResult);
		int result = u.getAcademicScale();
		u.setAcademicScale(4);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetSocialScale() {
		int expResult = -5;
		int result = u.getSocialScale();
		assertNotEquals("University" + expResult,expResult, result);;
	}

	@Test
	public void testSetSocialScale() {
		int expResult = 25;
		u.setSocialScale(expResult);
		int result = u.getSocialScale();
		u.setSocialScale(4);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetqOLScale() {
		int expResult = -5;
		int result = u.getqOLScale();
		assertNotEquals("University" + expResult,expResult, result);;
	}

	@Test
	public void testSetqOLScale() {
		int expResult = 25;
		u.setqOLScale(expResult);
		int result = u.getqOLScale();
		u.setqOLScale(4);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetEnrolled() {
		double expResult = -5.0;
		double result = u.getEnrolled();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetEnrolled() {
		double expResult = 25.0;
		u.setEnrolled(expResult);
		double result = u.getEnrolled();
		u.setEnrolled(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetSATV() {
		double expResult = -5.0;
		double result = u.getSATV();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetSATV() {
		double expResult = 25.0;
		u.setSATV(expResult);
		double result = u.getSATV();
		u.setSATV(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetSATM() {
		double expResult = -5.0;
		double result = u.getSATM();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetSATM() {
		double expResult = 25.0;
		u.setSATM(expResult);
		double result = u.getSATM();
		u.setSATM(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetExpenses() {
		double expResult = -5.0;
		double result = u.getExpenses();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetExpenses() {
		double expResult = 25.0;
		u.setExpenses(expResult);
		double result = u.getExpenses();
		u.setExpenses(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetFinancialAid() {
		double expResult = -5.0;
		double result = u.getFinancialAid();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetFinancialAid() {
		double expResult = 25.0;
		u.setFinancialAid(expResult);
		double result = u.getFinancialAid();
		u.setFinancialAid(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetAdmitted() {
		double expResult = -5.0;
		double result = u.getAdmitted();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetAdmitted() {
		double expResult = 25.0;
		u.setAdmitted(expResult);
		double result = u.getAdmitted();
		u.setFinancialAid(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetFemales() {
		double expResult = -5.0;
		double result = u.getFemales();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testSetFemales() {
		double expResult = 25.0;
		u.setFemales(expResult);
		double result = u.getFemales();
		u.setFemales(4.0);
		assertEquals(expResult,expResult, result);
	}

	@Test
	public void testGetEmphases() {
		ArrayList<String> expResult = null;
		ArrayList<String> result = u.getEmphases();
		assertNotEquals("University" + expResult,expResult, result);
	}

	@Test
	public void testPrint() {
		String expResult = null;
		String result = u.print();
		assertNotEquals("University" + expResult,expResult, result);
	}

}
