package nz.ac.auckland.se754sem2018.mycash;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class DollarTestRunner {

	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(DollarMultiplicationTest.class, DollarDivisionTest.class);
		
		for(Failure failure: result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}

}
