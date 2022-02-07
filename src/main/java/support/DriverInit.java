package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class DriverInit {

    private final String baseUrl = "http://spree-vapasi.herokuapp.com/";
    private final String browser = getProperty("browser");
    public static WebDriver driver;

    public void getBrowser() {
        if (null == browser || browser.isEmpty()) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
            }
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        getBaseUrl();
    }

    private void getBaseUrl() {
        this.driver.get(baseUrl);
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void closeBrowser() {
        this.driver.quit();
    }
}