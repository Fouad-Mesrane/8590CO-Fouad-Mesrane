package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchPageResults;
import pageObjectLibrary.SelectedProductPage;
import pageObjectLibrary.ShoppingCartPage;
import utils.TestDataReader;

public class AddProductToCartTest extends BasePage {

    @Test
    public void validateAddToCart(){
        HomePage homePage = new HomePage();
        SearchPageResults results = homePage.doSearch(TestDataReader.getTestData().getProperty("search.term"));
        SelectedProductPage selectedProduct = results.selectProduct();
        ShoppingCartPage shoppingCart = selectedProduct.addProductToCart();
        Assert.assertTrue(shoppingCart.validateItemsInCart());
    }
}
