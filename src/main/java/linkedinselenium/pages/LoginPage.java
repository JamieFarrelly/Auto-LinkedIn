package linkedinselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    
    @FindBy(id="session_key-login")
    private WebElement emailAddressInput;
    
    @FindBy(id="session_password-login")
    private WebElement passwordInput;
    
    @FindBy(id="btn-primary")
    private WebElement submitButton;
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterEmailAddress(String emailAddress) {
        this.emailAddressInput.clear();
        this.emailAddressInput.sendKeys(emailAddress);
    }
    
    public void enterPassword(String password) {
        this.passwordInput.clear();
        this.passwordInput.sendKeys(password);
    }
    
    public HomePage submit() {
        submitButton.click();
        return new HomePage(driver);
    }
}