package tests;

import pageObjects.LoginPage;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SignUpPage;

import static utils.WebDriverContainer.*;

public class LoginTest extends TestBase {
    @Test (dataProvider = "loginFormLinks")
    public static void loginFieldsPresent(String loginFormLink) {
        SoftAssert softAssert = new SoftAssert();

        getDriver().get(loginFormLink);

        // check if elements are displayed
        softAssert.assertTrue(LoginPage.isAccountLoginSectionDisplayed(), "login section NOT found");
        softAssert.assertTrue(LoginPage.isEmailFieldDisplayed(), "email field form NOT found");
        softAssert.assertTrue(LoginPage.isPasswordFieldDisplayed(), "password field NOT found");
        softAssert.assertTrue(LoginPage.isLoginButtonDisplayed(), "login button NOT found");
        softAssert.assertTrue(LoginPage.isLostPasswordButtonDisplayed(), "lost password button NOT found");
        softAssert.assertTrue(LoginPage.isSignUpLinkDisplayed(), "sign up link NOT found");

        softAssert.assertAll();
    }

    @Test(dataProvider = "loginCredentials", timeOut = 15000)
    public static void validLoginTest(String email, String password, String firstName, String lastName) {
        SoftAssert softAssert = new SoftAssert();

        getDriver();
        LoginPage.attemptLogin(email, password);

        // get actual results
        boolean logoutLinkDisplayed = LoginPage.isLogoutLinkDisplayed();

        // check asserts
        softAssert.assertTrue(logoutLinkDisplayed, "logout link is NOT displayed");
        softAssert.assertAll();
    }

    @Test(dataProvider = "loginCredentials", timeOut = 15000)
    public static void loginMessageTest(String email, String password, String firstName, String lastName) {
        // expected results
        String expectedSuccessLoginMessage = String.format("You are now logged in as %s %s.", firstName, lastName);
        SoftAssert softAssert = new SoftAssert();

        getDriver();
        LoginPage.attemptLogin(email, password);

        // get actual results
        boolean actualSuccessLoginMessageDisplayed = LoginPage.isSuccessLoginMessageDisplayed();
        String actualSuccessLoginMessage = LoginPage.getSuccessLoginMessage();

        // check asserts
        softAssert.assertTrue(actualSuccessLoginMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualSuccessLoginMessage, expectedSuccessLoginMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test
    @Ignore
    public static void loginWithEmptyFields() {
        String emptyLoginFieldsMessage = "Please fill in this field";

        // start test
        getDriver();

        LoginPage.clickLoginButton();

        // don't know how to catch error tooltip. it's not in html
    }

    @Test
    public static void emptyPasswordLogin() {
        // expected results
        String expectedMissingPasswordLoginMessage = "You must provide both email address and password.";
        String email = "test@email.com";
        SoftAssert softAssert = new SoftAssert();

        getDriver();
        LoginPage.enterEmail(email);
        LoginPage.clickLoginButton();

        // get actual results
        boolean actualMissingPasswordLoginMessageDisplayed = LoginPage.isMissingPasswordLoginMessageDisplayed();
        String actualMissingPasswordLoginMessage = LoginPage.getMissingPasswordLoginMessage();

        // check asserts
        softAssert.assertTrue(actualMissingPasswordLoginMessageDisplayed, "error message is NOT displayed");
        softAssert.assertEquals(actualMissingPasswordLoginMessage, expectedMissingPasswordLoginMessage, "error message text is NOT correct");
        softAssert.assertAll();
    }

    @Test (dataProvider = "restoreEmailCredentials")
    public static void lostPasswordEmailSent(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        // expected results
        String expectedRestorePasswordEmailSentMessage = "A new password has been sent to your email address.";
        SoftAssert softAssert = new SoftAssert();

        getDriver().get("https://litecart.stqa.ru/en/login");
        LoginPage.enterEmail(email);
        LoginPage.clickLostPasswordButton();

        // get actual results
        boolean actualRestorePasswordEmailSentMessageDisplayed = LoginPage.isRestorePasswordEmailSentMessageDisplayed();
        String actualRestorePasswordEmailSentMessage = LoginPage.getRestorePasswordEmailSentMessage();

        // check asserts
        softAssert.assertTrue(actualRestorePasswordEmailSentMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualRestorePasswordEmailSentMessage, expectedRestorePasswordEmailSentMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test (dataProvider = "loginCredentials", timeOut = 15000)
    public static void lostPasswordIncorrectEmail(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        // expected results
        String expectedEmailAddressDoesNotExistMessage = "The email address does not exist in our database.";
        SoftAssert softAssert = new SoftAssert();

        getDriver().get("https://litecart.stqa.ru/en/login");
        LoginPage.enterEmail(email + "123");
        LoginPage.clickLostPasswordButton();

        // get actual results
        boolean actualEmailAddressDoesNotExistMessageDisplayed = LoginPage.isEmailAddressDoesNotExistMessageDisplayed();
        String actualEmailAddressDoesNotExistMessage = LoginPage.getEmailAddressDoesNotExistMessage();

        // check asserts
        softAssert.assertTrue(actualEmailAddressDoesNotExistMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualEmailAddressDoesNotExistMessage, expectedEmailAddressDoesNotExistMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test
    public static void signUpPageFields() {
        // expected results
        SoftAssert softAssert = new SoftAssert();

        getDriver().get("https://litecart.stqa.ru/en/login");
        LoginPage.clickSignUpLink();

        // check if elements are displayed
        softAssert.assertTrue(SignUpPage.isFirsNameFieldDisplayed(), "first name field NOT found");
        softAssert.assertTrue(SignUpPage.isLastNameFieldDisplayed(), "last name field form NOT found");
        softAssert.assertTrue(SignUpPage.isAddress1FieldDisplayed(), "address 1 field NOT found");
        softAssert.assertTrue(SignUpPage.isEmailFieldDisplayed(), "email field NOT found");
        softAssert.assertTrue(SignUpPage.isPasswordFieldDisplayed(), "desired password field NOT found");
        softAssert.assertTrue(SignUpPage.isCreateAccountButtonDisplayed(), "create account button NOT found");

        softAssert.assertAll();
    }
}