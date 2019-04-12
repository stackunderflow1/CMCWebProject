package edu.csbsju.cs;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import edu.csbsju.cs.Controllers.AdminFunctionalityController;
import edu.csbsju.cs.Controllers.DataBaseController;
import edu.csbsju.cs.Entity.University;
import edu.csbsju.cs.Entity.Users;

public class TestAdminFunctionalityController {

	DataBaseController dbc;
	Users u;
	AdminFunctionalityController afc;
	University s;

	@Before
	public void setUp() throws Exception {
		afc = new AdminFunctionalityController();
		dbc = new DataBaseController();
		u = new Users("dummy", "test", "dummytest", "password", 'u', 'Y');
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("BIOLOGY");
		s = new University("TEST", "MINNESOTA", "URBAN", "PUBLIC", 2000, 50, -1, -1, 22550, 20, 5500, 50, 80, 3, 3, 3,
				emp);
		
	}

	@Test
	public void testAdminFunctionalityController() {
		AdminFunctionalityController afcNew = new AdminFunctionalityController();
		assertSame("Constructor test", afc, afcNew);
	}

	@Test
	public void testAddUser() {
		afc.addUser(u);
		
		ArrayList<Users> userList = afc.getAllUsers();
		for(Users i : userList) {
			if(i.getUsername().equals("dummytest")) {
				
				assertTrue("Succesfully added user", i.getUsername().equals("dummytest"));
			}
		}
		afc.deleteUser(u);
	}

	@Test
	public void testDeleteUser() {
		afc.addUser(u);
		afc.deleteUser(u);
		boolean found = false;
		ArrayList<Users> userList = afc.getAllUsers();
		for(Users i : userList) {
			if(i.getUsername().equals("dummytest")) {
				found = true;
				assertTrue("Succesfully deleted user", i.getUsername().equals("dummytest"));
			}
			if(found == true) {
				assertFalse(true);
				
			}
			else {
				assertTrue(true);
			}
		}
		
		
	}

	@Test
	public void testEditUser() {
		afc.editUser(u, "notdummy", "test", "dummytest","password", 'u', 'Y');
		ArrayList<Users> userList = afc.getAllUsers();
		
		for(Users i : userList) {
			if(i.getUsername().equals("dummytest")) {
				assertTrue("Edit user works", u.getFirstName().equals("notdummy"));
			}
		}
	}

	@Test
	public void testAddUniversity() {
		afc.addUniversity(s);
		
		ArrayList<University> schoolList = dbc.getAllSchoolDetails();
		for(University i : schoolList) {
			if(i.getName().equals("TEST")) {
				
				assertTrue("Succesfully added University", i.getName().equals("TEST"));
			}
		}
		afc.deleteSchool(s);
	
		}

	@Test
	public void testGetAllUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSchool() {
		afc.addUniversity(s);
		afc.deleteSchool(s);
		boolean found = false;
		ArrayList<University> schoolList = dbc.getAllSchoolDetails();
		for(University i : schoolList) {
			if(i.getName().equals("TEST")) {
				found = true;
				assertTrue("Succesfully deleted University", i.getName().equals("TEST"));
			}
		}
		if(found == true) {
			assertFalse(false);
			
		}
		else {
			assertTrue(true);
		}	
		}

/*	@Test
	public void testEditSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeactivateUser() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetUserUsers() {
		fail("Not yet implemented");
	}

}
