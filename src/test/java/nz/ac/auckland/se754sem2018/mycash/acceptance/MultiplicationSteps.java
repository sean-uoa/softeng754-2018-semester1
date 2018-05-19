package nz.ac.auckland.se754sem2018.mycash.acceptance;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import nz.ac.auckland.se754sem2018.mycash.Dollar;

public class MultiplicationSteps {
	
	Dollar five;
	Dollar ten;
	
	@Given("User has $amount dollars")
	public void givenUserHas5Dollars(int amount) {
		five = new Dollar(amount);
	}

	@When("User multiply it by $multiplier")
	public void whenUserMultiplyItBy2(int multiplier) throws InterruptedException{
		ten = five.times(multiplier);
	}

	@Then("The resultant amount is $result")
	public void thenTheResultantAmountIs10(int result) {
		assertEquals(new Dollar(result), ten);
	}
}
