package edu.csbsju.cs;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import org.junit.Before;
import org.junit.Test;

import edu.csbsju.cs.Entity.*;

public class SavedSchoolsTest {
	ArrayList<String> emp = new ArrayList<String>();
	University u = new University("i2", "i", "i", "i", 1, 1.1, 1.2, 1.3, 1.4, 1.5, 2, 2.1, 2.2, 3, 4, 5, emp);
	SavedSchools schools = new SavedSchools(u, "2019-4-10 9-49-37");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSavedSchools() {
		SavedSchools school = new SavedSchools(u, "2019-4-10 9-49-37");
		SavedSchools sch = null;
		assertNotEquals("school" + sch,sch, school);
	}

	@Test
	public void testGetUniversity() {
		University expResult = u;
		University result = schools.getUniversity();
		assertEquals("University" + expResult,expResult, result);
		
	}

	@Test
	public void testGetTimeStamp() {
		SimpleDateFormat expResult = null;
		SimpleDateFormat result = schools.getTimeStamp();
		assertNotEquals("Time" + expResult,expResult, result);
	}

}
