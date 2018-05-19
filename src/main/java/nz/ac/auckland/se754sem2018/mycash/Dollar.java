package nz.ac.auckland.se754sem2018.mycash;

public class Dollar implements Cloneable{
	
	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}
	
	public Dollar times(int multiplier) {
		this.amount  *= multiplier;
		Dollar result = null;
		try {
			result = (Dollar)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Dollar dividedBy(int denominator) throws NegativeNumberException{
		if (denominator < 0) {
			throw new NegativeNumberException();
		}
		amount /= denominator;
		Dollar result = null;
		try {
			result = (Dollar)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return result;
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
