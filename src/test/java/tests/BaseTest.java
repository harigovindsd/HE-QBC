package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import support.DriverInit;

public abstract class BaseTest {
    DriverInit driverInit = new DriverInit();

    @BeforeClass
    public void setUp() {
        driverInit.getBrowser();
    }

    @AfterClass
    public void closeBrowser() {
        driverInit.closeBrowser();
    }
}