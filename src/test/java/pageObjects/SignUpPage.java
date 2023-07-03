package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private By firsNameField = By.xpath("//*[@name='firstname']");
    private By lastNameField = By.xpath("//*[@name='lastname']");
    private By address1Field = By.xpath("//*[@name='address1']");
    private By emailField = By.xpath("//*[@name='email']");
    private By passwordField = By.xpath("//*[@name='password']");
    private By createAccountButton = By.xpath("//*[@name='create_account']");


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFirsNameFieldDisplayed() {
        return driver.findElement(firsNameField).isDisplayed();
    }

    public boolean isLastNameFieldDisplayed() {
        return driver.findElement(lastNameField).isDisplayed();
    }

    public boolean isAddress1FieldDisplayed() {
        return driver.findElement(address1Field).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public boolean isCreateAccountButtonDisplayed() {
        return driver.findElement(createAccountButton).isDisplayed();
    }

    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}
