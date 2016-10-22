package linkedinselenium.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageObject {
    
    @FindBy(css="#results > .people > .result-image") // LinkedIn shows more than just people in results, like ads etc - this filters them out
    List<WebElement> userImages;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Clicks on every persons LinkedIn profile and opens it as a new tab, to save having to go back to the previous page

     */
    public void clickAllUsersProfiles() {
        
        /*
         * http://stackoverflow.com/questions/6032230/selenium-2-open-link-in-new-tab-and-close-tabs
         * Chrome key combos:
         * SHIFT + CTRL + click = Open in new tab (and switch to new tab)
         * SHIFT + CTRL + RETURN = Open in new tab (in background)
         */
        Actions act = new Actions(driver);
        act.keyDown(Keys.LEFT_CONTROL).keyDown(Keys.LEFT_SHIFT).perform();
        for (WebElement userImage: userImages) {

            userImage.click();
        }
        
        act.keyUp(Keys.LEFT_CONTROL).keyDown(Keys.LEFT_SHIFT).perform(); // finished up, important to stop holding down those keys
    }
}