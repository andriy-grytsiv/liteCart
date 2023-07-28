package utils;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties locators;

    static {
        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println("Error reading from property file - " + e.getMessage());
        }
    }

    public static By getLocator(String locator) {
        String value = locators.getProperty(locator);

        String[] result = value.split("=", 2);
        LocatorTypes locatorType = LocatorTypes.valueOf(result[0]);
        String selector = result[1];

        By by = switch (locatorType) {
            case id -> By.id(selector);
            case css -> By.cssSelector(selector);
            case name -> By.name(selector);
            case xpath -> By.xpath(selector);
            case tagName -> By.tagName(selector);
            case linkText -> By.linkText(selector);
            case className -> By.className(selector);
        };

        return by;
    }
}
