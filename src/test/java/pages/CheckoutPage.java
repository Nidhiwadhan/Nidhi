package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
    }

    public String getMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
    
    public void removeButton() {
    	driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }
    
    public void logout() {
    	driver.findElement(By.id("react-burger-menu-btn")).click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement logout = wait.until(
    	    ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link"))
    	);

    	// Step 3: Click logout
    	logout.click();
    	
    }
}