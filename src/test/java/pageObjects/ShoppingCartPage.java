package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.util.List;

import static utils.WebDriverContainer.getDriver;

public class ShoppingCartPage extends PageBase{
    private static By productItemsWrapper = Locators.getLocator("ShoppingCart.itemsWrapper");
    private static By productItem = Locators.getLocator("ShoppingCart.productItem");
    private static By productName = Locators.getLocator("ShoppingCart.productName");

    public static List<WebElement> getProductItems() { return getDriver().findElement(productItemsWrapper).findElements(productItem); }

    public static String getProductNameInItem(WebElement element) {
        return element.findElement(productName).getText();
    }

    public static boolean isProductDisplayed() {
        return getDriver().findElement(productItemsWrapper).findElement(productItem).isDisplayed();
    }



}
