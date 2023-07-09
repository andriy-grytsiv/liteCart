package pageObjects;

import org.openqa.selenium.By;
import utils.Locators;

import static utils.WebDriverContainer.*;

public class ProductPage extends PageBase{
    private static By addToCartButton = Locators.getLocator("ProductPage.addToCartButton");

    public static boolean isAddToCartButtonDisplayed() {
        return getDriver().findElement(addToCartButton).isDisplayed();
    }

    public static void clickAddToCartButton() {
        getDriver().findElement(addToCartButton).click();
    }
}
