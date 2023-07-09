package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.Locators;

import static utils.WebDriverContainer.*;

public class LoginPage extends PageBase{
    private static By accountLoginSection = Locators.getLocator("LoginPage.accountLoginSection");
    private static By emailField = Locators.getLocator("LoginPage.emailField");
    private static By passwordField = Locators.getLocator("LoginPage.passwordField");
    private static By loginButton = Locators.getLocator("LoginPage.loginButton");
    private static By logoutLink = Locators.getLocator("LoginPage.logoutLink");
    private static By successLoginMessage = Locators.getLocator("LoginPage.successLoginMessage");
    private static By lostPasswordButton = Locators.getLocator("LoginPage.lostPasswordButton");
    private static By signUpLink = Locators.getLocator("LoginPage.signUpLink");
    private static By missingPasswordLoginMessage = Locators.getLocator("LoginPage.missingPasswordLoginMessage");
    private static By restorePasswordEmailSentMessage = Locators.getLocator("LoginPage.restorePasswordEmailSentMessage");
    private static By emailAddressDoesNotExistMessage = Locators.getLocator("LoginPage.emailAddressDoesNotExistMessage");

    public static boolean isAccountLoginSectionDisplayed() {
        return getDriver().findElement(accountLoginSection).isDisplayed();
    }
    public static boolean isEmailFieldDisplayed() {
        return getDriver().findElement(emailField).isDisplayed();
    }
    public static void enterEmail(String email) {
        getDriver().findElement(emailField).sendKeys(email);
    }
    public static boolean isPasswordFieldDisplayed() {
        return getDriver().findElement(passwordField).isDisplayed();
    }
    public static void enterPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }
    public static boolean isLoginButtonDisplayed() {
        return getDriver().findElement(passwordField).isDisplayed();
    }
    public static void clickLoginButton() {
        getDriver().findElement(loginButton).click();
    }
    public static void attemptLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public static boolean isLogoutLinkDisplayed() {
        try {
            return getDriver().findElement(logoutLink).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static boolean isSuccessLoginMessageDisplayed() {
        return getDriver().findElement(successLoginMessage).isDisplayed();
    }
    public static String getSuccessLoginMessage() {
        return getDriver().findElement(successLoginMessage).getText();
    }
    public static boolean isLostPasswordButtonDisplayed() {
        return getDriver().findElement(lostPasswordButton).isDisplayed();
    }
    public static void clickLostPasswordButton() {
        getDriver().findElement(lostPasswordButton).click();
    }
    public static boolean isSignUpLinkDisplayed() {
        return getDriver().findElement(signUpLink).isDisplayed();
    }
    public static void clickSignUpLink() {
        getDriver().findElement(signUpLink).click();
    }
    public static boolean isMissingPasswordLoginMessageDisplayed() {
        return getDriver().findElement(missingPasswordLoginMessage).isDisplayed();
    }
    public static String getMissingPasswordLoginMessage() {
        return getDriver().findElement(missingPasswordLoginMessage).getText();
    }
    public static boolean isRestorePasswordEmailSentMessageDisplayed() {
        return getDriver().findElement(restorePasswordEmailSentMessage).isDisplayed();
    }
    public static String getRestorePasswordEmailSentMessage() {
        return getDriver().findElement(restorePasswordEmailSentMessage).getText();
    }
    public static boolean isEmailAddressDoesNotExistMessageDisplayed() {
        return getDriver().findElement(emailAddressDoesNotExistMessage).isDisplayed();
    }
    public static String getEmailAddressDoesNotExistMessage() {
        return getDriver().findElement(emailAddressDoesNotExistMessage).getText();
    }
}