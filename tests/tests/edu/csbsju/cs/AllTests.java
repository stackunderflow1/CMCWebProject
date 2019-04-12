package edu.csbsju.cs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataBaseControllerTests.class, LogOnControllerTest.class, SavedSchoolsTest.class,
		TestAdminFunctionalityController.class, TestStudentFunctionalityController.class, TestUniversityContoller.class,
		UniversityTest.class, UsersTest.class })
public class AllTests {

}
