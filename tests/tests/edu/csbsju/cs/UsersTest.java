package edu.csbsju.cs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.csbsju.cs.Entity.*;

public class UsersTest {
	Users u;

	@Before
	public void setUp() throws Exception {
		u = new Users("dummy", "test", "dummytest", "password", 'u', 'Y');
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUsersConstructorInvalidType() {
		new Users("noah", "lefebvre", "nlefebvre", "pcm9", 'x', 'Y');

	}

	@Test(expected = IllegalArgumentException.class)
	public void testUsersConstructorInvalidStatus() {
		new Users("noah", "lefebvre", "nlefebvre", "pcm9", 'u', 'j');
	}

	@Test
	public void testGetFirstName() {
		assertTrue("getFirstName() expected dummy", "dummy".equals(u.getFirstName()));
	}

	@Test
	public void testGetLastName() {
		assertTrue("getLastName() expected test", u.getLastName().equals("test"));
	}

	@Test
	public void testGetUsername() {
		assertTrue("getUsername() expected dummytest", u.getUsername().equals("dummytest"));
	}

	@Test
	public void testGetPassword() {
		assertTrue("getPassword() expected password", u.getPassword().equals("password"));
	}

	@Test
	public void testGetType() {
		assertTrue("getType() expected 'u'", u.getType() == 'u');
	}

	@Test
	public void testGetStatus() {
		assertTrue("getStatus() expected 'Y'", u.getStatus() == 'Y');
	}

	@Test
	public void testSetFirstName() {
		u.setFirstName("dexter");
		assertTrue("Sets first name to dexter", u.getFirstName().equals("dexter"));
	}

	@Test
	public void testSetLastName() {
		u.setLastName("morgan");
		assertTrue("Sets last name to morgan", u.getLastName().equals("morgan"));
	}

	@Test
	public void testSetUserName() {
		u.setUserName("dmorg");
		assertTrue("Sets username to dmorg", u.getUsername().equals("dmorg"));
	}

	@Test
	public void testSetPassword() {
		u.setPassword("icetruck");
		assertTrue("Sets password to icetruck", u.getPassword().equals("icetruck"));
	}

	@Test
	public void testSetStatus() {
		u.setStatus('N');
		assertTrue("Sets type to 'N'", u.getStatus() == 'N');
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetStatusInvalidParam() {
		u.setStatus('d');
	}

	@Test
	public void testSetType() {
		u.setType('a');
		assertTrue("Sets type to 'a'", u.getType() == 'a');
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetTypeInvalidParam() {
		u.setType('x');
	}

}
