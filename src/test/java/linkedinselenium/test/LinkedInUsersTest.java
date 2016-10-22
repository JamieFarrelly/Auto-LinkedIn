package linkedinselenium.test;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import linkedinselenium.Constants;
import linkedinselenium.pages.HomePage;
import linkedinselenium.pages.LoginPage;
import linkedinselenium.pages.SearchPage;
import linkedinselenium.pages.SearchResultsPage;

public class LinkedInUsersTest extends BaseTest {
    
    List<String> searchTerms = Arrays.asList("Google recruiter", "Facebook recruiter");

    /*
     * Logs in to LinkedIn
     * Goes to the search page
     * Enters in the first search term
     * Clicks on every profile that comes back in the search results
     * 
     * Enters in the second search term
     * Clicks on every profile that comes back in the search results etc.
     */
    @Test
    public void viewUserProfilesTest() {
        driver.get(Constants.LOGIN_URL);
        
        LoginPage loginPage = new LoginPage(driver);
        
        loginPage.enterEmailAddress("contact@gmail.com");
        loginPage.enterPassword("notmypassword");
        
        HomePage homePage = loginPage.clickLoginButton();
        SearchPage searchPage = homePage.clickSearchButton(); // one time only from the home page
        
        for (String searchTerm : searchTerms) {
            searchPage.enterSearchTerm(searchTerm);
            SearchResultsPage searchResultsPage = searchPage.clickSearchButton();
            searchResultsPage.clickAllUsersProfiles();
            
            // back to the search results page so we can start again and enter the next search term if there is one
            // does this in the very first tab but that's fine
            searchResultsPage.clickSearchButton();
        }
    }
}