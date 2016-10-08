package linkedinselenium.test;
import org.junit.Test;

import linkedinselenium.Constants;
import linkedinselenium.pages.LoginPage;

public class SearchUsersTest extends BaseTest {

    @Test
    public void searchUsers() {
        driver.get(Constants.LOGIN_URL);
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.enterEmailAddress("contact@gmail.com");
        loginPage.enterPassword("notmypassword");
        loginPage.submit();
    }
    
}
