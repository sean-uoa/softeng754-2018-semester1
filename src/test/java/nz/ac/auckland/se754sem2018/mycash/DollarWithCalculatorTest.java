package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DollarWithCalculatorTest {
	
	Dollar five;
	ICalculator calculator;
	
	@Before
	public void setUp() {
		//Given
		five = new Dollar(5);
		calculator = Mockito.mock(ICalculator.class);
		five.setCalculator(calculator);
	}
	
	@Test
	public void shouldHaveNoNullCalculatorWhenSetCalculatorSuccessfully() {
		
		// Then
		assertFalse(five.isCalculatorNull());
	}
	
	@Test
	public void shouldReturnTenWhenFiveDollarIsMultipliedByTwo() {
		
		// Given
		Mockito.doReturn(10).when(calculator).multiply(5, 2);
		
		// When
		Dollar result  = five.timesWithCalculator(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}

}
