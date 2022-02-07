package pages;

import maps.ProductDetailsMap;
import support.BaseCommands;

public class ProductDetailsPage {

    ProductDetailsMap productDetailsMap = new ProductDetailsMap();
    BaseCommands baseCommands = new BaseCommands();

    public void assertProductTitle(String expectedProductTitle) {
        baseCommands.assertElementText(productDetailsMap.PRODUCT_TITLE, expectedProductTitle);
    }

    public void clickOnAddToCartButton() {
        baseCommands.clickOnElement(productDetailsMap.ADD_TO_CART_BUTTON);
    }
}
