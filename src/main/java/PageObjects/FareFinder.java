package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		new WebDriverWait(driver, 10).until(new Utils(driver).elementVisibleTest(driver.findElement(By.xpath(".//*[@id='hotelResultsUpdatingLayer']/div/div/div[2]/img")), false));
	}

}
