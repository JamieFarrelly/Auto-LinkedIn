package linkedinselenium.test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import linkedinselenium.Constants;

public class BaseTest {
    
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }
    
    @AfterClass
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}