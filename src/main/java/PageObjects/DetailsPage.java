package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.Utils;


public class DetailsPage {

    WebDriver driver;

    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean ValidateHotelDetails(String neighborhood, String rating) {
    	new Utils(driver).waitForElementVisible(".//div[@class='hotelPriceModule details']/a", 10, true);
    	String neighborhoodName = driver.findElement(By.cssSelector("div.neighborhoodName")).getText().toLowerCase();
        String stars = driver.findElement(By.cssSelector("span.starsAmount")).getAttribute("title");
        if(neighborhoodName.contains(neighborhood.toLowerCase()) && stars.contains(rating + " out of 5.0")) {
            return true;
        }
        return false;
    }

}
