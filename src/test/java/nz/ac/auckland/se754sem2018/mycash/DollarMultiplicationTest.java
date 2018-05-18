package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarMultiplicationTest {

	@Test
	public void testMuliplication() {
		// Preconditions
		Dollar five = new Dollar(5);
		
		// Actions
		five.times(2);
		
		// Postconditions
		assertEquals(new Dollar(10), five);
	}

}
