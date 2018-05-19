package nz.ac.auckland.se754sem2018.mycash;

public interface ICalculator {

	public int add(int augend, int addend);
	
	public int subtract(int minuend, int subtrahend);
	
	public int multiply(int multiplicand, int multiplier);
	
	public int divide(int dividend, int divisor);
}
