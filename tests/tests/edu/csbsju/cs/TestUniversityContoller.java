package edu.csbsju.cs;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import edu.csbsju.cs.Controllers.*;
import edu.csbsju.cs.Entity.University;

public class TestUniversityContoller {
	UniversityController uc = new UniversityController();
	ArrayList<String> emp = new ArrayList<String>();
	University u = new University("i", "i", "i", "i", 1, 1.1, 1.2, 1.3, 1.4, 1.5, 2, 2.1, 2.2, 3, 4, 5, emp);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchAllSChools() {
		ArrayList<University> expNonResult = null;
		ArrayList<University> result = uc.searchAllSchools("i", "i", "i", "i", "1", "1.1", "1.2", "1.3", "1.4", "1.5", "2", "2.1", "2.2", "3", "4", "5");
		assertNotEquals("ArrayList " + expNonResult,expNonResult, result);
	}
	
	@Test
	public void testTopReccommended() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testDist() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testTopRecommendedSort() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAcceptanceProbability() {
		fail("Not yet implemented");
	}

}
