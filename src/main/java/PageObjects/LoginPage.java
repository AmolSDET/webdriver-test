package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utilities.Utils;

/**
 * Page Object For Login Page
 *
 */
public class LoginPage {

	WebDriver driver;
	private static Logger LOG = LoggerFactory.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getLoginPage() {
		driver.findElement(By.cssSelector(".headerSignIn .signInModule .currentStatusBlock .helloContainer .signup")).click();
		new Utils(driver).waitForElementVisible(".//*[@id='userActions']", 10, true);
		driver.findElement(By.xpath(".//*[@id='headerSignIn']")).click();
	}

	public void login(String username, String password) {
	    LOG.info("Logging in with credentials:- " + username + "/" + password);
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath(".//div[@class='logInModule grayOuterBox']/form/div[3]/div[2]/button")).click();
	}

	public void logout() {
		driver.findElement(By.cssSelector(".headerSignIn .signInModule .currentStatusBlock .helloContainer .hello")).click();
		new Utils(driver).waitForElementVisible(".//*[@id='userActions']", 10, true);
		driver.findElement(By.xpath(".//*[@id='userActions']/div[3]/a")).click();
	}

}
