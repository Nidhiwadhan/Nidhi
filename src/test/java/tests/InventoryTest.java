package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;
import pages.CheckoutPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryTest extends BaseTest {

    @Test
    public void sortPriceLowToHighTest() {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
        InventoryPage inventory = new InventoryPage(DriverFactory.getDriver());
        CheckoutPage checkout= new CheckoutPage(DriverFactory.getDriver());
        // Step 1: Login
        login.login("standard_user", "secret_sauce");

        // Step 2: Apply sorting
        inventory.sortByLowToHigh();

        // Step 3: Get actual prices
        List<Double> actualPrices = inventory.getAllPrices();

        // Step 4: Create expected sorted list
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        System.out.println("Actual: " + actualPrices);
        System.out.println("Expected: " + expectedPrices);

        // Step 5: Assertion
        Assert.assertEquals(actualPrices, expectedPrices,
                "Products are not sorted correctly (Low → High)");
        checkout.mainMenu();
        checkout.logout();
    }
}
