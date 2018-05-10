package nz.ac.auckland.se754sem2018.mycash;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FixtureDemoTest {

	@BeforeClass public static void beforeClass() {
		System.out.println("In beforeClass");
	}
	
	@AfterClass public static void afterClass() {
		System.out.println("In afterClass");
	}
	
	@Before public void before() {
		System.out.println("In before");
	}
	
	@After public void after() {
		System.out.println("In after");
	}
	
	@Test public void testCase1() {
		System.out.println("In testCase1");
	}
	
	@Test public void testCase2() {
		System.out.println("In testCase2");
	}
	
}
