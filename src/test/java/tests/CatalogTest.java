package tests;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CatalogPage;
import pageObjects.NavigationMenu;
import utils.ScreenshotListener;

import java.util.List;

import static utils.WebDriverContainer.getDriver;

@Listeners({ScreenshotListener.class, ReportPortalTestNGListener.class})
public class CatalogTest extends TestBase{
    static final String allureFeatureName = "Catalog";

    @Test
    @Feature(value = allureFeatureName)
    @Story(value = "LTC-123")
    public static void navigateToCatalogCategory() {
        String expectedCategoryTitle = "Rubber Ducks | My Store111";

        NavigationMenu.clickCategoryRubberDucks();

        // check if page is correct
        Assert.assertTrue(NavigationMenu.pageTitleMatchesExpected(expectedCategoryTitle), "NOT correct page title\n");
    }

    @Test
    @Feature(value = allureFeatureName)
    @Issue(value ="STU-30423")
    public static void catalogFieldsPresent() {
        SoftAssert softAssert = new SoftAssert();
        getDriver().get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");

        // check if elements are displayed
        softAssert.assertTrue(CatalogPage.isSearchFieldDisplayed(), "search field NOT found");
        softAssert.assertTrue(CatalogPage.isSubcategoryLinkCarouselDisplayed(), "subcategory in carousel NOT found");
        softAssert.assertTrue(CatalogPage.isSubcategoryLinkNavigationTreeDisplayed(), "subcategory in navigation tree NOT found");
        softAssert.assertTrue(CatalogPage.isManufacturerAcmeLinkDisplayed(), "manufacturer link NOT found");

        softAssert.assertAll();
    }

    @Test
    @Feature(value = allureFeatureName)
    @TmsLink(value = "125662995")
    public static void searchProduct() {
        String searchTerm = "blue";
        String searchResultsText = String.format("Search Results for \"%s\"", searchTerm);

        SoftAssert softAssert = new SoftAssert();
        getDriver().get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");

        CatalogPage.enterSearchTerm(searchTerm);
        CatalogPage.searchTerm();

        softAssert.assertTrue(CatalogPage.isSearchResultsTextDisplayed());
        softAssert.assertEquals(CatalogPage.getSearchResultsText(), searchResultsText);

        softAssert.assertAll();
    }

    @Test
    @Feature(value = allureFeatureName)
    public static void sortingByName() {
        String expectedFirstProductTitle = "Blue Duck";
        String expectedLastProductTitle = "Yellow Duck";

        SoftAssert softAssert = new SoftAssert();
        getDriver().get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");

        CatalogPage.clickSortingName();
        List<WebElement> productTiles = CatalogPage.getProductTiles();

        String actualFirstProductTitle = CatalogPage.getProductNameOnTile(productTiles.get(0));
        softAssert.assertEquals(actualFirstProductTitle, expectedFirstProductTitle, "first product name NOT correct");
        String actualLastProductTitle = CatalogPage.getProductNameOnTile(productTiles.get(productTiles.size()-1));
        softAssert.assertEquals(actualLastProductTitle, expectedLastProductTitle, "last product name NOT correct");

        softAssert.assertAll();
    }

    /*
    FULL PLANNED TEST SCOPE:
    - fields present
    - search product
    - category navigation
    - subcategory navigation
    - product navigation
    - default sorting
    - sorting options (name, price, popularity, date)
    - filters usage (manufacturers)
    - navigation by filter
    - products on sale display
    */

}
