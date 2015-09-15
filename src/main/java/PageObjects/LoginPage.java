package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object For Login Page
 *
 */
public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getLoginPage() {
		Utils ut = new Utils(driver);
		driver.findElement(By.cssSelector(".headerSignIn .signInModule .currentStatusBlock .helloContainer .signup")).click();
		new WebDriverWait(driver, 10).until(ut.elementVisibleTest(driver.findElement(By.id("userActions")), true));
		driver.findElement(By.xpath(".//*[@id='headerSignIn']")).click();
	}

	public void login(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath(".//div[@class='logInModule grayOuterBox']/form/div[3]/div[2]/button")).click();
	}

	public void logout() {
		Utils ut = new Utils(driver);
		driver.findElement(By.cssSelector(".headerSignIn .signInModule .currentStatusBlock .helloContainer .hello")).click();
		new WebDriverWait(driver, 10).until(ut.elementVisibleTest(driver.findElement(By.id("userActions")), true));
		driver.findElement(By.xpath(".//*[@id='userActions']/div[3]/a")).click();
	}

}
