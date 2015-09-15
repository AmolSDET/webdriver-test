package Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import PageObjects.FareFinder;
import PageObjects.ResultsPage;
import PageObjects.Utils;

public class HotelResultsTest {
	
public static WebDriver driver;
	
	@BeforeClass
	public static void invokeDriver() {
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile fp = p.getProfile("automation");
		driver = new FirefoxDriver(fp);
	}
	
	@Test
	public void testResults() {
		new Utils(driver).getApplication();
		new FareFinder(driver).searchHotel("sfo", "10/15/15", "10/16/15");
		System.out.println("Number of opaque results found:- " + new ResultsPage(driver).opaqueResultList().size());
	}
	
	@AfterClass
	public static void destroy() {
		driver.quit();
	}

}
