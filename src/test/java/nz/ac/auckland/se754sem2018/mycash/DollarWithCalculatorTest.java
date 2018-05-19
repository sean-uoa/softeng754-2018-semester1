package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class DollarWithCalculatorTest {
	
	@Test
	public void shouldHaveNoNullCalculatorWhenSetCalculatorSuccessfully() {
		
		//Given
		Dollar five = new Dollar(5);
		ICalculator calculator = Mockito.mock(ICalculator.class);
		
		// Given
		five.setCalculator(calculator);
		
		// Then
		assertFalse(five.isCalculatorNull());
	}
}
