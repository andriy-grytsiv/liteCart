package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import static utils.WebDriverContainer.*;
import static utils.WebDriverContainer.getDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    private static String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void setUp() {
        // Code to set up any necessary preconditions before each test method
        getDriver();
        getDriver().get(baseUrl);
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        // Code to set up any necessary preconditions before each test method
        quitDriver();
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