import pageObjects.LoginPage;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.SignUpPage;

public class LoginTest extends TestBase {
    @Test (dataProvider = "loginFormLinks")
    public static void loginFieldsPresent(String loginFormLink) {
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get(loginFormLink);
        LoginPage loginPage = new LoginPage(driver);

        // check if elements are displayed
        softAssert.assertTrue(loginPage.isAccountLoginSectionDisplayed(), "login section NOT found");
        softAssert.assertTrue(loginPage.isEmailFieldDisplayed(), "email field form NOT found");
        softAssert.assertTrue(loginPage.isPasswordFieldDisplayed(), "password field NOT found");
        softAssert.assertTrue(loginPage.isLoginButtonDisplayed(), "login button NOT found");
        softAssert.assertTrue(loginPage.isLostPasswordButtonDisplayed(), "lost password button NOT found");
        softAssert.assertTrue(loginPage.isSignUpLinkDisplayed(), "sign up link NOT found");

        softAssert.assertAll();
    }

    @Test(dataProvider = "loginCredentials", timeOut = 15000)
    public static void validLoginTest(String email, String password, String firstName, String lastName) {
        // expected results
        String expectedPageTitle = "Online Store | My Store";
        String expectedSuccessLoginMessage = String.format("You are now logged in as %s %s.", firstName, lastName);
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/");
        LoginPage loginPage = new LoginPage(driver);

        // login
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        // get actual results
        String actualPageTitle = driver.getTitle();
        boolean logoutLinkDisplayed = loginPage.isLogoutLinkDisplayed();
        boolean actualSuccessLoginMessageDisplayed = loginPage.isSuccessLoginMessageDisplayed();
        String actualSuccessLoginMessage = loginPage.getSuccessLoginMessage();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(logoutLinkDisplayed, "logout link is NOT displayed");
        softAssert.assertTrue(actualSuccessLoginMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualSuccessLoginMessage, expectedSuccessLoginMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test
    @Ignore
    public static void loginWithEmptyFields() {
        String emptyLoginFieldsMessage = "Please fill in this field";

        // start test
        driver.get("https://litecart.stqa.ru/en/");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLoginButton();

        // don't know how to catch error tooltip. it's not in html
    }

    @Test
    public static void emptyPasswordField() {
        // expected results
        String expectedPageTitle = "Login | My Store";
        String expectedMissingPasswordLoginMessage = "You must provide both email address and password.";
        String email = "test@email.com";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/");
        LoginPage loginPage = new LoginPage(driver);

        // login with empty password
        loginPage.enterEmail(email);
        loginPage.clickLoginButton();

        // get actual results
        String actualPageTitle = driver.getTitle();
        boolean actualMissingPasswordLoginMessageDisplayed = loginPage.isMissingPasswordLoginMessageDisplayed();
        String actualMissingPasswordLoginMessage = loginPage.getMissingPasswordLoginMessage();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualMissingPasswordLoginMessageDisplayed, "error message is NOT displayed");
        softAssert.assertEquals(actualMissingPasswordLoginMessage, expectedMissingPasswordLoginMessage, "error message text is NOT correct");
        softAssert.assertAll();
    }

    @Test (dataProvider = "restoreEmailCredentials")
    public static void lostPasswordEmailSent(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        // expected results
        String expectedPageTitle = "Login | My Store";
        String expectedRestorePasswordEmailSentMessage = "A new password has been sent to your email address.";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");
        LoginPage loginPage = new LoginPage(driver);

        // sent restore password email
        loginPage.enterEmail(email);
        loginPage.clickLostPasswordButton();

        // get actual results
        String actualPageTitle = driver.getTitle();
        boolean actualRestorePasswordEmailSentMessageDisplayed = loginPage.isRestorePasswordEmailSentMessageDisplayed();
        String actualRestorePasswordEmailSentMessage = loginPage.getRestorePasswordEmailSentMessage();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualRestorePasswordEmailSentMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualRestorePasswordEmailSentMessage, expectedRestorePasswordEmailSentMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test (dataProvider = "loginCredentials", timeOut = 15000)
    public static void lostPasswordEmailNotSent(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        // expected results
        String expectedPageTitle = "Login | My Store";
        String expectedEmailAddressDoesNotExistMessage = "The email address does not exist in our database.";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");
        LoginPage loginPage = new LoginPage(driver);

        // sent restore password email
        loginPage.enterEmail(email + "123");
        loginPage.clickLostPasswordButton();

        // get actual results
        String actualPageTitle = driver.getTitle();
        boolean actualEmailAddressDoesNotExistMessageDisplayed = loginPage.isEmailAddressDoesNotExistMessageDisplayed();
        String actualEmailAddressDoesNotExistMessage = loginPage.getEmailAddressDoesNotExistMessage();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualEmailAddressDoesNotExistMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualEmailAddressDoesNotExistMessage, expectedEmailAddressDoesNotExistMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test
    public static void signUpPageFields() {
        // expected results
        String expectedPageTitle = "Create Account | My Store";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpLink();

        // check if elements are displayed
        SignUpPage signUpPage = new SignUpPage(driver);
        softAssert.assertTrue(signUpPage.isFirsNameFieldDisplayed(), "first name field NOT found");
        softAssert.assertTrue(signUpPage.isLastNameFieldDisplayed(), "last name field form NOT found");
        softAssert.assertTrue(signUpPage.isAddress1FieldDisplayed(), "address 1 field NOT found");
        softAssert.assertTrue(signUpPage.isEmailFieldDisplayed(), "email field NOT found");
        softAssert.assertTrue(signUpPage.isPasswordFieldDisplayed(), "desired password field NOT found");
        softAssert.assertTrue(signUpPage.isCreateAccountButtonDisplayed(), "create account button NOT found");

        String actualPageTitle = driver.getTitle();
        softAssert.assertEquals(actualPageTitle, expectedPageTitle);

        softAssert.assertAll();
    }
}