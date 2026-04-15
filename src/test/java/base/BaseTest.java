package base;

import org.testng.annotations.*;
import utils.DriverFactory;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }
}