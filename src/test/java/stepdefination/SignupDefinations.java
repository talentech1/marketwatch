package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserHelper;

public class SignupDefinations {
	@Given("I am on the signup page")
	public void i_am_on_the_signup_page() {
		BrowserHelper.driver.get("https://www.marketwatch.com/sign-up");
	}

	@When("I enter my {string}")
	public void i_enter_my_a_bc_gmail_com(String email) {
		WebElement iframe = BrowserHelper.driver.findElement(By.xpath("//iframe[@class=\"iframe\"]"));
		BrowserHelper.driver.switchTo().frame(iframe);
		WebElement emailInput = BrowserHelper.driver.findElement(By.id("email"));
		emailInput.sendKeys(email);
	}

	@When("click create an account")
	public void click_create_an_account() throws InterruptedException {
		Thread.sleep(2000);
		WebElement createButton = BrowserHelper.driver.findElement(By.xpath("//*[@class=\"button-mw-newreg\"]/button"));
		createButton.click();
	}

	@Then("I should see an error")
	public void i_should_see_an_error() {
		WebElement errorMessage = BrowserHelper.driver.findElement(By.xpath("//label[@class=\"error\"]"));
		Assert.assertEquals(errorMessage.getText(), "Please enter a valid email address.");
	}
	
	@Then("I should be on the signup page")
	public void i_should_be_on_signuppage() {
		Assert.assertEquals(BrowserHelper.driver.getTitle(), "Welcome - Learn About Member Benefits - MarketWatch - MarketWatch");
	}
}
