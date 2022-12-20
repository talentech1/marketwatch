package stepdefination;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.BrowserHelper;

public class LoginDefinations {
	
	@Given("I am on the homepage")
	public void goToHomePage() {
		HomePage homepage = new HomePage();
		homepage.loadPage();
	}
	
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
		HomePage homepage = new HomePage();
		homepage.profileIcon.click();
	    homepage.loginLink.click();
	}
	
	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
	    WebElement username = BrowserHelper.driver.findElement(By.id("username"));
	    username.sendKeys("mytalentech@gmail.com");
	    WebElement continueButton = BrowserHelper.driver.findElement(By.cssSelector(".continue-submit.new-design.solid-button"));
	    continueButton.click();
	    WebElement password = BrowserHelper.driver.findElement(By.id("password-login-password"));
	    password.sendKeys("tatenttech123");
	    WebElement signInButton = BrowserHelper.driver.findElement(By.cssSelector(".basic-login-submit.new-design.solid-button"));
	    signInButton.click();
	}
	
	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		WebElement profileIcon = BrowserHelper.driver.findElement(By.cssSelector("label[title='Toggle account settings menu']"));
		profileIcon.click();
		WebElement username = BrowserHelper.driver.findElement(By.cssSelector(".profile--name"));
		Assert.assertEquals(username.getText(), "TALENT TECH");
	}
	
}
