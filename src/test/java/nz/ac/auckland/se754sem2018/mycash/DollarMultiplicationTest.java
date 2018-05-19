package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;

public class DollarMultiplicationTest {

	@Test
	public void testMuliplication() {
		// Preconditions
		Dollar five = new Dollar(5);
		
		// Actions
		Dollar result = five.times(2);
		
		// Postconditions
		assertEquals(new Dollar(10), result);
	}
	
	@Test
	public void shouldReturnTenDollarWhenFiveDollarMultipliedByTwo() {
		// Given
		Dollar five = new Dollar(5);
		
		// When
		Dollar result = five.times(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}
	
	@Test 
	public void shouldNotBeAffectedWhenPerformingMultiplication() {
		// Given
		Dollar five = new Dollar(5);
		
		// When
		five.times(2);
		
		// Then
		assertEquals(new Dollar(5), five);
	}

}
