package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FareFinder {
	
	WebDriver driver;
	
	public FareFinder(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchHotel(String dest, String startDate, String endDate) {
		driver.findElement(By.name("destCity")).sendKeys(dest);
		driver.findElement(By.id("startDateCalendarHotel-field")).sendKeys(startDate);
		driver.findElement(By.id("endDateCalendarHotel-field")).sendKeys(endDate);
		driver.findElement(By.id("findHotelButton")).click();
		new Utils(driver).waitUntilElementNoPresent(".//*[@id='hotelResultsUpdatingLayer']/div/div/div[2]/img", 10);
	}

}
