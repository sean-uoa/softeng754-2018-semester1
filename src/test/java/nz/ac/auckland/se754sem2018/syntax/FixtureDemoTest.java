package nz.ac.auckland.se754sem2018.syntax;

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
	
	@Test public void testMethod1() {
		System.out.println("In testMethod1");
	}
	
	@Test public void testMethod2() {
		System.out.println("In testMethod2");
	}
	
}
