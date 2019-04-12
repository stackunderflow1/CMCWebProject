package edu.csbsju.cs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.csbsju.cs.Controllers.LogOnController;

public class LogOnControllerTest {
	LogOnController log;

	@Before
	public void setUp() throws Exception {
		log = new LogOnController();
	}

	@Test
	public void testLogOnUser() {
		boolean expResult = true;
		log.logOn("juser", "user");
		boolean result = log.isLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testLogOnAdmin() {
		boolean expResult = true;
		log.logOn("nadmin", "admin");
		boolean result = log.isAdminLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testDeactivatedUserLogOn() {
		log.logOn("luser", "user");
		boolean expResult = false;
		boolean result = log.isLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testWrongUsernameLogOn() {
		log.logOn("failure", "user");
		boolean expResult = false;
		boolean result = log.isLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testWrongPasswordLogOn() {
		log.logOn("juser", "failure");
		boolean expResult = false;
		boolean result = log.isLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testLogOutUser() {
		boolean expResult = false;
		log.logOn("juser", "user");
		log.logOut();
		boolean result = log.isLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}
	
	@Test
	public void testLogOutAdmin() {
		boolean expResult = false;
		log.logOn("nadmin", "admin");
		log.adminLogOut();
		boolean result = log.isAdminLoggedOn();
		assertEquals("Logged on is " + expResult,expResult, result);
	}

}
