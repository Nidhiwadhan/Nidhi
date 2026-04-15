package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

public class ShoppingTest extends BaseTest {

    @Test
    public void purchaseFlow() {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());
        CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());

        login.login("standard_user", "secret_sauce");

        inventory.addItem();
        inventory.openCart();

        checkout.checkout();

        Assert.assertEquals(
            checkout.getMessage(),
            "Thank you for your order!"
        );
    }


@Test
public void RemoveFromCart() {

    LoginPage login = new LoginPage(DriverFactory.getDriver());
    InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());
    CheckoutPage checkout = new CheckoutPage(DriverFactory.getDriver());

    login.login("standard_user", "secret_sauce");

    inventory.addItem();
    inventory.openCart();
    checkout.removeButton();
    checkout.mainMenu();
    checkout.logout();
   
    
}
}