package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DollarCalculatorIntegrationTest {

	Dollar five;
	ICalculator calculator;
	
	@Before
	public void setUp() {
		
		// Given
		five = new Dollar(5);
		calculator = new WebServiceCalculator();
		five.setCalculator(calculator);
	}
	
	@Test
	public void shouldReturnTenWhenFiveDollarIsMultipliedByTwo() {
		
		// When
		Dollar result  = five.timesWithCalculator(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}
	
	@Test(expected = NegativeNumberException.class)
	public void shouldThrowExeptionWhenDividedByNegativeNumber() {
		
		// When
		five.timesWithCalculator(-2);
	}
	
	@Test
	public void shouldReturnTwoWhenFiveDollarIsDividedByTwo() {
		
		// When
		Dollar result = five.dividesWithCalculator(2);
		
		// Then
		assertEquals(new Dollar(2), result);
	}
	
	@Test(expected = ArithmeticException.class)
	public void shouldThrowExceptionWhenDividedByZero() {
		
		// When
		five.dividesWithCalculator(0);
	}

}
