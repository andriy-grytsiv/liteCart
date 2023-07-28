package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

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
        String browser = System.getProperty("browser");
        String platform = System.getProperty("platform");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(browser);
        caps.setPlatform(Platform.valueOf(platform));
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.213:4444/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

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
