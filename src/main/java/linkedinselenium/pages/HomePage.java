package linkedinselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    
    @FindBy(className="search-button") // doesn't have an ID
    private WebElement searchButton; 

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }
}