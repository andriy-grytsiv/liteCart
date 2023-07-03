package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By accountLoginSection = By.xpath("//*[@name='login_form']");
    private By emailField = By.xpath("//*[@name='email']");
    private By passwordField = By.xpath("//*[@name='password']");
    private By loginButton = By.xpath("//*[@name='login']");
    private By logoutLink = By.xpath("//*[@id='box-account']//a[text()='Logout']");
    private By successLoginMessage = By.xpath("//*[@class='notice success']");
    private By lostPasswordButton = By.xpath("//*[@name='lost_password']");
    private By signUpLink = By.xpath("//*[@name='login_form']//*[@href='https://litecart.stqa.ru/en/create_account']");
    private By missingPasswordLoginMessage = By.xpath("//*[@class='notice errors']");
    private By restorePasswordEmailSentMessage = By.xpath("//*[@class='notice success']");
    private By emailAddressDoesNotExistMessage = By.xpath("//*[@class='notice errors']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountLoginSectionDisplayed() {
        return driver.findElement(accountLoginSection).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return driver.findElement(emailField).isDisplayed();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(passwordField).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLogoutLinkDisplayed() {
        try {
            return driver.findElement(logoutLink).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isSuccessLoginMessageDisplayed() {
        return driver.findElement(successLoginMessage).isDisplayed();
    }

    public String getSuccessLoginMessage() {
        return driver.findElement(successLoginMessage).getText();
    }

    public boolean isLostPasswordButtonDisplayed() {
        return driver.findElement(lostPasswordButton).isDisplayed();
    }

    public void clickLostPasswordButton() {
        driver.findElement(lostPasswordButton).click();
    }

    public boolean isSignUpLinkDisplayed() {
        return driver.findElement(signUpLink).isDisplayed();
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public boolean isMissingPasswordLoginMessageDisplayed() {
        return driver.findElement(missingPasswordLoginMessage).isDisplayed();
    }

    public String getMissingPasswordLoginMessage() {
        return driver.findElement(missingPasswordLoginMessage).getText();
    }

    public boolean isRestorePasswordEmailSentMessageDisplayed() {
        return driver.findElement(restorePasswordEmailSentMessage).isDisplayed();
    }

    public String getRestorePasswordEmailSentMessage() {
        return driver.findElement(restorePasswordEmailSentMessage).getText();
    }

    public boolean isEmailAddressDoesNotExistMessageDisplayed() {
        return driver.findElement(emailAddressDoesNotExistMessage).isDisplayed();
    }

    public String getEmailAddressDoesNotExistMessage() {
        return driver.findElement(emailAddressDoesNotExistMessage).getText();
    }
}