package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(
            DriverFactory.getDriver().getCurrentUrl().contains("inventory")
        );
    }
    
    
    @Test
    public void invalidLogin() {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
        login.login("wrongUser", "wrongPassword");
        String error = login.getErrorMessage();
        System.out.println("Error message: " + error);

        Assert.assertTrue(
                   error.contains("Username and password do not match any user in this service"),
        "Expected error message not displayed"
    );
    }
}