package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserHelper;

public class HomePage {
	WebDriver driver;

	@FindBy(css = ".logged-out.profile")
	public WebElement profileIcon;

	@FindBy(linkText = "Log In")
	public WebElement loginLink;

	public HomePage() {
		driver = BrowserHelper.driver;
		PageFactory.initElements(driver, this);
	}

	public void loadPage() {
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		if (currentURL != "https://www.marketwatch.com/") {
			driver.get("https://www.marketwatch.com/");
		}
	}
}
