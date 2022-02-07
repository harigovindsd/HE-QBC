package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BaseCommands {

    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void assertBrowserTitle(String expectedTitle) {
        assertEquals(getWebDriver().getTitle(), expectedTitle);
    }

    public WebElement element(String selector) {
        return getWebDriver().findElement(By.cssSelector(selector));
    }

    public List<WebElement> elements(String selector) {
        return getWebDriver().findElements(By.cssSelector(selector));
    }

    public int numberOfElements(String selector) {
        List<WebElement> webElements = elements(selector);
        int counter = 0;
        if (null != webElements || webElements.isEmpty()) counter = webElements.size();
        return counter;
    }

    public List<String> getElementsText(String selector) {
        List<WebElement> webElements = elements(selector);
        List<String> elementsText = new LinkedList<>();
        if (null != webElements || webElements.isEmpty()) {
            for (WebElement webElement : webElements) {
                elementsText.add(webElement.getText());
            }
        }
        return elementsText;
    }

    public String getElementText(String selector) {
        return element(selector).getText();
    }

    public void assertElementText(String selector, String expectedText) {
        assertEquals(getElementText(selector), expectedText);
    }

    public void enterText(String selector, String textToEnter) {
        element(selector).sendKeys(textToEnter);
    }

    public void clickOnElement(String selector) {
        element(selector).click();
    }

    public void waitForElementVisibility(String selector) {
        element(selector).isDisplayed();
    }

    public void explicitlyWaitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement elementByXpath(String selector) {
        return getWebDriver().findElement(By.xpath(selector));
    }

}