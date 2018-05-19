package nz.ac.auckland.se754sem2018.mycash;

public class Dollar implements Cloneable{
	
	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}
	
	public Dollar times(int multiplier) {
		int resultantAmount = this.amount*multiplier;
		return new Dollar(resultantAmount);
	}
	
	public Dollar dividedBy(int denominator) throws NegativeNumberException{
		if (denominator < 0) {
			throw new NegativeNumberException();
		}
		int resultantAmount = this.amount/denominator;
		return new Dollar(resultantAmount);
	}
	
	@Override
	public String toString() {
		return "$"+this.amount;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Dollar && this.amount == ((Dollar) other).amount) {
			return true;
		}
		return false;
	}
}
