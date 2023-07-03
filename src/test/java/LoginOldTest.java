import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginOldTest extends TestBase {
    @Test (dataProvider = "loginFormLinks")
    public static void loginFieldsPresent(String loginFormLink) {
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get(loginFormLink);

        // find elements and check if they are displayed
        WebElement accountLoginSection = driver.findElement(By.xpath("//*[@name='login_form']"));
        softAssert.assertTrue(accountLoginSection.isDisplayed(), "login section NOT found");

        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        softAssert.assertTrue(emailField.isDisplayed(), "email field form NOT found");

        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));
        softAssert.assertTrue(passwordField.isDisplayed(), "password field NOT found");

        WebElement loginButton = driver.findElement(By.xpath("//*[@name='login']"));
        softAssert.assertTrue(loginButton.isDisplayed(), "login button NOT found");

        WebElement lostPasswordButton = driver.findElement(By.xpath("//*[@name='lost_password']"));
        softAssert.assertTrue(lostPasswordButton.isDisplayed(), "lost password button NOT found");

        WebElement signUpLink = driver.findElement(By.xpath("//*[@name='login_form']//*[@href='https://litecart.stqa.ru/en/create_account']"));
        softAssert.assertTrue(signUpLink.isDisplayed(), "sign up link NOT found");

        softAssert.assertAll();
    }

    @Test(dataProvider = "loginCredentials", timeOut = 15000)
    public static void validLoginTest(String email, String password, String firstName, String lastName) {
        String expectedPageTitle = "Online Store | My Store";
        String expectedSuccessLoginMessage = String.format("You are now logged in as %s %s.", firstName, lastName);
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/");

        // login
        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@name='login']"));
        loginButton.click();

        // get actual results
        String actualPageTitle = driver.getTitle();
        WebElement logoutLink = null;
        try {
            logoutLink = driver.findElement(By.xpath("//*[@id='box-account']//a[text()='Logout']"));

        } catch (NoSuchElementException e) {
            System.out.println("logout link is NOT displayed");
        }

        // suggestion from IDEA. is it good practice or NOT?
        assert logoutLink != null;

        boolean logoutLinkDisplayed = logoutLink.isDisplayed();
        WebElement successLoginMessage = driver.findElement(By.xpath("//*[@class='notice success']"));
        boolean actualSuccessLoginMessageDisplayed = successLoginMessage.isDisplayed();
        String actualSuccessLoginMessage = successLoginMessage.getText();

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

        WebElement loginButton = driver.findElement(By.xpath("//*[@name='login']"));
        loginButton.click();

        // don't know how to catch error tooltip. it's not in html
    }

    @Test
    public static void emptyPasswordField() {
        // start test
        driver.get("https://litecart.stqa.ru/en/");

        String expectedPageTitle = "Login | My Store";
        String expectedMissingPasswordLoginMessage = "You must provide both email address and password.";
        String email = "test@email.com";
        SoftAssert softAssert = new SoftAssert();

        // login with empty password
        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        emailField.sendKeys(email);
        WebElement loginButton = driver.findElement(By.xpath("//*[@name='login']"));
        loginButton.click();

        // get actual results
        String actualPageTitle = driver.getTitle();
        WebElement missingPasswordLoginMessage = driver.findElement(By.xpath("//*[@class='notice errors']"));
        boolean actualMissingPasswordLoginMessageDisplayed = missingPasswordLoginMessage.isDisplayed();
        String actualMissingPasswordLoginMessage = missingPasswordLoginMessage.getText();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualMissingPasswordLoginMessageDisplayed, "error message is NOT displayed");
        softAssert.assertEquals(actualMissingPasswordLoginMessage, expectedMissingPasswordLoginMessage, "error message text is NOT correct");
        softAssert.assertAll();
    }

    @Test (dataProvider = "restoreEmailCredentials")
    public static void lostPasswordEmailSent(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        String expectedPageTitle = "Login | My Store";
        String expectedRestorePasswordEmailSentMessage = "A new password has been sent to your email address.";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");

        // sent restore password email
        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        emailField.sendKeys(email);
        WebElement lostPasswordButton = driver.findElement(By.xpath("//*[@name='lost_password']"));
        lostPasswordButton.click();

        // get actual results
        String actualPageTitle = driver.getTitle();
        WebElement restorePasswordEmailSentMessage = driver.findElement(By.xpath("//*[@class='notice success']"));
        boolean actualRestorePasswordEmailSentMessageDisplayed = restorePasswordEmailSentMessage.isDisplayed();
        String actualRestorePasswordEmailSentMessage = restorePasswordEmailSentMessage.getText();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualRestorePasswordEmailSentMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualRestorePasswordEmailSentMessage, expectedRestorePasswordEmailSentMessage, "success login message is NOT correct");
        softAssert.assertAll();

//        driver.quit();
    }

    @Test (dataProvider = "loginCredentials", timeOut = 15000)
    public static void lostPasswordEmailNotSent(String email, String ignoredPassword, String ignoredFirstName, String ignoredLastName) {
        String expectedPageTitle = "Login | My Store";
        String expectedEmailAddressDoesNotExistMessage = "The email address does not exist in our database.";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");

        // sent restore password email
        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        emailField.sendKeys(email + "123");
        WebElement lostPasswordButton = driver.findElement(By.xpath("//*[@name='lost_password']"));
        lostPasswordButton.click();

        // get actual results
        String actualPageTitle = driver.getTitle();
        WebElement emailAddressDoesNotExistMessage = driver.findElement(By.xpath("//*[@class='notice errors']"));
        boolean actualEmailAddressDoesNotExistMessageDisplayed = emailAddressDoesNotExistMessage.isDisplayed();
        String actualEmailAddressDoesNotExistMessage = emailAddressDoesNotExistMessage.getText();

        // check asserts
        softAssert.assertEquals(actualPageTitle, expectedPageTitle, "page title is NOT correct");
        softAssert.assertTrue(actualEmailAddressDoesNotExistMessageDisplayed, "success login message is NOT displayed");
        softAssert.assertEquals(actualEmailAddressDoesNotExistMessage, expectedEmailAddressDoesNotExistMessage, "success login message is NOT correct");
        softAssert.assertAll();
    }

    @Test
    public static void signUpPageFields() {
        String expectedPageTitle = "Create Account | My Store";
        SoftAssert softAssert = new SoftAssert();

        // start test
        driver.get("https://litecart.stqa.ru/en/login");

        WebElement signUpLink = driver.findElement(By.xpath("//*[@name='login_form']//*[@href='https://litecart.stqa.ru/en/create_account']"));
        signUpLink.click();

        // find elements and check if they are displayed
        WebElement firsNameField = driver.findElement(By.xpath("//*[@name='firstname']"));
        softAssert.assertTrue(firsNameField.isDisplayed(), "first name field NOT found");

        WebElement lastNameField = driver.findElement(By.xpath("//*[@name='lastname']"));
        softAssert.assertTrue(lastNameField.isDisplayed(), "last name field form NOT found");

        WebElement address1Field = driver.findElement(By.xpath("//*[@name='address1']"));
        softAssert.assertTrue(address1Field.isDisplayed(), "address 1 field NOT found");

        WebElement emailField = driver.findElement(By.xpath("//*[@name='email']"));
        softAssert.assertTrue(emailField.isDisplayed(), "email field NOT found");

        WebElement passwordField = driver.findElement(By.xpath("//*[@name='password']"));
        softAssert.assertTrue(passwordField.isDisplayed(), "desired password field NOT found");

        WebElement createAccountButton = driver.findElement(By.xpath("//*[@name='create_account']"));
        softAssert.assertTrue(createAccountButton.isDisplayed(), "create account button NOT found");

        String actualPageTitle = driver.getTitle();

        softAssert.assertEquals(actualPageTitle, expectedPageTitle);

        softAssert.assertAll();
    }
}
