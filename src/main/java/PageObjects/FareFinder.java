package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utilities.Utils;

public class FareFinder {

	WebDriver driver;
	private static Logger LOG = LoggerFactory.getLogger(FareFinder.class);

	public FareFinder(WebDriver driver) {
		this.driver = driver;
	}

	public void searchHotel(String dest, String startDate, String endDate) {
	    driver.findElement(By.name("destCity")).clear();
		driver.findElement(By.name("destCity")).sendKeys(dest);
        driver.findElement(By.id("startDateCalendarHotel-field")).clear();
		driver.findElement(By.id("startDateCalendarHotel-field")).sendKeys(startDate);
        driver.findElement(By.id("endDateCalendarHotel-field")).clear();
		driver.findElement(By.id("endDateCalendarHotel-field")).sendKeys(endDate);
		driver.findElement(By.id("findHotelButton")).click();
		LOG.info("Searching with following params:- " + dest + ", " + startDate + ", " + endDate);
		new Utils(driver).waitForElementVisible(".//*[@id='hotelResultsUpdatingLayer']/div/div/div[2]/img", 10, false);
	}

}
