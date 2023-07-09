package pageObjects;

import static utils.WebDriverContainer.*;

public class PageBase {
    public static boolean pageTitleMatchesExpected(String expectedTitle) {
        return getDriver().getTitle().equals(expectedTitle);
    }
}
