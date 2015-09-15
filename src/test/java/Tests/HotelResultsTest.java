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
import PageObjects.Utils;

public class HotelResultsTest {

public static WebDriver driver;
private static Logger LOG = LoggerFactory.getLogger(HotelResultsTest.class);

	@BeforeClass
	public static void invokeDriver() {
		//ProfilesIni p = new ProfilesIni();
		//FirefoxProfile fp = p.getProfile("automation");
		driver = new FirefoxDriver();
	}

	@Test
	public void testResults() {
		new Utils(driver).getApplication();
		new FareFinder(driver).searchHotel("sfo", "10/15/15", "10/16/15");
		LOG.info("Number of opaque results found:- " + new ResultsPage(driver).opaqueResultList().size());
	}

	@Test
    public void selectPgood() {
        new Utils(driver).getApplication();
        new FareFinder(driver).searchHotel("sfo", "10/15/15", "10/16/15");
        new ResultsPage(driver).selectPgood("S. SFO Intl Airport - Burlingame area hotel", "4");
        Assert.assertTrue("Invalid details on details page", new DetailsPage(driver).
                ValidateHotelDetails("S. SFO Intl Airport - Burlingame area hotel", "4"));
    }

	@AfterClass
	public static void destroy() {
		driver.quit();
	}

}
