package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class SearchAndAddProductToCartTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();

    @Test
    public void verifySearchAndClickOnProduct() {
        homePage.waitForLogoVisibility();
        homePage.assertBrowserTitle();
        String searchKey = "Jersey";
        homePage.enterSearchCriteriaToSearchBox(searchKey);
        homePage.clickOnSearchSubmitButton();
        homePage.waitForSearchResultsVisibility(searchKey);
        homePage.assertNumberOfSearchResults(searchKey, 4);

        String searchResult_Third_Item = homePage.getSearchResults(searchKey).get(2);
        String expectedItem = "Apache Baseball Jersey";
        homePage.assertSearchResult(searchResult_Third_Item, expectedItem);
        homePage.clickOnSearchResultItem(expectedItem);

        productDetailsPage.assertProductTitle(expectedItem);
        productDetailsPage.clickOnAddToCartButton();

        cartPage.assertShoppingCartHeader();
        cartPage.assertProductDescription(expectedItem);
        cartPage.assertCheckoutLink();
    }
}