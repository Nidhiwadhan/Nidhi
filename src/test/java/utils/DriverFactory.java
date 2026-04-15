package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false); // ⭐ IMPORTANT

        options.setExperimentalOption("prefs", prefs);

        if (ConfigReader.isHeadless()) {
            
        	options.addArguments("--headless=new");
        	options.addArguments("--no-sandbox");
        	
            
        }

        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
        //getDriver().manage().deleteAllCookies();
        getDriver().get(ConfigReader.getBaseUrl());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {
    
        getDriver().quit();
        driver.remove();
    }
}