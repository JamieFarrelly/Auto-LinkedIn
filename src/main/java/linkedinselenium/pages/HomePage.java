package linkedinselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    
    @FindBy(id="main-search-box")
    private WebElement searchInput;
    
    @FindBy(className="search-button") // doesn't have an ID
    private WebElement searchButton; 

    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void enterSearchTerm(String searchTerm) {
        this.searchInput.clear();
        this.searchInput.sendKeys(searchTerm);
    }
    
    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}