package pages;

import maps.HomeMap;
import org.openqa.selenium.WebElement;
import support.BaseCommands;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage {

    HomeMap homeMap = new HomeMap();
    BaseCommands baseCommands = new BaseCommands();

    public void assertBrowserTitle() {
        baseCommands.assertBrowserTitle("Spree Demo Site");
    }

    public void clickOnSearchBox() {
        baseCommands.clickOnElement(homeMap.SEARCH_TEXT_BOX);
    }

    public void enterSearchCriteriaToSearchBox(String searchKey) {
        clickOnSearchBox();
        baseCommands.enterText(homeMap.SEARCH_TEXT_BOX, searchKey);
    }

    public void clickOnSearchSubmitButton() {
        baseCommands.clickOnElement(homeMap.SEARCH_QUERY_SUBMIT);
    }

    public String getSearchResultSelector(String searchKey) {
        return homeMap.SEARCH_RESULT_ITEMS.replace("searchKey", searchKey);
    }

    public void waitForSearchResultsVisibility(String searchKey) {
        baseCommands.waitForElementVisibility(getSearchResultSelector(searchKey));
    }

    public String getSearchResult(String searchKey) {
        return baseCommands.getElementText(getSearchResultSelector(searchKey));
    }

    public void assertSearchResult(String searchKey, String expectedSearchItem) {
        assertEquals(getSearchResult(searchKey), expectedSearchItem);
    }

    public List<String> getSearchResults(String searchKey) {
        return baseCommands.getElementsText(getSearchResultSelector(searchKey));
    }

    public void clickOnSearchResultItem(String itemName) {
        baseCommands.clickOnElement(getSearchResultSelector(itemName));
    }

    public int numberOfElements(String searchKey) {
        return baseCommands.numberOfElements(getSearchResultSelector(searchKey));
    }

    public void assertNumberOfSearchResults(String searchKey, int expectedSearchResultNumbers) {
        assertEquals(numberOfElements(searchKey), expectedSearchResultNumbers);
    }

    public void waitForLogoVisibility(){
        WebElement logoElement = baseCommands.elementByXpath(homeMap.LOGO_IMG);
        baseCommands.explicitlyWaitFor(logoElement);
    }
}