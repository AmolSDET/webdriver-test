package PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;

public class Utils {

	WebDriver driver;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public void getApplication() {
		driver.get(System.getProperty("applicationUrl"));
	}

	public Function<WebDriver, Boolean> elementVisibleTest(final WebElement element, final Boolean visible) {
	    return new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            Boolean status;
	            try {
	                status = element.isDisplayed() == visible;
	            }
	            catch (NoSuchElementException e ){
	                status = !visible;
	            }
	            return status;
	        }
        };
	}

}
