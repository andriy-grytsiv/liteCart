package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends PageBase{
    private WebDriver driver;
    private By searchField = By.xpath("//*[@type='search']");
    private By searchResultsText = By.xpath("//*[@id='box-search-results']/h1");
    private By subcategoryLinkCarousel = By.xpath("//*[@class='listing-wrapper categories']//a[@title='Subcategory']");
    private By subcategoryLinkNavigationTree = By.xpath("//*[@id='box-category-tree']//*[@class='category-2']");
    private By manufacturerAcmeLink = By.xpath("//*[@class='manufacturers']//a[@href='https://litecart.stqa.ru/en/acme-corp-m-1/']");
    private By manufacturerNavigationTitle = By.xpath("//*[@id='box-manufacturer']/h1[@class='title']");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isSearchFieldDisplayed() {
        return driver.findElement(searchField).isDisplayed();
    }
    public void enterSearchTerm(String searchTerm) {
        driver.findElement(searchField).sendKeys(searchTerm);
    }
    public boolean isSearchResultsTextDisplayed() {
        return driver.findElement(searchResultsText).isDisplayed();
    }
    public void getSearchResultsText() {
        driver.findElement(searchResultsText).getText();
    }
    public boolean isSubcategoryLinkCarouselDisplayed() {
        return driver.findElement(subcategoryLinkCarousel).isDisplayed();
    }
    public void clickSubcategoryCarouselLink() {
        driver.findElement(subcategoryLinkCarousel).click();
    }
    public boolean isSubcategoryLinkNavigationTreeDisplayed() {
        return driver.findElement(subcategoryLinkNavigationTree).isDisplayed();
    }
    public void clickSubcategoryLinkNavigationTree() {
        driver.findElement(subcategoryLinkNavigationTree).click();
    }
    public boolean isManufacturerAcmeLinkDisplayed() {
        return driver.findElement(manufacturerAcmeLink).isDisplayed();
    }
    public void clickManufacturerAcmeLink() {
        driver.findElement(manufacturerAcmeLink).click();
    }
    public boolean isManufacturerNavigationTitleDisplayed() {
        return driver.findElement(manufacturerNavigationTitle).isDisplayed();
    }
    public void getManufacturerNavigationTitleText() {
        driver.findElement(manufacturerNavigationTitle).getText();
    }
}
