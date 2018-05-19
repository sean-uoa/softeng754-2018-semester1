package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class DollarMockitoExampleTest {

	@Test
	public void shouldReturnEmptyValueWhenInvokeAUnmodifiedMethodOfAMockObject() {
		
		// Given
		Dollar mockedFive = Mockito.mock(Dollar.class);
		
		// When
		Dollar result = mockedFive.times(2);
		
		// Then
		assertNull(result);
	}
	
	@Test
	public void shouldBehaveTheSameWhenInvokeAUnmodifiedMethodOfASpyObject() {
		// Given
		Dollar spiedFive = Mockito.spy(new Dollar(5));
		
		// When
		Dollar result = spiedFive.times(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}
	
	@Test
	public void shouldBehaveAsSpecifiedWhenAMethodHasBeenModifiedWithSyntax1() {
		// Given
		Dollar mockedFive = Mockito.mock(Dollar.class);
		Mockito.doReturn(new Dollar(10)).when(mockedFive).times(2);
		
		// When
		Dollar result = mockedFive.times(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}
	
	@Test
	public void shouldBehaveAsSpecifiedWhenAMethodHasBeenModifiedWithSyntax2() {
		// Given
		Dollar mockedFive = Mockito.mock(Dollar.class);
		Mockito.when(mockedFive.times(2)).thenReturn(new Dollar(10));
		
		// When
		Dollar result = mockedFive.times(2);
		
		// Then
		assertEquals(new Dollar(10), result);
	}
	
	@Test(expected = Exception.class)
	public void shouldCaptureTheExceptionWhenAMethodConfiguredToThrowIt() {
		// Given
		Dollar mockedFive = Mockito.mock(Dollar.class);
		Mockito.doThrow(new Exception("blabla...")).when(mockedFive).times(2);
		
		// When
		mockedFive.times(2);
	}
	
	@Test
	public void shouldBeExecutedOnceWhenInvokeAMethodOfAMockObject() {
		// Given
		Dollar mockedFive = Mockito.mock(Dollar.class);
		
		// When
		mockedFive.times(2);
		
		// Then
		Mockito.verify(mockedFive, Mockito.times(1)).times(2);
	}

}
