package nz.ac.auckland.se754sem2018.mycash;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.codeborne.selenide.Configuration;

public class MultiplicationWithUISteps {
	
	@BeforeStory
	public void beforeStory() {
		Configuration.browser = "Firefox";
        Configuration.baseUrl="http://localhost";
	}
	
	@Given("User has $amount dollars")
	public void givenUserHas5Dollars(int amount) {
		open("/");
		$("#t1").setValue(String.valueOf(amount));
	}

	@When("User multiply it by $multiplier")
	public void whenUserMultiplyItBy2(int multiplier) throws InterruptedException{
	    $("#t2").setValue(String.valueOf(multiplier));
	    $("#times").click();
	    Thread.sleep(3000);
	}

	@Then("The resultant amount is $result")
	public void thenTheResultantAmountIs10(int result) {
	    assertEquals(String.valueOf(result), $("#result").getValue());
	}
}
