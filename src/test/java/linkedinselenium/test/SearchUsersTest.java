package linkedinselenium.test;
import org.junit.Test;

import linkedinselenium.Constants;
import linkedinselenium.pages.HomePage;
import linkedinselenium.pages.LoginPage;
import linkedinselenium.pages.SearchResultsPage;

public class SearchUsersTest extends BaseTest {

    @Test
    public void searchUsers() {
        driver.get(Constants.LOGIN_URL);
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.enterEmailAddress("contact@gmail.com");
        loginPage.enterPassword("notmypassword");
        
        HomePage homePage = loginPage.clickLoginButton();
        homePage.enterSearchTerm("google recruiter");
        
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        searchResultsPage.clickAllUsersProfiles();
    }
}