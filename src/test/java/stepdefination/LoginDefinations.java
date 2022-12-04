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

public class LoginDefinations {
	WebDriver driver;
	
	@Given("I am on the homepage")
	public void goToHomePage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.marketwatch.com/");
		WebElement overlayCloseButton = driver.findElement(By.className("close-btn"));
		overlayCloseButton.click();
	}
	
	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() {
	    WebElement profileIcon = driver.findElement(By.cssSelector(".logged-out.profile"));
	    profileIcon.click();
	    WebElement loginLink = driver.findElement(By.linkText("Log In"));
	    loginLink.click();
	}
	
	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
	    WebElement username = driver.findElement(By.id("username"));
	    username.sendKeys("mytalentech@gmail.com");
	    WebElement continueButton = driver.findElement(By.cssSelector(".continue-submit.new-design.solid-button"));
	    continueButton.click();
	    WebElement password = driver.findElement(By.id("password-login-password"));
	    password.sendKeys("tatenttech123");
	    WebElement signInButton = driver.findElement(By.cssSelector(".basic-login-submit.new-design.solid-button"));
	    signInButton.click();
	}
	
	@Then("I should be logged in")
	public void i_should_be_logged_in() {
		WebElement profileIcon = driver.findElement(By.cssSelector("label[title='Toggle account settings menu']"));
		profileIcon.click();
		WebElement username = driver.findElement(By.cssSelector(".profile--name"));
		Assert.assertEquals(username.getText(), "TALENT TECH");
	}
	
}
