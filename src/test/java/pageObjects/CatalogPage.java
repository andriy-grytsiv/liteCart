package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Locators;

import java.util.List;

import static utils.WebDriverContainer.*;

public class CatalogPage extends PageBase {
    private static By searchField = Locators.getLocator("CatalogPage.searchField");
    private static By searchResultsText = Locators.getLocator("CatalogPage.searchResultsText");
    private static By subcategoryLinkCarousel = Locators.getLocator("CatalogPage.subcategoryLinkCarousel");
    private static By subcategoryLinkNavigationTree = Locators.getLocator("CatalogPage.subcategoryLinkNavigationTree");
    private static By manufacturerAcmeLink = Locators.getLocator("CatalogPage.manufacturerAcmeLink");
    private static By manufacturerNavigationTitle = Locators.getLocator("CatalogPage.manufacturerNavigationTitle");
    private static By sortingName = Locators.getLocator("CatalogPage.sortingName");
    private static By sortingPrice = Locators.getLocator("CatalogPage.sortingPrice");
    private static By sortingPopularity = Locators.getLocator("CatalogPage.sortingPopularity");
    private static By sortingDate = Locators.getLocator("CatalogPage.sortingDate");
    private static By productTilesWrapper = Locators.getLocator("CatalogPage.productTilesWrapper");
    private static By productTile = Locators.getLocator("CatalogPage.productTile");
    private static By productNameOnTile = Locators.getLocator("CatalogPage.productNameOnTile");

    public static boolean isSearchFieldDisplayed() {
        return getDriver().findElement(searchField).isDisplayed();
    }

    public static void enterSearchTerm(String searchTerm) {
        getDriver().findElement(searchField).sendKeys(searchTerm);
    }

    public static void searchTerm() {
        getDriver().findElement(searchField).sendKeys(Keys.ENTER);
    }

    public static boolean isSearchResultsTextDisplayed() {
        return getDriver().findElement(searchResultsText).isDisplayed();
    }

    public static String getSearchResultsText() {
        return getDriver().findElement(searchResultsText).getText();
    }

    public static boolean isSubcategoryLinkCarouselDisplayed() {
        return getDriver().findElement(subcategoryLinkCarousel).isDisplayed();
    }

    public static void clickSubcategoryCarouselLink() {
        getDriver().findElement(subcategoryLinkCarousel).click();
    }

    public static boolean isSubcategoryLinkNavigationTreeDisplayed() {
        return getDriver().findElement(subcategoryLinkNavigationTree).isDisplayed();
    }

    public static void clickSubcategoryLinkNavigationTree() {
        getDriver().findElement(subcategoryLinkNavigationTree).click();
    }

    public static boolean isManufacturerAcmeLinkDisplayed() {
        return getDriver().findElement(manufacturerAcmeLink).isDisplayed();
    }

    public static void clickManufacturerAcmeLink() {
        getDriver().findElement(manufacturerAcmeLink).click();
    }

    public static boolean isManufacturerNavigationTitleDisplayed() {
        return getDriver().findElement(manufacturerNavigationTitle).isDisplayed();
    }

    public static void getManufacturerNavigationTitleText() {
        getDriver().findElement(manufacturerNavigationTitle).getText();
    }

    public static boolean isSortingNameDisplayed() {
        return getDriver().findElement(sortingName).isDisplayed();
    }

    public static void clickSortingName() {
        getDriver().findElement(sortingName).click();
    }

    public static boolean isSortingPriceDisplayed() {
        return getDriver().findElement(sortingPrice).isDisplayed();
    }

    public static void clickSortingPrice() {
        getDriver().findElement(sortingPrice).click();
    }

    public static boolean isSortingNamePopularity() {
        return getDriver().findElement(sortingPopularity).isDisplayed();
    }

    public static void clickSortingPopularity() {
        getDriver().findElement(sortingPopularity).click();
    }

    public static boolean isSortingDateDisplayed() {
        return getDriver().findElement(sortingDate).isDisplayed();
    }

    public static void clickSortingDate() {
        getDriver().findElement(sortingDate).click();
    }

    public static List<WebElement> getProductTiles() { return getDriver().findElement(productTilesWrapper).findElements(productTile); }

    public static String getProductNameOnTile(WebElement element) {
        return element.findElement(productNameOnTile).getText();
    }
}
