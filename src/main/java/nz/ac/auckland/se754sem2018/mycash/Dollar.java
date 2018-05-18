package nz.ac.auckland.se754sem2018.mycash;

public class Dollar {
	
	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}
	
	public Dollar times(int multiplier) {
		this.amount  *= multiplier;
		return this;
	}
	
	public void dividedBy(int denominator) throws NegativeNumberException{
		if (denominator < 0) {
			throw new NegativeNumberException();
		}
		amount /= denominator;
	}
	
	@Override
	public String toString() {
		return "$"+this.amount;
	}
}
