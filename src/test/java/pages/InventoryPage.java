package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;

public class InventoryPage {

    WebDriver driver;
    By sortDropdown = By.className("product_sort_container");
    By priceList = By.className("inventory_item_price");
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void sortByLowToHigh() {
        Select select = new Select(
            WaitUtils.waitForElement(sortDropdown)
        );
        select.selectByValue("lohi");
    }
    
    public List<Double> getAllPrices() {

        List<WebElement> elements =
            driver.findElements(priceList);

        List<Double> prices = new ArrayList<>();

        for (WebElement el : elements) {
            String price = el.getText().replace("$", "");
            prices.add(Double.parseDouble(price));
        }

        return prices;
    }
    
    public void addItem() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}