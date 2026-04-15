package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}