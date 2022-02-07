package pages;

import maps.ShoppingCartMap;
import support.BaseCommands;

public class ShoppingCartPage {

    ShoppingCartMap shoppingCartMap = new ShoppingCartMap();
    BaseCommands baseCommands = new BaseCommands();

    public void assertShoppingCartHeader() {
        baseCommands.assertElementText(shoppingCartMap.CART_HEADER, "Shopping Cart");
    }

    public void assertProductDescription(String expectedProduct) {
        baseCommands.assertElementText(shoppingCartMap.ITEM_DESCRIPTION, expectedProduct);
    }

    public void assertCheckoutLink() {
        baseCommands.assertElementText(shoppingCartMap.CHECKOUT_LINK, "Checkout");
    }
}


