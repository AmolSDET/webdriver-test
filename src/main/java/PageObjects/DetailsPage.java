/*
 * Copyright 2013 Hotwire. All Rights Reserved.
 *
 * This software is the proprietary information of Hotwire.
 * Use is subject to license terms.
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author adeshmukh
 *
 */
public class DetailsPage {

    WebDriver driver;

    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean ValidateHotelDetails(String neighborhood, String rating) {
        new WebDriverWait(driver, 10).until(new Utils(driver).elementVisibleTest(driver.findElement(By.cssSelector("a.bookNotBtn")), true));
        String neighborhoodName = driver.findElement(By.cssSelector("div.neighborhoodName")).getText().toLowerCase();
        String stars = driver.findElement(By.cssSelector("span.starsAmount")).getAttribute("title");
        if(neighborhoodName.contains(neighborhood.toLowerCase()) && stars.contains(rating + " out of 5.0")) {
            return true;
        }
        return false;
    }

}
