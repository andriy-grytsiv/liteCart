package pageObjects;

import org.openqa.selenium.By;
import utils.Locators;

import static utils.WebDriverContainer.getDriver;

public class NavigationMenu extends PageBase{
    private static By homeIcon = Locators.getLocator("NavigationMenu.homeIcon");
    private static By categoryRubberDucks = Locators.getLocator("NavigationMenu.categoryRubberDucks");
    private static By subcategorySubcategory = Locators.getLocator("NavigationMenu.subcategorySubcategory");
    private static By cart = Locators.getLocator("NavigationMenu.cart");
    private static By cartQuantity = Locators.getLocator("NavigationMenu.cartQuantity");

    public static boolean isHomeIconVisible() {
        return getDriver().findElement(homeIcon).isDisplayed();
    }

    public static void clickHomeIcon() {
        getDriver().findElement(homeIcon).click();
    }

    public static boolean isCategoryRubberDucks() {
        return getDriver().findElement(categoryRubberDucks).isDisplayed();
    }

    public static void clickCategoryRubberDucks() {
        getDriver().findElement(categoryRubberDucks).click();
    }

    public static boolean isSubcategorySubcategoryDucks() {
        return getDriver().findElement(subcategorySubcategory).isDisplayed();
    }

    public static void clickSubcategorySubcategory() {
        getDriver().findElement(subcategorySubcategory).click();
    }

    public static void clickCart() {
        getDriver().findElement(cart).click();
    }

    public static String getCartQuantity() {
        return getDriver().findElement(cartQuantity).getText();
    }

    public static By getCartQuantityLocator() {
        return cartQuantity;
    }
}
