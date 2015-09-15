package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	WebDriver driver;
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getApplication() {
		driver.get(System.getProperty("applicationUrl"));
	}
	
	public void waitUntilElementLoads(WebElement element, long timeInSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementNoPresent(String xpath, long timeInSecs) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

}
