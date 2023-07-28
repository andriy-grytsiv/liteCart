package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static utils.Browser.CHROME;

public class WebDriverContainer {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            driver = initDriver();
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    private static WebDriver initDriver() {
        Browser browserName = Browser.getEnumByLabel(System.getProperty("browser", CHROME.getBrowserName()));

        WebDriver driver = switch (browserName) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case SAFARI -> new SafariDriver();
        };
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver(){
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
