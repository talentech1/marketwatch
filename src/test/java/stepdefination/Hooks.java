package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utils.BrowserHelper;

public class Hooks {
	@BeforeAll
	public static void before_all() {
		BrowserHelper.setupDriver();
		BrowserHelper.driver.get("https://www.marketwatch.com/");
		try {
			WebElement overlayCloseButton = BrowserHelper.driver.findElement(By.className("close-btn"));
			overlayCloseButton.click();
		} catch (Exception e) {

		}

	}

	@AfterAll
	public static void after_all() {
		BrowserHelper.driver.close();
	}
	
	@After("@iframe")
	public void switoToDefaultContent() {
		BrowserHelper.driver.switchTo().defaultContent();
	}
}
