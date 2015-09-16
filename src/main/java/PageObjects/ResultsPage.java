package PageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultsPage {

	WebDriver driver;
	private static Logger LOG = LoggerFactory.getLogger(ResultsPage.class);

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	private List<WebElement> opaqueResultList() {
		List<WebElement> results = driver.findElements(By.cssSelector("#opaque-hotel-results .results .opaque .singleResult.opaque"));
		return results;
	}
	
	public boolean validateOpaqueResults() {
		if(driver.findElements(By.cssSelector("#opaque-hotel-results .results .opaque .singleResult.opaque")).size() > 10) {
			return true;
		}
		return false;
	}

	public void selectPgood(String neighborhood, String starRating) {
	    List<WebElement> elements = opaqueResultList();
	    boolean pgoodFound = false;
	    for (WebElement element : elements) {
	        String neighborhoodName = element.findElement(By.cssSelector("span#hotelOrHoodName")).getText();
	        //compare neighborhood
	        if (neighborhoodName.toLowerCase().contains(neighborhood.toLowerCase())) {
	            String stars = element.findElement(By.cssSelector("span.starsAmount")).getAttribute("title");
	            LOG.info(neighborhoodName + "---" + stars);
	            //compare starRating
	            if (stars.contains(starRating + " out of 5.0")) {
	                LOG.info("Pgood Found");
	                pgoodFound = true;
	                LOG.info("Price of this pgood:- " + element.findElement(By.cssSelector("div.price")).getText());
	                element.findElement(By.cssSelector("a.detailsLink")).click();
	                break;
	            }
	        }
	    }
	    if(!pgoodFound) {
	        throw new NoSuchElementException();
	    }
	}

}
