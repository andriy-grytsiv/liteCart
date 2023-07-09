package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static utils.Browser.CHROME;

public class WebDriverContainer {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        Browser browserName = Browser.getEnumByLabel(System.getProperty("browser", CHROME.getBrowserName()));

        driver = switch (browserName) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
        };
        driver.manage().window().maximize();
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
