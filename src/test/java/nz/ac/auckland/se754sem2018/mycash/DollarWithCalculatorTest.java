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

	@Test
	public void shouldCallICalculatorMultiplyMethodOnceWhenInvokingTimesWithCalculator() {
		// Given
		Mockito.doReturn(10).when(calculator).multiply(5, 2);
		
		// When
		five.timesWithCalculator(2);
		
		// Then
		Mockito.verify(calculator, Mockito.times(1)).multiply(5, 2);
	}
	
	@Test(expected = NegativeNumberException.class)
	public void shouldThrowExeptionWhenDividedByNegativeNumber() {
		
		// Given
		Mockito.doReturn(-10).when(calculator).multiply(5, -2);
		
		// When
		five.timesWithCalculator(-2);
	}
	
	@Test
	public void shouldReturnTwoWhenFiveDollarIsDividedByTwo() {
		
		// Given
		Mockito.doReturn(2).when(calculator).divide(5, 2);
		
		// When
		Dollar result = five.dividesWithCalculator(2);
		
		// Then
		assertEquals(new Dollar(2), result);
	}
	
	@Test(expected = ArithmeticException.class)
	public void shouldThrowExceptionWhenDividedByZero() {
		
		// Given
		Mockito.doThrow(new ArithmeticException("Divided by 0")).when(calculator).divide(5, 0);
		
		// When
		five.dividesWithCalculator(0);
	}
}
