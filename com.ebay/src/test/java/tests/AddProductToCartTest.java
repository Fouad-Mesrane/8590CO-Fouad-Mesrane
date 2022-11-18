package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchPageResults;
import pageObjectLibrary.SelectedProductPage;
import pageObjectLibrary.ShoppingCartPage;

public class AddProductToCartTest extends BasePage {

    @Test
    public void validateAddToCart(){
        HomePage homePage = new HomePage();
        SearchPageResults results = homePage.doSearch();
        SelectedProductPage selectedProduct = results.selectProduct();
        ShoppingCartPage shoppingCart = selectedProduct.addProductToCart();
        Assert.assertTrue(shoppingCart.validateItemsInCart());
    }
}
