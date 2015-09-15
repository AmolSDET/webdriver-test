package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		ut.waitUntilElementLoads(driver.findElement(By.id("userActions")), 10);
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
		ut.waitUntilElementLoads(driver.findElement(By.id("userActions")), 10);
		driver.findElement(By.xpath(".//*[@id='userActions']/div[3]/a")).click();
	}

}
