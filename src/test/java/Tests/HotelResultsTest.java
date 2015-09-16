package Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PageObjects.DetailsPage;
import PageObjects.FareFinder;
import PageObjects.ResultsPage;
import Utilities.Utils;

public class HotelResultsTest {

public static WebDriver driver;
private static Logger LOG = LoggerFactory.getLogger(HotelResultsTest.class);

	@BeforeClass
	public static void invokeDriver() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testResults() {
		LOG.info("validating number of opaque results");
		new Utils(driver).getApplication();
		new FareFinder(driver).searchHotel("sfo", "10/15/15", "10/16/15");
		Assert.assertTrue("Number of opaque results is less than expected", new ResultsPage(driver).validateOpaqueResults());
	}

	@Test
    public void selectPgood() {
        new Utils(driver).getApplication();
        new FareFinder(driver).searchHotel("sfo", "10/15/15", "10/16/15");
        new ResultsPage(driver).selectPgood("S. SFO Intl Airport - Burlingame area hotel", "4");
        Assert.assertTrue("Invalid details on details page", new DetailsPage(driver).
                ValidateHotelDetails("S. SFO Intl Airport - Burlingame area", "4"));
    }

	@AfterClass
	public static void destroy() {
		driver.quit();
	}

}
