package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utils {

	WebDriver driver;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public void getApplication() {
	    driver.manage().deleteAllCookies();
		driver.get(System.getProperty("applicationUrl"));
	}

	public void waitForElementVisible(String xpath, long timeToWait, boolean visible) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean status = false;
		if(visible && driver.findElements(By.xpath(xpath)).size() > 0) {
			status = true;
		}
		if(!visible && driver.findElements(By.xpath(xpath)).size() == 0) {
			status = true;
		}
		if(!status) {
			driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
		}		
	}

}
