package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	
	WebDriver driver;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> opaqueResultList() {
		List<WebElement> results = driver.findElements(By.cssSelector("#opaque-hotel-results .results .opaque .singleResult.opaque"));
		return results;
	}

}
