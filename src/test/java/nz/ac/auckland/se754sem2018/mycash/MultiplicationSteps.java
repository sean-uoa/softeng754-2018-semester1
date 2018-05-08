package nz.ac.auckland.se754sem2018.mycash;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.codeborne.selenide.Configuration;

public class MultiplicationSteps {
	
	Dollar five;
	
	@Given("User has $amount dollars")
	public void givenUserHas5Dollars(int amount) {
		five = new Dollar(amount);
	}

	@When("User multiply it by $multiplier")
	public void whenUserMultiplyItBy2(int multiplier) throws InterruptedException{
		five.times(multiplier);
	}

	@Then("The resultant amount is $result")
	public void thenTheResultantAmountIs10(int result) {
		assertEquals(result, five.amount);
	}
}
