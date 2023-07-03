import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class TestBase {
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Code to set up any necessary preconditions before each test method
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        // Code to set up any necessary preconditions before each test method
        if (driver != null) {
            driver.quit();
        }
    }


    @DataProvider(name = "restoreEmailCredentials")
    public Object[][] returnRestoreEmailCredentials() {
        String[][] restoreEmailCredentials = {{"fewivo3646@extemer.com", "JisCtHQ3gs7", "Test", "Tester"},
                // {"someEmail@site.com", "invalidPassword", "firstName", "lastName"}
        };

        return restoreEmailCredentials;
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] returnLoginCredentials() {
        String[][] loginCredentials = {{"fewivo3647@extemer.com", "CssAh52W9qV", "Test", "Tester"},
                // {"someEmail@site.com", "invalidPassword", "firstName", "lastName"}
        };

        return loginCredentials;
    }

    @DataProvider(name = "loginFormLinks")
    public Object[] returnLoginFormLinks() {
        String[] loginFormLinks = {"https://litecart.stqa.ru/en/", "https://litecart.stqa.ru/en/login"};

        return loginFormLinks;
    }
}