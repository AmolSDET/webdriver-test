package Tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import PageObjects.LoginPage;
import PageObjects.Utils;

/**
 * Unit test for simple App.
 */
public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void invokeDriver() {
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile fp = p.getProfile("automation");
		driver = new FirefoxDriver(fp);
	}
	
	@Test
	public void testLogin() {
		new Utils(driver).getApplication();
		LoginPage lp = new LoginPage(driver);
		lp.getLoginPage();
		lp.login("xyz@gmail.com", "xyz123");
		lp.logout();
	}
	
	@AfterClass
	public static void destroy() {
		driver.quit();
	}

}
