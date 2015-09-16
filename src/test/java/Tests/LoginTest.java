package Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.LoginPage;
import Utilities.Utils;

/**
 * Unit test for simple App.
 */
public class LoginTest {

	public static WebDriver driver;

	@BeforeClass
	public static void invokeDriver() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testLogin() {
		new Utils(driver).getApplication();
		LoginPage lp = new LoginPage(driver);
		lp.getLoginPage();
		lp.login("xyz123@gmail.com", "xyz111");
		lp.logout();
	}

	@AfterClass
	public static void destroy() {
		driver.quit();
	}

}
