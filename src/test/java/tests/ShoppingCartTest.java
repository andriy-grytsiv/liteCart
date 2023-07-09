package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.NavigationMenu;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;

import java.time.Duration;
import java.util.List;

import static utils.WebDriverContainer.*;

public class ShoppingCartTest extends TestBase{
    @Test
    public static void navigateToCart() {
        String expectedCartTitle = "Checkout | My Store";
        getDriver();

        NavigationMenu.clickCart();

        Assert.assertTrue(NavigationMenu.pageTitleMatchesExpected(expectedCartTitle));
    }

    @Test
    public static void addProductToCart() {
        String expectedProductName = "Blue Duck";

        SoftAssert softAssert = new SoftAssert();
        getDriver().get("https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4");

        ProductPage.clickAddToCartButton();

        String targetValue = "1";
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Maximum wait time of 10 seconds
        wait.until(ExpectedConditions.textToBe(NavigationMenu.getCartQuantityLocator(), targetValue));

        NavigationMenu.clickCart();
        List<WebElement> cartItems = ShoppingCartPage.getProductItems();

        softAssert.assertTrue(ShoppingCartPage.isProductDisplayed(), "product NOT displayed");
        softAssert.assertEquals(ShoppingCartPage.getProductNameInItem(cartItems.get(0)), expectedProductName, "NOT correct product in cart");

        softAssert.assertAll();
    }

    /*
    FULL PLANNED TEST SCOPE:
    - navigate to cart
    - elements displayed - empty cart
    - elements displayed - product in cart
    - back functionality
    - add product to cart
    - navigate between products in cart
    - change quantity of product
    - remove product
    - different shipping address checkbox
    */

}
