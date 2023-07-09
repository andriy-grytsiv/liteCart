package pageObjects;

import org.openqa.selenium.By;
import utils.Locators;

import static utils.WebDriverContainer.*;

public class SignUpPage extends PageBase{
    private static By firsNameField = Locators.getLocator("SignUpPage.firsNameField");
    private static By lastNameField = Locators.getLocator("SignUpPage.lastNameField");
    private static By address1Field = Locators.getLocator("SignUpPage.address1Field");
    private static By emailField = Locators.getLocator("SignUpPage.emailField");
    private static By passwordField = Locators.getLocator("SignUpPage.passwordField");
    private static By createAccountButton = Locators.getLocator("SignUpPage.createAccountButton");

    public static boolean isFirsNameFieldDisplayed() {
        return getDriver().findElement(firsNameField).isDisplayed();
    }

    public static boolean isLastNameFieldDisplayed() {
        return getDriver().findElement(lastNameField).isDisplayed();
    }

    public static boolean isAddress1FieldDisplayed() {
        return getDriver().findElement(address1Field).isDisplayed();
    }

    public static boolean isEmailFieldDisplayed() {
        return getDriver().findElement(emailField).isDisplayed();
    }

    public static boolean isPasswordFieldDisplayed() {
        return getDriver().findElement(passwordField).isDisplayed();
    }

    public static boolean isCreateAccountButtonDisplayed() {
        return getDriver().findElement(createAccountButton).isDisplayed();
    }

    public static void clickCreateAccountButton() {
        getDriver().findElement(createAccountButton).click();
    }
}
