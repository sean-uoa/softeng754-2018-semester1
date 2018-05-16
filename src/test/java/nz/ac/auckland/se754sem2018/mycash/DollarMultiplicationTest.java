package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class DollarMultiplicationTest {
	
	@Test
	public void testMuliplication() {
		// Preconditions
		Dollar five = new Dollar(5);
		
		// Actions
		five.times(2);
		
		// Postconditions
		assertEquals(10, five.amount);
	}
	
//	@Ignore
//	@Test
//	public void testMockObjects() {
//		// Given
//		Dollar five = Mockito.mock(Dollar.class);
//		Mockito.when(five.times(2)).thenReturn(10);
//		
//		// When
//		five.times(2);
//		
//		// Then
//		assertEquals(10, five.amount);
//	}
//	
//	@Ignore
//	@Test
//	public void testSpyObjects() {
//		// Given
//		Dollar five = Mockito.spy(new Dollar(5));
//		Mockito.doReturn(10).when(five).times(2);
//		
//		// When
//		five.times(2);
//		
//		// Then
//		assertEquals(10, five.amount);
//	}
//	
//	@Ignore
//	@Test(expected=Exception.class)
//	public void testThrowException() {
//		// Given
//		Dollar five = Mockito.mock(Dollar.class);
//		Mockito.when(five.times(2)).thenThrow(new Exception("blabla"));
//		
//		// When
//		five.times(2);
//	}
//	
//	@Ignore
//	@Test
//	public void testVerifyStep() {
//		// Given
//		Dollar five = Mockito.mock(Dollar.class);
//		
//		// When
//		five.times(2);
//		
//		// Then
//		Mockito.verify(five, Mockito.times(1)).times(1);
//	}

}
