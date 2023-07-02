import org.testng.annotations.DataProvider;

public class TestBase {

    @DataProvider(name = "restoreEmailCredentials")
    public Object[][] returnRestoreEmailCredentials() {
        String[][] restoreEmailCredentials = {{"fewivo3646@extemer.com", "JisCtHQ3gs7", "Test", "Tester"},
                // {"someEmail@site.com", "invalidPassword", "firstName", "lastName"}
        };

        return restoreEmailCredentials;
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] returnLoginCredentials() {
        String[][] loginCredentials = {{"fewivo3647@extemer.com", "CssAh52W9qV", "Test", "Tester"},
                // {"someEmail@site.com", "invalidPassword", "firstName", "lastName"}
        };

        return loginCredentials;
    }

    @DataProvider(name = "loginFormLinks")
    public Object[] returnLoginFormLinks() {
        String[] loginFormLinks = {"https://litecart.stqa.ru/en/", "https://litecart.stqa.ru/en/login"};

        return loginFormLinks;
    }
}